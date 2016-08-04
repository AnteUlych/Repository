<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<html>
<title>FSM</title>
<head>

<style>
card {
	position: relative;
	left: 180px;
	padding-right: 870px;
	padding-bottom: 520px;
	background-color: #FFFFC5;
	box-shadow: 10px 10px 5px grey;
}

div {
	width: 800px;
}

position {
	position: relative;
	left: 200px;
}

click {
	position: relative;
	left: 750px;
}
</style>

</head>

<body>
	<card></card>
	<position>
	<h2 style="text-indent: 200px; color: red;">Оценка сервиса
		компании FSM</h2>
	<br />
	<div>Мы признательны Вам за доверие, оказанное нашей компании, и
		хотим улучшить наш сервис. Просим Вас ответить на вопросы нашей анкеты
		с помощью оценки, используя 10-бальную шкалу. Спасибо!</div>
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
				<td><form:input path="company" /> <form:errors path="company"
						cssStyle="color: #ff0000;" /></td>

			</tr>
		</table>
		<br />

		<table>
			<tr>
				<td>1. ${questions.get(0)}
				<td><form:radiobuttons path="rate1" items="${rate1}" /> <form:errors
						path="rate1" cssStyle="color: #ff0000;" /></td>
			</tr>

			<tr>
				<td>2. ${questions.get(1)}
				<td><form:radiobuttons path="rate2" items="${rate2}" /> <form:errors
						path="rate2" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>3. ${questions.get(2)}
				<td><form:radiobuttons path="rate3" items="${rate3}" /> <form:errors
						path="rate3" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>4. ${questions.get(3)}
				<td><form:radiobuttons path="rate4" items="${rate4}" /> <form:errors
						path="rate4" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>5. ${questions.get(4)}
				<td><form:radiobuttons path="rate5" items="${rate5}" /> <form:errors
						path="rate5" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>6. ${questions.get(5)}
				<td><form:radiobuttons path="rate6" items="${rate6}" /> <form:errors
						path="rate6" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>7. ${questions.get(6)}
				<td><form:radiobuttons path="rate7" items="${rate7}" /> <form:errors
						path="rate7" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>8. ${questions.get(7)}
				<td><form:radiobuttons path="rate8" items="${rate8}" /> <form:errors
						path="rate8" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>9. ${questions.get(8)}
				<td><form:radiobuttons path="rate9" items="${rate9}" /> <form:errors
						path="rate9" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>10. ${questions.get(9)}
				<td><form:radiobuttons path="rate10" items="${rate10}" /> <form:errors
						path="rate10" cssStyle="color: #ff0000;" /></td>
			</tr>

		</table>
		<br />

		<click> <input type="submit" name="submit" value="отправить">
		</click>
	</form:form> </position>
</body>
</html>