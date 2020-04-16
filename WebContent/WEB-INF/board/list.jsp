<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="board.DtoDaoService.BoardDto" %>
<%
List<BoardDto> list = (List<BoardDto>)request.getAttribute("list");
%>

<html>
<head>

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<title>QnA</title>

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


<!-- javascript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnWrite").click(function(){
		if(${loginData.s_email==null}){
			var result = confirm("회원만 쓸 수 있습니다. 글쓰시겠습니까?")
			if(result){location.href="RegistStudent.do";}
			else{ }//취소누르면 이거 else가 실행
		}else{
			location.href="write.do";
		}
	});

	$("#a").on("click",function(){
		("#password").show();
		});

	/* //비밀번호 확인하기 팝업창
	function passwordcheck(e1,e2){
		$.ajax({
		       type : "get",
		       url : "view.do?code=${row.code}",
		       data : "dcode1=" + e2,
		       dataType : "html",
		      success : function(data){

		     var temp = $('#' + el);  //레이어의 id를 temp변수에 저장
		     var bg = temp.prev().hasClass('bg'); //dimmed 레이어를 감지하기 위한 boolean 변수

		     if(bg){
		        $('.layer').fadeIn();
		      }else{
		        temp.fadeIn(); //bg 클래스가 없으면 일반레이어로 실행한다.
		      }

		      // 화면의 중앙에 레이어를 띄운다.
		       if (temp.outerHeight() < $(document).height() ) temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
		       else temp.css('top', '0px');
		       if (temp.outerWidth() < $(document).width() ) temp.css('margin-left', '-'+temp.outerWidth  ()/2+'px');
		       else temp.css('left', '0px');


		      $("#pop-layer").html(data);          

		      },
		       error:function(xhr, status, res){
		       alert(status);
		       }
		     }),


		   temp.find('a.cbtn').click(function(e){
		    if(bg){
		     $('.layer').fadeOut();
		    }else{
		     temp.fadeOut();  //'닫기'버튼을 클릭하면 레이어가 사라진다.
		    }
		    e.preventDefault();
		   });

		  $('.layer .bg').click(function(e){
		    $('.layer').fadeOut();
		    e.preventDefault();
		   });
	
	}*/
}); 

</script>
<style>
.searchModal{
display:none;
psition:fixed;
z-index:10;
left:0;top:0;
width:100%, height:100%;
overflow:auto;
background-color:rgb(0,0,0);
background-color:rgba(0,0,0,0.4);
}
</style>


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
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="LoginStudent.do">로그인하기</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="BoardList.do">문의하기</a></li>
                    </ul>
                </div>
            </div>
        </nav>




<!-- 내용 -->
<!-- Masthead-->
<header class="masthead">
<div class="container">


<!-- 검색 -->
<div class="row-50 h-30 align-items-left justify-content-center text-center">
<form name="form1" method="get" action="BoardList.do">	
	<div class="input-group mt-3 mb-3">
	 <div class="input-group-prepend">
  	  	<select class="form-control" name="searchOption"> <!--  <select class="selectpicker" data-style="btn-primary" style="display: none;" name="searchOption">  -->
	<!-- 검색 조건을 처리후  jstl <cout value="name"></cout> : 변수명넣고 화면에 출력 && 첫번째 피!연산자 ? 두번째 피!연산자 : 세번째 피연산자; -->
		<option value="all" <c:out value="${map.searchOption=='all'?'selected' : ''}"/> >전체검색</option>
		<option value="writer" <c:out value="${map.searchOption=='writer' ? 'selected' : ''}"/> >작성자</option>
		<option value="title" <c:out value="${map.searchOption=='title' ? 'selected' : ''}"/> >제목</option>
		<option value="content" <c:out value="${map.searchOption == 'content' ? 'selected' : '' }"/> >내용</option>
	  </select>
	 </div>
		<input name="keyword" class="form-control" value="${map.keyword}">
		<input type="submit" class="btn btn-success" value="검색">
	 </div>
