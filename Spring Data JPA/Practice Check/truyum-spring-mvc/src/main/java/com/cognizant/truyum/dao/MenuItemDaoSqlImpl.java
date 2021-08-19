package com.cognizant.truyum.dao;

import java.sql.Date;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component("menuItemDao")
public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<MenuItem> getMenuItemListAdmin() {
		
		String query = "select mi_id as id, mi_name as name, mi_price as Price, mi_category as category,"+ 
		"if (mi_active = 'yes','true','false') as active, if (mi_free_delivery = 'yes','true','false') as freeDelivery, mi_date_of_launch as dateOfLaunch  from menu_item";
		List<MenuItem> menuItemList = jdbcTemplate.query(query, new BeanPropertyRowMapper<MenuItem>(MenuItem.class));

		return menuItemList;

	}

	public List<MenuItem> getMenuItemListCustomer() {
		String query = "select mi_id as id, mi_name as name, mi_price as Price, mi_category as category,"+ 
				"if (mi_active = 'yes','true','false') as active, if (mi_free_delivery = 'yes','true','false') as freeDelivery, mi_date_of_launch as dateOfLaunch  from menu_item";
		List<MenuItem> menuItemList = jdbcTemplate.query(query, new BeanPropertyRowMapper<MenuItem>(MenuItem.class));
		return menuItemList;
	}

	public MenuItem getMenuItem(long menuItemId) {
		String query = "select mi_name name,mi_price price,mi_date_of_launch dateOfLaunch,mi_category category,"
				+ "if (mi_active = 'yes','True','False') as active, if (mi_free_delivary = 'yes','True','False') as freeDelivery from menu_items where mi_id=?";
		MenuItem menuItem = jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<MenuItem>(MenuItem.class),
				new Object[] {menuItemId});
		return menuItem;

	}

	public void modifyMenuItem(MenuItem menuItem) {
		
		String query = "update menu_items set mi_name =?,mi_price =?,mi_active = ?,mi_date_of_launch =?,mi_category =?,mi_free_delivary = ? where mi_id=?";
		int n = jdbcTemplate.update(query, new Object[] { menuItem.getName(), menuItem.getPrice(), menuItem.isActive(),menuItem.getDateOfLaunch(),menuItem.getCategory(),menuItem.isFreeDelivery(),menuItem.getId() });

	}

}
