
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>RiskManageSystem</title>
		

		<!-- CSS -->
		<link href="../assets/css/style.min.css" rel="stylesheet">
		<link rel="stylesheet" href="../css/amazeui.css"/>
	</head>
	<body class="projects ">
		
	<section class="gradient">
		<div class="container" style="margin-left:35%">
			<div class="row">
			<div class="clearfix" >
			<!--  
			<s:form name="loginForm" action="/admin/login" method="post">
			<%
			String message=null;
			if((message=(String)request.getAttribute("message"))!=null)
			%>
			<p style="color:red">${message}</p>
      			<table align="center" style="border-collapse: separate;border-spacing: 10px">
        		<tr>
          		<td><s:textfield name="admin.admin_name" label="姓名" required="required"/></td>
        		</tr>
        		<tr>
           		<td><s:password name="admin.admin_psd" label="密码" required="required"/></td>
       			 </tr> 
       
        		<tr>
          		<td colspan="2" align="center">
          		<s:submit value="登陆" cssClass="am-btn am-btn-block am-btn-primary"/> 
          		</td>
        		</tr>
      			</table>
    		</s:form>
			-->
			<form action='' method='post'>
				<div>
					<p><strong>${info}&nbsp;</strong></p>
				  <div>
					<span>账户</span>
					<input type="text" id='lc' name='logincode'> 
				  </div>
				  <br>
				  <div>
					<span>密码</span>
					<input type="password" id='pwd' name='password'> 
				  </div>
				  <br>
				 <input type="submit" id='login' value="登录" style='margin-top:10px;margin-left:10%'/>
			    </div>
			 </form>
			
      </div>
      </div>
      </div>
      </section>
      
     
	
</body>
</html>