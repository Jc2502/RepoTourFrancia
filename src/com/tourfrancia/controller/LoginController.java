package com.tourfrancia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tourfrancia.delegate.LoginDelegate;
import com.tourfrancia.viewBean.LoginBean;

@Controller
public class LoginController {

    @Autowired
    private LoginDelegate loginDelegate;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean) {
        ModelAndView model = new ModelAndView("login");
       // model.addObject("loginBean", loginBean);
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean") LoginBean loginBean) {
        ModelAndView model = null;
        try {
            boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
            if (isValidUser) {
                System.out.println("User Login Successful");
                request.setAttribute("loggedInUser", loginBean.getUsername());
                model = new ModelAndView("laCarrera");
            } else {
                model = new ModelAndView("login");
                request.setAttribute("message", "Invalid credentials!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
        @ModelAttribute("loginBean")
        public LoginBean getLoginBean() {
            return new LoginBean();
        }

    @RequestMapping("/index")
    public ModelAndView goToIndex() {
        return new ModelAndView("index");
    }

    @RequestMapping("/galeria")
    public ModelAndView goToGaleria() {
        return new ModelAndView("galeria");
    }

    @RequestMapping("/laCarrera")
    public ModelAndView goToLaCarrera() {
        return new ModelAndView("laCarrera");
    }

    @RequestMapping("/entrenamientos")
    public ModelAndView goToEntrenamientos() {
        return new ModelAndView("entrenamientos");
    }

    @RequestMapping("/noticias")
    public ModelAndView goToNoticias() {
        return new ModelAndView("noticias");
    }

    @RequestMapping("/contacto")
    public ModelAndView goToContacto() {
        return new ModelAndView("contacto");
    }

     
}
