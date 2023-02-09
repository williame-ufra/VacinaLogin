/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.rn;

import br.edu.ufra.dao.GenericDAO;
import br.edu.ufra.entidade.Raca;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class RacaRN {

    private final GenericDAO<Raca> RACA_DAO = new GenericDAO<Raca>();

    public boolean salvar(Raca raca) {
        if (raca == null) {
            return false;
        } else {
            if (raca.getId() == null || raca.getId() == 0) {
                return RACA_DAO.criar(raca);
            } else {
                return RACA_DAO.alterar(raca);
            }
        }
    }

    public List<Raca> listar() {
        return RACA_DAO.obterTodos(Raca.class);
    }

    public Raca obter(Integer id) {
        return RACA_DAO.obter(Raca.class, id);
    }

    public boolean excluir(Raca raca) {
        if (raca == null) {
            return false;
        } else {
            return RACA_DAO.excluir(raca);
        }
    }
}
