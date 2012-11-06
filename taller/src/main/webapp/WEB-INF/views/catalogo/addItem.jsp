<%@ include file="../common/includeTop.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:choose>
	<c:when test="${limiteMaximo != null}">
		<table width="45%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan="2"><c:out value="${limiteMaximo}" /></td>
			</tr>
			<tr>
				<td><a href="javascript:history.go(-1)">Return</a></td>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
	<form:form method="post" commandName="formItem" action="addItem" >
	<table width="45%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td colspan="3">Familia: <c:out value="${familia}"/></td>
		</tr>
		<tr>
			<td>Codigo</td>
			<td><form:input disabled="true" path="itemCodigo"/></td>
			<td>&nbsp;</td>
		</tr>
		<tr>	
			<td>Descripcion</td>
			<td><form:input path="descripcion"/></td>
			<td><form:errors path="descripcion" cssClass="error"/></td>
		</tr>
		<tr>
			<td>Unidad Medida</td>
			<td>
				<form:select path="unidadMedidaId">
					<form:option value="0" label="-- Seleccionar --"/>
					<form:options items="${unidadMedidaList}"  itemValue="unidadMedidaId" itemLabel="descripcion"/>
				</form:select>
			</td>
			<td><form:errors path="unidadMedidaId" cssClass="error"/></td>
		</tr>
	</table>
	
	<input type="submit" align="center" value="Añadir Item"/>
	</form:form>

	</c:otherwise>
</c:choose>
<%@ include file="../common/includeBottom.jsp" %>