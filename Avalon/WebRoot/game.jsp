<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="Dao.PlayerDao"%>
<%@page import="entity.Player"%>
<%@page import="entity.GameConfig"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'game.jsp' starting page</title>
      <meta http-equiv="content-type" content="text/html">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/mystyle.css">
	<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
	<script type="text/javascript" src="js/cookie_util.js"></script>
	<script type="text/javascript" charset="GBK" src="js/game.js">
	<script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
     <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
     
	</script>
  </head>
  	<%	
  		request.setCharacterEncoding("utf-8");
  	 	//PlayerDao.getAllJs(PlayerDao.list.size());
  	 	new GameConfig(PlayerDao.list.size());
  	 %>
  <body>
  	<div id="d3">
  	<% 
  		if(PlayerDao.getJsByCookie(session.getId())==null){
  			response.sendRedirect("error.jsp");
  		}
  	%>
  	<p><h2>玩家昵称：<span id="sname"><%=PlayerDao.getNameByCookie(session.getId()) %></span></h2></p>
  	<p><h2>游戏ID：<span id="sid"><%=PlayerDao.getGameIdByCookie(session.getId()) %></span></h2></p>
  	<p>游戏角色：<%=PlayerDao.getJsByCookie(session.getId()).getName() %><button id="detail" class="btn btn-info btn-lg">显示角色信息</button></p>
  	<div id="d0" class="hide">
  		<%
  			out.print("<img class='left' src='"+PlayerDao.getJsByCookie(session.getId()).getImg()+"'>");
  			out.print("<div id='sp'><h3>"+PlayerDao.getJsByCookie(session.getId()).getInfo()+"</h3></div>");
  		%>
  		
  	</div>
  	<div id="d1" style="clear:left">
  		<button  class="vote" value="true"><img src="img/zc.png"></button>
  		<button  class="vote" value="false" ><img src="img/fd.png"></button>
  	</div>
  	<div class="hide" id="task">
  		<h3>任务投票 （好人只能投任务成功，坏人可以投任务成功）</h3>
  		<button  class="task" value="true" ><img src="img/task_cg.png"></button>
  		<button  class="task" value="false" ><img src="img/task_sb.png"></button>
  	</div>
  	<div class="hide" id="cap">
  		<h3>队长区</h3>
  		<div id="dd">
  		</div>
  		<% 
  			
  			System.out.println(PlayerDao.list.size());
  			for(int i=0;i<PlayerDao.list.size();i++){
  				Player p=PlayerDao.list.get(i);
  				out.print("<label><input type='checkbox' name='check' class='check' value='"+p.getGameid()+"'><span id='ss'>"+p.getName()+"</span></label>");
  			}
  		%>
  		<h2><button class="submit">提交</button></h2>
  	</div>
  	</div>
  	<div id="d4">
  		<h3>游戏日记</h3>
  		<ul></ul>
  		
  	</div>
  	<div id="d5" class="hide">
  		<h2>玩家列表= =</h2>
  		<%
  			for(int i=0;i<PlayerDao.list.size();i++){
  				Player p=PlayerDao.list.get(i);
  				out.println("<p>"+p.getName()+"："+p.getJs().getName()+"</p>");
  			}
  		%>
  		
  	</div>
  </body>
</html>
