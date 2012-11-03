<%@ include file="../common/includeTop.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<span>Cart </span>
	<!-- Listar todo las lista de grupo --> 
  			
<form:form action="updateCantidadCart" method="post" modelAttribute="cart" >
<table>
	<tr>
	<th>No.</th>
    <th>Codigo</th>
    <th>Descripcion</th>
    <th>UnidadMedida</th>
    <th>Cantidad</th>
    <th>InStock</th>
    <th>Accion</th>
  	</tr>
  	
  	<c:if test="${cart.numberOfItems == 0}">
  	<tr>
  		<td colspan="4">
  		No hay items en el carrito
  		</td>
  	</tr>
  	</c:if>

  	
  	<c:forEach var="cartItem" items="${cart.cartItemList}" varStatus="status">
  	<tr>
  		<td>${status.count}</td>
  		<td>${cartItem.item.itemCodigo}</td>
  		<td>${cartItem.item.descripcion}</td>
  		<td>${cartItem.item.unidadMedida.acronimo}</td>
  		<td><input name="cartItemList[${status.index}].cantidad" value="${cartItem.cantidad}"/></td>
  		<td>${cartItem.inStock}</td>
  		<td>
  			<a href="<c:url value="removeItemFromCart?itemId=${cartItem.item.itemId}" />">Remove item</a>
  		</td>
  	</tr>
  	</c:forEach>
  	<tr>
  		<td colspan="4">${cart.subTotal}</td>
  	</tr>
</table>
<br />
<input type="submit" value="Update"/> | 
<a href="<c:url value="/cart/checkout"/>">Checkout</a>  
</form:form>
<a href="<c:url value="/almacen/almacenItemList"/>">Back to Almacen Item List</a> | 


<%@ include file="../common/includeBottom.jsp" %>