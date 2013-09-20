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
				  <input type="text" name="computerName" value="${computer.name}"/>
				<!-- <input type="text" name="computerName" value="<c:choose>
																	<c:when test="${errorName != null &&errorName == true }">
																		${computerSaved.name}
																	</c:when>
																	<c:otherwise>
																	<c:if test="${computer.name != null }">
																		${computer.name}
																	</c:if>
																	
																	</c:otherwise>
																</c:choose>"/>-->
				<span class="help-inline">Required</span>					
				</div>
			</div>
	
			<div class="clearfix">
				<label for="introduced">Introduced date:</label>
				<div class="input">
					<input type="date" name="introducedDate" pattern="YY-MM-dd" value="${computer.introduced}"/>
					<span class="help-inline" id="dateInitRequired">format : YYYY-MM-DD - required</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="discontinued">Discontinued date:</label>
				<div class="input">
					<input type="date" name="discontinuedDate" pattern="YY-MM-dd" value="${computer.discontinued}"/>
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


<script type="text/javascript" src="js/javascriptValidation.js"></script>


<jsp:include page="include/footer.jsp" />