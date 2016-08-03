
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>FSM</title>
<head>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}
th {
    background-color: #ffe866;
}
th, td {
    padding: 8px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}

tr:hover{background-color:#f5f5f5}
</style>
</head>


<body>
	<div align="center">
        <table border="1" cellpadding="5">
            <caption>Результат анкетирования</caption>
            <tr>
                <th>Клиент</th>
                <th>ФИО</th>
                <th>Дата заполнения формы</th>
                <th># 1</th>
                <th># 2</th>
                <th># 3</th>
                <th># 4</th>
                <th># 5</th>
                <th># 6</th>
                <th># 7</th>
                <th># 8</th>
                <th># 9</th>
                <th># 10</th>
                <th>Оценка</th>
            </tr>
            <c:forEach var="questionnaire" items="${questionnaire}">
                <tr>
                    <td><c:out value="${questionnaire.company}" /></td>
                    <td><c:out value="${questionnaire.name}" /></td>
                    <td><c:out value="${questionnaire.getDate()}" /></td>
                    <td><c:out value="${questionnaire.question1}" /></td>
                    <td><c:out value="${questionnaire.question2}" /></td>
                    <td><c:out value="${questionnaire.question3}" /></td>
                    <td><c:out value="${questionnaire.question4}" /></td>
                    <td><c:out value="${questionnaire.question5}" /></td>
                    <td><c:out value="${questionnaire.question6}" /></td>
                    <td><c:out value="${questionnaire.question7}" /></td>
                    <td><c:out value="${questionnaire.question8}" /></td>
                    <td><c:out value="${questionnaire.question9}" /></td>
                    <td><c:out value="${questionnaire.question10}" /></td>
                     <td><c:out value="${questionnaire.getTotalRate()}" /></td>
                </tr>
            </c:forEach>
            
             <tr style="font-weight:bold">
                <td>Итог</td>
                <td>-</td>
                <td>-</td>
                <td>${totalRates.get(1)}</td>
                <td>${totalRates.get(2)}</td>
                <td>${totalRates.get(3)}</td>
                <td>${totalRates.get(4)}</td>
                <td>${totalRates.get(5)}</td>
                <td>${totalRates.get(6)}</td>
                <td>${totalRates.get(7)}</td>
                <td>${totalRates.get(8)}</td>
                <td>${totalRates.get(9)}</td>
                <td>${totalRates.get(10)}</td>
                
                <td>${totalRates.get(0)}</td>
            </tr>
            
            
        </table>
    </div>


</body>
</html>