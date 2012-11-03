<%@ include file="../common/includeTop.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<span>Catalogo Almacen - Listado de Item</span>
	<!-- Listar todo las lista de grupo -->
<p>Search item</p>

<form:form method="post" modelAttribute="formSearchItem" action="searchAlmacenItem">
	<table>
		<tr>
		<td><form:input path="keyword"/></td>
		<td><input type="submit" value="Buscar"/></td>
		</tr> 
	</table>
</form:form>
 
<table>
	<tr>
    <th>Codigo</th>
    <th>UnidadMedida</th>
    <th>Descripcion</th>
    <th>Accion</th>
  	</tr>
  	
  	<c:if test="${itemList == null}">
  	<tr>
  		<td colspan="4">
  		No hay items dentro del almacen principal
  		</td>
  	</tr>
  	</c:if>
  	<c:forEach var="item" items="${itemList}">
  	<tr>
  		<td>${item.itemCodigo}</td>
  		<td>${item.unidadMedida.acronimo}</td>
  		<td>${item.descripcion}</td>
  		<td>
  		<a href="<c:url value="/cart/addItemToCart?itemId=${item.itemId}" />">Add to cart</a>
  		</td>
  	</tr>
  	</c:forEach>
</table>
	
<%@ include file="../common/includeBottom.jsp" %>