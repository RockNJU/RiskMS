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
		<script src="../assets/js/jquery.min.js"></script>
        <script src="../assets/js/amazeui.js"></script>
		<script src="../assets/js/highcharts.js"></script>
        <script src="../assets/js/modules/exporting.js"></script>
		<script type="text/javascript">
				
	$(document).ready(function(){
		chart1();chart2();
	});			
	
	function chart1() {
		    $('#riskRatioReg').highcharts({
		        chart: {
		            type: 'column'
		        }, title: {
		            text: '风险被识别统计'
		        }, xAxis: {
		            categories: ${itemsReg.toString()}
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: '被识别次数'
		            }
		        },
		        tooltip: {
		            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		                '<td style="padding:0"><b>{point.y} </b></td></tr>',
		            footerFormat: '</table>',
		            shared: true,
		            useHTML: true
		        },
		        plotOptions: {
		            column: {
		                pointPadding: 0.2,
		                borderWidth: 0
		            }
		        },
		        series: [{
		            name: '风险条目',
		            data: ${riskRatioReg.toString()}

		        }]
		    });
		}
		
		function chart2() {
		    $('#riskRatioPro').highcharts({
		        chart: {
		            type: 'column'
		        }, title: {
		            text: '衍生问题统计'
		        }, xAxis: {
		            categories: ${itemsPro.toString()}
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: '转变风险次数'
		            }
		        },
		        tooltip: {
		            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		                '<td style="padding:0"><b>{point.y:.1f} %</b></td></tr>',
		            footerFormat: '</table>',
		            shared: true,
		            useHTML: true
		        },
		        plotOptions: {
		            column: {
		                pointPadding: 0.2,
		                borderWidth: 0
		            }
		        },
		        series: [{
		            name: '风险条目',
		            data: ${riskRatioPro.toString()}

		        }]
		    });
		}
		
		
		function reg(){
			var bt = $("#beginTime1").val();
			var et = $("#endTime1").val();
			var url="statisRegTime.action?bt="+bt+"&et="+et;
			window.location.href=url;
			
		}
		
		function pro(){
			var bt = $("#beginTime2").val();
			var et = $("#endTime2").val();
			var url="statisProTime.action?bt="+bt+"&et="+et;
			window.location.href=url;
			
			
		}
		
		function all(){
			var url="statis.action";
			window.location.href=url;
			
		}
		
		</script>
		
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
      <li><a href="../admin/statis"><span class="am-icon-home"></span> 风险库统计</a></li>
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">风险库统计</strong> <small></small></div>
      
    </div>
    
<div class="am-tabs am-margin" data-am-tabs>
    <ul class="am-tabs-nav am-nav am-nav-tabs">
      <li class="am-active"><a href="#tab1">风险被识别统计</a></li>
      <li><a href="#tab2">演变问题统计</a></li>
    </ul>
    <div class="am-tabs-bd">
      <div class="am-tab-panel am-fade am-in am-active" id="tab1">
      
       	<table id="table1" class="am-table am-table-striped am-table-hover table-main">
 	<tr>
 	
	<td><input id="beginTime1" name="beginTime1"  size="16" type="text" value="开始时间" class="form-datetime am-form-field">
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
	<td><input id="endTime1" name="endTime1"  size="16" type="text" value="结束时间" class="form-datetime am-form-field">
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
			
 	<td><input type="button" onclick="reg();" value="查询" /></td>
 	<td><input type="button" onclick="all();" value="显示所有统计"/></td>
    </tr>
    </table>
      <div id="riskRatioReg" style="min-width:700px;height:400px"></div>
      </div>
       <div class="am-tab-panel am-fade" id="tab2">
              	<table id="table2" class="am-table am-table-striped am-table-hover table-main">
 	<tr>
 	<td><input id="beginTime2" name="beginTime2"  size="16" type="text" value="开始时间" class="form-datetime am-form-field">
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
	<td><input id="endTime2" name="endTime2"  size="16" type="text" value="结束时间" class="form-datetime am-form-field">
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
 	<td><input type="button" onclick="pro();" value="查询" /></td>
 	<td><input type="button" onclick="all();" value="显示所有统计"/></td>
    </tr>
    </table>
      <div id="riskRatioPro" style="min-width:700px;height:400px"></div>
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