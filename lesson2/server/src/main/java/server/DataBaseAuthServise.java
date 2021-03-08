package server;

import java.sql.*;

public class DataBaseAuthServise implements AuthService {

    private static Connection connection;
    private static Statement statement;

    public DataBaseAuthServise() {
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE login = ?;");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.isClosed()) {
                System.out.println("empty");
                return null;
            }
            if (resultSet.getString("password").equals(password)) {
                System.out.println("good");
                return resultSet.getString("nickname");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        try {
            connect();
            PreparedStatement preparedStatementSelectLogin = connection.prepareStatement("SELECT * FROM users WHERE (login = ?);");
            preparedStatementSelectLogin.setString(1, login);
            ResultSet resultSetLogin = preparedStatementSelectLogin.executeQuery();

            /*PreparedStatement preparedStatementSelectNickname = connection.prepareStatement("SELECT * FROM users WHERE (nickname = ?);");
            preparedStatementSelectNickname.setString(3, nickname);
            ResultSet resultSetNickname = preparedStatementSelectNickname.executeQuery();*/
            if (!resultSetLogin.isClosed()) {
                return false;
            } else {
                PreparedStatement preparedStatementInsert = connection.prepareStatement("INSERT INTO users (login, password, nickname) VALUES (?, ?, ?);");
                preparedStatementInsert.setString(1, login);
                preparedStatementInsert.setString(2, password);
                preparedStatementInsert.setString(3, nickname);
                return preparedStatementInsert.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return false;
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        statement = connection.createStatement();
    }

    private static void disconnect() {
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
