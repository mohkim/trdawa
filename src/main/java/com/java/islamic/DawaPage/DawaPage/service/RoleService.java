/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.islamic.DawaPage.DawaPage.service;

import com.java.islamic.DawaPage.DawaPage.entity.Role;
import com.java.islamic.DawaPage.DawaPage.repository.CommentRepository;
import com.java.islamic.DawaPage.DawaPage.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KEMAL
 */
@Repository
public class RoleService {
    @Autowired
    public  RoleRepository roleRepository;
    
    
    
    public void  newRole(Role  role){
           
        roleRepository.save(role);
      
    }
    public  void  deleteRole(Long  id){
        
        roleRepository.deleteById(id);
    }
    
    public  Role  getRole(Long  id){
      return  roleRepository.getOne(id);
    }
    
    public  Role  getAdminRole(){
        Role  role= roleRepository.findByName("ADMIN");
        if(role==null){
            roleRepository.save(new  Role("ADMIN"));
           return  roleRepository.findByName("ADMIN");
        } else
            return  roleRepository.findByName("ADMIN");
    }
    
     public  Role  getUserRole(){
         Role  role= roleRepository.findByName("USER");
        if(role==null){
            roleRepository.save(new  Role("USER"));
           return  roleRepository.findByName("USER");
        } else
            return  roleRepository.findByName("USER");
    }
}
