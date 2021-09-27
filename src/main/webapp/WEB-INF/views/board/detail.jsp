<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin: 160px 320px;">
	<p class="detail"
		style="width: 100%; text-align: center; font: bolder; font-size: 20px;">상세보기</p>
	<div style="display: flex; justify-content: center;">
		<div class="card" style="width: 700px; height: auto;">
			<div class="card" style="height: auto; background-color: #dfd5c8;">
				<div class="card-body text-center">
					<table class="board_view" id="boardTable" style="margin-left: 30px; width: 590px;">
						<colgroup>
							<col width="18%">
							<col width="30%">
							<col width="18%">
							<col width="*">
						</colgroup>

						<tbody>
							<tr>
								<th>제목</th>
								<td>${board.title}</td>
								<th>조회수</th>
								<td>${board.count}</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${user.username}</td>
								<th>작성시간</th>
								<td><fmt:formatDate value="${board.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
							<tr>
								<th>내용</th>
								<td colspan="3">
									<div style="margin-top: 13px; padding-left: 20px; text-align: left;">${board.content}</div>
								</td>
							</tr>
						</tbody>
					</table>
					<hr>
					<div style="display: flex; justify-content: center;">
						<ul id="reply--box" class="list-group" style="width: 590px;">
							<c:forEach var="reply" items="${replys}">
								<li id="reply--1" class="list-group-item d-flex justify-content-between" style="background-color: #F0ECE3;">
									<div>${reply.content}</div>
									<div class="d-flex">
										<div class="font-italic">작성자 : ${reply.username} &nbsp;</div>
										<c:if test="${reply.userid == principal.user.id}">
											<button onClick="index.replyDelete(${board.id}, ${reply.id})" class="badge">삭제</button>
										</c:if>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
					<br>
					<form>
						<input type="hidden" id="boardId" value="${board.id}"/>
						<div style="display: flex; justify-content: center;">
							<textarea id="reply-content" class="form-control" rows="1" style="width: 590px;"></textarea>
						</div>
						<br>
						<div style="display: flex; justify-content: right; margin-right: 35px;">
							<button type="button" id="btn-reply-save" class="btn btn-primary" style="margin-top: -10px;">댓글 등록</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div style="visibility: hidden;"><span id="id">${board.userid}</span></div>
	<div style="display: flex; justify-content: right; width: 900px; margin-top: -30px;">
		<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		&nbsp;
		<c:if test="${user.id == principal.user.id}">
			<a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
			&nbsp;
			<button id="btn-delete" class="btn btn-danger">삭제</button>
		</c:if>
	</div>
</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>