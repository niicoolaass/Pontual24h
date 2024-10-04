package br.com.ponto.dao;

import br.com.ponto.factory.ConnectionFactory;
import br.com.ponto.model.Funcionario;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;

public class FuncionarioDAO {
    //C: CREATE
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
}
