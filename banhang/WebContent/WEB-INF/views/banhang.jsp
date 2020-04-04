<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="text/html; charset=UTF-8">
 <title>Bán Hàng</title>
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="assets/plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="customcss/style.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="assets/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="assets/plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="assets/dist/css/adminlte.min.css">
  <link rel="stylesheet" href="assets/dist/css/style.min.css">
  <link rel="stylesheet" href="assets/dist/css/style.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="assets/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="assets/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="assets/plugins/summernote/summernote-bs4.css">
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
            <h1>BÁN HÀNG</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Bán hàng</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    <!-- Main content -->
      <section class="content">
      <div class="row">
        <div class="col-md-12 col-xs-12">
          <div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title">Sản phẩm</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                  <i class="fas fa-minus"></i></button>
              </div>
            </div>
            <div class="card-body">
             <form method="POST" action="${pageContext.request.contextPath}/them-vao-gio">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Tên sản phẩm</th>
                  <th>Đơn giá</th>
                  <th>Số lượng</th>
                  <th>Chiết khấu</th>
                  <th>Thêm vào giỏ</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td><select class="form-control custom-select" name="masanpham" onchange="demo(this.value)">
                 <option value="">Chọn sản phẩm</option>
                  <c:forEach items="${sanpham}" var = "sanpham">
                  <option value="${sanpham.maSanPham}">${sanpham.tenSanPham}</option>
                   </c:forEach>
                </select></td>
                  <td><input type="text" id="giaban" name="giaban" onkeyup="this.value=FormatNumber(this.value);"></td>
                  <td><input type="number" name="soluong" value="1"></td>
                  <td><input type="text" name="chietkhau" value="0" onkeyup="this.value=FormatNumber(this.value);"></td>
                  <td><button type="submit"><i class="fas fa-plus"></i></button></td>
                </tr>
                </tbody>
              </table>
             
              </form>
            </div>

          </div>
        </div>
     <div class="col-md-12 col-xs-12">
          <div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title">Giỏ Hàng</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                  <i class="fas fa-minus"></i></button>
              </div>
            </div>
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Sản phẩm</th>
                  <th>Đơn giá</th>
                  <th>Số lượng</th>
                  <th>ĐVT</th>
                  <th>Chiết khấu</th>
                  <th>Xóa</th>
                </tr>
                </thead>
                <tbody>
               <c:forEach items="${giohang}" var = "giohang">
				<tr>
					<td>${giohang.tenSanPham}</td>
					<td><span id="gia${giohang.id}" >${giohang.giaBan}</span></td>
					<td>${giohang.soLuong}</td>
					<td>${giohang.donVi}</td>
					<td><span id="chietkhau${giohang.id}">${giohang.chietKhau}</span></td>
					<td><a href="${pageContext.request.contextPath}/xoa-don-hang?id=${giohang.id}">Xóa</a></td>
				</tr>
	</c:forEach>
                </tbody>
              </table>
              
            </div>

          </div>
        </div>
        <div class="col-md-7 col-xs-12"  style="float: left;">
           <div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title">Khách hàng</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                  <i class="fas fa-minus"></i></button>
              </div>
            </div>
            <form method="POST" action="${pageContext.request.contextPath}/ban-hang">
            <div class="card-body">
              <div class="col-md-12 form-group float-left">
                <label for="inputKhachHang">Khách Hàng:</label>
              <select class="form-control custom-select" name="makhachhang" onchange="kh(this.value)">
                 <option value="">Chọn khách hàng</option>
                  <c:forEach items="${khachhang}" var = "khachhang">
                  <option value="${khachhang.maKhachHang}">${khachhang.hoTen}</option>
                   </c:forEach>
                </select>
              </div>

              <div class="col-md-6 form-group float-left">
                <label for="inputMaKhachHang">Mã Khách Hàng:</label>
                <span id="makhachhang" class="infokh"></span>
              </div>
              <div class="col-md-6 form-group float-left">
                <label for="inputMaKhachHang">Họ tên:</label>
                <span id="tenkhachhang" class="infokh"></span>
              </div>

               <div class="col-md-6 form-group float-left">
                <label for="inputSoDT">Số điện thoại:</label>
                 <span id="dienthoai" class="infokh"></span>
              </div>

              <div class="col-md-6 form-group float-left">
                <label for="inputLoai" >Loại:</label>
                 <span id="loai" class="infokh"></span>
              </div>

              <div class="col-md-6 form-group float-left">
                <label for="inputEmail">Email:</label>
                 <span id="email" class="infokh"></span>
              </div>

              <div class="col-md-6 form-group float-left">
                <label for="inputGioiTinh">Giới tính:</label>
                 <span id="gioitinh" class="infokh"></span>
              </div>

              
               <div class="col-md-12 form-group float-left">
                <label for="inputDiaChi">Địa chỉ:</label>
                <span id="diachi" class="infokh"></span>
              </div>

            </div>
            <!-- /.card-body -->
        </div></div>

        <div class="col-md-5 col-xs-12"  style="float: left;">
           <div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title">Thanh toán</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                  <i class="fas fa-minus"></i></button>
              </div>
            </div>
            <div class="card-body">
              <div class="col-md-12 form-group">
                 <label for="inputNhanVien">Nhân viên bán hàng:</label>
                  <select class="form-control custom-select" name="nhanvien">
                  <c:forEach items="${nhanvien}" var = "nhanvien">
                  <option value="${nhanvien.userName}">${nhanvien.hoten} - ${nhanvien.userName}</option>
                   </c:forEach>
                </select>
              </div>

              <div class="col-md-12 form-group">
                 <label for="inputTongTienHang">Tổng tiền hàng:</label>
                 <span style="float: right;" class="giaban" id="tongtien"></span>
              </div>

              <div class="col-md-12 form-group">
                 <label for="inputKhachCanTra">Tổng chiết khấu:</label>
                 <span style="float: right;" class="giaban" id = "chietkhau"></span>
              </div>

               <div class="col-md-12 form-group">
                <label for="inputGhiChu">Ghi chú:</label>
                <textarea type="text" id="inputGhiChu" class="form-control" name="ghichu"></textarea>
              </div>

              <div class="col-12 " style="text-align: center; margin-bottom: 20px;">
                <input type="submit" value="Lưu" class="btn btn-block btn-danger">
              </div>

            </div>
            </form>
            <!-- /.card-body -->
        </div></div>




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

