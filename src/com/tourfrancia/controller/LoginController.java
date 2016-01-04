package com.tourfrancia.controller;

import LogicaTour.Equipos.Ciclista;
import LogicaTour.Equipos.Equipo;
import LogicaTour.Etapas.Puerto;
import LogicaTour.Tour_Francia.ProxyTour;
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
import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class LoginController {

    @Autowired
    private LoginDelegate loginDelegate;
    private ProxyTour proxyTour = new ProxyTour();

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
                if (loginBean.getUsername().equals("admin")) {
                    System.out.println("admin Login Successful");
                    request.setAttribute("loggedInUser", loginBean.getUsername());
                    model = new ModelAndView("admin/indexPage");
                } else {
                    System.out.println("User Login Successful");
                    request.setAttribute("loggedInUser", loginBean);
                    model = new ModelAndView("index");
                }
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

    @RequestMapping(value = "/equipos", method = RequestMethod.POST)
    public ModelAndView showTeamInfo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("equipoBean") Equipo equipoBean) {
        ModelAndView model = null;
        try {
            System.out.println(equipoBean.getNombre());
            equipoBean = proxyTour.getEquipo(equipoBean.getNombre());
            request.setAttribute("listaEquipos", proxyTour.getEquipos());
            if (equipoBean != null) {
                System.out.println("Successful");
                request.setAttribute("ciclistas", equipoBean.getCiclistas());
                request.setAttribute("equipo", equipoBean);
                model = new ModelAndView("equipos");
            } else {
                System.out.println("FAIL");
                model = new ModelAndView("equipos");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    @ModelAttribute("equipoBean")
    public Equipo getEquipo() {
        return new Equipo();
    }

    @RequestMapping(value = "/ciclistas", method = RequestMethod.POST)
    public ModelAndView showCicInfo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("ciclistaBean") Ciclista ciclistaBean) {
        ModelAndView model = null;
        try {
            System.out.println(ciclistaBean.getNombre());
            ciclistaBean = proxyTour.getCiclista(ciclistaBean.getNombre());
            request.setAttribute("listaCiclistas", proxyTour.getCiclistas());
            if (ciclistaBean != null) {
                System.out.println("Successful");
                request.setAttribute("nombre", ciclistaBean.getNombre());
                request.setAttribute("equipo", ciclistaBean.getNombreEquipo());
                request.setAttribute("dorsal", ciclistaBean.getDorsal());

                model = new ModelAndView("ciclistas");
            } else {
                System.out.println("FAIL");
                model = new ModelAndView("ciclistas");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    @ModelAttribute("ciclistaBean")
    public Ciclista getCiclista() {
        return new Ciclista();
    }

    @RequestMapping(value = "/puertos", method = RequestMethod.POST)
    public ModelAndView showPuertoInfo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("puertoBean") Puerto puertoBean) {
        ModelAndView model = null;
        try {
            double media = 0;
            if (puertoBean.getCategoria() != null) {
                ArrayList puertos = null;
                ArrayList puertosAux = new ArrayList();
                System.out.println("Successful");
                if (puertoBean.getCategoria().equals("")) {
                    puertos = (ArrayList) proxyTour.getPuertos();
                } else {
                    puertos = (ArrayList) proxyTour.getPuertos(puertoBean.getCategoria());
                }

                if (puertoBean.getAlturaMaxima() != 0) {

                    for (Iterator iterator = puertos.iterator(); iterator.hasNext();) {
                        Puerto next = (Puerto) iterator.next();
                        media += next.getAlturaMaxima();

                    }
                    media = media / puertos.size();
                    System.out.println(media);
                    for (Iterator iterator = puertos.iterator(); iterator.hasNext();) {
                        Puerto next = (Puerto) iterator.next();
                        if (next.getAlturaMaxima() >= media && puertoBean.getAlturaMaxima() == 1) {
                            puertosAux.add(next);
                        } else if (next.getAlturaMaxima() <= media && puertoBean.getAlturaMaxima() == -1) {
                            puertosAux.add(next);
                        }
                    }

                    request.setAttribute("listadoPuertos", puertosAux);
                    model = new ModelAndView("puertos");
                } else {
                    request.setAttribute("listadoPuertos", puertos);
                    model = new ModelAndView("puertos");
                }
            } else {
                System.out.println("FAIL");
                model = new ModelAndView("puertos");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    @ModelAttribute("puertoBean")
    public Puerto getPuerto() {
        return new Puerto();
    }

    @RequestMapping("/index")
    public ModelAndView goToIndex() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/puertos", method = RequestMethod.GET)
    public ModelAndView goToPuertos(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("puertos");
    }

    @RequestMapping("/etapas")
    public ModelAndView goToLaCarrera() {
        return new ModelAndView("etapas");
    }

    @RequestMapping("/contacto")
    public ModelAndView goToContacto() {
        return new ModelAndView("contacto");
    }

    @RequestMapping(value = "/equipos", method = RequestMethod.GET)
    public ModelAndView goToEquipos(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listaEquipos", proxyTour.getEquipos());
        return new ModelAndView("equipos");
    }

    @RequestMapping(value = "/ciclistas", method = RequestMethod.GET)
    public ModelAndView goToCiclistas(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("ciclistas");
        request.setAttribute("listaCiclistas", proxyTour.getCiclistas());
        return model;
    }

    @RequestMapping(value = "/addCiclistas", method = RequestMethod.GET)
    public ModelAndView goToAddCiclistas(HttpServletRequest request, HttpServletResponse response) {
//        if (request.getAttribute("loggedInUser").equals("admin")) {
        return new ModelAndView("admin/addCiclistas");
        // } else {
        //      return null;
        //  }
    }

    @RequestMapping(value = "/addEquipo", method = RequestMethod.GET)
    public ModelAndView goToAddEquipo(HttpServletRequest request, HttpServletResponse response, String loggedInUser) {
        //   if (loggedInUser.equals("admin")) {
        return new ModelAndView("admin/addEquipo");
        //   } else {
        //       return null;
        //   }
    }

}
