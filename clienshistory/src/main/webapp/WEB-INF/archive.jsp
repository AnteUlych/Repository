 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page language="java" contentType="text/html; charset=cp1251"%>
 <%@ page pageEncoding="cp1251"%>
 
<!DOCTYPE html>
<html>
<title>Агротеп</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/fixedheader/3.2.3/js/dataTables.fixedHeader.min.js"></script>

<link rel="stylesheet" href="<c:url value="/resources/w3.css" />">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/fixedheader/3.2.3/css/fixedHeader.dataTables.min.css">

<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> &nbsp;Menu</button>
  <span class="w3-bar-item w3-right"> <a href="/clientshisory/login" ><i class="fa fa-sign-out fa-fw"></i></a></span>
${menuForHead}
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    
    <div class="w3-col s8 w3-bar">
      <span><strong>${name}</strong></span><br>
    </div>
  </div>
  <hr>

  <div class="w3-bar-block">
    <a href="/clientshisory/plan" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>&nbsp; Close Menu</a>
    <a href="/clientshisory/plan" class="w3-bar-item w3-button w3-padding "><i class="fa fa-calendar w3-text-blue"></i>&nbsp; Графік дзвінків</a>
    <a href="/clientshisory/calculates" class="w3-bar-item w3-button w3-padding "><i class="fa fa-book w3-text-pink"></i>&nbsp; Запити</a>
    <a href="/clientshisory/archive" class="w3-bar-item w3-button w3-padding "><i class="fa fa-archive w3-text-orange"></i>&nbsp; Архів запитів</a>
    <a href="/clientshisory/addclient" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user-plus w3-text-green"></i>&nbsp; Додати клієнта</a>
    <a href="/clientshisory/find" class="w3-bar-item w3-button w3-padding"><i class="fa fa-search w3-text-red"></i>&nbsp; Пошук компаній</a>
 
    <a href="/clientshisory/report" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bar-chart w3-text-gray"></i>&nbsp; Звіт</a>
  </div>

  <hr>
    <div class="w3-bar-block">
    
    <c:forEach items="${products}" var="prod" varStatus="theCount">
    <a href="/clientshisory/planproduct/${prod.id}" class="w3-bar-item w3-button w3-padding "><i class="fa fa-minus"></i>&nbsp; ${prod.product}</a>
    </c:forEach>
<hr>
  </div>
  
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5>
   
    <b><i class="fa fa-archive"></i> Архів запитів 
    </b>
     
    
    </h5>
  </header>
  
<br>
<div class="w3-container">

 
    <table id="example" class="w3-table w3-bordered w3-border w3-white w3-hoverable">
<thead>
<tr>	
<th>Клієнт</th>
<th>Менеджер</th>
<th>Вага</th>
<th>Вантаж</th>
<th>РС</th>
<th>t</th>
<th>АДР</th>
<th>Відправка</th>

<th>Доставка</th>

<th>Актуальність</th>
<th>Ціна</th>
<th>Бюджет клієнта</th>
<th>Коментар</th>
</tr>	
	</thead>
	<tbody>
<c:forEach items="${calculates}" var="calc" varStatus="theCount">		
<tr>
<td><a href="/clientshisory/client/${calc.companyid}">${calc.company}</a></td>
<td>${calc.manager}</td>
<td>${calc.weight}</td>
<td>${calc.freight}</td>
<td>${calc.truck}</td>
<td>${calc.temperature}</td>
<td><b style="color:red">${calc.dangerous}</b></td>
<td>${calc.cityfrom}, ${calc.countryfrom}</td>
<td>${calc.cityto}, ${calc.countryto}</td>
<td>${calc.calculateonadate}</td>
<td>${calc.budget}</td>
<td>${calc.rate}</td>
<td>${calc.comments}</td>
</tr>
</c:forEach>
</tbody>
<tfoot>
<tr>	
<th>Клієнт</th>
<th>Менеджер</th>
<th>Вага</th>
<th>Вантаж</th>
<th>РС</th>
<th>t</th>
<th>АДР</th>
<th>Відправка</th>

<th>Доставка</th>

<th>Актуальність</th>
<th>Ціна</th>
<th>Бюджет клієнта</th>
<th>Коментар</th>
</tr>	
</tfoot>
</table>
<br>
<br>



<br><br><br>
  
  </div>

  </div>

<script>

// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
    if (mySidebar.style.display === 'block') {
        mySidebar.style.display = 'none';
        overlayBg.style.display = "none";
    } else {
        mySidebar.style.display = 'block';
        overlayBg.style.display = "block";
    }
}

// Close the sidebar with the close button
function w3_close() {
    mySidebar.style.display = "none";
    overlayBg.style.display = "none";
}

$(document).ready(function () {
    // Setup - add a text input to each footer cell
    $('#example thead tr')
        .clone(true)
        .addClass('filters')
        .appendTo('#example thead');
 
    var table = $('#example').DataTable({
        orderCellsTop: true,
        fixedHeader: true,
        initComplete: function () {
            var api = this.api();
 
            // For each column
            api
                .columns()
                .eq(0)
                .each(function (colIdx) {
                    // Set the header cell to contain the input element
                    var cell = $('.filters th').eq(
                        $(api.column(colIdx).header()).index()
                    );
                    var title = $(cell).text();
                    $(cell).html('<input type="text" size="4" style="border:none" />');
 
                    // On every keypress in this input
                    $(
                        'input',
                        $('.filters th').eq($(api.column(colIdx).header()).index())
                    )
                        .off('keyup change')
                        .on('change', function (e) {
                            // Get the search value
                            $(this).attr('title', $(this).val());
                            var regexr = '({search})'; //$(this).parents('th').find('select').val();
 
                            var cursorPosition = this.selectionStart;
                            // Search the column for that value
                            api
                                .column(colIdx)
                                .search(
                                    this.value != ''
                                        ? regexr.replace('{search}', '(((' + this.value + ')))')
                                        : '',
                                    this.value != '',
                                    this.value == ''
                                )
                                .draw();
                        })
                        .on('keyup', function (e) {
                            e.stopPropagation();
 
                            $(this).trigger('change');
                            $(this)
                                .focus()[0]
                                .setSelectionRange(cursorPosition, cursorPosition);
                        });
                });
        },
    });
});
</script>

</body>
</html>