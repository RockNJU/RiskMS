<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>RMS</title>
		<link rel="shortcut icon" href="../assets/pic/favicon.png">

		<!-- CSS -->

		<link href="../assets/css/style.min.css" rel="stylesheet">
		<link rel="stylesheet" href="../assets/css/amazeui.css"/>
		<link rel="stylesheet" href="../assets/css/amazeui.datetimepicker.css"/>
		<link rel="stylesheet" href="../assets/css/admin.css"/>
		<script src="../assets/js/jquery.min.js"></script>
		<script src="../assets/js/amazeui.js"></script>
		<script src="../assets/js/amazeui.datetimepicker.js"></script>
	</head>
	<body >
		<header>
			<div class="container">
				<div class="row">
					<div class="col-xs-10 col-sm-6 col-md-4">
						<a class="logo">风险管理系统</a>
					</div>
				</div>
			</div>
		</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
	<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="../admin/showAllUser"><span class="am-icon-home"></span> 用户管理</a></li>
         <li><a href="../index.jsp"><span class="am-icon-calendar"></span> 注销</a></li>
        
      </ul>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> 公告</p>
          <p>您只有添加系统用户的权限</p>
        </div>
      </div>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-tag"></span> wiki</p>
          <p>Welcome to the Risk Management System wiki!</p>
        </div>
      </div>
    </div>
  </div>

  <!-- sidebar end -->
  <!-- content start -->
  <div class="admin-content">		
	<div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理</strong> <small></small></div>
    </div>
    
<div class="am-tabs am-margin" data-am-tabs>
    <ul class="am-tabs-nav am-nav am-nav-tabs">
      <li class="am-active"><a href="#tab1">添加用户</a></li>
      <li><a href="#tab2">所有用户</a></li>
    </ul>
    
     <div class="am-tabs-bd">
      <div class="am-tab-panel am-fade am-in am-active" id="tab1">
 		<div class="am-g">
      <div class="am-u-sm-12">

	<s:form action="/admin/addUser" method="post" cssClass="am-form">
	<%
	String message=null;
	if((message=(String)request.getAttribute("message"))!=null)
	%>
	<p style="color:red">${message}</p>
      <table align="center" style="border-collapse: separate;border-spacing: 10px">
         <tr>
          <td><s:textfield name="user_add.user_name" label="用户名称" required="required"/></td>
          <td><s:textfield name="user_add.user_psd" label="登录密码" required="required"/></td>
        </tr>
        <tr>
            <td><s:select name="user_add.role" list="#{'1':'项目经理', '2':'开发人员'}" label="用户类型" required="required"/></td>
             
        </tr> 
        
         <tr>
          <td align="center">
          <s:submit value="添加" cssClass="am-btn am-btn-block am-btn-primary"/> <s:reset value="重置" cssClass="am-btn am-btn-block am-btn-success"/>
          </td>
        </tr>
      </table>
    </s:form>
			
      </div>
      </div>
      </div>


      <div class="am-tab-panel am-fade" id="tab2">
      <div class="am-g">
      <div class="am-u-sm-12">
      
       <table class="am-table am-table-striped am-table-hover table-main">
      <tr>
      <th style="background: #C2F1E2">用户编号</th>
      <th style="background: #C2F1E2">用户姓名</th>
      <th style="background: #C2F1E2">登录密码</th>
      <th style="background: #C2F1E2">用户类型</th>
      </tr>
      
           <s:iterator id="s" value="scds" status="scdsStatus">
     <tr>
       <td><s:property value="user_id"/></td>
       <td><s:property value="user_name"/></td>
       <td><s:property value="user_psd"/></td>
       <td>
       <s:if test="role==1">项目经理</s:if>
       <s:else>项目经理</s:else>
       </td>
      
     </tr>
     </s:iterator>
      </table>
      
      
      </div>
      </div>
     
      </div>
      </div>
    </div>


      </div>

      
 
</div>

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