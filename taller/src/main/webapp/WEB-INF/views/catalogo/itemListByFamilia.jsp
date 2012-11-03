<%@ include file="../common/includeTop.jsp" %>
	<span>Catalogo Almacen - Listado de Familia <c:out value="${model.familia.descripcion}"/></span>
	<!-- Listar todo las lista de grupo --> 
<table>
	<tr>
    <th>Codigo</th>
    <th>UnidadMedida</th>
    <th>Descripcion</th>
    <th>Accion</th>
  	</tr>
  	
  	<c:if test="${model.itemList == null}">
  	<tr>
  		<td colspan="6">
  		No hay items dentro de la famiilia
  		</td>
  	</tr>
  	</c:if>
  	<c:forEach var="item" items="${model.itemList}">
  	<tr>
  		<td>${item.itemCodigo}</td>
  		<td>${item.unidadMedida.acronimo}</td>
  		<td>${item.descripcion}</td>
  		<td>Editar</td>
  	</tr>
  	</c:forEach>
</table>

<p>
	<a href="<c:url value="/catalogo/verFamilias?grupoId=${model.familia.grupoId}" />">Return to Familia</a> | 
	<a href="<c:url value="/catalogo/addItem?familiaId=${model.familia.familiaId}" />" >Añadir Item</a>
</p>	
	
<%@ include file="../common/includeBottom.jsp" %>