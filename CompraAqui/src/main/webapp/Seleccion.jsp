<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<%
	String ano = request.getParameter("ano");

String N1 = request.getParameter("N1");
String N2 = request.getParameter("N2");
String N3 = request.getParameter("N3");
String N4 = request.getParameter("N4");
String N5 = request.getParameter("N5");
String N6 = request.getParameter("N6");
String N7 = request.getParameter("N7");
String N8 = request.getParameter("N8");
String N9 = request.getParameter("N9");
String N10 = request.getParameter("N10");

String No1 = request.getParameter("No1");
String No2 = request.getParameter("No2");
String No3 = request.getParameter("No3");
String No4 = request.getParameter("No4");
String No5 = request.getParameter("No5");
String No6 = request.getParameter("No6");
String No7 = request.getParameter("No7");
String No8 = request.getParameter("No8");
String No9 = request.getParameter("No9");
String No10 = request.getParameter("No10");

String I1 = request.getParameter("I1");
String I2 = request.getParameter("I2");
String I3 = request.getParameter("I3");
String I4 = request.getParameter("I4");
String I5 = request.getParameter("I5");
String I6 = request.getParameter("I6");
String I7 = request.getParameter("I7");
String I8 = request.getParameter("I8");
String I9 = request.getParameter("I9");
String I10 = request.getParameter("I10");

String S1 = request.getParameter("S1");
String S2 = request.getParameter("S2");
String S3 = request.getParameter("S3");
String S4 = request.getParameter("S4");
String S5 = request.getParameter("S5");
String S6 = request.getParameter("S6");
String S7 = request.getParameter("S7");
String S8 = request.getParameter("S8");
String S9 = request.getParameter("S9");
String S10 = request.getParameter("S10");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" pageEncoding="utf-8"%> --%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/seleccion.css" />
<title>ComprAqui</title>
</head>
<head>
<div align="center">
	<body>

		<div id="main-container">
			<h1>El ranking del <c:out value="${ano }" /> es:</h1>
			<table class="table table-sm">
				<thead>
					<tr>
						<th scope="col"></th>
						<th scope="col">Nombre Juego</th>
						<th scope="col">Nota</th>
						<th scope="col">Precio Steam</th>
						<th scope="col">Precio InstantGaming</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td><c:out value="${N1}" /></td>
						<td><c:out value="${No1}" /></td>
						<td><c:out value="${S1}" /></td>
						<td><c:out value="${I1}" /></td>
					</tr>

					<tr>
						<th scope="row">2</th>
						<td><c:out value="${N2}" /></td>
						<td><c:out value="${No2}" /></td>
						<td><c:out value="${S2}" /></td>
						<td><c:out value="${I2}" /></td>
					</tr>

					<tr>
						<th scope="row">3</th>
						<td><c:out value="${N3}" /></td>
						<td><c:out value="${No3}" /></td>
						<td><c:out value="${S3}" /></td>
						<td><c:out value="${I3}" /></td>
					</tr>

					<tr>
						<th scope="row">4</th>
						<td><c:out value="${N4}" /></td>
						<td><c:out value="${No4}" /></td>
						<td><c:out value="${S4}" /></td>
						<td><c:out value="${I4}" /></td>
					</tr>


					<tr>
						<th scope="row">5</th>
						<td><c:out value="${N5}" /></td>
						<td><c:out value="${No5}" /></td>
						<td><c:out value="${S5}" /></td>
						<td><c:out value="${I5}" /></td>
					</tr>

					<tr>
						<th scope="row">6</th>
						<td><c:out value="${N6}" /></td>
						<td><c:out value="${No6}" /></td>
						<td><c:out value="${S6}" /></td>
						<td><c:out value="${I6}" /></td>
					</tr>

					<tr>
						<th scope="row">7</th>
						<td><c:out value="${N7}" /></td>
						<td><c:out value="${No7}" /></td>
						<td><c:out value="${S7}" /></td>
						<td><c:out value="${I7}" /></td>
					</tr>
					<tr>
						<th scope="row">8</th>
						<td><c:out value="${N8}" /></td>
						<td><c:out value="${No8}" /></td>
						<td><c:out value="${S8}" /></td>
						<td><c:out value="${I8}" /></td>
					</tr>
					<tr>
						<th scope="row">9</th>
						<td><c:out value="${N9}" /></td>
						<td><c:out value="${No9}" /></td>
						<td><c:out value="${S9}" /></td>
						<td><c:out value="${I9}" /></td>
					</tr>
					<tr>
						<th scope="row">10</th>
						<td><c:out value="${N10}" /></td>
						<td><c:out value="${No10}" /></td>
						<td><c:out value="${S10}" /></td>
						<td><c:out value="${I10}" /></td>
					</tr>
				</tbody>
			</table>

		</div>
		<br>
		<a href="https://store.steampowered.com/?l=spanish"
			class="badge badge-secondary">Steam</a>
		<a
			href="https://www.instant-gaming.com/es/?gclid=CjwKCAjwztL2BRATEiwAvnALcvOlfMQC1lraMoyQeZ6FOkUtbimQ28IKbFAGXm50ZZHxmE8fau6ZXRoCYB4QAvD_BwE"
			class="badge badge-secondary">InstantGaming</a>
		<a href="https://as.com/meristation/" class="badge badge-secondary">MeriStation</a>
		<br>
		<br>
		<a class="btn btn-primary" href="index.jsp" role="button">Volver</a>
	<body>
</html>