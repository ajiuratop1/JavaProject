import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main extends TestConnection {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "postgres";
        String pass = "postgres";

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name > ");
        String inputString1 = input.nextLine();

        System.out.print("Enter your surname : ");
        String inputString2 = input.nextLine();

        System.out.print("Enter your age : ");
        String inputString3 = input.nextLine();

        System.out.println(inputString1 +" " + inputString2 + " " + inputString3);


        Connection conn = DriverManager.getConnection(url, userName, pass);
        Statement statement = conn.createStatement();
        String sql = String.format("INSERT INTO Users (name,surname,age) VALUES " + "( " + "\'" + inputString1 + "\'" +", " +"\'" + inputString2 +"\'" + ","+ inputString3 + ")");
        System.out.printf(sql);
        statement.executeUpdate(sql);



//
//        //JOptionPane example
//        String input = JOptionPane.showInputDialog(null,
//                "Enter Your name:");
//
//        JOptionPane.showMessageDialog(null, "You entered " + input);


                ;
    };
}
