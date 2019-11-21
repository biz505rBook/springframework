<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/WEB-INF/views/include/include-title.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<p>시작페이지</p>
<!-- BODY에 문자열 STUDENT-LIST가 있으면 file을 불러와라 -->
<c:if test= "${BODY == 'STUDENT-LIST' }">
	<%@ include file="/WEB-INF/views/body/student/list.jsp" %>
</c:if>
</body>
</html>