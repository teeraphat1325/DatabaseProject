/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.databaseproject.service;

import com.mycompany.databaseproject.dao.UserDao;
import com.mycompany.databaseproject.model.User;

/**
 *
 * @author teeraphat
 */
public class UserService {
    public User login(String name,String password){
        UserDao userDao = new UserDao();
        User user = userDao.getByName(name);
        if(user != null && user.getPassword().equals(password)){
            return user; 
        }
        return null;
    }
}
