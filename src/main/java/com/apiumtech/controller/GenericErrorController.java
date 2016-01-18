package com.apiumtech.controller;

import com.apiumtech.controller.base.SecureController;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by roman on 18/01/16.
 */
@Controller
public class GenericErrorController extends SecureController implements ErrorController {
    @RequestMapping(path = "/error")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String defaultErrorPage() {
        return "errors/404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
