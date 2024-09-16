/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.databaseproject.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informatics
 */
public class User {
    private int id;
    private String name;
    private String password;
    private int role;
    private String gender;

    public User(int id, String name, String password, int role, String gender) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.gender = gender;
    }

    public User(String name, String password, int role, String gender) {
        this.id = -1;
        this.name = name;
        this.password = password;
        this.role = role;
        this.gender = gender;
    }

    public User() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + ", gender=" + gender + '}';
    }
    
    public void formRS(ResultSet rs){
        try {
            this.setId(rs.getInt("user_id"));
            this.setName(rs.getString("user_name"));
            this.setRole(rs.getInt("user_role"));
            this.setGender(rs.getString("user_gender"));
            this.setPassword(rs.getString("user_password"));
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
