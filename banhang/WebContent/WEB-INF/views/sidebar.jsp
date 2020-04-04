  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="${pageContext.request.contextPath}/home" class="brand-link">
      <img src="${pageContext.request.contextPath}/thvlogo.png" alt="Dashboard" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Dashboard</span>
    </a>
    <!-- Sidebar -->
    <div class="sidebar">
     
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
      
          
          <li class="nav-item">
            <a href="home" class="nav-link">
              <i class="fas fa-home"></i>
              <p>
                Trang Chủ 
              </p>
            </a>
          </li>
 		<li class="nav-item">
            <a href="ban-hang" class="nav-link">
              <i class="fas fa-cart-arrow-down"></i>
              <p>
                Bán Hàng
              </p>
            </a>
          </li>
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="fas fa-layer-group"></i>
              <p>
                Sản Phẩm 
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/them-san-pham" class="nav-link">
                  <i class="fas fa-plus"></i>
                  <p>Thêm mới</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/don-vi" class="nav-link">
                  <i class="fas fa-ankh"></i>
                  <p>Đơn vị</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/san-pham" class="nav-link">
                  <i class="fab fa-artstation"></i>
                  <p>Tất cả sản phẩm</p>
                </a>
              </li>
            </ul>
          </li>

           <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="fas fa-table"></i>
              <p>
                Danh mục 
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/them-danh-muc" class="nav-link">
                  <i class="fas fa-plus"></i>
                  <p>Thêm mới</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/danh-muc" class="nav-link">
                  <i class="fab fa-artstation"></i>
                  <p>Tất cả danh mục</p>
                </a>
              </li>
            </ul>
          </li>

          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fab fa-asymmetrik"></i>
              <p>
                Thương Hiệu
                 <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/them-thuong-hieu" class="nav-link">
                  <i class="fas fa-plus"></i>
                  <p>Thêm mới</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/thuong-hieu" class="nav-link">
                  <i class="fab fa-artstation"></i>
                  <p>Tất cả thương hiệu</p>
                </a>
              </li>
            </ul>
          </li>

          <li class="nav-item">
            <a href="#" class="nav-link">
             <i class="fas fa-hotel"></i>
              <p>
                Nhà Cung Cấp
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
             <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/them-nha-cung-cap" class="nav-link">
                  <i class="fas fa-plus"></i>
                  <p>Thêm mới</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/nha-cung-cap" class="nav-link">
                 <i class="fab fa-artstation"></i>
                  <p>Tất cả nhà cung cấp</p>
                </a>
              </li>
            </ul>
          </li>

          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fas fa-users"></i>
              <p>
                Khách Hàng
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
             <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/them-khach-hang" class="nav-link">
                  <i class="fas fa-plus"></i>
                  <p>Thêm mới</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/khach-hang" class="nav-link">
                  <i class="fab fa-artstation"></i>
                  <p>Tất cả khách hàng</p>
                </a>
              </li>
            </ul>
          </li>

          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/kho-hang" class="nav-link">
              <i class="fas fa-database"></i>
              <p>
                Kho Hàng
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/logout" class="nav-link">
              <i class="fas fa-sign-out-alt"></i>
              <p>
                Đăng xuất
              </p>
            </a>
          </li>

        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>