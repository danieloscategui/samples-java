<%@ include file="../common/includeTop.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<span>Pedidos Almacen Pendientes</span>
<!-- Listar todo las lista de grupo -->
<table>
	<tr>
    <th>Nro. Pedido</th>
    <th>Fecha Pedido</th>
    <th>Solicitado por</th>
    <th>Accion</th>
  	</tr>

  	<c:forEach var="pedidoAlmacen" items="${listaPedidoAlmacenPendientes}">
  	<tr>
  		<td>${pedidoAlmacen.pedidoId}</td>
  		<fmt:formatDate var = "fechaPedido" value="${pedidoAlmacen.fechaPedido}" pattern="dd/MM/yyyy"/>
  		<td>${fechaPedido}</td>
  		<td>${pedidoAlmacen.solicitadoPor}</td>
  		<td><a href="<c:url value="/almacen/verPedido?pedidoId=${pedidoAlmacen.pedidoId}" />"> Ver detalle</a></td>
  	</tr>
  	</c:forEach>
</table>
	
<%@ include file="../common/includeBottom.jsp" %>