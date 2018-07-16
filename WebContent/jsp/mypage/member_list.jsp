<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="service.MemberServiceImpl"%>
<%@ page import="java.util.*" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="domain.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="ㄴUTF-8" />
	<title>회원목록</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<form action="../../main.jsp"><input type="submit" value="초기화면"/></form>
	<h2>회원명단</h2>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>팀명</th>
			<th>직책</th>
			<th>주민등록번호</th>
			<th>나이</th>
			<th>성별</th>
		</tr>
	<%
	List<MemberBean> lst = MemberServiceImpl.getInstance().listMember();
	for(MemberBean e : lst){
			%>
				<tr>
					<td><%=e.getUserId() %></td>
					<td><%=e.getPassword() %></td>
					<td><%=e.getName() %>	</td>
					<td><%=e.getTeamId() %>	</td>
					<td><%=e.getRoll() %>	</td>
					<td><%=e.getSsn() %>	</td>
					<td><%=(Integer.parseInt(new SimpleDateFormat("YYYY").format(new Date()))-(Integer.parseInt(e.getSsn().substring(0,2))+1899)) %></td>
					<td><%if(e.getSsn().substring(7,8).equals("1")){
						%> 남 <% 
					} else {
						%> 여 <%
						}%>
					</td>
				</tr>
			<%
		}
	%>
	</table>
</body>
</html>
