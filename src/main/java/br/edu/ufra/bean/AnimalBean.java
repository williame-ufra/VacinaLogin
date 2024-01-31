/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.bean;

import br.edu.ufra.entidade.Animal;
import br.edu.ufra.rn.AnimalRN;
import br.edu.ufra.util.UtilBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Fabio
 */
@ManagedBean
@RequestScoped
public class AnimalBean {

    private List<Animal> animais;
    private Animal animal = new Animal();
    private final AnimalRN ANIMAL_RN = new AnimalRN();

    /**
     * Creates a new instance of AnimalBean
     */
    public AnimalBean() {
    }

    @PostConstruct
    public void init() {
        animais = ANIMAL_RN.listar();
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void excluir() {
        if (ANIMAL_RN.excluir(animal)) {
            UtilBean.criarMensagemDeInformacao("Animal excluído");
            animais = ANIMAL_RN.listar();
        } else {
            UtilBean.criarMensagemDeErro("Não foi possível excluir o animal");
        }
    }

    public void salvar() {
        if (ANIMAL_RN.salvar(animal)) {
            UtilBean.criarMensagemDeInformacao("Animal salvo");
        } else {
            UtilBean.criarMensagemDeErro("Não foi possível salvar o animal");
        }
    }

}
