<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
     

    <title>Login Page | </title>
    <%@ include file="header.jsp" %>

  </head>

  <body class="login">
 
      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form id="supplierlogin" method="POST" action="/login/login">
              <h1>User Login</h1>
              <div>
                <input type="email" class="form-control" placeholder="Username" required="required" name="emailId"/>
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Password" required="required" name="password" />
              </div>
              <div>
                <button href="index.html" type="submit" class="btn btn-success col-sm-12">Log in</button>
               </div>
               <div>
               	<a href="/user/register" class="btn btn-primary col-sm-12">User Register</a>
               </div>
               <div>
               	<a href="/supplier/register-form" class="btn btn-primary col-sm-12">New Supplier Registration</a>
               </div>

              <div class="clearfix"></div>

            </form>
          </section>
        </div>

     </div>
         <script src="/SupplierDashboard/vendors/jquery/dist/jquery.min.js"></script>
     
         <script src="/SupplierDashboard/vendors/sweetalert2/sweetalert2.min.js"></script>
     
         <script src="/SupplierDashboard/js/notify.min.js"></script>

	<script type="text/javascript">
		var frm = $('#supplierlogin');
		frm.submit(function(e) {
			$.ajax({
				type : frm.attr('method'),
				url : frm.attr('action'),
				data : frm.serialize(), // serializes the form's elements.
				success : function(data) {
					if (data === 'admin') {
						//swal('Good job!', data.message, 'success')
						location.href = "/AdminDashboard/AdminView/admin_home.jsp";
					}else if (data === 'supplier') {
						//swal('Good job!', data.message, 'success')
						location.href = "/SupplierDashboard/supplierView/index_home.jsp";
					}else if (data === 'enduser') {
						swal('Good job!', data.message, 'success')
						location.href = "/";
					} else if (data === 'fail') {
						$("#supplierlogin").notify(data.message, {
							position : "top center"
						});
					} else {
						swal('Oops...', 'Something went wrong!', 'error')
					}
				}
			});
			e.preventDefault(); // avoid to execute the actual submit of the form.
		});
		
		function supplierReg(){
			
		}
	</script>
</body>
</html>