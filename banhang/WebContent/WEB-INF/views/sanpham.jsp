<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="text/html; charset=UTF-8">
  <title>Tất cả sản phẩm</title>
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
            <h1>SẢN PHẨM</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Sản phẩm</li>
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
            <div class="card-header" style="display:flex">
              <h3 class="card-title">Sản phẩm</h3>
             <span style ="margin-left: auto;"><a href="${pageContext.request.contextPath}/them-san-pham"><button type="button" class="btn btn-primary">Thêm sản phẩm</button></a></span>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
					<th>ID</th>
					<th>Mã Vạch</th>
					<th>Mã sản phẩm</th>
					<th>Tên sản phẩm</th>
					<th>Giá vốn</th>
					<th>Giá bán</th>
					<th>Giá buôn</th>
					<th>Số Lượng</th>
					<th>VAT</th>
					<th>Xử lý</th>
				</tr>
                </thead>
                <tbody>
           <c:forEach items="${tatCaSanPham}" var = "sanpham">
				<tr>
					<td>${sanpham.id}</td>
					<td>${sanpham.maVach}</td>
					<td>${sanpham.maSanPham}</td>
					<td>${sanpham.tenSanPham}</td>
					<td><span id="giavon${sanpham.id}">${sanpham.giaVon}</span></td>
					<td><span id="giaban${sanpham.id}">${sanpham.giaBan}</span></td>
					<td><span id="giabuon${sanpham.id}">${sanpham.giaBuon}</span></td>
					<td>${sanpham.soLuong}</td>
					<td>${sanpham.vat}</td>
					<td><a href="${pageContext.request.contextPath}/sua-san-pham?masanpham=${sanpham.maSanPham}">Sửa</a> / <a href="${pageContext.request.contextPath}/xoa-san-pham?masanpham=${sanpham.maSanPham}">Xóa</a></td>
				</tr>
	</c:forEach>
                </tbody>
                <tfoot>
                <tr>
                 	<th>ID</th>
					<th>Mã Vạch</th>
					<th>Mã sản phẩm</th>
					<th>Tên sản phẩm</th>
					<th>Giá vốn</th>
					<th>Giá bán</th>
					<th>Giá buôn</th>
					<th>Số Lượng</th>
					<th>VAT</th>
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
<script language="javascript">
window.onload = function(){
	<c:forEach items="${tatCaSanPham}" var = "sanpham">
	var idgiav = "giavon" +  ${sanpham.id};
	var giav = document.getElementById(idgiav).innerHTML;
	document.getElementById(idgiav).innerHTML=FormatNumber(String(giav));
	
	var idgiabn = "giaban" +  ${sanpham.id};
	var giabn = document.getElementById(idgiabn).innerHTML;
	document.getElementById(idgiabn).innerHTML=FormatNumber(String(giabn));
	
	var idgiabuon = "giabuon" +  ${sanpham.id};
	var giabun = document.getElementById(idgiabuon).innerHTML;
	document.getElementById(idgiabuon).innerHTML=FormatNumber(String(giabun));
	</c:forEach>
}
</script>
<script src="customjs/custom.js"></script>
</body>
</html>