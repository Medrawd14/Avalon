<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="javax.sound.midi.SysexMessage"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
     <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link rel="stylesheet" type="text/css" href="css/mystyle.css">
	<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
	<script type="text/javascript">
		function f1(){
			$.ajax({
				url:"logout",
				type:"get",
				success:function(){
					location.reload();
				},
			});
		}
	</script>
  </head>
  
  <body>
  	<%
  		System.out.println("这里是 main。jsp");
  		if(session.getAttribute("name")==null){
  			response.sendRedirect("index.jsp");	
  		} 
  	%>
  	<p><h1>欢迎：<%=session.getAttribute("name") %></h1><button class="btn btn-primary btn-lg" onclick="f1()">退出</button></p>
    <div class="d1">
    	<div class="d2">
    		<%@include file="PlayList.jsp" %>
    		
    	</div>
    	<div class="d3">
    		
    	</div>
    	<div style="clear: letf"></div>
    </div>
  </body>
</html>
