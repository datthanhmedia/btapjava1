<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="text/html; charset=UTF-8">
  <title>Thêm Nhân Viên</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="customcss/style.css">
  <!-- Font Awesome -->
   <link rel="stylesheet" href="assets/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="assets/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="assets/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="assets/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>

<body class="sidebar-mini sidebar-collapse">
<div class="wrapper">
  <!-- Navbar -->
  
    <jsp:include page="navbar.jsp" />
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  
	<jsp:include page="sidebar.jsp" />
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>THÊM NHÂN VIÊN</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Thêm nhân viên</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    <!-- Main content -->
${thongbao}
      <section class="content" >
      <div class="row">
        <div class="col-md-12" style="margin: 30px">
          <div class="card card-primary">
            <div class="card-body">
				<form method="POST" action="${pageContext.request.contextPath}/them-nhan-vien">
                <div class="col-md-6 form-group float-left">
                <label>Tài khoản:</label>
                <input type="text" name="username" class="form-control">
              </div>

              <div class="col-md-6 form-group float-left">
                <label>Mật khẩu:</label>
                <input type="password" name="password" class="form-control">
              </div>

              <div class="col-md-6 form-group float-left">
                <label>Chức vụ:</label>
                <select class="form-control custom-select" name="chucvu">
                 <option>Quản Trị</option>
                 <option>Nhân viên bán hàng</option>
                </select>
              </div>
               <div class="col-md-6 form-group float-left">
                <label>Họ tên:</label>
                 <input type="text" name="hoten" class="form-control">
              </div>

               <div class="col-md-6 form-group float-left">
                <label>Ngày sinh:</label>
                 <input type="date" name="ngaysinh" class="form-control">
              </div>

               <div class="col-md-6 form-group float-left">
                <label>CMND/Căn cước</label>
                 <input type="text" name="cmnd" class="form-control">
              </div>

              <div class="col-md-6 form-group float-left">
                <label>Điện thoại:</label>
                 <input type="text" name="dienthoai" class="form-control">
              </div>

              <div class="col-md-6 form-group float-left">
                <label>Email:</label>
                 <input type="text" name="email" class="form-control">
              </div>

            </div>
 
            <!-- /.card-body -->
            <div class="row">
        <div class="col-12 " style="text-align: center; margin-bottom: 20px;">
          <a href="${pageContext.request.contextPath}/home"><button type="button" class="btn btn-secondary">Quay lại</button></a>
          <input type="submit" value="Thêm mới" class="btn btn-success">
        </div>
      </div>
          </div>
          </form>
          <!-- /.card -->
        </div>

      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
    
	<jsp:include page="footer.jsp" />
  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<script src="assets/plugins/jquery/jquery.min.js"></script>
<script src="customjs/custom.js"></script>
<!-- AdminLTE App -->
<script src="assets/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="assets/dist/js/demo.js"></script>
<!-- page script -->
</body>

</html>