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
				
						<div class="col-xs-12  copyright text-center">
							<h1>软件风险管理系统<br>Risk Management System</h1>
						</div>
				
			</div>
		</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
	<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="../admin/showItemStateListModify"><span class="am-icon-home"></span> 返回</a></li>
        
      </ul>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> 公告</p>
          <p>风险管理计划RA即将推出</p>
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">触发问题</strong> <small></small></div>
    </div>
 
<div class="am-g">
      <div class="am-u-sm-12">

	<s:form action="/admin/updateState" method="post">
	<%
	String message=null;
	if((message=(String)request.getAttribute("message"))!=null)
	%>
	<p style="color:red">${message}</p>
      <table align="center" style="border-collapse: separate;border-spacing: 10px">
        <tr>
          <td><s:textfield name="modify_content" label="问题内容" required="required"/></td>
        </tr>
        <tr>
         <td class="tdLabel"><label for="createTime" class="label">时段</label>
          <td><input id="createTime" name="modify_createTime"  size="16" type="text" value="2016-11-11" readonly class="form-datetime am-form-field">
			<script>
			  $(function() {
			    $('.form-datetime').datetimepicker({
			    	format: 'yyyy-mm-dd hh:ii',
			        autoclose: true,
			        todayBtn: true
			        });
			  });
			</script>
        
          </td>
        </tr> 
        <tr>
          <td >
          <s:submit value="新增问题" cssClass="am-btn am-btn-block am-btn-primary"/> <s:reset value="重置" cssClass="am-btn am-btn-block am-btn-success"/>
          </td>
        </tr>
      </table>
    </s:form>
			
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