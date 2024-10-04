package br.com.ponto.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "147147";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pontual24h?useSSL=false&serverTimezone=UTC";

    // Conexão com o banco de dados
    public static Connection createConnectionToMySQL() throws  Exception{
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return  connection;
    }

    public static void main(String[] args) throws Exception {

        // Recuperar uma conexão com o banco de dados
        Connection con = createConnectionToMySQL();

        //Teste se a conexão é nula
        if (con!=null) {
            System.out.println("Conexão obetida com sucesso!");
            con.close();
        }
    }



}
