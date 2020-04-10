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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script type="text/javascript">

//updatedelete.jsp로 넘어가는 것
$(document).ready(function(){
  $("#btnUpdate").click(function(){
	var code=document.form1.code.value;
	document.form1.action="updatepath.do";
	document.form1.submit();
  });



//delete.do 실행
/* $(document).ready(function(){ */
  $("#btnDelete").click(function(){
   if(confirm("삭제하시겠습니까?")){
   document.form1.action="delete.do";
   document.form1.submit();
   }
  });

/* 
//답글달기의 restcontroller 방식 : replylist.do 실행
$(document).ready(function(){
$("#btnReply").click(function(){
    var replytext=$("#replytext").val();
    var code="${BoardDto.code}";
    var param="replytext="+replytext+"&code="+code;

    if(replytext=""){
        alert("댓글을 입력하세요");
    }

    $.ajax({
        type:"post",
        url:"replyinsert.do",
        data:param,
        success:function(){
            alert("댓글이 등록되었습니다.");
            listReply2();
            }
});
});
 
 */

//restController 방식(Json)
//댓글목록
/* $(document).ready(function(){ */
	listReply2();
});

  function listReply2(){
  	  $.ajax({
      	  type:"get",
      	  url:"replylist.do?code=${BoardDto.code}",
      	  success:function(result){
//          	  consol.log(result);
              var output = '<table class="table table-dark table-hover">';
              output += '<thead><tr>';
              output += "<th>번호</th><th>댓글 작성자</th><th>댓글내용</th><th>댓글쓴날짜</th>";
              output += "</tr></thead>";
              for(var i in result){
            	  output += "<tbody><tr>";
            	  output += "<td>"+result[i].rno+"</td>";
                  output += "<td>"+result[i].replyer+"</td>";
                  output += "<td>"+result[i].replytext+"</td>";
                  output += "<td>"+changeDate(result[i].reg_datetime);
            	  output += "</tr></tbody>";
                  }
              output += "</table>";
              
              $("#listReply").html(output);
           }
       });
  }

  
  function changeDate(date){
	  date=new Date(parseInt(date));
	  year = date.getFullYear();
	  month = date.getMonth();
	  day=date.getDate();
	  hour = date.getHours();
	  minute=date.getMinutes();
	  second=date.getSeconds();
	  strDate=year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
	  return strDate;
  }


  /* 
  //댓글 list controller방식
  $(document).ready(function(){
  	listReply();
  });
   
  function listReply(){

  	    $.ajax({
          	 type:"get"
          	 ,url:"replylist.do?code=2"
          	 ,dataType:"json" 	 
          	 ,success:function(result){
              	 //responseText가 result에 저장됨.
              	 $("#listReply").text(result);
          	 }
       });  
    //  $("#listReply").load("");
       
  }

   */

	  
 
 
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
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#about">댓글보기</a></li>
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

<h1 class="text-white">QnA보기</h1>

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
<input type="hidden" name="code" value="${BoardDto.code}">

<br><br>
<!-- <div style="width:650px; text-align:center;"> -->

<form name=form1>
<input type="hidden" name="code" value="${BoardDto.code}">
</form>

<c:if test="${loginData.s_email!=null}">
<input type="button" id="btnUpdate"  class="btn btn-info" value="수정"/>
<input type="button" id="btnDelete" class="btn btn-danger" value="삭제"/>
</c:if>
<!-- input type="button"은 이렇게도 쓰일 수 있다
<button type="submit" id="btnUpdate">수정완료</button> 
<button type="submit" id="btnDelete">삭제</button> -->

</div>
</div>
</header>
${BoardDto.code}번째 게시물이며 
<c:if test="${loginData.s_email!=null}">${loginData.name}님이 로그인하셨습니다.</c:if>
<c:if test="${loginData.s_email==null}">비회원입니다.</c:if>


<!-- About section--><!-- 댓글 section -->
<section class="page-section bg-Warning" id="about">
<div class="container">

<div class="row h-30 align-items-left justify-content-center text-center">
<div style="width:650px; text-align:center;">

<!-- 로그인안하면 이런 창이 보이게 -->
<c:if test="${loginData.s_email==null}">
<h2>로그인을 해야 더하고 싶은 말을 <br>댓글로 남길 수 있습니다.</h2>
</c:if>

<!-- 로그인한 회원만 댓글 작성폼이 보이게 처리 -->
<c:if test="${loginData.s_email!=null}">
<h2>더하고 싶은 말을 댓글을 남겨주세요.</h2><!-- class="text-white" -->
<textarea rows="5" cols="90" name=replytext" placeholder="ex) 결제창이 안열려요. 결제방식을 무통장입금으로 하고 싶어요 등"></textarea><br>
<button type="button" id="btnReply" class="btn btn-primary btn-block">댓글작성</button><br><br>
</c:if>

</div>
</div>




<c:if test="${loginData.s_email!=null}">
<div id="listReply"></div>
</c:if>




</div><!-- <----container db -->
</section>







<%--이건 없어질 코든데 걍 아까워서 남겨놓음 
<h1>계층형 게시물달기</h1>
<form name="form1" method="post">

<div>작성자이름 <input name="writer" placeholder="이름을 입력해주세요" value="운영자"> </div>
<div>제목<input name="title" size="80" placeholder="제목을 입력해주세요" value="ㄴ>${BoardDto.title}에 대한 답글"></div>
<div>내용<textarea name="content" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea></div>

 --%>
<%-- <input type="hidden" name="originNo" value="${BoardDto.groupOrd}">
<input type="hidden" name="groupOrd" value="${BoardDto.code+1}">
<input type="hidden" name="groupLayer" value="${BoardDto.groupOrd}">
 --%>


<!-- <input type="button" id="btnInsertLayer" class="btn btn-primary" value="답글달기"/> 
 -->




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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>       
</body>
</html>