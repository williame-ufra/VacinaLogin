/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.bean;

import br.edu.ufra.entidade.Raca;
import br.edu.ufra.rn.RacaRN;
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
public class RacaBean {

    private List<Raca> racas;
    private Raca raca = new Raca();
    private final RacaRN RACA_RN = new RacaRN();

    /**
     * Creates a new instance of RacaBean
     */
    public RacaBean() {
    }

    @PostConstruct
    public void init() {
        racas = RACA_RN.listar();
    }

    public List<Raca> getRacas() {
        return racas;
    }

    public void setRacas(List<Raca> racas) {
        this.racas = racas;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public void excluir() {
        if (RACA_RN.excluir(raca)) {
            UtilBean.criarMensagemDeInformacao("Raca excluída");
            racas = RACA_RN.listar();
        } else {
            UtilBean.criarMensagemDeErro("Não foi possível excluir a raça");
        }
    }

    public void salvar() {
        if (RACA_RN.salvar(raca)) {
            UtilBean.criarMensagemDeInformacao("Raca salva");
        } else {
            UtilBean.criarMensagemDeErro("Não foi possível salvar o raça");
        }
    }

}
