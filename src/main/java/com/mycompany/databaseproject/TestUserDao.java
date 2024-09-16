/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.databaseproject;

import com.mycompany.databaseproject.dao.UserDao;
import com.mycompany.databaseproject.model.User;

/**
 *
 * @author informatics
 */
public class TestUserDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        for(User u:userDao.getAll()){
            System.out.println(u);
        }
    }
}
