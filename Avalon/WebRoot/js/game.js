
$(function(){
			
			$("#detail").click(function(){
			
				if($(this).text()=="��ʾ��ɫ��Ϣ"){
					
					$("#d0").attr("class","show");
					$(this).text("���ؽ�ɫ��Ϣ");
				}
				else{
					
					$("#d0").attr("class","hide");
					$(this).text("��ʾ��ɫ��Ϣ");
				}
			});
			var time=setInterval(function(){
				$.ajax({
					url:"cap",
					type:"post",
					data:{"id":$("#sid").text()},
					success:function(num){
						//alert("�ӳ����ؽ��"+num);
						if(num.trim()!="null"){
							//alert("���Ƕӳ�");
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
						var win=num.match("<h2>��Ϸ�������췽ʤ��</h2>");
						var back=num.match("<h2>��Ϸ�������̿�ѡ����Ҵ�ɱ</h2>");
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
										alert("�㱻ѡ�вμӱ�������");
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
							//console.log("��ѡ�е�"+ch[i].value);
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
						var q=result.split("����")[1];
						//alert("q:"+q);
						if(q.trim()=="�ɽ���"){
							//alert("�ɽ���");
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
						alert("�����ύ�ɹ�");
						$("#task").attr("class","hide");
					}
				});
			})
			
		})