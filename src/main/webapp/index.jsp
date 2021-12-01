<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 11/18/2021
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<!-- То что контент может вылететь с разных сторон это не баг а фича!
    сделано криворуким дебилом который ищет себя

-->
<head>
    <meta charset="UTF-8">
    <title> LABA</title>
    <link rel="icon" type="image/png" href="media/fly.jpg"/>
    <link rel="stylesheet" href="css/style.css">
</head>


<body>

<header>
    <div id="header_left">
        <h2>Антонов Дмитрий Владимирович<br>
            группа Р3215</h2>
    </div>
    <div id="header_right">
        <h2 id="right_h2">Вариант 15001</h2>
    </div>
</header>
<div class="content">
    <div class="graph center">

        <svg id="svgField" style="    height: 300px;
width: 300px;
background-color: white;">
            <!— fill elements are here to make everything look nice-->
            <polygon fill="#0076ff" fill-opacity="1" points="150,150 150,210 273,150"></polygon>
            <rect fill="#0076ff" fill-opacity="1" x="150" y="30" height="120" width="60"></rect>
            <g transform="translate(150,150)">
                <path d="M0 0 -60 0 A60 55 0 0 1 0 -60" fill="#0076ff"/>
            </g>
            <line stroke="black" x1="0" x2="300" y1="150" y2="150"></line>
            <line stroke="black" x1="150" x2="150" y1="0" y2="300"></line>

            <text x="275" y="143">R</text>
            <line stroke="black" x1="273" x2="273" y1="148" y2="152"></line>

            <text x="215" y="143">R/2</text>
            <line stroke="black" x1="210" x2="210" y1="148" y2="152"></line>

            <text x="90" y="143">-R/2</text>
            <line stroke="black" x1="90" x2="90" y1="148" y2="152"></line>

            <text x="30" y="143">-R</text>
            <line x1="30" x2="30" y1="148" y2="152"></line>

            <text x="150" y="26">R</text>
            <line stroke="black" x1="148" x2="152" y1="30" y2="30"></line>

            <text x="150" y="86">R/2</text>
            <line stroke="black" x1="148" x2="152" y1="90" y2="90"></line>

            <text x="155" y="215">-R/2</text>
            <line stroke="black" x1="147" x2="153" y1="210" y2="210"></line>

            <text x="150" y="280">-R</text>
            <line x1="148" x2="152" y1="270" y2="270"></line>

            <circle r="2" stroke="black" cx="150" cy="150"/>

            <polygon fill="black" points="300,150 295,145 295,155" stroke="black"></polygon>
            <polygon fill="black" points="150,0 145,5 155,5" stroke="black"></polygon>

            <circle  cx="150" cy="150" id="pointer" r="5"></circle>
        </svg>
    </div>
    <div class="changes">
        <div class="by_x">
            изменения по x <br>
            <input class="XBox" value="-2" type="checkbox" name="-2">-2
            <input class="XBox" value="-1.5" type="checkbox" name="-1.5">-1.5
            <input class="XBox" value="-1" type="checkbox" name="-1">-1
            <input class="XBox" value="-0.5" type="checkbox" name="-0.5">-0.5
            <input class="XBox" value="0" type="checkbox" name="0">0
            <input class="XBox" value="1" type="checkbox" name="1">1
            <input class="XBox" value="1.5" type="checkbox" name="1.5">1.5
            <input class="XBox" value="2" type="checkbox" name="2">2


        </div>
        <br>
        <div class="by_y">
            изменения по y <br>
            <input id="y" type="text" maxlength="5" onchange="this.value = this.value.replace(/,/g, '.')">
            <label for="y"><br>-5 ... 5</label>
        </div>
        <br>
        <div class="by_R">
            изменения по R <br>
            <input class="rBox" value="1" type="checkbox" name="1">1
            <input class="rBox" value="1.5" type="checkbox" name="2">1.5
            <input class="rBox" value="2" type="checkbox" name="3">2
            <input class="rBox" value="2.5" type="checkbox" name="4">2.5
            <input class="rBox" value="3" type="checkbox" name="5">3

        </div>
    </div>
    <br>
    <div class="center manager-buttons">
        <button class="send-button" id="clearButton" type="button">Очистить</button>
        <button class="send-button" id="submitButton" type="button">Отправить</button>
    </div>
    <BR>
    <table border="50" id="result_table">
        <thead>
            <th scope="col" class="coords_column">X</th>
            <th scope="col" class="coords_column">Y</th>
            <th scope="col" class="coords_column">R</th>
            <th scope="col" class="time_column">Текущее время</th>
            <th scope="col" class="time_column">Время выполнения</th>
            <th scope="col" class="result_column">Результат</th>
        </thead>
        <tbody id="answerValues">
        <%@include file="table.jsp"%>
        </tbody>
    </table>

    <footer id="footer">
        footer
    </footer>
</div>



<script type="text/javascript" src="js/script.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
</html>