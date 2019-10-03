package com.sort.capas.swvicaria.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {

            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404";

            }/* Reservado para el error 500
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }*/
            else if(statusCode == HttpStatus.FORBIDDEN.value()){
                return "403";
            }
        }
        /*Este return esta reservado cuando ahuevo ni puta idea de lo que truene,
        puede ser una pagina asi general como: Something went wrong!
        Our Engineers are on it */
        return "403";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
