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
<h1><fmt:message key="addproduct.heading"/></h1>
<form:form method="post" modelAttribute="product" action="addproduct.htm">
  <form:input type="hidden" path="id"/>
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">Description</td>
        <td width="20%">
          <form:input path="description"/>
        </td>
        <td width="60%">
          <form:errors path="description" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Long Description</td>
        <td width="20%">
          <form:input path="long_description"/>
        </td>
        <td width="60%">
          <form:errors path="long_description" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Price</td>
        <td width="20%">
          <form:input path="price"/>
        </td>
        <td width="60%">
          <form:errors path="price" cssClass="error"/>
        </td>
    </tr>
  </table>
  <br>
  <input type="submit" align="center" value="Save Product">
</form:form>

<a href="<c:url value="/hello.htm"/>">Home</a>

<%@ include file="/WEB-INF/jsp/logoutlink.jsp" %>


</body>
</html>