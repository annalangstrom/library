/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCconnection;

import GUI.CreateAccountGui;
import java.sql.*;
/**
 *
 * @author annalangstrom
 */
public final class JDBCconnection {
    
    //static final String DBURL = "jdbc:mysql://localhost:3306/library?zeroDateTimeBehavior=convertToNull&useSSL=false"; //Carolines
    static final String DBURL = "jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false"; //Annas
    static final String USER = "root";
    static final String PWD = "annasvea";
    
    private Connection con = null; //Hanterar uppkoppling
    
    //Konstruktor
    public JDBCconnection(CreateAccountGui ca) throws ClassNotFoundException, 
            SQLException{
        this();
        
    }
    //Konstruktor
    public JDBCconnection() throws ClassNotFoundException, 
            SQLException{
       //Koppla upp
       this.con = connectToDb(con); 
    }
    
    public Connection connectToDb(Connection con) throws ClassNotFoundException, SQLException{
       //Koppla upp mot db
        if (con == null){
            con = DriverManager.getConnection(DBURL, USER, PWD);
        } 
        return con;
    }
    
    public void closeDbConnection() throws SQLException{
        //Stäng uppkoppling
        if (con != null) {
            con.close();
        }
    }
    
    
    
}
