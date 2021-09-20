<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin: 120px 320px;">
	<p class="detail"
		style="width: 100%; text-align: center; font: bolder; font-size: 20px;">상세보기</p>
	<div style="display: flex; justify-content: center;">
		<div class="card" style="width: 700px; height: 400px;">
			<div class="card bg-light" style="height: 400px;">
				<div class="card-body text-center">
					<table class="board_view" style="margin-left: 30px; width: 650px;">
						<colgroup>
							<col width="10%">
							<col width="30%">
							<col width="15%">
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
								<td>${board.createDate}</td>
							</tr>
							<tr>
								<th>내용</th>
								<td colspan="3">
									<div style="margin-top: 15px; padding-left: 40px; text-align: left;">${board.content}</div>
								</td>
							</tr>
						</tbody>
					</table>
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