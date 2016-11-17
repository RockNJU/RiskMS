<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>风险管理系统RMS</title>
		<link rel="shortcut icon" href="../assets/pic/favicon.png">

		<!-- CSS -->
		<link href="../assets/css/style.min.css" rel="stylesheet">
		<link rel="stylesheet" href="../assets/css/amazeui.css"/>
	</head>
	<body class="projects ">
		<header class="">
			<div class="container">
				<div class="row">
				
					<div class="col-xs-2 col-sm-6 col-md-8">
						<nav id="mobile-menu-icon" class="mobile-menu-icon desktop-menu hidden-md hidden-lg">
							<a class="hamburger" href="#"><span class="ion-navicon"></span></a>
						</nav>
						<nav class="desktop-menu hidden-xs hidden-sm">
							<a href="../user/login.jsp" >经理与开发者入口</a>
							<a href="../admin/login.jsp">管理员入口</a>
						</nav>
					</div>
				</div>
			</div>
		</header>
		<section class="gradient">
	<div class="container" style="margin-left:35%">
		<div class="row">
			<div class="clearfix" >
			
	<s:form name="loginForm" action="/user/loginMD" method="post">
	<%
	String message=null;
	if((message=(String)request.getAttribute("message"))!=null)
	%>
	<p style="color:red">${message}</p>
      <table align="center" style="border-collapse: separate;border-spacing: 10px">
        <tr>
          <td><s:textfield name="user.user_name" label="用户名称" required="required"/></td>
        </tr>
        <tr>
           <td><s:password name="user.user_psd" label="登陆密码" required="required"/></td>
        </tr> 
       
        <tr>
          <td colspan="2" align="center">
          <s:submit value="登陆" cssClass="am-btn am-btn-block am-btn-primary"/> 
          </td>
        </tr>
      </table>
    </s:form>
			
      </div>
      </div>
      </div>
      </section>
      
      <footer>
			<div class="container">
				<div class="row">
					<div class="footer-notes">
						<div class="col-xs-12 col-sm-4">
							<h1>From our blog</h1>
															<p><a href="/blog/pushh-is-an-app-to-help-you-track-your-fitness-selfies">Pushh is a free iPhone app that helps you keep track of your fitness selfies</a></p>
															<p><a href="/blog/ddo-downloaded-90k-times">Den Danske Ordbog has hit 90K downloads on the App Store</a></p>
													</div>
						<div class="col-xs-12 col-sm-4">
							<h1>We are social</h1>
							<p>We tweet, we post shots on Dribbble and updates on Facebook. Be sure to follow us :</p>
							<p><a href="http://www.twitter.com/dviance" target="_blank" class="social twitter animated">&#xf243;</a> <a href="http://www.dribbble.com/snapeuh" target="_blank" class="social instagram animated">&#xf22c;</a> <a href="http://www.facebook.com/dviance" target="_blank" class="social facebook animated">&#xf231;</a></p>
						</div>
						<div class="col-xs-12 col-sm-4">
							<h1>Contact us</h1>
							<p>We are available from Monday to Friday from 10AM to 6PM :</p>
							<p><a href="/contact" class="btn btn-sm uppercase">Get in touch</a></p>
						</div>
					</div>
				</div>
				<div class="separator"></div>
				<div class="row">
					<div class="col-xs-12 copyright text-center">
						<p>All right reserved • Dviance 2014 • Made in France</p>
					</div>
				</div>
			</div>
		</footer>
	
</body>
</html>