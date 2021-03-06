<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.PersonVo" %>

<!--  PhoneController에서 포워드 시켰다 personList -->
<%-- 
<%
	List<PersonVo> personList = (List<PersonVo>)request.getAttribute("pList"); //데이터 꺼내기 attribute는 범용 -> 다 받아야함 오브젝트로 받음 -> 형변환 해야함 / Dao 가져오지 않음 그려보면서 생각해보면 알아챌 수 있음
	
	/*
	System.out.println("====list.jsp======");
	System.out.println(personList);
	*/
%>
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>전화번호 리스트</h1>
	
	<p>
		입력한 전화번호 내역입니다.
	</p>
	<c:forEach items="pList" var="pl"> <!-- requestScope.pList -->
		<table border="1">
			<tr>
				<td>이름(name)</td>
				<td>${pl.name}</td>
			</tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td>${pl.hp}</td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td>${pl.company}</td>
			</tr>
			<tr>
				<td><a href="/phonebook2/pbc?action=uform&id=${pl.personId}">[수정]</a></td>
				<td><a href="/phonebook2/pbc?action=delete&id=${pl.personId}">[삭제]</a></td>
			</tr>
		</table>
		<br>
	</c:forEach>
	<a href="/phonebook2/pbc?action=wform">추가번호 등록</a>
	
	
</body>
</html>