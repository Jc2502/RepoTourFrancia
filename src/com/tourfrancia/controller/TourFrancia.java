package com.tourfrancia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TourFrancia { 
    @RequestMapping("/index")
        public ModelAndView goToIndex() {
		 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from TourFrancia.Java</div><br><br>";
		return new ModelAndView("index", "message", message);
	}
        
	
        
        
        @RequestMapping("/galeria")
        public ModelAndView goToGaleria() {
		 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from TourFrancia.Java</div><br><br>";
		return new ModelAndView("galeria", "message", message);
	}
        
        @RequestMapping("/laCarrera")
	public ModelAndView goToLaCarrera() {
		 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from TourFrancia.Java</div><br><br>";
		return new ModelAndView("laCarrera", "message", message);
	}
       
        @RequestMapping("/entrenamientos")
        public ModelAndView goToEntrenamientos() {
		 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from TourFrancia.Java</div><br><br>";
		return new ModelAndView("entrenamientos", "message", message);
	}
         @RequestMapping("/noticias")
        public ModelAndView goToNoticias() {
		 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from TourFrancia.Java</div><br><br>";
		return new ModelAndView("noticias", "message", message);
	}
        @RequestMapping("/contacto")
        public ModelAndView goToContacto() {
		 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from TourFrancia.Java</div><br><br>";
		return new ModelAndView("contacto", "message", message);
	}
}	