<%@page import="service.MemberServiceImpl"%>
<%@page import="service.MemberService"%>
<%@page import="domain.MemberBean"%>
<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원탈퇴 결과</title>
</head>
<body>
	<%
	MemberBean m = new MemberBean();
	m.setUserId(request.getParameter("userid"));
	m.setPassword(request.getParameter("password"));
	if(MemberServiceImpl.getInstance().login(m)){
		MemberServiceImpl.getInstance().removeMember(m);
		%><h3> 회원탈퇴 성공 </h3>
		<form action="../../main.jsp"><input type="submit" value="초기화면" />	</form>
		<%
	}else{
		%><h3> 회원탈퇴 실패! 아이디 또는 비밀번호가 없습니다.</h3>
		<%
	}
	%>
	
</body>
</html>