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

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">


//update함수 시작
$(document).ready(function(){
$("#btnUpdate").click(function(){
	document.location.href="updatedelete.jsp";
});
}); 


//delete.do 실행
$(document).ready(function(){
$("#btnDelete").click(function(){
	document.location.href="updatedelete.jsp";
});
});


//답글달기의 insertLayerList.do 실행
$(document).ready(function(){
$("#btnInsertLayer").click(function(){
 	var title=document.form1.title.value;
	var content=document.form1.content.value;
	var writer=document.form1.writer.value;
	
	var originNo=document.form1.originNo.value;
	var groupOrd=document.form1.groupOrd.value;
	var groupLayer=document.form1.groupLayer.value;
	
	if(writer==""){
		alert("이름을 입력하세요");
		document.form1.writer.focus();
		return;
	}if(title==""){
		alert("제목을 입력하세요");
		document.form1.title.focus();
		return;
	}if(content==""){
		alert("내용을 입력하세요");
		document.form1.content.focus();
		return;
	}
	 
	document.form1.action="insertLayer.do";
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


<!-- header -->
<header class="masthead">
<div class="row h-50 align-items-left justify-content-center text-center">
<div style="width:300px; height:300px; position:absolute; left:50%; top:40%;  margin-left:-150px; margin-top:-150px;">

<h1 class="text-white">게시글보기</h1>

<div> 
<p class="text-white">조회수 : ${BoardDto.viewcnt}
</div>

<div>
<p class="text-white">작성자이름 : ${BoardDto.writer}
</p>
</div>

<div>
<p class="text-white">제목 : ${BoardDto.title}
</p></div>

<div>
<p class="text-white">내용 : ${BoardDto.content}
</p>
</div>


<br><br>
<!-- <div style="width:650px; text-align:center;"> -->


<input type="button" id="btnUpdate"  class="btn btn-info" value="수정"/>
<input type="button" id="btnDelete" class="btn btn-danger" value="삭제"/>

<!-- <button type="submit" id="btnUpdate">수정완료</button> <button type="submit" id="btnDelete">삭제</button> -->

</div>
</div>
</header>







<!-- About section-->
<section class="page-section bg-secondary" id="about">
<div class="row h-30 align-items-left justify-content-center text-center">

<h1>답글달기</h1>
<form name="form1" method="post">

<div>작성자이름 <input name="writer" placeholder="이름을 입력해주세요" value="운영자"> </div>
<div>제목<input name="title" size="80" placeholder="제목을 입력해주세요" value="ㄴ>${BoardDto.title}에 대한 답글"></div>
<div>내용<textarea name="content" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea></div>


<input type="hidden" name="originNo" value="${BoardDto.groupOrd}">
<input type="hidden" name="groupOrd" value="${BoardDto.code+1}">
<input type="hidden" name="groupLayer" value="${BoardDto.groupOrd}">

<br><br><br>

<input type="button" id="btnInsertLayer" class="btn btn-primary" value="답글달기"/> 

</form>

</div>
</section>




















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