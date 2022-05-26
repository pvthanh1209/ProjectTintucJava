package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.messageUtil;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {

	private static final long serialVersionUID = 8884535893457453365L;
	
	@Inject
	private INewService newService;
	
	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		NewModel model = new NewModel();
//		String pageStr = request.getParameter("page");
//		String maxPageItemStr = request.getParameter("maxPageItem");
//		if(pageStr != null) {
//			model.setPage(Integer.parseInt(pageStr));
//		}else {
//			model.setPage(1);
//		}
//		if(maxPageItemStr != null) {
//			model.setMaxPageItem(Integer.parseInt("maxPageItemStr"));
//		}
		
		
		NewModel model = FormUtil.toModel(NewModel.class, request); // mapping vào giá trị ở abstractModel để truyền giá trị từ model ra views
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(newService.findAll(pageble)); // lấy ra 1 list
			model.setTotalItem(newService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/new/list.jsp";

		}else if(model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId() != null) { // sửa
				model = newService.findOne(model.getId());
			}else {// thêm mới
				
			}
			request.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/new/edit.jsp";
		}
		messageUtil.showMessage(request);
		request.setAttribute(SystemConstant.MODEL, model); // trả về model
		RequestDispatcher rd = request.getRequestDispatcher(view); // trả về view
		rd.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
