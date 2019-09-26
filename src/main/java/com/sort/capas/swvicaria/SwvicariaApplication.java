package com.sort.capas.swvicaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class SwvicariaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SwvicariaApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder2(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        String pass = "123";

        for(int i = 0; i < 3; i++){
            String bpass = passwordEncoder2().encode(pass);
            System.out.println(bpass);
        }
    }
}
