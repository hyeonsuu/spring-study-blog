package com.spring.springstudy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public ModelAndView index(HttpServletRequest req, HttpServletResponse res){

        ModelAndView mav = new ModelAndView();

        mav.setViewName("redirect:board/board_main");
        return mav;
    }
}
