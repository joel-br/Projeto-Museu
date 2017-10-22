package br.com.fatec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guerr
 */
public class Gerente extends Funcionario{
    private int bonificacao;

    public int getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(int bonificacao) {
        this.bonificacao = bonificacao;
    }
}
