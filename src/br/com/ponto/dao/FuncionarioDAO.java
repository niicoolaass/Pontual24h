package br.com.ponto.dao;

import br.com.ponto.factory.ConnectionFactory;
import br.com.ponto.model.Funcionario;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public static List<Funcionario> getFuncionarios() {

        String sql = "Select * FROM funcionarios";

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
                funcionario.setNome(rset.getString("nome"));
                //data de nascimento
                funcionario.setDataNascimento(rset.getDate("dataNascimento"));
                //cargo
                funcionario.setCargo(rset.getString("cargo"));
                //setor
                funcionario.setSetor(rset.getString("setor"));
                //data de admissao
                funcionario.setDataAdmissao(rset.getDate("dataAdmissao"));
                //id horario de trabalho
                funcionario.setHorarioTrabalho(rset.getInt("id_horarioTrabalho"));
                //status
                funcionario.setStatus(rset.getString("status"));

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

    //U: UPDATE - SET
    public static void update(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET nome = ?, dataNascimento = ?, cargo = ?, setor = ?, dataAdmissao = ?, id_horarioTrabalho = ? " +
        "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar conexao com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criar a classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar os valores para atualizar

            pstm.setString(1, funcionario.getNome());
            pstm.setDate(2, (Date) funcionario.getDataNascimento());
            pstm.setString(3, funcionario.getCargo());
            pstm.setString(4, funcionario.getSetor());
            pstm.setDate(5, (Date) funcionario.getDataAdmissao());
            pstm.setInt(6, funcionario.getHorarioTrabalho());

            //Qual o ID do funcionario que deseja atualizar?
            pstm.setInt(7, funcionario.getId());

            //Exxecutar a query
            pstm.execute();

            System.out.println("Atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if(pstm!=null) {
                    pstm.close();
                }

                if(conn!=null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //D: DELETE - DELETE
    public static void deleteByID(int id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

            System.out.println("Deletado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstm != null) {
                    pstm.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

