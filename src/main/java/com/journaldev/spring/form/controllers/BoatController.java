package com.journaldev.spring.form.controllers;

import com.journaldev.spring.form.model.Boat;
import com.journaldev.spring.form.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BoatController {

	private static final Logger logger = LoggerFactory.getLogger(BoatController.class);

	private Map<String, Boat> boats = null;

	public BoatController(){
		boats = new HashMap<String, Boat>();
	}

	@RequestMapping(value = "/boat/save", method = RequestMethod.GET)
	public String saveBoatPage(Model model) {
		logger.info("Returning boatSave.jsp page from saveBoatPage");
		model.addAttribute("boat", new Boat());
		return "boatSave";
	}

	@RequestMapping(value = "/boat/save.do", method = RequestMethod.POST)
	public String saveBoatAction(@Valid Boat boat, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
            logger.info(bindingResult.toString());
			logger.info("Returning boatSave.jsp page from saveBoatAction");
			return "boatSave";
		}
		logger.info("Returning boatSaveSuccess.jsp page");
		model.addAttribute("boat", boat);
		boats.put(boat.getReference(), boat);
		return "boatSaveSuccess";
	}

}
