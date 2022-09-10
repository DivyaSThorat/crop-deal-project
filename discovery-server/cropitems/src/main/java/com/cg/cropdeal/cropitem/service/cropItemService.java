package com.cg.cropdeal.cropitem.service;

import java.util.List;

import com.cg.cropdeal.cropitem.model.cropItem;


//import com.cg.cropdeal.cropitem.model.TestcropItem;

public interface cropItemService {
	//Defined the methods which is implemented in cropItemServiceImpl
	cropItem savecropItem(cropItem cropitem);
	List<cropItem> getAllcropItems();
	cropItem getcropItemById(long cropid);
	cropItem updatecropItem(cropItem cropitem,long cropid);
	void deletecropItem(long cropid);
	
}