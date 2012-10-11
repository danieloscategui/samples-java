<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<stripes:form beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean">
	<table>
	<tr>	
		<th colspan="2">Shipping Address</th>
	</tr>
	<tr>
		<td>First name:</td>
		<td><stripes:text name="order.shipToFirstName"/></td>
	</tr>	
	<tr>
		<td>Last name:</td>
		<td><stripes:text name="order.shipToLastName"/></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><stripes:text name="order.shipAddress1" size="40"/></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><stripes:text name="order.shipAddress2" size="40"/></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><stripes:text name="order.shipCity"/></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><stripes:text name="order.shipState" size="4"/></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><stripes:text name="order.shipZip" size="10"/></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><stripes:text name="order.shipCountry" size="15"/></td>
	</tr>
	</table>
	<stripes:submit name="newOrder" value="Continue"/>
	</stripes:form>
</div><!-- End div id="Catalog" -->

<%@ include file="../common/IncludeBottom.jsp"%>