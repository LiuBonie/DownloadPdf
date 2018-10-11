<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	SimpleDateFormat aa = new SimpleDateFormat("MM/dd/YYYY HH:mm aa",Locale.ENGLISH);
	String time = aa.format(new Date());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<link rel="stylesheet" href="css/dcalendar.picker.css"/>
<title>Insert title here</title>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>

</head>
<body>

	<div class="info">
		<form action="<%=basePath%>/info" method="post">
		
		<div class="info_name">
			<span>Name:</span>
			<input type="text" name="Name" id="Name" placeholder="请输入真实姓名"/>
		</div>
		<div class="info_start">
			<span>Start:</span>
			<input type="text" name="Start" id="Start" placeholder="出差开始日期" onblur="getDay()"/> 
		</div>
		<div>
			<span>End:</span>
			<input type="text" name="End" id="End" placeholder="出差结束日期" onblur="getDay()"/> 
		</div>
		<div>
			<span>Location:</span>
			<input type="text" name="Location" id="Location" placeholder="请输入出差地" onblur="getDay()"/>
		</div>
		<div>
			<span>PrintTime:</span>	
			<input type="text" name="PrintTime" id="PrintTime" class="info_disabled" readonly="readonly" value="<%=time%>"/>
		</div>
		<div>
			<span>Room:</span>
			<input type="text" name="Room" id="Room" placeholder="请输入房间号"/>
		</div>
		<div>
			<span>Folio:</span>
			<input type="text" name="Folio" id="Folio" placeholder="请输入页数"/>
		</div>
		<div>
			<span>days:</span>
			<input type="text" name="Days" id="Days" class="info_disabled" readonly="readonly">
		</div>
		<div>
			<p>${Msg }</p>
			<input type="submit" id="sub" value="提交" onmouseover="ok()" >
		</div>
		</form>
		<a href="${pageContext.request.contextPath }/view/Login.jsp">返回主页</a>
	</div>
		<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/dcalendar.picker.js"></script>
		<script type="text/javascript">
		
		getDay();
		$('#Start').dcalendarpicker({
			format:'mm/dd/yyyy'
		}); 
		$('#End').dcalendarpicker({
			format:'mm/dd/yyyy'
		});
		function getDay(){
			
			var start = document.getElementById("Start").value;
			var end = document.getElementById("End").value;
/* 			document.getElementById("Start").value =start.replace(/[^0-9]/g, "-");
			document.getElementById("End").value = end.replace(/[^0-9]/g, "-"); */
 			var start = new Date(start.replace(/[^0-9]/g, "/")); 
			var end = new Date(end.replace(/[^0-9]/g, "/")); 
			var days = end.getTime() - start.getTime(); 
			var day = parseInt(days / (1000 * 60 * 60 * 24)); 
			document.getElementById("Days").value = day;

			if($("#Days").val()=="NaN"){
				$("#Days").val("")
			}
		}
		function ok() {
			
			 if($("#Name").val()==""||$("#Start").val()==""||$("#End").val()==""
			  ||$("#Location").val()==""||$("#PrintTime").val()==""||$("#Room").val()==""
			  ||$("#Folio").val()==""){ 
				$("form p").text("请全部正确填写完毕，否则将影响您的出差补贴");	 
			 }else{
				 $("form p").text(" ");
			 }
		}
		function nook() {
			alert("ddd");
			$("#sub").removeAttr("disabled");
		}
	</script>
</body>
</html>