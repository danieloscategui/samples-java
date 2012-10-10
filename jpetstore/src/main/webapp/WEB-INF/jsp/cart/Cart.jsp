<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<stripes:link
		beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
		Return to Main Menu
	</stripes:link>
</div>

<div id="Catalog">
<div id="Cart">
	<h2>Shpping Cart</h2>
	<stripes:form
		beanclass="org.mybatis.jpetstore.web.actions.CartActionBean">
		<table>
			<tr>
				<td><b>Item ID</b></td>
				<td><b>Product ID</b></td>
				<td><b>Description</b></td>
				<td><b>In Stock?</b></td>
				<td><b>Quantity</b></td>
				<td><b>List Price</b></td>
				<td><b>Total Cost</b></td>
				<th>&nbsp;</th>
			</tr>
			<c:if test="${actionBean.cart.numberOfItems == 0}">
			<tr>
				<td colspan="8"><b>Your cart is empty</b></td>		
			</tr>
			</c:if>
			<c:forEach var="cartItem" items="${actionBean.cart.cartItems}">
			<tr>
				<td><stripes:link 
					beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
					event="viewItem">
					<stripes:param name="itemId" value="${cartItem.item.itemId}"/>
					${cartItem.item.itemId}
				</stripes:link>
				</td>
				<td>${cartItem.item.product.productId}</td>
				<td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
				${cartItem.item.attribute3} ${cartItem.item.attribute4}
				${cartItem.item.attribute5} ${cartItem.product.name}</td>
				<td>${cartItem.inStock}</td>
				<td><stripes:text name="${cartItem.item.itemId}" size="3"
					value="${cartItem.quantity}"/></td>
				<td><fmt:formatNumber value="${cartItem.item.listPrice}"
					pattern="$#,##0.00"/></td>
				<td><fmt:formatNumber value="${cartItem.item.total}"
					pattern="$#,##0.00"/></td>
				<td><stripes:link class="Button"
					beanclass="org.mybatis.jpetstore.web.actions.CartActionBean"
					event="removeItemFromCart">
					<stripes:param name="cartItem" value="${cartItem.item.itemId}"/>
					Remove
				</stripes:link></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="7">Sub Total: 
					<fmt:formatNumber value="${actionBean.cart.subTotal}" pattern="$#,##0.00"/>
					<stripes:submit name="updateQuantities" value="Update Cart"/>
				</td>
				<td>&nbsp;</td>
			<tr>
		</table>
	</stripes:form>
	
	<c:if test="${actionBean.cart.numberOfItems > 0}">
		<stripes:link class="Button"
			beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean"
			event="newOrderForm">
			Process to Checkout
		</stripes:link>
	</c:if>
</div><!-- End div id="Cart" -->

<div id="MyList">
	<c:if test="${sessionScope.accountBean != null}">
		<c:if test="${sessionScope.accountBean.authenticated}">
			<c:if test="${!empty sessionScope.accountBean.account.listOption}">
				<%@ include file="IncludeMyList.jsp" %>
			</c:if>
		</c:if>
	</c:if>
</div><!-- End div id="MyList" -->

<div id="Separator">&nbsp;</div>

</div><!-- End div id="Catalog" -->

<%@ include file="../common/IncludeBottom.jsp"%>