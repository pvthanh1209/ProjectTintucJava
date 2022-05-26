package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll(); // lấy tất cả các thể loại lên
	CategoryModel findOne(long id);
	CategoryModel findOneByCode(String code);
}
