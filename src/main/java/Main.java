import persistence.BDConnection;
import persistence.Operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {

        public static void main(String[] args) {
            Operations.setConnection(BDConnection.MySQLConnection());
            String sentencia = "SELECT * FROM Ninja;";
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(sentencia)) {
                ResultSet rs = Operations.query_db(ps);
                while (rs.next()) {
                    String nombreNinja = rs.getString("nombreNinja");
                    System.out.println(nombreNinja);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

