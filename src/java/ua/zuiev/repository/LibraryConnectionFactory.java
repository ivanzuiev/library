/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.zuiev.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Vanes
 */
public class LibraryConnectionFactory {
    
    public Connection getConnection(){
        Connection connection=null;
         try {
            InitialContext ic=new InitialContext();
            
            DataSource ds=(DataSource) ic.lookup("java:comp/env/jdbc/Library_2");
            
            connection=ds.getConnection();
        }   catch (SQLException ex) {
            Logger.getLogger(LibraryConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(LibraryConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    return connection;
}
}