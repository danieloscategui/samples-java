<%@ include file="../common/IncludeTop.jsp"%>

<div id="Welcome">
<div id="WelcomeContent">
	<c:if test="${sessionScope.accountBean != null}">
		<c:if test="${sessionScope.accountBean.authenticated}">
			Welcome ${sesionScope.accountBean.account.firstName}
		</c:if>
	</c:if>
</div><!-- End div id="WelcomeContent" -->
</div><!-- End div id="Welcome" -->

<div id="Main">
<div id="SideBar">
<div id="SideBarContent">
	<stripes:link
		beanclass="org.mybatis.jpetstore.web.actiosn.CatalogActionBean"
		event="viewCategory">
		<stripes:param name="categoryId" value="FISH"/>
		<img  src="../images/fish_icon.gif"/>
	</stripes:link><br />
	Saltwater, FreshWater<br />
	<stripes:link
		beanclass="org.mybatis.jpetstore.web.actiosn.CatalogActionBean"
		event="viewCategory">
		<stripes:param name="categoryId" value="DOGS"/>
		<img  src="../images/dogs_icon.gif"/>
	</stripes:link><br />
	Various Breeds<br />
	<stripes:link
		beanclass="org.mybatis.jpetstore.web.actiosn.CatalogActionBean"
		event="viewCategory">
		<stripes:param name="categoryId" value="CATS"/>
		<img  src="../images/cats_icon.gif"/>
	</stripes:link><br />
	Various Breeds, Exotic Varieties<br />
	<stripes:link
		beanclass="org.mybatis.jpetstore.web.actiosn.CatalogActionBean"
		event="viewCategory">
		<stripes:param name="categoryId" value="REPTILES"/>
		<img  src="../images/reptiles_icon.gif"/>
	</stripes:link><br />
	Lizards, Turtles, Snakes<br />
	<stripes:link
		beanclass="org.mybatis.jpetstore.web.actiosn.CatalogActionBean"
		event="viewCategory">
		<stripes:param name="categoryId" value="BIRDS"/>
		<img  src="../images/birds_icon.gif"/>
	</stripes:link><br />
	Exotic Varieties<br />
</div><!-- End div id="SideBarContent" -->
</div><!-- End div id="SideBar"-->

<div id="MainImage">
<div id="MainImageContent">
	<map name="estoremap">
		<area alt="Birds" coords="72,2,280,250"
			href="Catalog.action?viewCategory=&categoryId=BIRDS" shape="RECT" />
		<area alt="Fish" coords="2,180,72,250"
			href="Catalog.action?viewCategory=&categoryId=FISH" shape="RECT" />
		<area alt="Dogs" coords="60,250,130,320"
			href="Catalog.action?viewCategory=&categoryId=DOGS" shape="RECT" />
		<area alt="Reptiles" coords="140,270,210,340"
			href="Catalog.action?viewCategory=&categoryId=REPTILES" shape="RECT" />
		<area alt="Cats" coords="225,240,295,310"
			href="Catalog.action?viewCategory=&categoryId=CATS" shape="RECT" />
		<area alt="Birds" coords="280,180,350,250"
			href="Catalog.action?viewCategory=&categoryId=BIRDS" shape="RECT" />
	</map>
	<img height="355" src="../images/splash.gif" align="middle"
		usemap="#estoremap" width="350">
</div><!-- End div id="MainImageContent" -->

</div><!-- End div id="MainImage" -->

<div id="Separator">&nbsp;</div>

</div><!-- End div id="Main" -->

<%@ include file="../common/IncludeBottom.jsp"%>