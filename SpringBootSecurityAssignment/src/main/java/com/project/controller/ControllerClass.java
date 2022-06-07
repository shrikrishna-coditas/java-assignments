package com.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ControllerClass {
    @RequestMapping("/")
    public ModelAndView login() {
        return new ModelAndView("LoginPage");
    }

    //returns dashboard.jsp page (restricted for user only)
    @RequestMapping("/dashboard")
    public ModelAndView userDashboard() {
        return new ModelAndView("Dashboard");
    }

    //returns adminPanel.jsp page (restricted for admin only)
    @RequestMapping("/adminPanel")
    public ModelAndView adminDashboard() {
        return new ModelAndView("AdminPanel");
    }
}
