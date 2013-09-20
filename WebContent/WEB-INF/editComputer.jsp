<jsp:include page="include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.formation.computerdatabase.domain.*"%>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>

<section id="main">

	<h1>Edit Computer</h1>
	
	<form action="EditController" method="POST" id="editComputer">
		<fieldset>
			<div class="clearfix">
				<label for="name">Computer name:</label>
				<div class="input">
				
				<!-- On récupère la valeur à partir de l'attribut name de computer -->
				
					<input type="text" name="computerName" value="${computer.name}"/>
					<span class="help-inline">Required</span>					
				</div>
			</div>
	
			<div class="clearfix">
				<label for="introduced">Introduced date:</label>
				<div class="input">
				
				<!-- On récupère la valeur à partir de l'attribut date introduced de computer -->
				
					<input type="date" name="introducedDate" pattern="YY-MM-dd" value="${computer.introducedAsString}"/>
					<span class="help-inline" id="dateInitRequired">format : YYYY-MM-DD - required</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="discontinued">Discontinued date:</label>
				<div class="input">
				
				<!-- On récupère la valeur à partir de l'attribut date discontinued de computer -->
				
					<input type="date" name="discontinuedDate" pattern="YY-MM-dd" value="${computer.discontinuedAsString}"/>
					<span class="help-inline" id="dateDiscRequired">format : YYYY-MM-DD - required</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="company">Company Name:</label>
				<div class="input">
					<select name="company">
					<c:forEach 
					items="${requestScope.companies}" var="companies">
					<c:if test="${companies.id == computer.companie.id}">
						<option value="${companies.id}" selected="selected">${companies.name}</option>
					</c:if>
					<c:if test="${companies.id != computer.companie.id}">
						<option value="${companies.id}">${companies.name}</option>
					</c:if>
						</c:forEach>
					</select>
				</div>
			</div>

		</fieldset>
		<div class="actions">
			<input type="submit" value="Edit" class="btn primary">
			or <a href="Controller" class="btn">Cancel</a>
			or <a href="DeleteController?id=${computer.id}" class="btn primary">Delete</a>
		</div>
	</form>
</section>

<script type="text/javascript">
jQuery(document).ready(function(){
	$("#editComputer").validate({
	                rules: {
	                    "computerName" : {
	                    	"required":true //les rules sont des règles issues du plug in JQuery
	                    },
	                    "introducedDate" : {
	                    	"required":true,
	                    	"regex":/(\d{4})-(\d{2})-(\d{2})/ //permet de tester côté client si le champ n'est pas vide
	                    },
	                    "discontinuedDate" : {
	                    	"required":true,
	                    	"regex":/(\d{4})-(\d{2})-(\d{2})/
	                    }
	                },
	                messages: {//permet de tester le format de date
	                    computerName: "Please enter the computer name",
	                    introducedDate: "Please enter the introduced date",
	                    discontinuedDate:"Please enter the discontinued date"
	                },
	                submitHandler: function(form) {
	                    form.submit();
	                }
	            });

});
</script>


<jsp:include page="include/footer.jsp" />