/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.islamic.DawaPage.DawaPage.repository;

import com.java.islamic.DawaPage.DawaPage.entity.Comment;
import com.java.islamic.DawaPage.DawaPage.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KEMAL
 */
 
public  interface UserRepository extends  JpaRepository<User, Long> {

       public List<User> findByEmail(String email);
       
 
    
}
