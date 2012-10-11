<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<stripes:form beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean">
	
	<table>
	<tr>
		<th colspan="2">Payment Details</th>
	</tr>
	<tr>
		<td>Card Type:</td>
		<td><stripes:select name="order.cardType">
			<stripes:options-collection collection="${actionBean.creditCardTypes}"/>
		</stripes:select></td>
	</tr>
	<tr>
		<td>Card Number:</td>
		<td><stripes:text name="order.creditCard"/>* Use a fake number!</td>
	</tr>
	<tr>
		<td>Expiry Date (MM/YYYY):</td>
		<td><stripes:text name="order.expiryDate"/></td>
	</tr>
	<tr>
		<th colspan="2">Billing Address</th>
	</tr>
	<tr>
		<td>First name:</td>
		<td><stripes:text name="order.billToFirstName"/></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><stripes:text name="order.billToLastName"/></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><stripes:text name="order.billAddress1" size="40"/></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><stripes:text name="order.billAddress2" size="40"/></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><stripes:text name="order.billCity"/></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><stripes:text name="order.billState" size="4"/></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><stripes:text name="order.billZip" size="10"/></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><stripes:text name="order.billCountry" size="15"/></td>
	</tr>
	<tr>
		<td colspan="2"><stripes:checkbox name="shippingAddressRequired"/>
		Ship to different address...</td>
	</tr>
	</table>
	
	<stripes:submit name="newOrder" value="Continue"/>

	</stripes:form>
	
</div><!-- End div id="Catalog" -->

<%@ include file="../common/IncludeBottom.jsp"%>