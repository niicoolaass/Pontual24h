package br.com.ponto.dao;

import br.com.ponto.factory.ConnectionFactory;
import br.com.ponto.model.RegistroPonto;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;

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
}

