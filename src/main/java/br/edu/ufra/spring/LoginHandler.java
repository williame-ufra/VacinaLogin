/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.spring;

import br.edu.ufra.entidade.Usuario;
import br.edu.ufra.rn.UsuarioRN;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 * @author Fabio
 */
public class LoginHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UsuarioRN RN = new UsuarioRN();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        String username = a.getName();
        Usuario usuario = RN.obter(username);
        String pagina = "/index.xhtml";
        if (usuario != null) {
            pagina = "/usuario/animais.xhtml";
        }
        setDefaultTargetUrl(pagina);
        super.onAuthenticationSuccess(request, response, a);
    }

}
