<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>\
<c:url var="APIurl" value="/api-admin-new" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li class="active">Chỉnh sửa bài viết</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>

			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
						<form id="formSubmit">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thể
									loại</label>
								<div class="col-sm-9">
									<select class="form-control" id="categoryCode" name="categoryCode">
										<!-- check categoryCode = null là thêm mới -->
										<c:if test="${empty model.categoryCode}"> 
											<option value="">Chọn loại bài viết</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}"> ${item.name} </option>
											</c:forEach>
										</c:if>
										
										<c:if test="${not empty model.categoryCode}"> 
											<option value="">Chọn loại bài viết</option>
											<c:forEach var="item" items="${categories}">
													<option value="${item.code}" <c:if test="${item.code == model.categoryCode}"> selected="selected" </c:if> >
														 ${item.name} 
													 </option>	
											</c:forEach>
											
										</c:if>
									</select>
								</div>
							</div>
							<br/>
							<br/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tiêu
									đề</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title"
										value="${model.title}" />
								</div>
							</div>
							<br/>
							<br/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Hình
									đại diện</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="thumbnail"
										name="thumbnail" value="" />
								</div>
							</div>
							<br/>
							<br/>
	
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô
									tả ngắn</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="shortDescription"
										name="shortDescription" value="${model.shortDescription }" />
								</div>
							</div>
							<br/>
							<br/>
	
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Nội
									dung</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="content"
										name="content" value="${model.content }" />
								</div>
							</div>
							<br/>
							<br/>
	
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.id}">
										<input type="button" class="btn btn-white btn-warning btn-bold" id="btnAddOrUpdateNew"  value="Cập nhật bài viết" />
									</c:if>
									
									<c:if test="${empty model.id }">
										<input type="button" class="btn btn-white btn-warning btn-bold" id="btnAddOrUpdateNew"  value="Thêm bài viết" />
									</c:if>
									
								</div>
							</div>
							<input type="hidden" value="${model.id}" id="id" name="id"/>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
    $('#btnAddOrUpdateNew').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#id').val();
        if(id == ""){
        	addNew(data);
        }else{
        	updateNew(data);
        }
    });
    
    function addNew(data) {
		$.ajax({
			url: '${APIurl}',
			type: 'POST',
			contentType:'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function (result) {
				console.log(result);
			},
			error: function (error) {
				console.log(error);
			}
		});
	}
    
    function updateNew(data) {
		$.ajax({
			url: '${APIurl}',	//url muốn gọi về là /api-admin-new
			type: 'PUT',		//  method của bài
			contentType:'application/json', // kiểu dữ liệu gửi từ clinent lên sever
			data: JSON.stringify(data),     // ép kiểu từ kiểu javascriptObject sang kiểu json
			dataType: 'json',				// kiểu dữ liệu từ sever gửi về client
			success: function (result) {	
				console.log(result);
			},
			error: function (error) {
				console.log(error);
			}
		});
	}
    
	</script>
</body>
</html>