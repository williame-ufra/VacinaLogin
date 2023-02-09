/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.entidade.tipo;

public enum TipoPerfilUsuario {

    ADMINISTRADOR('A', "Administrador"),
    VETERINARIO('V', "Veterinário"),
    USUARIO('U', "Usuário");

    private Character valor;
    private String descricao;

    private TipoPerfilUsuario(Character tipo, String descricao) {
        this.valor = tipo;
        this.descricao = descricao;
    }

    public static TipoPerfilUsuario obter(char valor) {
        TipoPerfilUsuario resposta = USUARIO;
        TipoPerfilUsuario[] values = values();
        for (TipoPerfilUsuario t : values) {
            if (t.getValor() == valor) {
                resposta = t;
                return resposta;
            }
        }
        return resposta;
    }

    public boolean isAdministrador() {
        return equals(ADMINISTRADOR);
    }

    public boolean isVeterinario() {
        return equals(VETERINARIO);
    }

    public boolean isUsuario() {
        return equals(USUARIO);
    }

    public Character getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

}
