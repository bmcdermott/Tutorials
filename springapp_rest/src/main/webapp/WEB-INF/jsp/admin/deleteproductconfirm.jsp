<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="deleteproduct.heading"/></h1>
<form:form method="post" >
  Are you absolutely sure?  Deleted products cannot be retrieved...
  <input type="submit" align="center" value="Delete Product">
</form:form>

<a href="<c:url value="/hello.htm"/>">Home</a>

<%@ include file="/WEB-INF/jsp/logoutlink.jsp" %>


</body>
</html>