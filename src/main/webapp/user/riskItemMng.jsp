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
        <li><a href="../admin/showAllRiskItemForManager"><span class="am-icon-home"></span> 风险条目管理</a></li>
        <li><a href="../admin/showAllRA"><span class="am-icon-home"></span> 风险管理计划</a></li>
      <li><a href="../admin/showAllRiskItemForManager"><span class="am-icon-home"></span> 风险库统计</a></li>
         <li><a href="../index.jsp"><span class="am-icon-calendar"></span> 注销</a></li>
        
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">风险条目管理</strong> <small></small></div>
      
    </div>
    
<div class="am-tabs am-margin" data-am-tabs>
    <ul class="am-tabs-nav am-nav am-nav-tabs">
      <li class="am-active"><a href="#tab1">添加风险条目</a></li>
      <li><a href="#tab2">所有风险条目</a></li>
    </ul>
    
     <div class="am-tabs-bd">
      <div class="am-tab-panel am-fade am-in am-active" id="tab1">
 		<div class="am-g">
      <div class="am-u-sm-12">

	<s:form action="/admin/addRiskItem" method="post" cssClass="am-form">
	<%
	String message=null;
	if((message=(String)request.getAttribute("message"))!=null)
	%>
	<p style="color:red">${message}</p>
      <table align="center" style="border-collapse: separate;border-spacing: 10px">
         <tr>
          <td><s:textfield name="riskItem_add.content" label="风险内容" required="required"/></td>
          <td><s:select name="riskItem_add.probability" list="#{'1':'高', '2':'中', '3':'低'}" label="可能性" required="required"/></td>
          <td><s:select name="riskItem_add.effects" list="#{'1':'高', '2':'中', '3':'低'}" label="影响程度" required="required"/></td>
          <td><s:textfield name="riskItem_add.threshold" label="触发器/阙值" required="required"/></td>
             
        </tr>
       <s:checkboxlist name="selectedUserList" list="optionalUserList" listKey="user_id" listValue="user_name" label="跟踪者" required="required"/>
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
      <th style="background: #C2F1E2">风险条目编号</th>
      <th style="background: #C2F1E2">风险内容</th>
      <th style="background: #C2F1E2">可能性</th>
      <th style="background: #C2F1E2">影响程度</th>
      <th style="background: #C2F1E2">触发器/阙值</th>
      <th style="background: #C2F1E2">提交者</th>
      <th style="background: #C2F1E2">跟踪者</th>
      <th style="background: #C2F1E2">查看风险状态</th>
      </tr>
      
           <s:iterator id="s" value="riskItemList" status="scdsStatus">
     <tr>
       <td><s:property value="riskItem_id"/></td>
       <td><s:property value="content"/></td>
       <td>
       <s:if test="probability==1">高</s:if>
       <s:elseif test="probability==2">中</s:elseif>
       <s:elseif test="probability==3">低</s:elseif>
       </td>
       <td>
       <s:if test="effects==1">高</s:if>
       <s:elseif test="effects==2">中</s:elseif>
       <s:elseif test="effects==3">低</s:elseif>
       </td>
       <td><s:property value="threshold"/></td>
       <td><s:property value="sub_name"/></td>
       <td><s:property value="tracker_name"/></td>
       
       <s:set var="riskItem" value="#s" scope="session"></s:set>
		  <td>
		  
		  <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                    <s:url action="showItemStateList" var="p">
			    <s:param name="riskItemId"><s:property value="riskItem_id"/></s:param>
			</s:url>
                    <s:a href="%{p}" class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span>查看</s:a>
         
                  </div>
                </div>
		  
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