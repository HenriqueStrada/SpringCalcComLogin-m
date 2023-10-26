package com.calc.prestativa;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



public class NotFound {

    @ControllerAdvice
    public class ErrorController {

        @ExceptionHandler(value = { org.springframework.web.servlet.NoHandlerFoundException.class })
        public String handleNotFound() {
            return "notfound";
        }
    }
}
