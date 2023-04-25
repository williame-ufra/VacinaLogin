/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.spring;

import br.edu.ufra.entidade.Usuario;
import br.edu.ufra.rn.UsuarioRN;
import br.edu.ufra.util.UtilTexto;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class AuthenticationHandler implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        String login = a.getName();
        String senha = a.getCredentials().toString();
        String senhaCripto = UtilTexto.criptografarSHA256(senha);
        UsuarioRN RN = new UsuarioRN();
        Usuario user = RN.login(login, senhaCripto);
        if (user != null) {
            GrantedAuthorityImpl ga = new GrantedAuthorityImpl("ROLE_" + user.getPerfil());
            List<GrantedAuthority> auts = new ArrayList<GrantedAuthority>();
            auts.add(ga);
            return new UsernamePasswordAuthenticationToken(login, senha, auts);
        } else {
            throw new BadCredentialsException("Email, celular ou senha inválidos");
        }
    }

    @Override
    public boolean supports(Class<? extends Object> type) {
        return true;
    }

}
