 
jQuery.prototype.serializeObject=function(){  
    var obj=new Object();  
    $.each(this.serializeArray(),function(index,param){  
        if(!(param.name in obj)){  
            obj[param.name]=param.value;  
        }  
    });  
    return obj;  
};  

function ajax_register(registerData){
	 $.ajax({
	        type: 'post',
	        url: '../b/register.do',
	        data :registerData,
	        dataType: 'json',
	        success: function (registerData) {
	        	if('success'== registerData ){
	            	alert("注册成功");
	            	window.location.href="../a/login.do";
	            }else if('mailFail'== registerData ){
	            	alert("注册失败,邮箱已经注册");
	            	//$('#register-btn').href();
	            }else if('resetSubmit'== registerData ){
	            	alert("注册失败,不可重复提交");
	            	//$('#register-btn').href();
	            }else{
	            	alert("注册失败,"+registerData);
	            	 
	            }
	        },
	        error: function () {
	        	alert("网络异常");
	        }

	    });
}


function ajax_forgotPassword(forgotPasswordData){
	 $.ajax({
	        type: 'post',
	        url: '../b/forgotPassword.do',
	        data :forgotPasswordData,
	        dataType: 'json',
	        success: function (forgotPasswordData) {
	        	if('success'== forgotPasswordData ){
	            	
	        	/*	$('.control-group').addClass('error');
	        		$('.controls').appendChild($('.input-icon left').createElement('label')).addClass('.help-inline help-small no-left-padding');
	        		$('.help-inline help-small no-left-padding').html("邮件发送成功");*/
	        		alert("邮件发送成功");
	        		window.location.href="../a/login.do";
	            }else{
	            	alert("邮件发送失败");
	            	//$('#register-btn').href();
	            }
	        },
	        error: function () {
	        	alert("网络异常");
	        }

	    });
}

var Login = function () {
    
    return {
        // main function to initiate the module
        init: function () {
        	
           $('.login-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	                username: {
	                    required: true
	                },
	                password: {
	                    required: true
	                },
	                remember: {
	                    required: false
	                }
	            },

	            messages: {
	                username: {
	                    required: "Username is required."
	                },
	                password: {
	                    required: "Password is required."
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   
	                $('.alert-error', $('.login-form')).show();
	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	            	
	               // $("#loginForm").submit();
	             //   $(form).submit();
	            	

	            }
	        });

	        $('.login-form input').keypress(function (e) {
	            if (e.which == 13) {
	                if ($('.login-form').validate().form()) {
	                	$("#loginForm").submit();
	                }
	                return false;
	            }
	        });

	        $('.forget-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                email: {
	                    required: true,
	                    email: true
	                }
	            },

	            messages: {
	                email: {
	                    required: "Email is required."
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   

	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	            	var data = $(form).serializeObject() ;
	            	ajax_forgotPassword(data);
	            }
	        });

	        $('.forget-form input').keypress(function (e) {
	            if (e.which == 13) {
	                if ($('.forget-form').validate().form()) {
	                    window.location.href = "index.html";
	                }
	                return false;
	            }
	        });

	        jQuery('#forget-password').click(function () {
	            jQuery('.login-form').hide();
	            jQuery('.forget-form').show();
	        });

	        jQuery('#back-btn').click(function () {
	            jQuery('.login-form').show();
	            jQuery('.forget-form').hide();
	        });

	        $('.register-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                username: {
	                    required: true
	                },
	                password: {
	                    required: true
	                },
	                rpassword: {
	                    equalTo: "#register_password"
	                },
	                email: {
	                    required: true,
	                    email: true
	                },
	                tnc: {
	                    required: true
	                }
	            },

	            messages: { // custom messages for radio buttons and checkboxes
	                tnc: {
	                    required: "Please accept TNC first."
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   

	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	                
	              
	            },

	            errorPlacement: function (error, element) {
	                if (element.attr("name") == "tnc") { // insert checkbox errors after the container                  
	                    error.addClass('help-small no-left-padding').insertAfter($('#register_tnc_error'));
	                } else {
	                    error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	                }
	            },

	            submitHandler: function (form) {
	            	var data = $('.register-form').serializeObject() ;
	            	ajax_register(data);
	            }
	        });
	        

	        jQuery('#register-btn').click(function () {
	            jQuery('.login-form').hide();
	            jQuery('.register-form').show();
	        });

	        jQuery('#register-back-btn').click(function () {
	            jQuery('.login-form').show();
	            jQuery('.register-form').hide();
	        });
        }

    };

}();
