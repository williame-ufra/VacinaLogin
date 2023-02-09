/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.bean;

import br.edu.ufra.entidade.Usuario;
import br.edu.ufra.entidade.tipo.TipoPerfilUsuario;
import br.edu.ufra.rn.UsuarioRN;
import br.edu.ufra.util.UtilBean;
import br.edu.ufra.util.UtilTexto;
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
public class UsuarioBean {

    private List<Usuario> usuarios;
    private Usuario usuario = new Usuario();
    private final UsuarioRN USUARIO_RN = new UsuarioRN();

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    @PostConstruct
    public void init() {
        usuarios = USUARIO_RN.listar();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario animal) {
        this.usuario = animal;
    }

    public Usuario getUsuarioLogado() {
        return UtilBean.obterUsuarioLogado();
    }

    public boolean isNovoUsuario() {
        return this.usuario != null
                && (this.usuario.getId() == null || this.usuario.getId() == 0);
    }

    public boolean isAdministrador() {
        Usuario u = getUsuarioLogado();
        if (u != null) {
            final TipoPerfilUsuario perfil = TipoPerfilUsuario.obter(u.getPerfil());
            return perfil.isAdministrador();
        } else {
            return false;
        }
    }

    public boolean isPerfilUsuario() {
        Usuario u = getUsuarioLogado();
        if (u != null) {
            final TipoPerfilUsuario perfil = TipoPerfilUsuario.obter(u.getPerfil());
            return perfil.isUsuario();
        } else {
            return false;
        }
    }

    public boolean isVeterinario() {
        Usuario u = getUsuarioLogado();
        if (u != null) {
            final TipoPerfilUsuario perfil = TipoPerfilUsuario.obter(u.getPerfil());
            return perfil.isVeterinario();
        } else {
            return false;
        }
    }

    public String getPerfilDoUsuarioLogado() {
        Usuario u = getUsuarioLogado();
        if (u != null) {
            final TipoPerfilUsuario Perfil = TipoPerfilUsuario.obter(u.getPerfil());
            return Perfil.getDescricao();
        }
        return null;
    }

    public String getPerfilDoUsuario(Usuario u) {
        if (u != null) {
            final TipoPerfilUsuario Perfil = TipoPerfilUsuario.obter(u.getPerfil());
            return Perfil.getDescricao();
        }
        return "N/D";
    }

    public void excluir() {
        if (USUARIO_RN.excluir(usuario)) {
            UtilBean.criarMensagemDeInformacao("Usuario excluído");
            usuarios = USUARIO_RN.listar();
        } else {
            UtilBean.criarMensagemDeErro("Não foi possível excluir o usuário");
        }
    }

    public void salvar() {
        if (USUARIO_RN.salvar(usuario)) {
            UtilBean.criarMensagemDeInformacao("Usuario salvo");
        } else {
            UtilBean.criarMensagemDeErro("Não foi possível salvar o usuário");
        }
    }

}
