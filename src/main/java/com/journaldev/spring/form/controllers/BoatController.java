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
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@Controller
public class BoatController {

	private static final Logger logger = LoggerFactory.getLogger(BoatController.class);

	private Collection<Boat> boats = null;

	public BoatController(){
		boats = new ArrayList<Boat>();
        boats.addAll(dummyData());
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
		boats.add(boat);
		return "boatSaveSuccess";
	}

    @RequestMapping(value = "/boat/list", method = RequestMethod.GET)
    public ModelAndView listBoats() {
        logger.info("Boat list page");

        ModelAndView model = new ModelAndView("boatList");
        model.addObject("boats", boats);

        return model;
    }

    private Collection<Boat> dummyData() {
        List<Boat> dummyList = new ArrayList<>();

        dummyList.add(createBoat("Y0001", "Halberg Rassy", "HR42", 42, Boat.HullType.MONO, "Looking for some crew to do some sailing."));
        dummyList.add(createBoat("Y0002", "Jaguar", "SeaCat", 55, Boat.HullType.MULTI, "I just like to motor about then have some lunch."));

        return dummyList;
    }

    private Boat createBoat(String reference, String manufacturer, String model, int length,
                            Boat.HullType hullType, String description) {
        Boat boat = new Boat();
        boat.setReference(reference);
        boat.setManufacturer(manufacturer);
        boat.setModel(model);
        boat.setLength(length);
        boat.setHullType(hullType);
        boat.setDesc(description);
        return boat;
    }


}
