package com.notes.notes.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ErroController implements org.springframework.boot.web.servlet.error.ErrorController{

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Obtém o código de status do erro
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            // Redireciona para a página de erro apropriada com base no código de status
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        // Página de erro padrão
        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
}
