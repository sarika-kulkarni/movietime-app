package com.sarika.apps.movietime.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    public String home(){
        return "forward:/index.html";
    }
}
