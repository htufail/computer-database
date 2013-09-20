<jsp:include page="include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.formation.computerdatabase.domain.*"%>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>


<section id="main">

	<h1>Add Computer</h1>
	
	<form action="AddController" method="POST" id="addComputer">
		<fieldset>
			<div class="clearfix">
				<label for="name">Computer name:</label>
				<div class="input">
					<input type="text" name="computerName" />
					<span class="help-inline">Required</span>
				</div>
			</div>
	
			<div class="clearfix">
				<label for="introduced">Introduced date:</label>
				<div class="input">
					<input type="date" name="introducedDate" id="introducedDate" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="discontinued">Discontinued date:</label>
				<div class="input">
					<input type="date" name="discontinuedDate" id="discontinuedDate" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
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

<!-- On souhaitait rendre le code propre en le liant le javascript dans un fichier externe mais
ne marche pas bien sous IExplorer -->
<!--  <script type="text/javascript" src="js/javascriptValidation.js"></script>-->

<script type="text/javascript">
jQuery(document).ready(function(){
	$("#addComputer").validate({
	                rules: {
	                    "computerName" : {
	                    	"required":true
	                    },
	                    "introducedDate" : {
	                    	"required":true,
	                    	"regex":/(\d{4})-(\d{2})-(\d{2})/
	                    },
	                    "discontinuedDate" : {
	                    	"required":true,
	                    	"regex":/(\d{4})-(\d{2})-(\d{2})/
	                    }
	                },
	                messages: {
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