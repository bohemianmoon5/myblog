<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin: 240px 570px;">
	<form action="/auth/loginProc" method="POST">
		<div class="form-group">
			<label for="email">Username</label> 
			<input type="username" name="username" class="form-control" placeholder="Enter username" id="username" style="width: 600px;">
		</div>
		<div class="form-group">
			<label for="pwd">Password</label> 
			<input type="password" name="password" class="form-control" placeholder="Enter password" id="password" style="width: 600px;">
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"> 
			<input name="remember" class="form-check-input" type="checkbox"> Remember me
			</label>
		</div>
		<button id="btn-login" class="btn btn-primary">로그인</button>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=30c061b6dc1027d8348c07e998a3504c&redirect_uri=http://localhost:9999/auth/kakao/callback&response_type=code"><img height="40.5px" src="/images/kakao_login_button.png"/></a>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>