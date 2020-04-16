<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="admin.Dao.StudentDto" %>
<%
List<StudentDto> list = (List<StudentDto>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function()
{
	$("#ExcelExport").click(function()
			{
		location.href="StudentExport.do";
		})
});

function deleteStudent(s_num)
{if(confirm("삭제?"))
	{
	location.href="StudentDelete.do?s_num="+s_num;
	}
	
}

</script>
<title>Insert title here</title>
</head>
<body>
	<table class="table">
  <thead  class="table table-dark">
    <tr>
      <th scope="col">회원 번호</th>
      <th scope="col">이름</th>
      <th scope="col">이메일</th>
      <th scope="col">핸드폰 번호</th>
    </tr>
  </thead>
<c:forEach var="StudentDto" items="${list}">
 <tbody>
    <tr class="table-secondary">
      <td>${StudentDto.s_num}</td>
      <td>${StudentDto.name}</td>
      <td>${StudentDto.s_email}</td>
      <td>${StudentDto.s_phone}</td>
      <td><input type = "button" id = "delete" onclick = "deleteStudent(${StudentDto.s_num})" value = "삭제"><td/>
    </tr>
 </tbody>
</c:forEach>
  </table>
  
  <input type = "submit" id = "ExcelExport" value = "Exel파일로 뽑기">
</body>
</html>