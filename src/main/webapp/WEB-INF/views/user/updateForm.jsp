<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin: 240px 570px;">
	<form class="was-validated">
		<div class="form-group">
			<label for="username" style="font-size: large;">Username</label> <input
				type="text" class="form-control" value="${principal.user.username}"
				id="uname" placeholder="Enter username" name="uname" required
				style="width: 600px;" readonly>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<c:if test="${principal.user.oauth == null}">
			<div class="form-group">
				<label for="password" style="font-size: large;">Password</label> <input
					type="password" class="form-control" id="pwd"
					placeholder="Enter password" name="upwd" required
					style="width: 600px;">
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
		</c:if>
		<c:choose>
			<c:when test="${principal.user.oauth == null}">
				<div class="form-group">
					<label for="email" style="font-size: large;">Email</label> <input
						type="text" class="form-control" value="${principal.user.email}"
						id="email" placeholder="Enter email" name="uemail" required
						style="width: 600px;">
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="form-group">
					<label for="email" style="font-size: large;">Email</label> <input
						type="text" class="form-control" value="${principal.user.email}"
						placeholder="Enter email" name="uemail" required
						style="width: 600px;" readonly>
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
			</c:otherwise>
		</c:choose>

	</form>
	<input type="hidden" id="id" value="${principal.user.id}" />
	<c:choose>
		<c:when test="${principal.user.oauth == null}">
			<br>
			<button id="btn-update" class="btn btn-primary">수정하기</button>
			<button id="btn-back" class="btn btn-secondary"
				onclick="history.back()">돌아가기</button>
		</c:when>
		<c:otherwise>
			<br>
			<button id="btn-back" class="btn btn-primary"
				onclick="history.back()">돌아가기</button>
		</c:otherwise>
	</c:choose>

</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>