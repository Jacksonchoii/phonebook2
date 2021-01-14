<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.javaex.vo.PersonVo" %>

<%-- <%
	PersonVo personVo = (PersonVo)request.getAttribute("pVo"); //형변환 해줘야함
	/*
	System.out.println("====updateForm.jsp=====");
	System.out.println(personVo);
	확인만 해보고 주석처리 -계속 나오니까 헷갈림 정신없음
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

	<h1>전화번호 수정</h1>
	
	<p>
		전화번호를 수정하려면<br>
		아래 항목을 수정하고 "수정" 버튼을 클릭하세요.
	</p>
	
	<form action="/phonebook2/pbc" method="get">
		이름(name): <input type="text" name="name" value="${pVo.name}"><br> <!-- requestScope.pVo.name -->
		핸드폰(hp): <input type="text" name="hp" value="${pVo.hp}"><br>
		회사(company): <input type="text" name="company" value="${pVo.company}"><br>
		코드(id): <input type="text" name="id" value="${pVo.personId}"><br>
		action: <input type="text" name="action" value="update"><br>
		<button type="submit">수정</button>
	</form>
	
</body>
</html>