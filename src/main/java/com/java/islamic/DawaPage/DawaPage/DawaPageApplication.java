package com.java.islamic.DawaPage.DawaPage;

import com.java.islamic.DawaPage.DawaPage.entity.Role;
import com.java.islamic.DawaPage.DawaPage.entity.Topic;
import com.java.islamic.DawaPage.DawaPage.entity.User;
import com.java.islamic.DawaPage.DawaPage.service.RoleService;
import com.java.islamic.DawaPage.DawaPage.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class DawaPageApplication implements CommandLineRunner {

    @Autowired
    public RoleService roleService;
    @Autowired
    public UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DawaPageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
 
    }

}
