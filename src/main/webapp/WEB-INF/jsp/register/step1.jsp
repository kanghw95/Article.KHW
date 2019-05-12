<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>-->
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath}/" />
<title>게시글 조회</title>
</head>
	<table>
		<thead>
			<tr>
			    <td>글번호</td>
				<td>제목</td>
				<td>이름</td>
				<td>글내용</td>
				<td>날짜</td>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${article.articleId}</td>
					<td>${article.title}</td>
					<td>${article.name}</td>
					<td>${article.content}</td>
					<td>${article.udate}</td> 
				</tr>
		</tbody>
	</table>
	<form action="./app/main" method="post">
		<button type="submit">초기화면</button>
	</form>

</body>
</html>