<html>
<body>
	<h2>Hello World!</h2>

	<h4>Message from server:  ${message}</h4>

	<h4>This is a test of Spring MVC!</h4>

	<form name="input" action="/assignment1_martily/send" method="get">
		Please supply a message: <input type="text" name="content"> <input
			type="submit" value="Submit">
	</form>
	<p>
		<a href="/assignment1_martily/read">Get last message</a>
	</p>

	<a href="/assignment1_martily/read/all">Read all messages</a>
</body>
</html>
</body>
</html>
