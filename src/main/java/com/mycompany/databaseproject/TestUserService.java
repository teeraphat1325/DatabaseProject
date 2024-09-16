/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.databaseproject;

import com.mycompany.databaseproject.model.User;
import com.mycompany.databaseproject.service.UserService;

/**
 *
 * @author teeraphat
 */
public class TestUserService {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = userService.login("user2", "password");
        if(user!=null){
            System.out.println("Welcome user :" + user.getName());
        }else{
            System.out.println("ERROR");
        }
    }
}
