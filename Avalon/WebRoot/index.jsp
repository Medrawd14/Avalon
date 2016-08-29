<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
     <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  </head>
  
  <body>
  <%
  System.out.println("这里是 login。jsp");
  	if(session.getAttribute("name")!=null){
  		System.out.println(session.getId());
  		System.out.println(session.getAttribute("name"));
  		response.sendRedirect("main.jsp");
  	}
   %>
    <form action='login.do' method='post'>
    	<p>请输入昵称：<input placeholder="Text input" class="form-control" type="type" name="name"></p>
    	<p><input type="submit" value="提交" class="btn btn-success"></p>
    	
    </form>
  </body>
</html>
