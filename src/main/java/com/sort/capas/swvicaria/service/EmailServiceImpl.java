package com.sort.capas.swvicaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailSender;

    @Override
    public void send_message(String mail) throws Exception {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true); //multipart are attachments
        msgHelper.setFrom(emailSender);
        msgHelper.setTo(mail);
        msgHelper.setText("MOFA DICE HOLA");
        msgHelper.setSubject("Cabeza de Pija");
        javaMailSender.send(msg);
    }
}
