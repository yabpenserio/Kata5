package kata5p1;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Kata5P1 {

    public static void main(String[] args){
        String url = "jdbc:sqlite:Kata5.db";
        String sql =  "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                + " Id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " mail text NOT NULL);";
        Connection conn = null;
        Statement stat = null;
        
        try{
            conn = DriverManager.getConnection(url);
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM PEOPLE ");
            while(rs.next()){
                System.out.println(rs.getInt("id") + "\t" +
                                    rs.getString("Name") + "\t" +
                                    rs.getString("Apellidos") + "\t" +
                                    rs.getString("Departamento") + "\t");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        };
        try{
            stat.execute(sql);
            System.out.println("Tabla creada con éxito");
            
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
            
            
        
        
        
    }
    
}
