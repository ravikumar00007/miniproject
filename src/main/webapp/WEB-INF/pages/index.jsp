<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2 style="color:red;text-align:center" class="p-3 mb-2 bg-info text-red">Plan Report</h2>

	</div>
	<div class="container;p-3 mb-2 bg-primary-subtle text-primary-emphasis">
		<frm:form action="search" modelAttribute="serchRequest" method="POST">
			<table>
				<tr>
					<td>planNames</td>
					<td><frm:select path="planNames">
						<frm:option value="" >-select-</frm:option>
						<frm:options items="${planNames }"/>
						
						</frm:select>
					</td>
					<td>planStatus</td>
					<td><frm:select path="planStatus">
						<frm:option value="">-select-</frm:option>
						<frm:options items="${planStatus }"/>
						</frm:select>
					</td>
					<td>gender</td>
					<td><frm:select path="gender">
						<frm:option value="">-select-</frm:option>
						<frm:option value="male">male</frm:option>
						<frm:option value="female">female</frm:option>
						
						</frm:select>
					</td>
				</tr>
				<tr>
				<td>StartDate</td>
				<td><frm:input path="startDate" type="date"/></td>
				
				<td>EndDate</td>
				<td><frm:input path="endDate" type="date"/></td>
				</tr>
				<tr>
				<td><button type="submit" class="btn btn-primary">Serch</button></td>
				<td><a href="/" class="btn btn-primary">Reset</a></td>
				</tr>
				
			</table>
			<table class="table">
				<thead>
				<tr><th>Id</th><th>Holder name</th><th>Plan Name</th><th>Plan Status</th><th>Start date</th><th>End date</th><th>Benifit Amount</th>
				
				</tr>
				</thead>
				<tbody >
				<c:forEach var="c" items="${list }" varStatus="index">
				 <tr><td>${index.count }</td>
				 <td>${c.citizenName }</td>
				 <td>${c.planNames }</td>
				 <td>${c.planStatus }</td>
				 <td>${c.planStartDate }</td>
				 <td>${c.planEndDate }</td>
				 <td>${c.benifitAmount }</td>
				 </tr>
				</c:forEach>
				
				<c:if test="${empty list }">
				<td callspan="10" style="color:red;text-align:center">no record found</td>
				</c:if>
				
				</tbody>
			</table>
		</frm:form>
		<hr/>
		<hr/>
				Export : <a href="excel ">Excel</a> <a href="pdf" >Pdf</a> <a href="see developer"><img  src=""></a>
				
	</div>
	
				<h5 style="text-align:center">Copyright &copy; 2024 by S.S. infotech</h5>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>


</body>
</html>