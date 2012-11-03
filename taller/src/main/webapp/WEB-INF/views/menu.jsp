<%@ include file="common/includeTop.jsp" %>
	<h1>Bienvenido al menu, estimado : <c:out value="${nombre}"/>  </h1>
	<p>Catalogo grupo</p>
	
	
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Codigo</td>
			<td>Descripcion</td>
		</tr>
		
		<c:forEach var="grupo" items="${grupoList}">
		<tr>
			<td>${grupo.grupoId}</td>
			<td>${grupo.grupoCodigo}</td>
			<td>${grupo.descripcion}</td>
		</tr>
		</c:forEach>	
	</table>
	
<%@ include file="common/includeBottom.jsp" %>