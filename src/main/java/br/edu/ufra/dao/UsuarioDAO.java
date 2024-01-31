/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.dao;

import br.edu.ufra.entidade.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Fabio
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public Usuario login(String usuario, String senha) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = null;
        if (em != null) {
            transaction = em.getTransaction();
        } else {
            return null;
        }
        String sql = "select u from Usuario u "
                + " where "
                + " (u.celular = :celular or u.email = :email) "
                + " and u.senha = :senha ";
        Query query = em.createQuery(sql);
        Usuario resposta = null;
        try {
            transaction.begin();

            //recupera o usuário
            List<Usuario> usuarios = (List<Usuario>) query
                    .setParameter("celular", usuario)
                    .setParameter("email", usuario)
                    .setParameter("senha", senha)
                    .getResultList();

            if (usuarios != null
                    && usuarios.size() == 1) {
                resposta = usuarios.get(0);
                em.refresh(resposta);
            }

            //commit da operação
            transaction.commit();

            return resposta;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            if (transaction != null
                    && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
        return resposta;
    }

    public Usuario obter(String usuario) {
        EntityManager em = getEntityManager();
        String sql = "select o from Usuario o "
                + " where o.celular = :celular or o.email = :email ";
        Query query = em.createQuery(sql);
        Usuario resposta = null;
        try {
            List<Usuario> usuarios = (List<Usuario>) query
                    .setParameter("celular", usuario)
                    .setParameter("email", usuario)
                    .getResultList();
            if (usuarios != null
                    && usuarios.size() == 1) {
                resposta = usuarios.get(0);
                em.refresh(resposta);
            }
            return resposta;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            em.close();
        }
        return resposta;
    }
}
