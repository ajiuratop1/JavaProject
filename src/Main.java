import javax.swing.plaf.nimbus.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main {

        public static void main(String[] args)  throws ClassNotFoundException, SQLException, IOException {

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String userName = "postgres";
            String pass = "postgres";



                try(Connection conn = DriverManager.getConnection(url, userName, pass);
                BufferedReader sqlFile = new BufferedReader(new FileReader("/Users/petrodavydiuk/IdeaProjects/UltimateJava/src/table.sql"));
                Scanner scan = new Scanner(sqlFile);
                Statement statement = conn.createStatement()) {
                String line = " ";
                while (scan.hasNextLine()){
                    line = scan.nextLine();
                    if (line.endsWith(";")){
                        line = line.substring(0, line.length() -1);
                    }
                    statement.executeUpdate(line);
                }
                ResultSet rs = null;
                try {
                    rs = statement.executeQuery("SELECT * FROM Questions");
                    while (rs.next()){
                        int id = rs.getInt(1);
                        String text = rs.getString(2);
                        System.out.println("id = " + id + " Question = " + text);

                    }
                } catch (SQLException ex) {
                    System.err.println("SQL exception message: " + ex.getMessage());
                    System.err.println("SQLException SQL state: "+ ex.getSQLState());
                    System.err.println("SQLException error code: "+ ex.getErrorCode());
                }
                finally {
                    if (rs != null) {
                        rs.close();
                    }
                    else {
                        System.err.println("Ошибка чтения данных с БД");
                    }
                }

            }
    }
}