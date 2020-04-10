<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="board.DtoDaoService.BoardDto" %>
<%@ page import="board.DtoDaoService.ReplyDto" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<c:forEach var="row" items="${list}">
${row.rno}<br>${row.replyer}<br>${row.replytext}
</c:forEach>
<!-- 
<table style="width:700px">
<tbody>
<tr>
<td>

</td>
</tr>

</tbody>
</table>

 -->
 </body>
</html>