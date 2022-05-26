package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategorySerivce implements ICategoryService {

	/*
	 * private ICategoryDAO categoryDao;
	 * 
	 * public CategorySerivce() { categoryDao = new CategoryDAO(); }
	 */
	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
	
	
}
