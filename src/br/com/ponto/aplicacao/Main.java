package br.com.ponto.aplicacao;

import br.com.ponto.model.Funcionario;


public class Main {

    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Nicolas vieira");
        funcionario.setDataNascimento(java.sql.Date.valueOf("2004-04-16"));
        funcionario.setCargo("Fiscal de perdas");
        funcionario.setDataAdmissao(java.sql.Date.valueOf("2023-10-08"));

    }
}
