
<%@page import="java.util.*" pageEncoding="utf-8"%>
<%@page import="entity.Player"%>
<%@page import="Dao.PlayerDao"%>
<script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
     <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
<style>
	#link{
		display: none;
	}
</style>
	<p>当前在线人数：<span id="s">fdf</span></p>
	
	<script type="text/javascript">
	var time;
	//alert("sf");
	var s=document.getElementById("s");
	time=setInterval(function(){
		//var date=new Date();
		//console.log("111");
		//s.innerHTML=date.getTime();
		$.ajax({
			url:"num.do",
			type:"get",
			success:function(num){
				//alert("总人数返回"+num);
				$("#s").html(num);
				if(num>=7){
					$("#link").css("display","block");
				};
			},
		});
		$.ajax({
			url:"name",
			type:"post",
			success:function(info){
				//alert("总玩家"+info);
				var key=info.split(",");
				var s2=document.getElementById("u");
				s2.innerHTML="";
				for(var i=0;i<(key.length-1);i++){
					var v=document.createElement("li");
					v.innerHTML=key[i];
					s2.appendChild(v);
					};
				//$("#u").html(num);
			},
		});
	}
	, 1000);
		
	
</script>
	<div id="div">
    <ul id="u">
    			
    </ul>
    <a id="link" href="game.jsp"  class="btn btn-primary btn-lg disabled" role="button" medthod="post">进入游戏</a>
    </div>
    
 
