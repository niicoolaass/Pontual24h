package br.com.ponto.dao;

import br.com.ponto.factory.ConnectionFactory;
import br.com.ponto.model.Funcionario;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    //C: CREATE - INSERT
    public void save(Funcionario funcionario) throws Exception {

        String sql = "INSERT INTO funcionarios(nome, dataNascimento, cargo, setor, dataAdmissao, id_horarioTrabalho) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar uma conexão com o BD
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criação do PreparedStatement, para executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Valores esperados pela query
            pstm.setString(1, funcionario.getNome());
            pstm.setDate(2, new java.sql.Date(funcionario.getDataNascimento().getTime()));
            pstm.setString(3, funcionario.getCargo());
            pstm.setString(4, funcionario.getSetor());
            pstm.setDate(5, new java.sql.Date(funcionario.getDataAdmissao().getTime()));
            pstm.setInt(6, funcionario.getHorarioTrabalho());


            //Executar a query
            pstm.execute();

            System.out.println("Funcionario salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            //Fechar as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
    }
    }

    //R: READ - SELECT
    public List<Funcionario> getFuncionarios() {

        String sql = "Select + FROM funcionarios";

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai recuperar os dados do BD
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            //Enquanto tiver dados ele vai rodar
            while (rset.next()) {
                Funcionario funcionario = new Funcionario();

                //id
                funcionario.setId(rset.getInt("id"));
                //nome
                funcionario.setNome(rset.getString("Nome"));
                //data de nascimento
                funcionario.setDataNascimento(rset.getDate("Data de nascimento"));
                //cargo
                funcionario.setCargo(rset.getString("Cargo"));
                //setor
                funcionario.setSetor(rset.getString("Setor"));
                //data de admissao
                funcionario.setDataAdmissao(rset.getDate("Data de admissao"));
                //id horario de trabalho
                funcionario.setHorarioTrabalho(rset.getInt("Horario de trabalho"));
                //status
                funcionario.setStatus(rset.getString("Status"));

                funcionarios.add(funcionario);

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        return funcionarios;
    }
}

