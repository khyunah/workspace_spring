<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>FOR Example</h1>
	</header>
	<main>
		1에서 10까지 합은?
		<!-- JSP 태그를 활용해서  -->
	</main>
	<%
	int sum = 0;
	int i = 0;
	for (i = 1; i < 11; i++) {
		sum += i;
		if (i == 10) {
	%>
	<span><%=i%></span>
	<%
		} else {
	%>
	<span><%=i%> + </span>
	<%
		}
	}
	%>
	<span> = <%=sum%></span>
	<!-- out.println() 이라는 내장객체를 이용해서 화면에 뿌릴수도 있음 -->
</body>
</html>