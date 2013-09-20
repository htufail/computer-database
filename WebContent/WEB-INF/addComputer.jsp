<jsp:include page="include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.formation.computerdatabase.domain.*"%>

<script type="text/javascript">
	
	function error_field(){
		var name = document.getElementById("error_name");
		var dateI = document.getElementById("error_introDate");
		var dateD = document.getElementById("error_discDate");
		
		alert("name : " + name);
		//if(name == null || name.trim().isEmpty())
			name.innerHTML = "Please do give a name to your computer ";
		//if(dateI == null)
			dateI.innerHTML = "Please do give the date when your computer was introduced";
		//if(dateD == null)
			dateD.innerHTML = "Please do give the date when your computer was discontinued";
	
	}
	</script>

<section id="main">

	<h1>Add Computer</h1>
	
	<form action="AddController" method="POST" onload="error_field()">
		<fieldset>
			<div class="clearfix">
				<label for="name">Computer name:</label>
				<div class="input">
					<input type="text" name="computerName" />
					<span class="help-inline">Required</span>
					<span id="error_name"></span>
				</div>
			</div>
	
			<div class="clearfix">
				<label for="introduced">Introduced date:</label>
				<div class="input">
					<input type="date" name="introducedDate" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
					<span id="error_IntroDate"></span>
				</div>
			</div>
			<div class="clearfix">
				<label for="discontinued">Discontinued date:</label>
				<div class="input">
					<input type="date" name="discontinuedDate" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
					<span id="error_DiscDate"></span>
				</div>
			</div>
			<div class="clearfix">
				<label for="company">Company Name:</label>
				<div class="input">
					<select name="company">
					<c:forEach 
					items="${requestScope.companies}" var="companies">
						<option value="${companies.id}">${companies.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</fieldset>
		<div class="actions">
			<input type="submit" value="Add" class="btn primary">
			or <a href="Controller" class="btn">Cancel</a>
		</div>
	</form>
</section>

<jsp:include page="include/footer.jsp" />