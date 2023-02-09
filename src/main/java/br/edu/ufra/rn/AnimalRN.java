/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.rn;

import br.edu.ufra.dao.GenericDAO;
import br.edu.ufra.entidade.Animal;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class AnimalRN {

    private final GenericDAO<Animal> ANIMAL_DAO = new GenericDAO<Animal>();

    public boolean salvar(Animal animal) {
        if (animal == null) {
            return false;
        } else {
            if (animal.getId() == null || animal.getId() == 0) {
                return ANIMAL_DAO.criar(animal);
            } else {
                return ANIMAL_DAO.alterar(animal);
            }
        }
    }

    public List<Animal> listar() {
        return ANIMAL_DAO.obterTodos(Animal.class);
    }

    public Animal obter(Integer id) {
        return ANIMAL_DAO.obter(Animal.class, id);
    }

    public boolean excluir(Animal animal) {
        if (animal == null) {
            return false;
        } else {
            return ANIMAL_DAO.excluir(animal);
        }
    }
}
