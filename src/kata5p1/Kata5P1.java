package kata5p1;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Kata5P1 {

    public static void main(String[] args){
        String url = "jdbc:sqlite:Kata5.db";
        try(Connection connection = DriverManager.getConnection(url)){
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM PEOPLE ");
            while(rs.next()){
                System.out.println(rs.getInt("id") + "\t" +
                                    rs.getString("Name") + "\t" +
                                    rs.getString("Apellidos") + "\t" +
                                    rs.getString("Departamento") + "\t");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        };
        
        
    }
    
}
