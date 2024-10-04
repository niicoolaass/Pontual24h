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
//        funcionario.setNome("Nicolas vieira");
//        funcionario.setDataNascimento(java.sql.Date.valueOf("2004-04-16"));
//        funcionario.setCargo("Fiscal de perdas");
//        funcionario.setSetor("Segurança do trabalho");
//        funcionario.setDataAdmissao(java.sql.Date.valueOf("2023-10-08"));
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
    }
}
