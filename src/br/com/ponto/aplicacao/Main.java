package br.com.ponto.aplicacao;

import br.com.ponto.dao.FuncionarioDAO;
import br.com.ponto.model.Funcionario;


public class Main {

    public static void main(String[] args) {

        FuncionarioDAO funcionarioDao = new FuncionarioDAO();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Nicolas vieira");
        funcionario.setDataNascimento(java.sql.Date.valueOf("2004-04-16"));
        funcionario.setCargo("Fiscal de perdas");
        funcionario.setSetor("Segurança do trabalho");
        funcionario.setDataAdmissao(java.sql.Date.valueOf("2023-10-08"));

        try {
            funcionarioDao.save(funcionario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