</form>
</div>

<!-- 글쓰기 버튼-->
<div class="row">
<div class="col-lg-4"></div>
<div class="col-lg-4"></div>
<div class="col-lg-4">	

<button type="submit" id="btnWrite" class="btn btn-outline-warning btn-lg btn-block">글쓰기</button>	

</div>
</div>


<p class="text-white">${map.count}개의 게시물이 있습니다.</p>

<!-- 리스트 -->
<table class="table">
  <thead  class="table table-dark">
    <tr>
      <th scope="col">번호</th>
      <th scope="col">작성자</th>
      <th scope="col">제목</th>
      <th scope="col">작성일</th>
      <th scope="col">조회수</th>
    </tr>
  </thead>

 <c:forEach var="row" items="${map.list}">
  <tbody>
    <tr class="table-secondary">
      <td>${row.code}</td>
      <td>${row.writer}
       <c:if test="${row.recnt >0}">
     		<span style="color:yellow;">(답글 ${row.recnt}개)</span>
       	  </c:if>
      </td>
      <td>
      <!-- password 있으면 -->
      <c:if test="${row.password!=null}">
     <%--<div id="a">${row.title}<!-- "view.do?code=${row.code}?password=${row.password}" --> --%>
    	 <a href="passwordcheck.do?code=${row.code}">${row.title}
          <c:if test="${row.password!=null}">
     	 <span style="color:red;">(비밀글)</span>
     	  </c:if>
    	 </a>
      
      </c:if>
      <!-- password 없으면 -->
      <c:if test="${row.password==null}">
      	<a href="view.do?code=${row.code}" >${row.title}<!-- target="blank" -->
     	  <c:if test="${row.password!=null}">
     	 <span style="color:red;">(비밀글)</span>
     	  </c:if>
        </a>
      </c:if>
      </td>
      <td>${row.reg_datetime}</td>   <%-- <fmt:parseDate value="${BoardDto.reg_datetime}" pattern="yyyy-MM-dd HH:mm:ss"/> --%>
      <td>${row.viewcnt}</td>
    </tr>
  </tbody>
 </c:forEach>

</table>  
   <div id="password" class="searchModal">
    <input type="password" name="password" size="60" value="">
    </div>


<!-- 페이징 --> 
<div>
 <c:if test="${pagingData.curPage ne 1 }">
    <a href="BoardList.do?curPage=1">[처음]</a> 
 </c:if>
 <c:if test="${pagingData.curPage ne 1}">
    <a id= "prev" href="BoardList.do?curPage=${pagingData.prevPage}">[이전]</a> 
 </c:if>
 <c:forEach var="pageNum" begin="${pagingData.startPage }" end="${pagingData.endPage}">
   <c:choose>
        <c:when test="${pageNum eq  pagingData.curPage}">
           <span style="font-weight: bold;"><a href="BoardList.do?curPage=${pageNum}">${pageNum }</a></span> 
        </c:when>
        <c:otherwise>
           <a href="BoardList.do?curPage=${pageNum}">${pageNum}</a> 
        </c:otherwise>
   </c:choose>
 </c:forEach>
 <c:if test="${pagingData.curPage ne pagingData.pageCnt && pagingData.pageCnt > 0}">
    <a href="BoardList.do?curPage=${pagingData.nextPage}">[다음]</a> 
 </c:if>
 <c:if test="${pagingData.curRange ne pagingData.rangeCnt && pagingData.rangeCnt > 0}">
    <a href="BoardList.do?curPage=${pagingData.endPage}" >[끝]</a> 
 </c:if>
</div>
<div>
총 게시글 수 : ${pagingData.listCnt} / 총 페이지 수 : ${pagingData.pageCnt} / 현재 페이지 : ${pagingData.curPage} / 마지막 페이지 : ${pagingData.endPage} / 블록 수 : ${pagingData.rangeCnt} 
</div> 
</div><!-- container 태그 -->

</header>

    
    
    
        
        
         
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