<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head><title>회원 등록 폼</title></head>
<body>
	<form:form modelAttribute="memberInfo" >
		<p>
			<label for="name">이름</label>
			<form:input path="name" />
			<form:errors path="name" />
		</p>
		<p>
			<form:label path="password">비밀번호</form:label>
			<form:password path="password" />
			<form:errors path="password" />
		</p>
		<p>
			<form:label path="reCheck">비밀번호 재확인</form:label>
			<form:password path="reCheck"/>
			<form:errors path="reCheck"/>
		</p>
		<p>
			<form:label path="t_email">이메일</form:label>
			<form:input path="t_email" />
			<form:errors path="t_email" />
		</p>
		<p>
			<form:label path="t_phone">전화번호</form:label>
			<form:input path="t_phone" />
			<form:errors path="t_phone" />
		</p>
		<p>
			<input type="submit" value="회원 등록">
		</p>
	</form:form>
</body>
</html>












