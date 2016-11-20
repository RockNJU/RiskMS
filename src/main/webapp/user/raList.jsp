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
		
		<!-- 本页面所需要的js函数 -->
		<script language="javascript">
		function reg(){
			var bt = $("#beginTime").val();
			var et = $("#endTime").val();
			var url="sortReg.action?bt="+bt+"&et="+et;
			window.location.href=url;
		}
		function pro(){
			var bt = $("#beginTime").val();
			var et = $("#endTime").val();
			var url="sortPro.action?bt="+bt+"&et="+et;
			window.location.href=url;
		}
		function all(){
			var bt = $("#beginTime").val();
			var et = $("#endTime").val();
			var url="sortItem.action?bt="+bt+"&et="+et;
			window.location.href=url;
		}
		
		</script>
	</head>
	<body >
		
		<header>
				
		</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
	<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="../admin/showAllRA"><span class="am-icon-home"></span> 风险计划管理</a></li>
         <li><a href="../index.jsp"><span class="am-icon-calendar"></span> 注销</a></li>
        
      </ul>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> 公告</p>
          <p>风险管理计划RA正式上线</p>
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">风险计划管理</strong> <small></small></div>
    </div>
    
<div class="am-tabs am-margin" data-am-tabs>
    <ul class="am-tabs-nav am-nav am-nav-tabs">
      <li class="am-active"><a href="#tab1">新增风险计划</a></li>
      <li><a href="#tab2">所有风险计划</a></li>
    </ul>
    
     <div class="am-tabs-bd">
      <div class="am-tab-panel am-fade am-in am-active" id="tab1">
 		<div class="am-g">
      <div class="am-u-sm-12">



 	<s:form id="form1" cssClass="am-form">
 	<p style="color：blue;font-weight:bold;font-size:16px">风险条目列表</p><br>
 	<table id="tab" class="am-table am-table-striped am-table-hover table-main">
 	<tr>
 	<td><input id="beginTime" name="beginTime"  size="16" type="text" value="开始时间" class="form-datetime am-form-field">
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
	<td><input id="endTime" name="endTime"  size="16" type="text" value="结束时间" class="form-datetime am-form-field">
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
 	<td><input type="button" onclick="reg();" value="被识别最多" /></td>
 	<td><input type="button" onclick="pro();"  value="变问题最多" /></td>
 	<td><input type="button" onclick="all();" value="所有风险条目"/></td>
    </tr>
    </table>
   </s:form>
    
        <table id="table1" class="am-table am-table-striped am-table-hover table-main">
      <tr>
      <th style="background: #C2F1E2">风险条目编号</th>
      <th style="background: #C2F1E2">风险内容</th>
      <th style="background: #C2F1E2">可能性</th>
      <th style="background: #C2F1E2">影响程度</th>
      <th style="background: #C2F1E2">触发器/阙值</th>
      <th style="background: #C2F1E2">提交者</th>
      <th style="background: #C2F1E2">跟踪者</th>
      <th style="background: #C2F1E2">操作</th>
      </tr>
      
           <s:iterator id="s1" value="optionalItemList" status="scdsStatus">
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
       
       <s:set var="riskItem" value="#s1" scope="session"></s:set>
		  <td>
		  
		  <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                    
          <s:url action="addToTempItemList" var="p">
			    <s:param name="addTempItemId"><s:property value="riskItem_id"/></s:param>
			</s:url>
                    <s:a href="%{p}" class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span>添加到计划</s:a>
                  </div>
                </div>
		  
		   </td>
      
     </tr>
     </s:iterator>
      </table>
       
    
    
    <!-- 第二个表单开始#################### -->
    
     	<s:form id="form2" action="/admin/addNewRA" method="post" cssClass="am-form">
 	<p style="color：blue;font-weight:bold;font-size:16px">已选条目列表</p><br>

        <table id="table2" class="am-table am-table-striped am-table-hover table-main">
      <tr>
      <th style="background: #C2F1E2">风险条目编号</th>
      <th style="background: #C2F1E2">风险内容</th>
      <th style="background: #C2F1E2">可能性</th>
      <th style="background: #C2F1E2">影响程度</th>
      <th style="background: #C2F1E2">触发器/阙值</th>
      <th style="background: #C2F1E2">提交者</th>
      <th style="background: #C2F1E2">跟踪者</th>
      <th style="background: #C2F1E2">操作</th>
      </tr>
      
           <s:iterator id="s2" value="selectedItemList" status="scdsStatus">
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
       
       <s:set var="riskItem2" value="#s2" scope="session"></s:set>
		  <td>
		  
		  <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                    <s:url action="rmvFromTempItemList" var="p">
			    <s:param name="rmvTempItemId"><s:property value="riskItem_id"/></s:param>
			</s:url>
                    <s:a href="%{p}" class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span>从计划移除</s:a>
                  </div>
                </div>
		  
		   </td>
      
     </tr>
     </s:iterator>
      </table>
      <td><s:textfield name="add_ralist.ra_name" label="计划名称" required="required"/></td>
      <td align="center">
          <s:submit value="提交计划" cssClass="am-btn am-btn-block am-btn-primary"/>
          </td>
       
    </s:form>
			
      </div>
      </div>
      </div>


      <div class="am-tab-panel am-fade" id="tab2">
      <div class="am-g">
      <div class="am-u-sm-12">
      
       <table class="am-table am-table-striped am-table-hover table-main">
      <tr>
      <th style="background: #C2F1E2">风险计划编号</th>
      <th style="background: #C2F1E2">风险计划内容</th>
      <th style="background: #C2F1E2">创建时间</th>
      <th style="background: #C2F1E2">条目列表</th>
      <th style="background: #C2F1E2">操作</th>
      </tr>
      
           <s:iterator id="s3" value="allralist" status="scdsStatus">
     <tr>
       <td><s:property value="ra_id"/></td>
       <td><s:property value="ra_name"/></td>
       <td><s:property value="createTime"/></td>
       
       <s:set var="ra" value="#s3" scope="session"></s:set>
		  <td>
		  
		  <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                    <s:url action="showRAItemList" var="p">
			    <s:param name="raId"><s:property  value="ra_id"/></s:param>
			</s:url>
                    <s:a href="%{p}" class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span>查看</s:a>
         
                  </div>
                </div>
		  
		   </td>
		    <td>
		  
		  <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                    <s:url action="delRAItem" var="p">
			    <s:param name="raId"><s:property  value="ra_id"/></s:param>
			</s:url>
                    <s:a href="%{p}" class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span>删除</s:a>
         
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