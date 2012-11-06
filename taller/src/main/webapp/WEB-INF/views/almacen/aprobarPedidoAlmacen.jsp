<%@ include file="../common/includeTop.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<span>Informacion del Nuevo Pedido al Alamcen</span>
<!-- Listar todo las lista de grupo -->

<form:form action="/almacen/autorizarPedido" method="POST" modelAttribute="formPedidoAlmacen">
	<table>
	<tr>
		<th colspan = 2>Autorizado Por</th>
	</tr>
	<tr>
		<td><form:input path="autorizadoPor"/></td>
		<td><form:errors path="autorizadoPor" cssClass="error"/>
	</tr>
	
	</table>
</form:form>

<table>
	<tr>
		<td>Numero Pedido</td>
		<td>${pedidoAlmacen.pedidoId}</td>
	</tr>
	<tr>
		<td>Fecha Pedido</td>
		<fmt:formatDate var="fechaPedido" value="${pedidoAlmacen.fechaPedido}" pattern="dd/MM/yyyy"/>
		<td>${fechaPedido}</td>
	</tr>		
	<tr>
		<td>Estado</td>
		<td>${pedidoAlmacen.estado }</td>
	</tr>
	<tr>
		<td>Solicitante</td>
		<td>${pedidoAlmacen.solicitadoPor }</td>
	</tr>
</table>

<span>Item Solicitados</span>
<table>
	<tr>
    <th>Codigo</th>
    <th>Descripcion</th>
    <th>UnidadMedida</th>
    <th>Cantidad</th>
  	</tr>
  	
  	<c:forEach var="pedidoAlmacenItem" items="${pedidoAlmacen.pedidoAlmacenItems}">
  	<tr>
  		<td>${pedidoAlmacenItem.item.itemCodigo}</td>
  		<td>${pedidoAlmacenItem.item.descripcion}</td>
  		<td>${pedidoAlmacenItem.unidadMedida.acronimo}</td>
  		<fmt:formatNumber var="cantidadSolicitada" value="${pedidoAlmacenItem.cantidadSolicitada}" pattern="#0.00" />
  		<td>${cantidadSolicitada}</td>
  	</tr>
  	</c:forEach>
</table>
	
<%@ include file="../common/includeBottom.jsp" %>