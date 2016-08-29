
$(function(){
			
			$("#detail").click(function(){
			
				if($(this).text()=="显示角色信息"){
					
					$("#d0").attr("class","show");
					$(this).text("隐藏角色信息");
				}
				else{
					
					$("#d0").attr("class","hide");
					$(this).text("显示角色信息");
				}
			});
			var time=setInterval(function(){
				$.ajax({
					url:"cap",
					type:"post",
					data:{"id":$("#sid").text()},
					success:function(num){
						//alert("队长返回结果"+num);
						if(num.trim()!="null"){
							//alert("你是队长");
							$("#cap").attr("class","show");
							$("#cap #dd").html(num);
							
						}else{
							$("#cap").attr("class","hide");
							$("#cap #dd").html("");
						}
						
					}
				});
			}
			, 1000);
			var log=setInterval(function(){
				$.ajax({
					url:"log",
					type:"post",
					success:function(num){
						var win=num.match("<h2>游戏结束，红方胜利</h2>");
						var back=num.match("<h2>游戏结束，刺客选择玩家刺杀</h2>");
						if(win!=null||back!=null){
							$("#d1").hide();
							$("#d5").show();
						}
						var info=num.match("--do");
						if(info!=null){
							$.ajax({
								url:"totask",
								type:"post",
								data:{"id":$("#sid").text()},
								success:function(result){
									if(result.trim()=="true"){
										alert("你被选中参加本次任务");
										$("#task").attr("class","show");
									}
								}
							});
						}
						//$("#task").attr("class","hide");
						//$("ul").html("");
						$("ul").html(num);
							
					}
				});
			}
			, 1000);
			$(".submit").click(function(){
					//alert("sdf");
					var ch=document.getElementsByName("check");
					var info="value";
					for(var i=0;i<ch.length;i++){
						if(ch[i].checked){
							//console.log("被选中的"+ch[i].value);
							info=info+","+ch[i].value;
						}
						//console.log(ch[i].checked);
					}
					$.ajax({
						url:"team",
						type:"post",
						data:{"info":info},
						success:function(result){
							alert(result);
								}
							});
			});
			$(".vote").mousedown(function(){
				if($(this).val()=="true"){
					
					$(this).children("img").attr("src","img/zc2.png");
				}
				if($(this).val()=="false"){
					
					$(this).children("img").attr("src","img/fd2.png");
				}
				
			});
			$(".vote").mouseup(function(){
				if($(this).val()=="true"){
					
					$(this).children("img").attr("src","img/zc.png");
				}
				if($(this).val()=="false"){
					
					$(this).children("img").attr("src","img/fd.png");
				}
				
			});
			$(".vote").mousedown(function(){
				if($(this).val()=="true"){
					
					$(this).children("img").attr("src","img/zc2.png");
				}
				if($(this).val()=="false"){
					
					$(this).children("img").attr("src","img/fd2.png");
				}
				
			});
			$(".task").mouseup(function(){
				if($(this).val()=="true"){
					
					$(this).children("img").attr("src","img/task_cg.png");
				}
				if($(this).val()=="false"){
					
					$(this).children("img").attr("src","img/task_sb.png");
				}
				
			});
			$(".task").mousedown(function(){
				if($(this).val()=="true"){
					
					$(this).children("img").attr("src","img/task_cg2.png");
				}
				if($(this).val()=="false"){
					
					$(this).children("img").attr("src","img/task_sb2.png");
				}
				
			});
			
			$(".vote").click(function(){
				$.ajax({
					url:"vote",
					type:"post",
					data:{"key":$("#sname").text(),"info":$(this).val()},
					success:function(result){
						var $li=$("<li>"+result+"</li>");
						$("ul").append($li);
						var q=result.split("任务")[1];
						//alert("q:"+q);
						if(q.trim()=="可进行"){
							//alert("可进行");
							//$("#task").attr("class","show"); 
							
						}
						
					}
				});
			})
			$(".task").click(function(){
				$.ajax({
					url:"task",
					type:"post",
					data:{"key":$("#sname").text(),"info":$(this).val()},
					success:function(result){
						alert("任务提交成功");
						$("#task").attr("class","hide");
					}
				});
			})
			
		})