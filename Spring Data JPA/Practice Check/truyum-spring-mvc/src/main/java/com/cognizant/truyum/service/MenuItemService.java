package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {

//	@Autowired
//	private MenuItemDao menuItemDao;
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);

//	public List<MenuItem> getMenuItemListAdmin() {
//		return menuItemDao.getMenuItemListAdmin();
//	}
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin()
	{
		LOGGER.info("Start");
		return menuItemRepository.findAll();
	}
	
	@Transactional
	public List<MenuItem> getMenuItemListCustomer()
	{
		LOGGER.info("Start");
	 return menuItemRepository.findByActiveItems();
	}
	
	@Transactional
	public MenuItem getMenuItem(long menuItemId)
	{
		LOGGER.info("Start");
		return menuItemRepository.findById(menuItemId).get();
		
	}
	
	@Transactional
	public void modifyMenuItem(MenuItem menuItem)
	{
		LOGGER.info("Start");
		menuItemRepository.save(menuItem);
		LOGGER.info("End");
		
	}
	


//	public List<MenuItem> getMenuItemListCustomer() {
//		return menuItemDao.getMenuItemListCustomer();
//	}
//
//	public void modifyMenuItem(MenuItem menuItem) {
//		menuItemDao.modifyMenuItem(menuItem);
//	}
//
//	public MenuItem getMenuItem(long menuItemId) {
//		return menuItemDao.getMenuItem(menuItemId);
//	}

}
