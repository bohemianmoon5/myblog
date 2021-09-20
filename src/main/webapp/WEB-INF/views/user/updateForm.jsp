<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin: 200px 570px;">
	<form class="was-validated">
		<div class="form-group">
			<label for="username">Username</label> <input type="text"
				class="form-control" value="${principal.user.username}" id="uname" placeholder="Enter username"
				name="uname" required style="width: 600px;" readonly>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" id="pwd" placeholder="Enter password"
				name="upwd" required style="width: 600px;">
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="email">Email</label> <input type="text"
				class="form-control" value="${principal.user.email}" id="email" placeholder="Enter email"
				name="uemail" required style="width: 600px;">
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
	</form>
	<input type="hidden" id="id" value="${principal.user.id}"/>
	<button id="btn-update" class="btn btn-primary">수정하기</button>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>