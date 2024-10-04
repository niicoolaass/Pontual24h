package br.com.ponto.dao;

import br.com.ponto.factory.ConnectionFactory;
import br.com.ponto.model.HorarioTrabalho;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;

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
}

