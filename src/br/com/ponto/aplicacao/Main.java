package br.com.ponto.aplicacao;

import br.com.ponto.dao.FuncionarioDAO;
import br.com.ponto.dao.HorarioTrabalhoDAO;
import br.com.ponto.dao.RegistroPontoDAO;
import br.com.ponto.model.Funcionario;
import br.com.ponto.model.HorarioTrabalho;
import br.com.ponto.model.RegistroPonto;

import java.sql.Date;
import java.sql.Time;

public class Main {

    public static void main(String[] args) {

        //CRIAR OS REGISTROS

//        HorarioTrabalhoDAO horarioTrabalhoDAO = new HorarioTrabalhoDAO();
//
//        HorarioTrabalho horarioTrabalho = new HorarioTrabalho();
//        horarioTrabalho.setDiasSemana("Segunda a sabado");
//        horarioTrabalho.setHorarioEntrada(Time.valueOf("06:00:00"));
//        horarioTrabalho.setHorarioSaida(Time.valueOf("14:30:00"));
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

        //VISUALIZAÇÃO DOS DADOS

//        for(Funcionario f : FuncionarioDAO.getFuncionarios()) {
//            System.out.println("Funcionarios: " + f.getNome());
//        }


//        for(HorarioTrabalho f : HorarioTrabalhoDAO.getHorarioTrabalho()) {
//            System.out.println("Horário de trabalho: " + f.getHorarioEntrada());
//        }


//          for(RegistroPonto f : RegistroPontoDAO.getRegistroPonto()) {
//              System.out.println("Registro de ponto: " + f.getIdFuncionario());
//          }

        //ATUALIZAR

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


//        HorarioTrabalho h1 = new HorarioTrabalho();
//
//        h1.setDiasSemana ("segunda a sexta");
//        h1.setHorarioEntrada(java.sql.Time.valueOf("07:00:00"));
//        h1.setHorarioSaida(java.sql.Time.valueOf("16:30:00"));
//        h1.setIntervalo(java.sql.Time.valueOf("01:00:00"));
//        h1.setId(1);
//
//        HorarioTrabalhoDAO.update(h1);


//        RegistroPonto r1 = new RegistroPonto();
//
//        r1.setIdFuncionario (3);
//        r1.setData(java.sql.Date.valueOf("2024-08-10"));
//        r1.setHora(java.sql.Time.valueOf("01:00:00"));
//        r1.setTipoRegistro("Entrada");
//        r1.setId(2);
//
//        RegistroPontoDAO.update(r1);

        //DELETAR

//        FuncionarioDAO.deleteByID(7);


//        HorarioTrabalhoDAO.deleteByID(1);



    }
}
