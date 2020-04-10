<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="board.DtoDaoService.BoardDto" %>

<html lang="en">
<title>QnA</title>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Gugi&display=swap&subset=korean" rel="stylesheet">
<!-- Third party plugin CSS-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnSave").click(function(){
		var writer=document.form1.writer.value;
		
		var title=document.form1.title.value;
		var content=document.form1.content.value;	
		/* var emailcheck=document.form1.emailcheck.value;	 */
		
		if(writer==""){
			alert("이름을 입력하세요");
			document.form1.writer.focus();
			return false;
		}/* else if(email==emailcheck){ //email.equals(emailcheck)
			alert("회원가입한 이메일입니다");
			document.form1.email.focus();
			return false;
		} */ else if(title==""){
			alert("제목을 입력하세요");
			document.form1.title.focus();
			return false;
		}else if(content==""){
			alert("내용을 입력하세요");
			document.form1.content.focus();
			return false;
		}
		
		//폼에 입력한 데이터를 서버로 전송한다
		document.form1.submit(); 
		});

	
});
</script>
</head>


<body id="page-top">

 <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="http://localhost:8082/Matching/index.jsp">MatchingService</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto my-2 my-lg-0">
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#about">About</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#services">Services</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="insert.do">로그인하기</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="BoardList.do">문의하기</a></li>
                    </ul>
                </div>
            </div>
        </nav>


<%-- <%@ include file="" %> --%>

<!-- Masthead-->
<header class="masthead">
<div class="container">

<%-- <!-- 회원 -->
<c:if test="${loginData.s_email!=null}"> --%>

<div class="layer" style="position:absolute; width:100%; height:100%; top:30%; left:30%; right:30%">  <!-- <div class="col-md-12 text-center"> 중앙정렬-->
<form name="form1" method="post" action="insert.do">

<h1 class="text-white">QnA질문하기</h1>

<div class="text-white">작성자이름 <h2>${loginData.name}</h2>  <input type="hidden" name="writer" value="${loginData.name}"> </div>
<div class="text-white">제목<input name="title" size="80" placeholder="제목을 입력해주세요"></div>
<div class="text-white">내용<textarea name="content" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea></div>

<button type="button" id="btnSave" class="btn btn-secondary btn-lg">확인</button>
<button type="reset" class="btn btn-outline-danger" >처음부터 삭제하고 다시 쓰기</button><br><br><br>

</form>
</div>
<%-- </c:if> --%>

</div>
</header>

<%-- 
<!-- 비회원 -->
<c:if test="${loginData.s_email==null}">
<div class="layer" style="position:absolute; width:100%; height:100%; top:30%; left:30%; right:30%">  <!-- <div class="col-md-12 text-center"> 중앙정렬-->
<form name="form1" method="post" action="insert.do">

<h1 class="text-white">QnA질문하기</h1>

<div class="text-white">작성자이름 <input name="writer" placeholder="이름을 입력해주세요"> </div>
<div class="text-white">email<input name="email" placeholder="이메일을 입력해주세요"> </div>

<c:forEach var="row" items="${check}">
<input type="hidden" name="emailcheck" value="${row.s_email}">
</c:forEach>

<div class="text-white">제목<input name="title" size="80" placeholder="제목을 입력해주세요"></div>
<div class="text-white">내용<textarea name="content" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea></div>



<button type="button" id="btnSave" class="btn btn-secondary btn-lg">확인</button>
<button type="reset" class="btn btn-outline-danger">처음부터 삭제하고 다시 쓰기</button><br><br><br>

</form>
</div>

</c:if>

</div>
</header>

 --%>




<!-- Footer-->
 <footer class="bg-light py-5">
  <div class="container"><div class="small text-center text-muted">
   Copyright © 2020 - Start Bootstrap
  </div></div>
 </footer>
        
        
<!-- Bootstrap core JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<!-- Third party plugin JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
        

<!-- 기본 부트스트랩 get started -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>       

</body>
</html>