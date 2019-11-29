package com.sort.capas.swvicaria.service;

public interface IEmailService {
    void send_message(String mail, String author, String event) throws Exception;
}
