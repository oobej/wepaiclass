<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
</head>
<body>
<form method="post">
<label>제목</label>
${view.title}<hr />

<label>작성자</label>
${view.writer}<hr />

<label>내용</label>
${view.content}

<div>
<a href="/board/modify?bno=${view.bno}">게시물 수정</a>
<a href="/board/delete?bno=${view.bno}">게시물 삭제</a>
</div>

<button type="submit">작성</button></form>
</body>
</html>