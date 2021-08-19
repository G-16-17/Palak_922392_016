package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@Autowired
	private MenuItemService menuItemService;

	@GetMapping(path = "/show-menu-item-admin")
	public String showMenuItemAdmin(Model model) {
		LOGGER.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		model.addAttribute("menuItemList", menuItemList);
		LOGGER.info("END");
		return "menu-item-list-admin";
	}

	@GetMapping(path = { "/show-menu-item-list-customer", "/show-cart" })
	public String showMenuItemCustomer(Model model) {
		LOGGER.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		model.addAttribute("menuItemList", menuItemList);
		LOGGER.info("End");
		return "menu-item-list-customer";
	}
	
	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam("menuItemId") long menuItemId, ModelMap model) {
		LOGGER.info("Start");
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		model.put("menuItem", menuItem);
		LOGGER.info("End");
		return "edit-menu-item";

	}
	
	@PostMapping("/edit-menu-item")
	public String editMenuItem(@Validated @ModelAttribute("menuItem") MenuItem editedMenuItem, BindingResult bindingResult) {
		LOGGER.info("Start");
		if(bindingResult.hasErrors())
			return "edit-menu-item";
		menuItemService.modifyMenuItem(editedMenuItem);
		LOGGER.info("End");
		return "edit-menu-item-status";
	}
	


}
