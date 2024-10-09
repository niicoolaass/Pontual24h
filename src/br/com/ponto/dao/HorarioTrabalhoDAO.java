package br.com.ponto.dao;

import br.com.ponto.factory.ConnectionFactory;
import br.com.ponto.model.Funcionario;
import br.com.ponto.model.HorarioTrabalho;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class HorarioTrabalhoDAO {
    //C: CREATE
    public static void save(HorarioTrabalho HorarioTrabalho) throws Exception {

        String sql = "INSERT INTO horario_trabalho(diasSemana, horarioEntrada, horarioSaida, intervalo) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar uma conexão com o BD
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criação do PreparedStatement, para executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Valores esperados pela query
            pstm.setString(1, HorarioTrabalho.getDiasSemana());
            pstm.setTime(2, HorarioTrabalho.getHorarioEntrada());
            pstm.setTime(3, HorarioTrabalho.getHorarioSaida());
            pstm.setTime(4, HorarioTrabalho.getIntervalo());

            //Executar a query
            pstm.execute();

            System.out.println("Horário de trabalho salvo com sucesso!");
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
    public static List<HorarioTrabalho> getHorarioTrabalho() {

        String sql = "Select * FROM horario_trabalho";

        List<HorarioTrabalho> horarioTrabalho = new ArrayList<HorarioTrabalho>();

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
                HorarioTrabalho horarioTrabalho1 = new HorarioTrabalho();

                //id
                horarioTrabalho1.setId(rset.getInt("id"));
                //dias da semana
                horarioTrabalho1.setDiasSemana(rset.getString("diasSemana"));
                //Horario de entrada
                horarioTrabalho1.setHorarioEntrada(rset.getTime("horarioEntrada"));
                //Horario de saida
                horarioTrabalho1.setHorarioSaida(rset.getTime("horarioSaida"));
                //Intervalo
                horarioTrabalho1.setIntervalo(rset.getTime("intervalo"));

                horarioTrabalho.add(horarioTrabalho1);

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

        return horarioTrabalho;
    }

    //U: UPDATE - SET
    public static void update(HorarioTrabalho horarioTrabalho) {
        String sql = "UPDATE horario_trabalho SET diasSemana = ?, horarioEntrada = ?, horarioSaida = ?, intervalo = ? " +
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar conexao com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criar a classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar os valores para atualizar

            pstm.setString(1, horarioTrabalho.getDiasSemana());
            pstm.setTime(2, (Time) horarioTrabalho.getHorarioEntrada());
            pstm.setTime(3, (Time) horarioTrabalho.getHorarioSaida());
            pstm.setTime(4, (Time) horarioTrabalho.getIntervalo());

            //Qual o ID do horario de trabalho que deseja atualizar?
            pstm.setInt(5, horarioTrabalho.getId());

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
        String sql = "DELETE FROM horario_trabalho WHERE id = ?";

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

