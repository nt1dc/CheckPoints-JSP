# CheckPoints-JSP
<div>
<p>Техническое Задание<p/>

<img src="https://user-images.githubusercontent.com/70935236/147333449-e42b420f-8f0f-4852-95a0-aa811e75f9d3.png"/>

<p>Разработать веб-приложение на базе сервлетов и JSP, определяющее попадание точки на координатной плоскости в заданную область.</p>

<p>Приложение должно быть реализовано в соответствии с <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller" target="_blank">шаблоном MVC</a> и состоять из следующих элементов:</p>

<ul>
	<li><strong>ControllerServlet</strong>, определяющий тип запроса, и, в зависимости от того, содержит ли запрос информацию о координатах точки и радиусе, делегирующий его обработку одному из перечисленных ниже компонентов. Все запросы внутри приложения должны передаваться этому сервлету (по методу GET или POST в зависимости от варианта задания), остальные сервлеты с веб-страниц напрямую вызываться не должны.</li>
	<li><strong>AreaCheckServlet</strong>, осуществляющий проверку попадания точки в область на координатной плоскости и формирующий HTML-страницу с результатами проверки. Должен обрабатывать все запросы, содержащие сведения о координатах точки и радиусе области.</li>
	<li><strong>Страница JSP</strong>, формирующая HTML-страницу с веб-формой. Должна обрабатывать все запросы, не содержащие сведений о координатах точки и радиусе области.</li>
</ul>

<p id="yui_patched_v3_11_0_1_1489348727524_1267"><strong id="yui_patched_v3_11_0_1_1489348727524_1266">Разработанная страница JSP должна содержать:</strong></p>

<ol id="aui_3_4_0_1_11617">
	<li>"Шапку", содержащую ФИО студента, номер группы и номер варианта.</li>
	<li>Форму, отправляющую данные на сервер.</li>
	<li id="aui_3_4_0_1_11616">Набор полей для задания координат точки и радиуса области в соответствии с вариантом задания.</li>
	<li>Сценарий на языке JavaScript, осуществляющий валидацию значений, вводимых пользователем в поля формы.</li>
	<li>Интерактивный элемент, содержащий изображение области на координатной плоскости (в соответствии с вариантом задания) и реализующий следующую функциональность:
	<ul>
		<li>Если радиус области установлен, клик курсором мыши по изображению должен обрабатываться JavaScript-функцией, определяющей координаты точки, по которой кликнул пользователь и отправляющей полученные координаты на сервер для проверки факта попадания.</li>
		<li>В противном случае, после клика по картинке должно выводиться сообщение о невозможности определения координат точки.</li>
		<li>После проверки факта попадания точки в область изображение должно быть обновлено с учётом результатов этой проверки (т.е., на нём должна появиться новая точка).</li>
	</ul>
	</li>
	<li>Таблицу с результатами предыдущих проверок. Список результатов должен браться из контекста приложения, HTTP-сессии или Bean-компонента в зависимости от варианта.</li>
</ol>

<p><strong>Страница, возвращаемая AreaCheckServlet, должна содержать:</strong></p>

<ol>
	<li>Таблицу, содержащую полученные параметры.</li>
	<li>Результат вычислений - факт попадания или непопадания точки в область.</li>
	<li>Ссылку на страницу с веб-формой для формирования нового запроса.</li>
</ol>

<p id="aui_3_4_0_1_11640">Разработанное веб-приложение необходимо развернуть на сервере <a href="https://wildfly.org/" target="_blank">WildFly</a>. Сервер должен быть запущен в standalone-конфигурации, порты должны быть настроены в соответствии с выданным portbase, доступ к http listener'у должен быть открыт для всех IP.</p>

</div>