<!-- jQuery -->
<script src="assets/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="assets/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="assets/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="assets/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="assets/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="assets/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="assets/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="assets/plugins/moment/moment.min.js"></script>
<script src="assets/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="assets/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="assets/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="assets/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="assets/dist/js/adminlte.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="assets/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="assets/dist/js/demo.js"></script>
<!-- page script -->
 <script language="javascript">

 function kh($makh){
	<c:forEach items="${khachhang}" var = "khachhang">
		if($makh == "${khachhang.maKhachHang}"){
			document.getElementById("makhachhang").innerHTML = "${khachhang.maKhachHang}";
			document.getElementById("dienthoai").innerHTML = "${khachhang.dienThoai}";
			document.getElementById("loai").innerHTML = "${khachhang.loai}";
			document.getElementById("email").innerHTML = "${khachhang.email}";
			document.getElementById("gioitinh").innerHTML = "${khachhang.gioiTinh}";
			document.getElementById("diachi").innerHTML = "${khachhang.diaChi}";
			document.getElementById("tenkhachhang").innerHTML = "${khachhang.hoTen}";
		}
		</c:forEach>
}

 function demo($masp){
              				
              				<c:forEach items="${sanpham}" var = "sanpham">
              				
              				if($masp== '${sanpham.maSanPham}'){
              					document.getElementById("giaban").value = FormatNumber('${sanpham.giaBan}');
              				}
              				</c:forEach>
              			}
	              		
              			
              			window.onload = function(){
              				var tongtien=0;
              				var chietkhau1=0;
              				
              				<c:forEach items="${giohang}" var = "sanpham">
              				var id = "gia" + ${sanpham.id};
              				var idchietkhau = "chietkhau" + ${sanpham.id};
              				var chietkhau =document.getElementById(idchietkhau).innerHTML;
              				var giatri = document.getElementById(id).innerHTML;
              				document.getElementById(idchietkhau).innerHTML = FormatNumber(chietkhau);
              				document.getElementById(id).innerHTML = FormatNumber(giatri);
              				tongtien+=(${sanpham.giaBan} + ${sanpham.giaBan}*${sanpham.vat}/100)*${sanpham.soLuong};
              				chietkhau1+=${sanpham.chietKhau}*${sanpham.soLuong}*${sanpham.giaBan}/100;
              				</c:forEach>
              				
              				var tong = document.getElementById("tongtien");
              				var temp= tongtien - chietkhau1;
              				tong.innerHTML = FormatNumber(String(temp));
              				var chietkh = document.getElementById("chietkhau");
              				chietkh.innerHTML = FormatNumber(String(chietkhau1));
              				
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