<h3>Account Information</h3>
<table>
	<tr>
		<td>First name:</td>
		<td><stripes:text name="account.firstName"/></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><stripes:text name="account.lastName"/></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><stripes:text name="account.email" size="40"/></td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td><stripes:text name="account.phone"/></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><stripes:text name="account.address1" size="40"/></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><stripes:text name="account.address2" size="40"/></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><stripes:text name="account.city"/></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><stripes:text name="account.state" size="4"/></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><stripes:text name="account.zip" size="10"/></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><stripes:text name="account.country" size="15"/></td>
	</tr>
</table>

<h3>Profile Information</h3>

<table>
	<tr>
		<td>Language preference:</td>
		<td><stripes:select name="account.languagePreference">
			<stripes:options-collection collection="${actionBean.languages}"/>
		</stripes:select></td>
	</tr>
	<tr>
		<td>Favourite Category</td>
		<td><stripes:select name="account.favouriteCategoryId">
			<stripes:options-collection collection="${actionBean.categories}"/>
		</stripes:select></td>
	</tr>
	<tr>
		<td>Enable MyList</td>
		<td><stripes:checkbox name="${account.listOption}"/></td>
	</tr>
	<tr>
		<td>Enable MyBanner</td>
		<td><stripes:checkbox name="${account.bannerOption}"/></td>
	</tr>
</table>