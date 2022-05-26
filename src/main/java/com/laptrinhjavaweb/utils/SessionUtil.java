package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

// Quản lý thông tin người dùng
public class SessionUtil {
	
	private static SessionUtil sessionUtil = null;
	
	public static SessionUtil getInstance() {
		if(sessionUtil == null) {			// kiểm tra xem đối tượng sessionUtil đã tồn tại hay chưa
			sessionUtil = new SessionUtil();// Nếu chưa thì tạo đối tượng sessionUtil, còn có rồi thì lấy giá trị sessionUtil ra dùng
		}
		return sessionUtil;
	}
	
	// đối tượng session được tạo ra từ HttpServletRequest
	public void putValue(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);   // dùng request để lấy đối tượng session và sét giá trị cho nó
	}
	
	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);  // dùng request để lấy đối tượng session và lấy giá trị từ key ra 
	}
	
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);  // dùng request để lấy đối tượng session và xóa theo key của nó được truyền vào
	}
	
}
