/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.islamic.DawaPage.DawaPage;

import com.java.islamic.DawaPage.DawaPage.entity.Role;
import com.java.islamic.DawaPage.DawaPage.entity.User;
import com.java.islamic.DawaPage.DawaPage.service.CommentService;
import com.java.islamic.DawaPage.DawaPage.service.PostService;
import com.java.islamic.DawaPage.DawaPage.service.SubTopicService;
import com.java.islamic.DawaPage.DawaPage.service.UserService;
import java.util.List;
import java.util.Set;
 
 
 
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTest {

    @Autowired
    public UserService userService;

    @Autowired
    public SubTopicService subTopicService;
    @Autowired
    public PostService postService;
    @Autowired
    public CommentService  commentService;
    
    
    @Test
    public void contexLoads() throws Exception {

    }

    
    @Test
    public void findUser_Admin() throws Exception {
    List<User>   lst=userService.findUser_Admin();
     logger.info("all users  number  -> {}",lst.size());
    lst.forEach((user) -> {
        logger.info("all users with Admin Role -> {}  ",user);
       
        });

     
    }
  private   Logger logger = LoggerFactory.getLogger(this.getClass());
}
