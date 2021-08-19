package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	
//	public MenuItemDaoCollectionImpl() {
//
//		if (menuItemList == null) {
//
//			menuItemList = new ArrayList<MenuItem>();
//			try {
//				menuItemList.add(new MenuItem(1001, "Sandwich", 99, true, DateUtil.convertToDate("15/03/2017"),
//						"Main Course", true));
//				menuItemList.add(new MenuItem(1002, "Burger", 129, true, DateUtil.convertToDate("23/12/2017"),
//						"Main Course", false));
//
//				menuItemList.add(new MenuItem(1003, "Pizza", 149, true, DateUtil.convertToDate("21/08/2018"),
//						"Main Course", false));
//
//				menuItemList.add(new MenuItem(1004, "French Fries", 57, false, DateUtil.convertToDate("02/07/2017"),
//						"Starters", true));
//
//				menuItemList.add(new MenuItem(1005, "Chocolate Brownie", 32, true, DateUtil.convertToDate("02/11/2022"),
//						"Dessert", true));
//			} catch (ParseException e) {
//				System.out.println("Error...." + e.getMessage());
//			}
//
//		}
//	}

	private List<MenuItem> menuItemList;

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> itemList = new ArrayList();
		Date today = new Date();
		for (MenuItem item : menuItemList) {
			if ((item.getDateOfLaunch().before(today) || item.getDateOfLaunch().equals(today))
					&& item.isActive() == true) {
				itemList.add(item);
			}
		}
		return itemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		int pos = -1;
		for (int i = 0; i < menuItemList.size(); i++) {

			if (menuItemList.get(i).getId() == menuItem.getId()) {
				pos = i;
				break;
			}
		}
		if (pos != 1) {
			menuItemList.set(pos, menuItem);
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = null;

		for (MenuItem item : menuItemList) {
			if (item.getId() == menuItemId)
				menuItem = item;
			break;
		}
		return menuItem;
	}


}
