package br.com.ponto.dao;

import br.com.ponto.factory.ConnectionFactory;
import br.com.ponto.model.Funcionario;
import br.com.ponto.model.HorarioTrabalho;
import br.com.ponto.model.RegistroPonto;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class RegistroPontoDAO {
    //C: CREATE
    public void save(RegistroPonto registroPonto) throws Exception {

        String sql = "INSERT INTO registro_ponto(id_funcionario, data, hora, tipoRegistro) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar uma conexão com o BD
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criação do PreparedStatement, para executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Valores esperados pela query
            pstm.setInt(1, registroPonto.getIdFuncionario());
            pstm.setDate(2, new Date(registroPonto.getData().getTime()));
            pstm.setTime(3, new Time(registroPonto.getHora().getTime()));
            pstm.setString(4, registroPonto.getTipoRegistro());

            //Executar a query
            pstm.execute();

            System.out.println("Registro de ponto salvo com sucesso!");
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //R: READ - SELECT
    public static List<RegistroPonto> getRegistroPonto() {

        String sql = "Select * FROM registro_ponto";

        List<RegistroPonto> registroPontos = new ArrayList<RegistroPonto>();

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
                RegistroPonto registroPonto = new RegistroPonto();

                //id
                registroPonto.setId(rset.getInt("id"));
                //id funcionario
                registroPonto.setIdFuncionario(rset.getInt("id_funcionario"));
                //data
                registroPonto.setData(rset.getDate("data"));
                //hora
                registroPonto.setHora(rset.getTime("hora"));
                //tipo de registro
                registroPonto.setTipoRegistro(rset.getString("tipoRegistro"));

                registroPontos.add(registroPonto);

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

        return registroPontos;
    }

    //U: UPDATE - SET
    public static void update(RegistroPonto registroPonto) {
        String sql = "UPDATE registro_ponto SET id_funcionario = ?, data = ?, hora = ?, tipoRegistro = ? " +
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar conexao com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criar a classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar os valores para atualizar

            pstm.setInt(1, registroPonto.getIdFuncionario());
            pstm.setDate(2, (Date) registroPonto.getData());
            pstm.setTime(3, registroPonto.getHora());
            pstm.setString(4, registroPonto.getTipoRegistro());

            //Qual o ID do Registro de ponto que deseja atualizar?
            pstm.setInt(5, registroPonto.getId());

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
        String sql = "DELETE FROM registro_ponto WHERE id = ?";

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

