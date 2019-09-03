<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	int op1 = Integer.parseInt(request.getParameter("op1"));
	int op2 = Integer.parseInt(request.getParameter("op2"));
	int result = op1 + op2;
%>
<data>
	<op1 value="<%=op1%>"/>
	<op2 value="<%=op2%>"/>
	<result value="<%=result%>"/>
</data>
