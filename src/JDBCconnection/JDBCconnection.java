/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCconnection;

import java.sql.*;
/**
 *
 * @author annalangstrom
 */
public class JDBCconnection {
    public static void main(String []args) throws SQLException{
        
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false";
        final String SELECT_QUERY = "SELECT title, author FROM item";
        final String user = "root";
        final String pass = "annasvea";
        
        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL, user, pass);
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY))
        {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            System.out.printf("Authors Table of Books Database:%n%n");
            
            for (int i = 1; i <= numberOfColumns; i++)
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            System.out.println();
            
            while(resultSet.next()){
                for (int i = 1; i <= numberOfColumns; i++)
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                    
                System.out.println();
                
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
}
