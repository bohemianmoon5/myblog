<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="layout/header.jsp"%>
<c:choose>
	<c:when test="${empty principal}">
		<div class="container" style="margin: 70px auto;">
			<div class="row">
				<div class="col-sm-4">
					<div class="card m-3" style="width: 250px">
						<img class="card-img-top" src="images/MasonNa.jpg"
							alt="Card image">
						<div class="card-body">
							<h4 class="card-title">Mason Na</h4>
							<p class="card-text">
								Hi~ I'm Mason.<br>This is my blog.
							</p>
							<a href="#" class="btn btn-primary">See Profile</a>
						</div>
					</div>
				</div>
				<div class="col-sm-8" style="margin: 30px 0px;">
					<h2>SpringBoot 게시판 만들기</h2>
					<br>
					<h4>구현 기능들</h4>
					<p style="font-size: 19px;">User : 로그인, 로그아웃, 회원가입, 회원정보 (스프링 시큐리티, 카카오 로그인, 비밀번호 암호화)<br>
					Board : 글쓰기, 글 수정, 글 삭제, 페이징<br>
					Reply : 댓글 쓰기, 댓글 삭제<br>
					기타 : 캘린더 (Fullcalendar + 구글 캘린더), 오전/오후(Emoji)
						</p>
					<br>
					<h4>개발환경</h4>
					<p style="font-size: 19px;">Platform : macOS Big Sur, i5, 8G<br>
					Language : Java 8<br>
					Web : JSP, JS, jQuery<br>
					Server : Apache Tomcat 9.0<br>
					Framework : Spring Framework 2.5<br>
					Library : FullCalendar v5.9.0, Bootstrap 4, Summernote 0.8.18<br>
					Database : Oracle 11g<br>
					VCS : Git</p>
				</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="container" style="margin: 140px 320px;">
			<div class="row">
				<c:forEach var="board" items="${boards}">
					<div class="col-lg-4">
						<div class="card"
							style="height: 180px; margin: 10px 0px; background-color: #e9e2da;">
							<div class="card-body text-center">
								<p class="card-text">${board.title}</p>
								<br> <br> <a href="/board/${board.id}"
									class="btn btn-info">See Detail</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<br>
			<ul class="pagination justify-content-center">
				<c:choose>
					<c:when test="${paging.nowPage == paging.startPage}">
						<li class="page-item disabled"><a class="page-link"
							href="?nowPage=${paging.nowPage - 1}">Previous</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="?nowPage=${paging.nowPage - 1}">Previous</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${paging.nowPage == paging.endPage || paging.total == 0}">
						<li class="page-item disabled"><a class="page-link"
							href="?nowPage=${paging.nowPage + 1}">Next</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="?nowPage=${paging.nowPage + 1}">Next</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</c:otherwise>
</c:choose>
<%@ include file="layout/footer.jsp"%>