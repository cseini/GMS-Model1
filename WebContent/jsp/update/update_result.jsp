<%@page import="service.MemberServiceImpl"%>
<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>비밀번호 변경 결과</title>
</head>
<body>
	<%
	MemberBean m = new MemberBean();
	m.setUserId(request.getParameter("userid"));
	m.setPassword(request.getParameter("old_password")+"/"+request.getParameter("new_password"));
	MemberServiceImpl.getInstance().modifyMember(m);
	%> 비밀번호를 변경하였습니다. <%	
	%>
	<form action="../../main.jsp"><input type="submit" value="초기화면"/> </form>
</body>
</html>