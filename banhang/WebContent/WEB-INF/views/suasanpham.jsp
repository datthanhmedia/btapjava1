<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="text/html; charset=UTF-8">
  <title>Sửa Sản Phẩm</title>
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
            <h1>Sửa sản phẩm: ${sanpham.tenSanPham}</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Sửa sản phẩm</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    <!-- Main content -->

      <section class="content" >
      <div class="row">
        <div class="col-md-12" style="margin: 30px">
          <div class="card card-primary">
            <div class="card-body">
				<form method="POST" action="${pageContext.request.contextPath}/sua-san-pham">
				<input type="text" name="id" class="form-control" value="${sanpham.id}" readonly style="display: none;">
                <div class="col-md-12 form-group float-left">
                <label for="tensanpham">Tên sản phẩm:</label>
                <input type="text" name="tensanpham" class="form-control" value="${sanpham.tenSanPham}">
              </div>

              <div class="col-md-6 form-group float-left">
                <label for="mavach">Mã vạch:</label>
                <input type="text" name="mavach" class="form-control" value="${sanpham.maVach}">
              </div>

              <div class="col-md-6 form-group float-left">
                <label for="masanpham">Mã sản phẩm:</label>
                 <input type="text" name="masanpham" class="form-control" value="${sanpham.maSanPham}" >
              </div>
             

               <div class="col-md-4 form-group float-left">
                <label for="giavon">Giá vốn:</label>
                 <input type="text" name="giavon" class="form-control" value="${sanpham.giaVon}" onkeyup="this.value=FormatNumber(this.value);" id="giavon">
              </div>

               <div class="col-md-4 form-group float-left">
                <label for="giaban">Giá bán:</label>
                 <input type="text" name="giaban" class="form-control" value="${sanpham.giaBan}" onkeyup="this.value=FormatNumber(this.value);" id="giaban">
              </div>

               <div class="col-md-4 form-group float-left">
                <label for="giabuon">Giá buôn:</label>
                 <input type="text" name="giabuon" class="form-control" value="${sanpham.giaBuon}" onkeyup="this.value=FormatNumber(this.value);" id="giabuon">
              </div>

              <div class="col-md-4 form-group float-left">
                <label for="soluong">Số lượng:</label>
                 <input type="number" name="soluong" class="form-control" value="${sanpham.soLuong}">
              </div>

              <div class="col-md-4 form-group float-left">
                <label for="donvi">Đơn vị:</label>
                 <select class="form-control custom-select" name="donvi">
                 <option value="">Chọn</option>
                  <c:forEach items="${donvi}" var = "donvi">
                  <option>${donvi.donVi}</option>
                   </c:forEach>
                </select>
              </div>

              <div class="col-md-4  form-group   float-left">
                <label for="vat">VAT:</label>
                 <input type="text" name="vat" class="form-control " value="${sanpham.vat}">
                  
              </div>
              <div class="col-md-4 form-group float-left">
                <label for="danhmuc">Danh mục sản phẩm:</label>
                 <select class="form-control custom-select" name ="danhmuc">
                 <option value="">Chọn</option>
                   <c:forEach items="${danhmuc}" var = "danhmuc">
                  <option>${danhmuc.tenDanhMuc}</option>
                   </c:forEach>
                </select>
              </div>
              <div class="col-md-4 form-group float-left">
                <label for="thuonghieu">Thương hiệu:</label>
                 <select class="form-control custom-select" name="thuonghieu">
                 <option value="">Chọn</option>
                  <c:forEach items="${thuonghieu}" var = "thuonghieu">
                  <option>${thuonghieu.tenThuongHieu}</option>
                   </c:forEach>
                </select>
              </div>
              <div class="col-md-4 form-group float-left">
                <label for="nhacungcap">Nhà cung cấp:</label>
                 <select class="form-control custom-select" name="thuonghieu">
                  <option value="">Chọn</option>
                   <c:forEach items="${nhacungcap}" var = "nhacungcap">
                  <option>${nhacungcap.tenNhaCungCap}</option>
                   </c:forEach>
                </select>
              </div>
            </div>
 
            <!-- /.card-body -->
            <div class="row">
        <div class="col-12 " style="text-align: center; margin-bottom: 20px;">
          <a href="${pageContext.request.contextPath}/san-pham"><button type="button" class="btn btn-secondary">Quay lại</button></a>
          <input type="submit" value="Hoàn thành" class="btn btn-success">
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
<!-- AdminLTE App -->
<script src="assets/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="assets/dist/js/demo.js"></script>
<!-- page script -->
<script language="javascript">
window.onload = function(){
	var giav = document.getElementById("giavon").value;
	document.getElementById("giavon").value=FormatNumber(giav);
	var giabn = document.getElementById("giaban").value;
	document.getElementById("giaban").value=FormatNumber(giabn);
	var giabun = document.getElementById("giabuon").value;
	document.getElementById("giabuon").value=FormatNumber(giabun);
}
</script>
<script src="customjs/custom.js"></script>

</body>

</html>