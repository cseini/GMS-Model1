<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.*" %>
<%@ page import="service.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입 결과</title>
</head>
<body>
	<%
		MemberBean m = new MemberBean();
		m.setUserId(request.getParameter("userid"));
		m.setPassword(request.getParameter("password"));
		m.setName(request.getParameter("name"));
		m.setSsn(request.getParameter("ssn"));
		if(MemberServiceImpl.getInstance().findMemberBySeq(m.getUserId())==null){
			MemberServiceImpl.getInstance().createMember(m);
			%>
				<h1>가입성공</h1>
			<%
		} else {
		 	%>
		 		<h1>가입실패. 아이디가 중복입니다.</h1>
		 	<%
		}
	%>
</body>
</html>