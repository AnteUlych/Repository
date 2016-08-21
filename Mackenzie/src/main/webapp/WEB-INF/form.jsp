<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>FSM</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<head>

<style>
@media ( min-width : 1200px) {
	.container {
		width: 990px;
	}
	.table-borderless td,.table-borderless th {
		border: 0 !important;
	}
	.jumbotron {
		border-radius: 10px 10px 10px 10px;
		-moz-border-radius: 10px 10px 10px 10px;
		-webkit-border-radius: 10px 10px 10px 10px;
		border: 0px solid #000000;
		-webkit-box-shadow: 10px 10px 41px -1px rgba(0, 0, 0, 0.75);
		-moz-box-shadow: 10px 10px 41px -1px rgba(0, 0, 0, 0.75);
		box-shadow: 10px 10px 41px -1px rgba(0, 0, 0, 0.75);
		background-color: #FFFFFF !important;
	}
}
</style>

</head>

<body>
	<br />
	<div class="container">
		<div class="jumbotron">
			<div class="pull-right">
				<img src="<c:url value="/resources/images/fsm.jpg" />" alt="fsm">
			</div>
			<br /> <br /> <br /> <br />
			<div style="width: 800px;">Мы признательны Вам за доверие,
				оказанное нашей компании, и хотим улучшить наш сервис. Просим Вас
				ответить на вопросы нашей анкеты с помощью оценки, используя
				10-бальную шкалу. Спасибо!</div>
			<br />

			<form:form method="POST" commandName="form">
				<table>

					<tr>
						<td colspan="20">Введите Ваше ФИО:
						<td><form:input path="name" /> <form:errors path="name"
								cssStyle="color: #ff0000;" /></td>

					</tr>
					<tr>
						<td colspan="20">Введите название Вашей компании:
						<td><form:input path="company" /> <form:errors
								path="company" cssStyle="color: #ff0000;" /></td>

					</tr>
				</table>
				<br />

				<table class="table table-hover table-borderless table-condensed">
					<tr>
						<td>1. ${questions.get(0)}
						<td><form:radiobuttons path="rate1" items="${rate1}" /><br />
							<form:errors path="rate1" cssStyle="color: #ff0000;" /></td>
					</tr>

					<tr>
						<td>2. ${questions.get(1)}
						<td><form:radiobuttons path="rate2" items="${rate2}" /><br />
							<form:errors path="rate2" cssStyle="color: #ff0000;" /></td>
					</tr>
					<tr>
						<td>3. ${questions.get(2)}
						<td><form:radiobuttons path="rate3" items="${rate3}" /><br />
							<form:errors path="rate3" cssStyle="color: #ff0000;" /></td>
					</tr>
					<tr>
						<td>4. ${questions.get(3)}
						<td><form:radiobuttons path="rate4" items="${rate4}" /><br />
							<form:errors path="rate4" cssStyle="color: #ff0000;" /></td>
					</tr>
					<tr>
						<td>5. ${questions.get(4)}
						<td><form:radiobuttons path="rate5" items="${rate5}" /><br />
							<form:errors path="rate5" cssStyle="color: #ff0000;" /></td>
					</tr>
					<tr>
						<td>6. ${questions.get(5)}
						<td><form:radiobuttons path="rate6" items="${rate6}" /><br />
							<form:errors path="rate6" cssStyle="color: #ff0000;" /></td>
					</tr>
					<tr>
						<td>7. ${questions.get(6)}
						<td><form:radiobuttons path="rate7" items="${rate7}" /><br />
							<form:errors path="rate7" cssStyle="color: #ff0000;" /></td>
					</tr>
					<tr>
						<td>8. ${questions.get(7)}
						<td><form:radiobuttons path="rate8" items="${rate8}" /><br />
							<form:errors path="rate8" cssStyle="color: #ff0000;" /></td>
					</tr>
					<tr>
						<td>9. ${questions.get(8)}
						<td><form:radiobuttons path="rate9" items="${rate9}" /><br />
							<form:errors path="rate9" cssStyle="color: #ff0000;" /></td>
					</tr>
					<tr>
						<td>10. ${questions.get(9)}
						<td><form:radiobuttons path="rate10" items="${rate10}" /><br />
							<form:errors path="rate10" cssStyle="color: #ff0000;" /></td>
					</tr>

				</table>
				<br />

				<input type="submit" class="btn btn-primary btn-lg pull-right"
					name="submit" value="отправить">

			</form:form>
		</div>
	</div>
</body>
</html>