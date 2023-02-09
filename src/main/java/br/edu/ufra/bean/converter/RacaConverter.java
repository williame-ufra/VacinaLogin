/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.bean.converter;

import br.edu.ufra.entidade.Raca;
import br.edu.ufra.rn.RacaRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author hugolima
 */
@FacesConverter(value = "racaConverter")
public class RacaConverter implements Converter {

    private RacaRN RN = new RacaRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.trim().isEmpty() || "null".equalsIgnoreCase(string)) {
            return null;
        }
        try {
            return RN.obter(Integer.valueOf(string));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null || !(o instanceof Raca)) {
            return null;
        }
        Raca raca = (Raca) o;
        if (raca.getId() == null) {
            return null;
        }
        return String.valueOf(raca.getId());
    }
}
