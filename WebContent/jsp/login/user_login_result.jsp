<%@page import="dao.MemberDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page import="service.*" %>
<%@ page import="domain.*" %>

<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe","seini144","password") -->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<%
		MemberBean m = new MemberBean();
		m.setUserId(request.getParameter("userid"));
		m.setPassword(request.getParameter("password"));
		if(MemberServiceImpl.getInstance().login(m)){
			%>
				<h3> <%= MemberDaoImpl.getInstance().login(m).getName() %> 님 로그인을 환영합니다.</h3>
				<form action="../../main.jsp"><input type="submit" value="초기화면"/> </form>
			<%
		}else{
			%>
				<h3>로그인 실패</h3>
			<%
		}
	%>
</body>
</html>



