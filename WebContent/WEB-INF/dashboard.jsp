<jsp:include page="include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="fr.formation.computerdatabase.domain.*"%>

<section id="main">
	<h1 id="homeTitle"> ${totalComputer}
	computers have been found
		</h1>
	<div id="actions">
		<form action="Controller" method="GET">
			<input type="search" id="searchbox" name="search"
				value="" placeholder="Search name">
			<input type="submit" id="searchsubmit"
				value="Filter by name"
				class="btn primary">
		</form>
		<a class="btn success" id="add" href="AddController">Add Computer</a>
	</div>

		<table class="computers zebra-striped">
			<thead>
				<tr>
					<!-- Variable declarations for passing labels as parameters -->
					<!-- Table header for Computer Name -->
					<th>Computer Name</th>
					  <th>Introduced Date</th>
					<!-- Table header for Discontinued Date -->
					<th>Discontinued Date</th> 
					<!-- Table header for Company -->
					<th>Company</th>
				</tr>
			</thead>
			<tbody>

				
				<c:forEach items="${requestScope.computers}" var="computer">
				<tr>
					<td><a href="EditController?id=${computer.id}"> ${computer.name}</a></td>
					<td>${computer.introduced}</td>
					<td>${computer.discontinued}</td>
					<td>${computer.companie.name}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		

<c:if test="${currentPage != 1}">
        <td><a href="Controller?page=${currentPage - 1}">Previous</a></td>
</c:if>
 
    
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${nbPages}" var="index">
                <c:choose>
                    <c:when test="${currentPage eq index}">
                        <td>${index}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="Controller?page=${index}">${index}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
 
    <c:if test="${currentPage lt nbPages}">
        <td><a href="Controller?page=${currentPage + 1}">Next</a></td>
    </c:if>-
</section>

<jsp:include page="include/footer.jsp" />
