<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supplier Registration |</title>
<%@ include file="header.jsp" %>
<style type="text/css">
#success_message{ display: none;}

.dis{
    display: inline;
    display: none;
}

</style>
</head>

<body>

 <div class="container">

    <form class="well form-horizontal" action=" " method="post"  id="contact_form">
<fieldset>

<!-- Form Name -->
<legend>Supplier Registration Form!</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" >User Name</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="user_name" placeholder="User Name" class="form-control"  type="text">
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Password</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input name="password" placeholder="Password" class="form-control"  type="text">
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Confirm Password</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input name="conf_password" placeholder="Confirm Password" class="form-control"  type="text">
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label">First Name</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  name="first_name" placeholder="First Name" class="form-control"  type="text">
    </div>
  </div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label" >Last Name</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="last_name" placeholder="Last Name" class="form-control"  type="text">
    </div>
  </div>
</div>

<!-- Text input-->
       <div class="form-group">
  <label class="col-md-4 control-label">E-Mail</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input name="email" placeholder="E-Mail Address" class="form-control"  type="text">
    </div>
  </div>
</div>


<!-- Text input-->
       
<div class="form-group">
  <label class="col-md-4 control-label">Phone #</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="phone" placeholder="(845)555-1212" class="form-control" type="text">
    </div>
  </div>
</div>

<!-- Text input-->
      
<div class="form-group">
  <label class="col-md-4 control-label">Address</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="address" placeholder="Address" class="form-control" type="text">
    </div>
  </div>
</div>

<!-- Text input-->
 
<div class="form-group">
  <label class="col-md-4 control-label">City</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="city" placeholder="city" class="form-control"  type="text">
    </div>
  </div>
</div>

<!-- Select Basic -->
   
<div class="form-group"> 
  <label class="col-md-4 control-label">State</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="state" class="form-control selectpicker">
      <option value=" " >Please select your state</option>
      <option>Alabama</option>
      <option>Alaska</option>
      <option >Arizona</option>
      <option >Hawaii</option>
      <option >daho</option>
      <option >Wyoming</option>
    </select>
  </div>
</div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label">Zip Code</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  	<input name="zip" placeholder="Zip Code" class="form-control"  type="text">
    </div>
</div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">Website or domain name</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
  <input name="website" placeholder="Website or domain name" class="form-control" type="text">
    </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">Upload your shop document</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-paperclip"></i></span>
  <input name="file" class="form-control" type="file">
    </div>
  </div>
</div>
<!-- radio checks -->
 <div class="form-group">
                        <label class="col-md-4 control-label">Services</label>
                        <div class="col-md-8 inputGroupContainer">
                             <div class="checkbox input-group">
						      <!-- <label class="control-label"><input type="checkbox" value="">Water</label> -->
						      <label class="control-label">
						      	<input type="checkbox" name="check1" onclick="dynInput(this);" />
						      							    
						      Residential </label><br>
						      <!-- <a id="c1" style="display: none;">This is check one content</a><br> -->
						     <!--  <div id="c1" style="display: none;">This is div for</div> -->
						      
						      <div id="c1"  style="display: none;" class="form-inline form-group res inputGroupContainer" >
							    <span class="form-inline form-group">
							    <label>Water Type:</label>
							    <select>
								    <option>Kinley</option>
								    <option>Bislery</option>
								    <option>Aquanfina</option>
								    <option>New Water</option>
							     </select>
							     
							     <label>Liter</label>
							    <select><option>1 lt</option>
							    <option>2 lt</option>
							    <option>5 lt</option>
							    <option>15 lt</option>
							     </select>
							    <label> Price:</label>
							     <input type="text"/>
							     <button class="btn btn-success add-more" type="button" onclick="addMore()"><i class="glyphicon glyphicon-plus"></i> Add</button>
								
							     </span>
						    </div>
						      
						      
							  <label class="control-label"> 
							  	<input type="checkbox" name="check2" onclick="dynInput(this);" />
							  	Commercial </label><br>
							  	<p id ="c2"></p><br>
							  <label class="control-label"> 
							  	<input type="checkbox" name="check3" onclick="dynInput(this);" />
							  	Party </label><br>
							  <p id="c3"></p>
						    </div>
						    
                            
                        </div>
                    </div>


<!-- Success message -->
<div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for contacting us, we will get back to you shortly.</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-warning" >Send <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>

</fieldset>
</form>
</div>
    </div><!-- /.container -->
    <script>
    
    
    function dynInput(cbox) {
    	if(cbox.checked && 'check1'==cbox.name){
    		//alert('check box is checked'); getElementsByClassName getElementById
    		document.getElementById('c1').style.display = "block";
    		
    	}else if('check1'== cbox.name) {    		
    		//alert('check box is unchecked');
    		document.getElementById('c1').style.display = "none";
    	}
   
	    
    }
    function addMore(){
    	alert('clicked on the add button');
    	
    	var number = document.getElementById("c1").value;

        for (i=0;i<1;i++){

            var input = document.createElement("input");
            input.type = "text";
            container.appendChild(input);
            container.appendChild(document.createElement("br"));
        }
    	
    	
    }
   
    </script>
 <script type="text/javascript">
  
 $(document).ready(function() {
	  
	    $('#contact_form').bootstrapValidator({
	        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            first_name: {
	                validators: {
	                        stringLength: {
	                        min: 2,
	                    },
	                        notEmpty: {
	                        message: 'Please supply your first name'
	                    }
	                }
	            },
	             last_name: {
	                validators: {
	                     stringLength: {
	                        min: 2,
	                    },
	                    notEmpty: {
	                        message: 'Please supply your last name'
	                    }
	                }
	            },
	            email: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please supply your email address'
	                    },
	                    emailAddress: {
	                        message: 'Please supply a valid email address'
	                    }
	                }
	            },
	            phone: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please supply your phone number'
	                    },
	                    phone: {
	                        country: 'US',
	                        message: 'Please supply a vaild phone number with area code'
	                    }
	                }
	            },
	            address: {
	                validators: {
	                     stringLength: {
	                        min: 8,
	                    },
	                    notEmpty: {
	                        message: 'Please supply your street address'
	                    }
	                }
	            },
	            city: {
	                validators: {
	                     stringLength: {
	                        min: 4,
	                    },
	                    notEmpty: {
	                        message: 'Please supply your city'
	                    }
	                }
	            },
	            state: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please select your state'
	                    }
	                }
	            },
	            zip: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please supply your zip code'
	                    },
	                    zipCode: {
	                        country: 'US',
	                        message: 'Please supply a vaild zip code'
	                    }
	                }
	            },
	            comment: {
	                validators: {
	                      stringLength: {
	                        min: 10,
	                        max: 200,
	                        message:'Please enter at least 10 characters and no more than 200'
	                    },
	                    notEmpty: {
	                        message: 'Please supply a description of your project'
	                    }
	                    }
	                }
	            }
	        })
	        .on('success.form.bv', function(e) {
	            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
	                $('#contact_form').data('bootstrapValidator').resetForm();

	            // Prevent form submission
	            e.preventDefault();

	            // Get the form instance
	            var $form = $(e.target);

	            // Get the BootstrapValidator instance
	            var bv = $form.data('bootstrapValidator');

	            // Use Ajax to submit form data
	            $.post($form.attr('action'), $form.serialize(), function(result) {
	                console.log(result);
	            }, 'json');
	        });
	});
 
 

 </script>
</body>
</html>