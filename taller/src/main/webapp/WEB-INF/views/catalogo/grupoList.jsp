<%@ include file="../common/includeTop.jsp" %>
<div id="contenido">
<span>Catalogo Almacen - Listado de Grupo</span>
<!-- Listar todo las lista de grupo -->

<table class="tabla">
	<thead>
	<tr>
    	<td class="caption alignCenter">Codigo</td>
    	<td class="caption alignCenter">Descripcion</td>
    	<td class="caption alignCenter">Accion</td>
  	</tr>
  	</thead>
  	<tbody>
  	<c:if test="${model.grupoList == null}">
  	<tr>
  		<td colspan="2">
  		No hay grupos dentro del catalogo
  		</td>
  	</tr>
  	</c:if>
  	<c:forEach var="grupo" items="${model.grupoList}">
  	<tr>
  		<td>
  			<a href="<c:url value="/catalogo/verFamilias?grupoId=${grupo.grupoId}" />">${grupo.grupoCodigo}
  			</a>
  		</td>
  		<td>${grupo.descripcion}</td>
  		<td>Editar</td>
  	</tr>
  	</c:forEach>
  	</tbody>
</table>

<p>
	<a href="<c:url value="/catalogo/addGrupo" />" >Añadir grupo</a>
</p>	
</div>
<%@ include file="../common/includeBottom.jsp" %>