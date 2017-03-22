<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/product.css"/>">

  
  <body>
   <div id="dialog" title="Are You Sure?">
	<p>Are you sure you want to delete this record??</p>
   </div>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Products</h3>
    <table width="95%" bgcolor="f8f8ff" border="1" cellspacing="0" cellpadding="5">
    <tr><td>Description</td><td>Long Description</td><td>Price</td></tr>
    
    <c:forEach items="${model.products}" var="prod">
      <tr>
      <td><c:out value="${prod.description}"/> </td>
      <td><c:out value="${prod.long_description}"/> </td>
      <td><i>$<c:out value="${prod.price}"/></i></td>
 	  <td>
 	    <a href="admin/addcomponent.htm?PRODUCT_ID=${prod.id}"> 
 	    <img src="<c:url value="/resources/img/add-icon.png"/>" alt="Add a Component" style="width:20px;height:20px;border:0">
 	    </a>
 	  </td>
 	  <td>
      	<form:form  
      		action="admin/editproduct.htm" method="get">
      		<input type="hidden" name="PRODUCT_ID" value="${prod.id}" /> 
      		<input type="image" src="<c:url value="/resources/img/edit-icon.png"/>" 
      			   alt="Edit" style="width:20px;height:20px;border:0">
      	</form:form>
      </td>
      <td>
        <form:form  
      		action="admin/deleteproductconfirm.htm?PRODUCT_ID=${prod.id}" method="post">
      		<input type="image" src="<c:url value="/resources/img/delete-icon.png"/>" 
      			   alt="Edit" style="width:20px;height:20px;border:0">
      	</form:form>
      </td>
<!--       <td> -->
<%--         <form:form class="dialog-link" method="DELETE" action="admin/deleteproductconfirm.htm?PRODUCT_ID=${prod.id}"><input type="button" value="delete"></form:form> --%>
<!--       </td> -->
      </tr>
      <c:forEach items="${prod.components}" var="comp">
      	<tr>
      	  <td></td>
	      <td><c:out value="${comp.description}"/></td>
	      <td><c:out value="${comp.long_description}"/></td>
	    </tr>
	  </c:forEach>
    </c:forEach>

    </table>
    
   	<form:form  
       action="admin/addcomponent.htm?PRODUCT_ID=${prod.id}" method="get">
	   <input type="image" src="<c:url value="/resources/img/add-icon.png"/>"
      		  alt="Add Component" style="width:20px;height:20px;border:0">
    </form:form>
    <form  
       action="admin/addcomponent.htm?PRODUCT_ID=${prod.id}" method="get">
	   <input type="image" src="<c:url value="/resources/img/add-icon.png"/>"
      		  alt="Add Component" style="width:20px;height:20px;border:0">
    </form>
    
    <br>
    	<a href="<c:url value="priceincrease.htm"/>">Increase Prices</a>
    <br>
    <br>
    	<a href="<c:url value="/admin/addproduct.htm"/>">Add a Product</a>
    <br>
    <%@ include file="/WEB-INF/jsp/logoutlink.jsp" %>

    <script src="<c:url value="/resources/js/jquery.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/product.js"/>"></script>
  </body>
</html>