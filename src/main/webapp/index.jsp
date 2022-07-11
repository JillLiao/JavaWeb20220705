<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	Hello JSP<%=new Date() %><p/> <!-- <p/>表示斷行，效果如同按2次enter -->
	印出 1~10 <br/> <!-- <br/>表示折行，效果如同按1次enter -->
	<%
		for(int i=1;i<=10;i++){
			out.print(i +" ");	
		}	
	%>
</body>
</html>