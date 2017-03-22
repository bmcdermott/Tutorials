<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head><title>TEST SECURITY</title></head>
  <body>
      	<p><a href="admin/security_landing.htm">GET</a></p>
        <form:form  method="POST" action="admin/security_landing.htm"><input type="submit" value="POST"></form:form>

  </body>
</html>