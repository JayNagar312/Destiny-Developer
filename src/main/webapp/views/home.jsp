<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org/">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" th:href="@{/css/style.css}">
</head>
<body>
<h1>This is home page</h1>
<h2 th:text="${name}"></h2>
<img alt="#" th:src="@{/images/cardone.jpg}">
<script type="text/javascript" th:src="@{/js/script.js}"></script>
</body>
</html>