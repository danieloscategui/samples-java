<%@ include file="../common/includeTop.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<span>Informacion del Nuevo Pedido al Alamcen</span>
<!-- Listar todo las lista de grupo -->

<form:form modelAttribute="formPedidoAlmacen" method="POST" action="confirmarPedido">
	<table>
		<tr>
			<td>Solicitante</td>
			<td><form:input path="solicitadoPor" /></td>
		</tr>
	</table>
	<input type="submit" value="Confirmar Pedido"/>
</form:form>

<span>Lista de Pedidos - ${fecha}</span>

<table>
	<tr>
    <th>Codigo</th>
    <th>UnidadMedida</th>
    <th>Descripcion</th>
    <th>Cantidad</th>
  	</tr>

  	<c:forEach var="cartItem" items="${cart.cartItemList}">
  	<tr>
  		<td>${cartItem.item.itemCodigo}</td>
  		<td>${cartItem.item.unidadMedida.acronimo}</td>
  		<td>${cartItem.item.descripcion}</td>
  		<td>${cartItem.cantidad}</td>
  	</tr>
  	</c:forEach>
</table>
	
<%@ include file="../common/includeBottom.jsp" %>