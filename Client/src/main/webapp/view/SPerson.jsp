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
<script type="text/javascript" src="js/dcalendar.picker.js"></script>
<link rel="stylesheet" type="text/css" href="css/styles.css" media="all"> 
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/moment.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    // date time picker

        $("#PrintTime").datetimepicker({
            locale: "zh-cn",
            format: "YYYY-MM-DD hh:mm a",
            dayViewHeaderFormat: "YYYY年 MMMM"
        });
        $("#Start").datetimepicker({
        	locale: "zh-cn",
            format: "MM/DD/YYYY",
            dayViewHeaderFormat: "YYYY年 MMMM"
        });$("#End").datetimepicker({
        	locale: "zh-cn",
            format: "MM/DD/YYYY",
            dayViewHeaderFormat: "YYYY年 MMMM"
        });
        function ok() {
			
			 if($("#Name").val()==""||$("#Start").val()==""||$("#End").val()==""
			  ||$("#Location").val()==""||$("#PrintTime").val()==""||$("#Room").val()==""
			  ||$("#Folio").val()==""){ 
				$("form p").text("请全部正确填写完毕，否则将影响您的出差补贴");	 
			 }else{
				 $("form p").text(" ");
			 }
		}
})
</script>

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
			<input type="text" name="Start" id="Start" placeholder="出差开始日期" /> 起始日期请不要填写一致不然pdf会打印错误
		</div>
		<div>
			<span>End:</span>
			<input type="text" name="End" id="End" placeholder="出差结束日期" /> 起始日期请不要填写一致不然pdf会打印错误
		</div>
		<div>
			<span>Location:</span>
			<input type="text" name="Location" id="Location" placeholder="请输入出差地" />
		</div>
		<div>			
			<span>PrintTime:</span>	
			<input type="text" name="PrintTime" id="PrintTime"   />  <%-- value="<%=time%>" --%>  <!-- class="info_disabled" -->
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
			<span>TaxInclu:</span>
			<input type="text" name="Days" class="info_disabled" >total = day*TaxInclu(62.37)
		</div>
		<div>
			<p>${Msg }</p>
			<input type="submit" id="sub" value="提交" onmouseover="ok()" >
		</div>
		</form>
		<a href="${pageContext.request.contextPath }/view/Login.jsp">返回主页</a>
	</div>

</body>
</html>