package com.java.islamic.DawaPage.DawaPage;

import com.java.islamic.DawaPage.DawaPage.service.RoleService;
import com.java.islamic.DawaPage.DawaPage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import java.util.List;
import com.java.islamic.DawaPage.DawaPage.entity.User;

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

        List<User> lst_adm = userService.findUser_Admin();

        if (lst_adm.isEmpty()) {
            creteAdmin();
        }

    }

    private void creteAdmin() {
        User amd = new User();
        amd.setEmail("kem.moh91@gmail.com");
        amd.setPassword("19hom.mek");
         amd.setFirst_name("Kemal");
          amd.setSecond_name("Mohammed");
          amd.setLast_name("AHMED");
           amd.setGender("Male");
           amd.setCountry("Eritrea");
           amd.setTown("Asmara");
           amd.setPhone_Number("+211920349703");
           amd.setUserActive(true);
              userService.newAdmin(amd);
}

}
