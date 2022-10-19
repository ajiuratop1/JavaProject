import org.postgresql.jdbc.PgConnection;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;



public class TestConnection {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "postgres";
        String pass = "postgres";


        try (Connection conn = DriverManager.getConnection(url, userName, pass);
             BufferedReader sqlFile = new BufferedReader(new FileReader("/Users/petrodavydiuk/IdeaProjects/UltimateJava/src/table.sql"));
             Scanner scan = new Scanner(sqlFile);
             Statement statement = conn.createStatement()) {
            String line = " ";
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                if (line.endsWith(";")) {
                    line = line.substring(0, line.length() - 1);
                }
                statement.executeUpdate(line);
            }
            ResultSet rs = null;


        }
    }
}
