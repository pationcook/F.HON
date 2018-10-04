<%@page trimDirectiveWhitespaces="true" %>
<!-- int 결과값 페이지 -->
<%
String result = (String)request.getParameter("result");
out.print(result);
%>