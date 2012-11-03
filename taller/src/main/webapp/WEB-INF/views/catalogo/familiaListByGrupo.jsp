<%@ include file="../common/includeTop.jsp" %>
	<span>Catalogo Almacen - Grupo <c:out value="${model.grupo.descripcion}"/></span>
	<!-- Listar todo las lista de grupo -->
<table>
	<tr>
    <th>Codigo</th>
    <th>Descripcion</th>
    <th>Accion</th>
  	</tr>
  	
  	<c:if test="${model.familiaList == null}">
  	<tr>
  		<td colspan="2">
  		No hay familias dentro del grupo
  		</td>
  	</tr>
  	</c:if>
  	<c:forEach var="familia" items="${model.familiaList}">
  	<tr>
  		<td>
  			<a href="<c:url value="/catalogo/verItems?familiaId=${familia.familiaId}" />">${familia.familiaCodigo}
  			</a>
  		</td>
  		<td>${familia.descripcion}</td>
  		<td>Editar</td>
  	</tr>
  	</c:forEach>
</table>

<p>
	<a href="<c:url value="/catalogo/grupoList" />" >Return to Grupo</a> | 
	<a href="<c:url value="/catalogo/addFamilia?grupoId=${model.grupo.grupoId}" />" >Añadir Familia</a>
</p>	
	
<%@ include file="../common/includeBottom.jsp" %>