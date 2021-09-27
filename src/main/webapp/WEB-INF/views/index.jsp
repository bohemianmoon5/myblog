<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="layout/header.jsp"%>
<c:choose>
	<c:when test="${empty principal}">
		<div class="container" style="margin: 100px auto;">
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
					<h5>구현 기능들</h5>
					<p>로그인, 로그아웃, 회원가입, 글쓰기, 글 수정, 글 삭제, 목록보기, 페이징처리, 비밀번호 암호화</p>
					<br>
					<h5>개발환경</h5>
					<p></p>
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
					<c:when test="${paging.nowPage == paging.endPage}">
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