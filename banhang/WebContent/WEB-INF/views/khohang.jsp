<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="text/html; charset=UTF-8">
  <title>Kho Hàng</title>
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
            <h1>KHO HÀNG</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Kho hàng</li>
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
              <h3 class="card-title">Kho Hàng</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
					<th>Ngày</th>
                  	<th>Kiểu</th>
                  	<th>Sản phẩm</th>
                  	<th>SL nhập</th>
                  	<th>SL xuất</th>
                  	<th>Tồn kho</th>
                  	<th>Giá</th>
                  	<th>Giá Vốn</th>
                  	<th>Chiết khấu</th>
                  	<th>Tổng tiền</th>
                  	<th>Ghi chú</th>
                  
				</tr>
                </thead>
                <tbody>
           <c:forEach items="${khoHang}" var = "sanpham">
				<tr>
					<td>${sanpham.ngay}</td>
					<td>${sanpham.kieu}</td>
					<td>${sanpham.tenSanPham}</td>
					<td>${sanpham.soLuongNhap}</td>
					<td>${sanpham.soLuongXuat}</td>
					<th>${sanpham.tonKho}</th>
					<td><span id="giaban${sanpham.id}">${sanpham.giaBan}</span></td>
					<td><span id="giavon${sanpham.id}">${sanpham.giaVon}</span></td>
					<td>${sanpham.chietKhau}</td>
					<td><span id="tong${sanpham.id}">${sanpham.giaBan + sanpham.giaBan*sanpham.vat/100 - sanpham.giaBan*sanpham.chietKhau/100}</span></td>
					<th>${sanpham.ghiChu}</th>
					
				</tr>
	</c:forEach>
                </tbody>
                <tfoot>
                <tr>
                 	<th>Ngày</th>
                  	<th>Kiểu</th>
                  	<th>Sản phẩm</th>
                  	<th>SL nhập</th>
                  	<th>SL xuất</th>
                  	<th>Tồn kho</th>
                  	<th>Giá</th>
                  	<th>Giá Vốn</th>
                  	<th>Chiết khấu</th>
                  	<th>Tổng tiền</th>
                  	<th>Ghi chú</th>
                  
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
<script>
window.onload = function(){
	
		 <c:forEach items="${khoHang}" var = "sanpham">
		var clsgiabanid = "giaban" + ${sanpham.id};
		var clsgiavonid = "giavon" + ${sanpham.id};
		var clstongid = "tong" + ${sanpham.id};
		var giasp = ${sanpham.giaBan};
		var chietkhau = ${sanpham.chietKhau};
		var vat = ${sanpham.vat};
		var tongtien = giasp + giasp*vat/100 - chietkhau*giasp/100;
		var giaban = document.getElementById(clsgiabanid).innerHTML;
		var giavon = document.getElementById(clsgiavonid).innerHTML;
		var tong = document.getElementById(clstongid).innerHTML;
		
		document.getElementById(clsgiabanid).innerHTML = FormatNumber(giaban);
		document.getElementById(clsgiavonid).innerHTML = FormatNumber(giavon);
		document.getElementById(clstongid).innerHTML = FormatNumber(String(tongtien));
		</c:forEach>
	}
function FormatNumber(str) {
		var strTemp = GetNumber(str);
		if (strTemp.length <= 3)
			return strTemp;
		strResult = "";
		for (var i = 0; i < strTemp.length; i++)
			strTemp = strTemp.replace(",", "");
		var m = strTemp.lastIndexOf(".");
		if (m == -1) {
			for (var i = strTemp.length; i >= 0; i--) {
				if (strResult.length > 0 && (strTemp.length - i - 1) % 3 == 0)
					strResult = "," + strResult;
				strResult = strTemp.substring(i, i + 1) + strResult;
			}
		} else {
			var strphannguyen = strTemp.substring(0, strTemp.lastIndexOf("."));
			var strphanthapphan = strTemp.substring(strTemp.lastIndexOf("."),
					strTemp.length);
			var tam = 0;
			for (var i = strphannguyen.length; i >= 0; i--) {

				if (strResult.length > 0 && tam == 4) {
					strResult = "," + strResult;
					tam = 1;
				}

				strResult = strphannguyen.substring(i, i + 1) + strResult;
				tam = tam + 1;
			}
			strResult = strResult + strphanthapphan;
		}
		return strResult;
	}

	function GetNumber(str) {
		var count = 0;
		for (var i = 0; i < str.length; i++) {
			var temp = str.substring(i, i + 1);
			
			if (temp == " ")
				return str.substring(0, i);
			if (temp == ".") {
				if (count > 0)
					return str.substring(0, ipubl_date);
				count++;
			}
		}
		return str;
	}

	function IsNumberInt(str) {
		for (var i = 0; i < str.length; i++) {
			var temp = str.substring(i, i + 1);
			if (!(temp == "." || (temp >= 0 && temp <= 9))) {
				alert(inputnumber);
				return str.substring(0, i);
			}
			if (temp == ",") {
				return str.substring(0, i);
			}
		}
		return str;
	}
</script>
</body>
</html>