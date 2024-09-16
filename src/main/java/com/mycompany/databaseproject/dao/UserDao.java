/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.databaseproject.dao;

import com.mycompany.databaseproject.helper.DatabaseHelper;
import com.mycompany.databaseproject.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author informatics
 */
public class UserDao implements Dao<User>{

    @Override
    public User get(int id) {
        User user = null;
        ArrayList<User> list = new ArrayList();
        String sql = "SELECT * FROM user WHERE user_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("user_name"));
                user.setRole(rs.getInt("user_role"));
                user.setGender(rs.getString("user_gender"));
                user.setPassword(rs.getString("user_password"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        ArrayList<User> list = new ArrayList();
        String sql = "SELECT * FROM user";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("user_name"));
                user.setRole(rs.getInt("user_role"));
                user.setGender(rs.getString("user_gender"));
                user.setPassword(rs.getString("user_password"));
                
                list.add(user);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }   
    
    @Override
    public User save(User obj) {
        ArrayList<User> list = new ArrayList();
        String sql = "INSERT INTO user (user_name,user_gender,user_password,user_role)"
                + "VALUES(?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getGender());
            stmt.setString(3, obj.getPassword());
            stmt.setInt(4, obj.getRole());
            stmt.executeUpdate();
            int id = DatabaseHelper.getInsertedId(stmt);
            obj.setId(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public User update(User obj) {
        ArrayList<User> list = new ArrayList();
        String sql = "UPDATE user"
                +" SET user_name = ?, user_gender = ? ,user_password = ?, user_role = ?"
                +" WHERE user_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getGender());
            stmt.setString(3, obj.getPassword());
            stmt.setInt(4, obj.getRole());
            stmt.setInt(5, obj.getId());
            int ret = stmt.executeUpdate();
            System.out.println(ret);
            return obj;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
