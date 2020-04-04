<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="text/html; charset=UTF-8">
  <title>Danh mục sản phẩm</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

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
            <h1>DANH MỤC</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Danh mục</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    <!-- Main content -->
      <section class="content">
      <div class="row">
        <div class="col-12">
          
          <!-- /.card -->
          <div class="card">
            <div class="card-header">
             <div class="card-header" style="display:flex">
              <h3 class="card-title">Danh Mục Sản Phẩm</h3>
             <span style ="margin-left: auto;"><a href="${pageContext.request.contextPath}/them-danh-muc"><button type="button" class="btn btn-primary">Thêm danh mục</button></a></span>
            </div>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                	<th>ID</th>
					<th>Mã Danh Mục</th>
					<th>Danh Mục</th>
					<th>Ghi chú</th>
					<th>Xử lý</th>
                </tr>
                </thead>
                <tbody>
            <c:forEach items="${tatCaDanhMuc}" var = "danhmuc">
				<tr>
					<td>${danhmuc.idDanhMuc}</td>
					<td>${danhmuc.maDanhMuc}</td>
					<td>${danhmuc.tenDanhMuc}</td>
					<td>${danhmuc.ghiChu}</td>
					<td><a href="${pageContext.request.contextPath}/sua-danh-muc?id=${danhmuc.idDanhMuc}">Sửa</a> / <a href="${pageContext.request.contextPath}/xoa-danh-muc?id=${danhmuc.idDanhMuc}">Xóa</a></td>
			     </tr>
			     </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                 	<th>ID</th>
					<th>Mã Danh Mục</th>
					<th>Danh Mục</th>
					<th>Ghi chú</th>
					<th>Xử lý</th>
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
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

<!-- jQuery -->
<script src="assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="assets/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="assets/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<script src="assets/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="assets/dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    
    $('#example1').DataTable({
      "paging": true,
      "lengthChange": true,
      "searching": true,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
</script>
</body>

</html>