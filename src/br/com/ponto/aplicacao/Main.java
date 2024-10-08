package br.com.ponto.aplicacao;

import br.com.ponto.dao.FuncionarioDAO;
import br.com.ponto.dao.HorarioTrabalhoDAO;
import br.com.ponto.dao.RegistroPontoDAO;
import br.com.ponto.model.Funcionario;
import br.com.ponto.model.HorarioTrabalho;
import br.com.ponto.model.RegistroPonto;

import java.sql.Time;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        //Criar os registros

//        HorarioTrabalhoDAO horarioTrabalhoDAO = new HorarioTrabalhoDAO();
//
//        HorarioTrabalho horarioTrabalho = new HorarioTrabalho();
//        horarioTrabalho.setDiasSemana("Segunda a sexta");
//        horarioTrabalho.setHorarioEntrada(Time.valueOf("07:00:00"));
//        horarioTrabalho.setHorarioSaida(Time.valueOf("16:30:00"));
//        horarioTrabalho.setIntervalo(Time.valueOf("1:00:00"));
//
//        try {
//            horarioTrabalhoDAO.save(horarioTrabalho);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
//
//        Funcionario funcionario = new Funcionario();
//        funcionario.setNome("João vitor");
//        funcionario.setDataNascimento(java.sql.Date.valueOf("2002-10-06"));
//        funcionario.setCargo("Auxiliar");
//        funcionario.setSetor("Financeiro");
//        funcionario.setDataAdmissao(java.sql.Date.valueOf("2020-08-10"));
//        funcionario.setHorarioTrabalho(1);
//
//        try {
//            funcionarioDao.save(funcionario);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        RegistroPontoDAO registroPontoDAO = new RegistroPontoDAO();
//        Date agora = new Date();
//        RegistroPonto registroPonto = new RegistroPonto();
//        registroPonto.setIdFuncionario(3);
//        registroPonto.setData(new Date());
//        registroPonto.setHora(new Time(agora.getTime()));
//        registroPonto.setTipoRegistro("Saida");
//
//        try {
//            registroPontoDAO.save(registroPonto);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        //Visualização dos registros do banco de dados

//        for(Funcionario f : FuncionarioDAO.getFuncionarios()) {
//            System.out.println("Funcionarios: " + f.getNome());
//        }

        //Atualizar

//        Funcionario f1 = new Funcionario();
//
//        f1.setNome("Nicolas vieira dos santos");
//        f1.setDataNascimento(java.sql.Date.valueOf("2004-04-16"));
//        f1.setCargo("Fiscal de perdas");
//        f1.setSetor("Segurança do trabalho");
//        f1.setDataAdmissao(java.sql.Date.valueOf("2023-10-08"));
//        f1.setHorarioTrabalho(1);
//        f1.setId(3);
//
//        FuncionarioDAO.update(f1);
    }
}
