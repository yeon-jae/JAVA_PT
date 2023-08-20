<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet" >
        <title>add todo Page</title>
    </head>
	<body>
	<div class="container">
        	<h1>Enter Todo details</h1>
        	<form:form method="post" modelAttribute="todo">
        	    Description:<form:input type="text" path="description" required="required"/>
        	    <form:input type="hidden" path="id"/>
        	    <form:input type="hidden" path="done"/>
        	    <input type="submit" class="btn btn-success"/>
        	</form:form>
	</div>
	<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.4/jquery.min.js"></script>
	</body>
</html>