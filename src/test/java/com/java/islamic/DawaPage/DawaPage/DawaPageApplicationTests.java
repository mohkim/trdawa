package com.java.islamic.DawaPage.DawaPage;

import com.java.islamic.DawaPage.DawaPage.entity.Comment;
import com.java.islamic.DawaPage.DawaPage.entity.User;
import com.java.islamic.DawaPage.DawaPage.service.CommentService;
import com.java.islamic.DawaPage.DawaPage.service.SubTopicService;
import com.java.islamic.DawaPage.DawaPage.service.UserService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DawaPageApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @Autowired
    SubTopicService  subTopicService;

    @Test
    public void contextLoads() {

    }

    @Test
    public void commentNotReadbyUser() {
        User user = userService.getUser(3L);

        LOG.log(Level.INFO,"retur of test  -->  "+subTopicService.subtopicAccessUser(user, 1L));
        
    }
    private static final Logger LOG = Logger.getLogger(DawaPageApplicationTests.class.getName());

}
