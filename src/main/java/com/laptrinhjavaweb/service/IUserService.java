package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.UserModel;

//tầng service sẽ return về DAO
public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
