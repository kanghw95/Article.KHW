<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시글</title>
</head>
<body>
	<h2>게시글 작성</h2>
	<form action="./app/register/step3" method="post">
		<p>
			글 :<br> <input type="text" name="title" value="${param.title}">
		</p>
		<p>
			내용 :<br> <input type="text" name="content" value="${param.content}">
		</p>
	
		<button type="submit">작성완료</button>
	</form>
</body>
</html>