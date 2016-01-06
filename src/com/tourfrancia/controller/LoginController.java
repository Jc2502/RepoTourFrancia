package com.tourfrancia.controller;

import LogicaTour.Equipos.Ciclista;
import LogicaTour.Equipos.Equipo;
import LogicaTour.Etapas.Etapa;
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
import java.util.List;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loggedInUser")
public class LoginController {

    @Autowired
    private LoginDelegate loginDelegate;
    private ProxyTour proxyTour = new ProxyTour();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean) {
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @ModelAttribute("loginBean") LoginBean loginBean) {

        ModelAndView model = null;
        try {
            boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
            if (isValidUser) {

                modelMap.addAttribute("loggedInUser", loginBean.getUsername());
                if (loginBean.getUsername().equals("admin")) {
                    System.out.println("admin Login Successful");
                    request.setAttribute("loggedInUser", modelMap.get("loggedInUser"));
                    model = new ModelAndView("admin/indexPage");
                } else {
                    System.out.println("User Login Successful");
                    request.setAttribute("loggedInUser", modelMap.get("loggedInUser"));
                    model = new ModelAndView("index");
                }
            } else {

                modelMap.addAttribute("loggedInUser", "null");
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
    public ModelAndView showTeamInfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @ModelAttribute("equipoBean") Equipo equipoBean) {
        if (modelMap.get("loggedInUser").equals("null")) {
            return null;
        }
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
    public ModelAndView showCicInfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @ModelAttribute("ciclistaBean") Ciclista ciclistaBean) {
        if (modelMap.get("loggedInUser").equals("null")) {
            return null;
        }
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
    public ModelAndView showPuertoInfo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("puertoBean") Puerto puertoBean, ModelMap modelMap) {
        if (modelMap.get("loggedInUser").equals("null")) {
            return null;
        }
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
    public ModelAndView goToIndex(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        if (modelMap.get("loggedInUser").equals("null")) {
            return null;
        }
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/puertos", method = RequestMethod.GET)
    public ModelAndView goToPuertos(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        if (modelMap.get("loggedInUser").equals("null")) {
            return null;
        }
        return new ModelAndView("puertos");
    }

     @RequestMapping(value = "/loadEtapa", method = RequestMethod.POST)
    public ModelAndView loadEtapa(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @ModelAttribute("etapaBean") Etapa etapaBean) {
        if (modelMap.get("loggedInUser").equals("null")) {
            return null;
        }
        
        request.setAttribute("listaEtapas", proxyTour.getEtapas());
        request.setAttribute("etapa", proxyTour.getEtapa(etapaBean.getNumeroEtapa()));
        request.setAttribute("listaPuertos", proxyTour.getPuertosEtapa(etapaBean.getNumeroEtapa()));
       // request.setAttribute("listaGanadorEtapaPuerto", proxyTour.getGanadorEtapaPuerto());
        return new ModelAndView("etapas");
    }
    
      @ModelAttribute("etapaBean")
    public Etapa getEtapa() {
        return new Etapa();
    }
    
    
    @RequestMapping(value = "/etapas", method = RequestMethod.GET)
    public ModelAndView goToEtapas(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        if (modelMap.get("loggedInUser").equals("null")) {
            return null;
        }
        
        request.setAttribute("listaEtapas", proxyTour.getEtapas()); 
        return new ModelAndView("etapas");
    }

    @RequestMapping("/contacto")
    public ModelAndView goToContacto(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        if (modelMap.get("loggedInUser").equals("null")) {
            return null;
        }
        return new ModelAndView("contacto");
    }

    @RequestMapping(value = "/equipos", method = RequestMethod.GET)
    public ModelAndView goToEquipos(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        if (modelMap.get("loggedInUser").equals("null")) {
            return null;
        } else {
            request.setAttribute("listaEquipos", proxyTour.getEquipos());
            return new ModelAndView("equipos");
        }
    }

    @RequestMapping(value = "/ciclistas", method = RequestMethod.GET)
    public ModelAndView goToCiclistas(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        if (modelMap.get("loggedInUser").equals("null")) {
            return null;
        } else {
            ModelAndView model = new ModelAndView("ciclistas");
            request.setAttribute("listaCiclistas", proxyTour.getCiclistas());
            return model;
        }
    }

    /**
     * *****************************************ADMIN
     * ZONE************************************************************
     */
    @RequestMapping(value = "/modifyCiclistas", method = RequestMethod.GET)
    public ModelAndView goToAddCiclistas(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {

        if (!modelMap.get("loggedInUser").equals("admin")) {
            return null;
        }
        request.setAttribute("listaCiclistas", proxyTour.getCiclistas());
        request.setAttribute("listaEquipos", proxyTour.getEquipos());
        return new ModelAndView("admin/modifyCiclistas");

    }

    @RequestMapping(value = "/loadCiclista", method = RequestMethod.POST)
    public ModelAndView addCiclista(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @ModelAttribute("ciclistaBean") Ciclista ciclistaBean) {
        Ciclista ciclista = null;
        if (!modelMap.get("loggedInUser").equals("admin")) {
            return null;
        }
        if (request.getParameter("submit").equals("Remove")) {
            if (proxyTour.existeCiclista(ciclistaBean.getNombre())) {
                proxyTour.rmCiclista(ciclistaBean.getNombre());

            }
        } else if (request.getParameter("submit").equals("Update")) {
            if (proxyTour.existeCiclista(ciclistaBean.getNombre())) {
                ciclista = proxyTour.getCiclista(ciclistaBean.getNombre());
                if (ciclistaBean.getNombreEquipo() != null) {
                    ciclista.setNombreEquipo(ciclistaBean.getNombreEquipo());
                    proxyTour.modCiclistaEquipo(ciclista.getNombre(), ciclista.getNombreEquipo());
                }
            } else {
                proxyTour.addCiclistaEquipo(ciclistaBean.getNombre(), ciclistaBean.getNombreEquipo());
            }
        }
        request.setAttribute("listaCiclistas", proxyTour.getCiclistas());
        request.setAttribute("listaEquipos", proxyTour.getEquipos());
        request.setAttribute("ciclista", proxyTour.getCiclista(ciclistaBean.getNombre()));
        return new ModelAndView("admin/modifyCiclistas");
    }

    @RequestMapping(value = "/modifyEquipos", method = RequestMethod.GET)
    public ModelAndView goToAddEquipo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        if (!modelMap.get("loggedInUser").equals("admin")) {
            return null;
        }
        request.setAttribute("listaEquipos", proxyTour.getEquipos());
        return new ModelAndView("admin/modifyEquipos");

    }

    @RequestMapping(value = "/modEquipo", method = RequestMethod.POST)
    public ModelAndView addEquipo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @ModelAttribute("equipoBean") Equipo equipoBean) {
        Equipo equipo = null;
        if (!modelMap.get("loggedInUser").equals("admin")) {
            return null;
        }
        if (request.getParameter("submit").equals("Remove")) {
            if (proxyTour.existeEquipo(equipoBean.getNombre())) {
                proxyTour.rmEquipo(equipoBean.getNombre());
                equipoBean.setNombreDirector("");
                equipoBean.setNombre("");
            }
        } else if (request.getParameter("submit").equals("Update")) {
            if (proxyTour.existeEquipo(equipoBean.getNombre())) {
                if (equipoBean.getNombre() != null) {
                    proxyTour.modDirecEquipo(equipoBean.getNombre(), equipoBean.getNombreDirector());
                    equipoBean.setNombreDirector(proxyTour.getEquipo(equipoBean.getNombre()).getNombreDirector());
                }
            } else {
                proxyTour.addEquipo(equipoBean.getNombre(), equipoBean.getNombreDirector());

            }
        }
        
        request.setAttribute("listaEquipos", proxyTour.getEquipos());
        return new ModelAndView("admin/modifyEquipos");
    }
    
    @RequestMapping(value = "/loadEquipo", method = RequestMethod.POST)
    public ModelAndView loadEquipo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @ModelAttribute("equipoBean") Equipo equipoBean) {
        Equipo equipo = null;
        if (!modelMap.get("loggedInUser").equals("admin")) {
            return null;
        }
            
        if (!equipoBean.getNombre().equals("")) {
               equipoBean.setNombreDirector(proxyTour.getEquipo(equipoBean.getNombre()).getNombreDirector());
        }

        
        
        request.setAttribute("listaEquipos", proxyTour.getEquipos());
        return new ModelAndView("admin/modifyEquipos");
    }
    
    @RequestMapping(value = "/indexPage", method = RequestMethod.GET)
    public ModelAndView goToIndexPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        if (!modelMap.get("loggedInUser").equals("admin")) {
            return null;
        }

        return new ModelAndView("admin/indexPage");

    }
    
     @RequestMapping(value = "/adminEtapas", method = RequestMethod.GET)
    public ModelAndView goToAdminEtapas(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {

        if (!modelMap.get("loggedInUser").equals("admin")) {
            return null;
        }
        request.setAttribute("etapaBean", proxyTour.getEtapa(1));
        request.setAttribute("listaCiclistas", proxyTour.getListaCiclistas());
        request.setAttribute("listaEquipos", proxyTour.getEquipos());
        request.setAttribute("listaEtapas", proxyTour.getEtapas());
        return new ModelAndView("admin/adminEtapas");

    }
    @RequestMapping(value = "/modEtapa", method = RequestMethod.POST)
    public ModelAndView modEtapa(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @ModelAttribute("etapaBean") Etapa etapaBean) {
        System.out.println("modetapas");
        if (!modelMap.get("loggedInUser").equals("admin")) {
            return null;
        }
        if (etapaBean!= null) {
            if (etapaBean.getGanador_etapa() != null) {
                proxyTour.setGanadorEtapa(etapaBean.getNumeroEtapa(),etapaBean.getGanador_etapa());
            }
        }
        request.setAttribute("listaCiclistas", proxyTour.getListaCiclistas());
        request.setAttribute("listaEquipos", proxyTour.getEquipos());
        request.setAttribute("listaEtapas", proxyTour.getEtapas());
        return new ModelAndView("admin/adminEtapas");

    }
    
    
     @RequestMapping(value = "/adminPuertos", method = RequestMethod.GET)
    public ModelAndView goToAdminPuertos(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {

        if (!modelMap.get("loggedInUser").equals("admin")) {
            return null;
        }
        request.setAttribute("etapaBean", proxyTour.getEtapa(1));
        request.setAttribute("listaCiclistas", proxyTour.getListaCiclistas());
        request.setAttribute("listaEquipos", proxyTour.getEquipos());
        request.setAttribute("listaEtapas", proxyTour.getEtapas());
        request.setAttribute("listaPuertos", proxyTour.getPuertos());
        return new ModelAndView("admin/adminPuertos");

    }
    
    
    
    
    
     @RequestMapping(value = "/logout")
     public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
         
         modelMap.addAttribute("loggedInUser", "null");
         
         return new ModelAndView("login");
     }

}
