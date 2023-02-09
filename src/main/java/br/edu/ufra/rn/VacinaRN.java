/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.rn;

import br.edu.ufra.dao.GenericDAO;
import br.edu.ufra.entidade.Vacina;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class VacinaRN {

    private final GenericDAO<Vacina> VACINA_DAO = new GenericDAO<Vacina>();

    public boolean salvar(Vacina vacina) {
        if (vacina == null
                || vacina.getAnimal() == null) {
            return false;
        } else {
            if (vacina.getId() == null || vacina.getId() == 0) {
                return VACINA_DAO.criar(vacina);
            } else {
                return VACINA_DAO.alterar(vacina);
            }
        }
    }

    public List<Vacina> listar() {
        return VACINA_DAO.obterTodos(Vacina.class);
    }

    public Vacina obter(Integer id) {
        return VACINA_DAO.obter(Vacina.class, id);
    }

    public boolean excluir(Vacina vacina) {
        if (vacina == null) {
            return false;
        } else {
            return VACINA_DAO.excluir(vacina);
        }
    }
}
