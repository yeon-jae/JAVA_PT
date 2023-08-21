<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet" >
        <title>List todo Pages</title>
    </head>
	<body>
	<div class="container">
	    <div>
        	<h1>Your Todos</h1>
        			<table class="table">
        				<thead>
        					<tr>
        						<th>id</th>
        						<th>Description</th>
        						<th>Target Date</th>
        						<th>Is Done?</th>
        						<th></th>
        					</tr>
        				</thead>
        				<tbody>
        					<c:forEach items="${todos}" var="todo">
        						<tr>
        							<td>${todo.id}</td>
        							<td>${todo.description}</td>
        							<td>${todo.targetDate}</td>
        							<td>${todo.done}</td>
        							<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
        						</tr>
        					</c:forEach>
        				</tbody>
        			</table>
        			<a href="add-todo" class="btn btn-success">Add Todo</a>
        		</div>

	</div>
	<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.4/jquery.min.js"></script>
	</body>
</html>