package com.tourfrancia.dao.impl;

import LogicaTour.Tour_Francia.Tour;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.tourfrancia.dao.UserDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author CENTAUR
 */
public class UserDaoImpl implements UserDao {

    private Connection c;
    private Statement s;
    private ResultSet rs;
    private ResultSetMetaData rsmd;

    @Override
    public boolean isValidUser(String username, String password) throws SQLException {
        boolean ret = false;
        try {
            Class.forName(("sun.jdbc.odbc.JdbcOdbcDriver"));

            c = DriverManager.getConnection("jdbc:odbc:OrigenDatos", "", "");
            s = c.createStatement();   
            rs = s.executeQuery("Select count(1) from users where username = '" + username + "' and password = '" + password + "'");
            if (rs.next()) {
                ret = (rs.getInt(1) > 0);
            } else {
                ret = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            c.close();
            return ret;
        }
    }
    
}
