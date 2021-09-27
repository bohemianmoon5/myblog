<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin: 130px 570px;">
	<form class="was-validated">
		<div class="form-group">
			<label for="username" style="font-size: large;">Username</label> <input type="text"
				class="form-control" id="uname" placeholder="Enter username"
				name="uname" required style="width: 600px;">
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="password" style="font-size: large;">Password</label> <input type="password"
				class="form-control" id="pwd" placeholder="Enter password"
				name="upwd" required style="width: 600px;">
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="email" style="font-size: large;">Email</label> <input type="text"
				class="form-control" id="email" placeholder="Enter email"
				name="uemail" required style="width: 600px;">
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"> <input
				class="form-check-input" type="checkbox" name="remember" required>
				<span style="font-size: small;">개인정보 이용에 동의하시겠습니까?</span>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Check this checkbox to continue.</div>
			</label>
		</div>
	</form>
	<br>
	<button id="btn-save" class="btn btn-primary">회원가입</button>
	<button id="btn-back" class="btn btn-secondary" onclick="history.back()">돌아가기</button>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>