/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.islamic.DawaPage.DawaPage.service;

import com.java.islamic.DawaPage.DawaPage.entity.Role;
import com.java.islamic.DawaPage.DawaPage.entity.Sub_topic;
import com.java.islamic.DawaPage.DawaPage.entity.User;
import com.java.islamic.DawaPage.DawaPage.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KEMAL
 */
@Repository
public class UserService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public RoleService roleService;

    public void newAdmin(User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        user.addRoles(roleService.getAdminRole());
        userRepository.save(user);

    }

    public void newUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setUserActive(true);

        user.addRoles(roleService.getUserRole());
        userRepository.save(user);

    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }

    public User getUser(Long id) {
        return userRepository.getOne(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean isEmailPresent(String email) {
        List<User> list = userRepository.findByEmail(email);

        if (!list.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public User findByEmail(String email) {
        List<User> list = userRepository.findByEmail(email);

        return list.get(0);
    }

    public int userDiabled(String email) {
        List<User> list = userRepository.findByEmail(email);
        if (list.isEmpty()) {   //  user  do not  exist
            return 0;
        } else {
            if (list.get(0).isUserActive()) {
                return 1;   // user  exit and active  
            } else {
                return 2;             // user  exist  and not  active
            }
        }
    }
/**
 * returns all Users with Admin Role
 * @return  
 */
    public List<User> findUser_Admin() {
        Role adm = roleService.getAdminRole();
        return userRepository.findAdminUser(adm.getName());

    }
/**
 * returns all Users with User Role
 * @return  
 */
    public List<User> findUser_User() {
        Role usr = roleService.getUserRole();
        return userRepository.findAdminUser(usr.getName());

    }
}
