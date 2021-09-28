let index = {
	init: function() {
		$("#btn-save").on("click",()=>{
			this.save();
		});
		$("#btn-update").on("click",()=>{
			this.update();
		});
		/*
		$("#btn-login").on("click",()=>{
			this.login();
		});
		*/
	},
	
	save: function() {
		//alert('user의 insert함수 호출됨');
		let data = {
			username: $("#uname").val(),
			password: $("#pwd").val(),
			email: $("#email").val()
		};
		//console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
		}).done(function(resp){
			let obj = Object.values(resp);
			if(obj[1] == -1) {
				alert("회원가입 실패!");
				//alert(JSON.stringify(resp));
			}else {
				alert("회원가입 성공!");
				location.href="/";
			}
			console.log(Object.values(resp));
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	update: function() {
		let data = {
			id: $("#id").val(),
			username: $("#uname").val(),
			password: $("#pwd").val(),
			email: $("#email").val()
		};
		
		$.ajax({
			type: "PUT",
			url: "/user",
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
		}).done(function(resp){
			let obj = Object.values(resp);
			if(obj[0] == 500) {
				alert("수정 실패!");
			}else {
				alert("수정 완료!!");
				location.href="/";
			}
			console.log(resp);
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
	/*
	login: function() {
		//alert('user의 selectById함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
		};
		//console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/api/user/login",
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
		}).done(function(resp){
			let obj = Object.values(resp);
			if(obj[0] == 500) {
				alert("로그인 실패!");
				//alert(JSON.stringify(resp));
			}else {
				alert("로그인 성공!");
				location.href="/";
			}
			console.log(Object.values(resp));
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
	*/
}

index.init();