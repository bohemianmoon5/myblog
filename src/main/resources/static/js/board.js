let index = {
	init: function() {
		$("#btn-save").on("click",()=>{
			this.save();
		});
		$("#btn-delete").on("click",()=>{
			this.deleteById();
		});
		$("#btn-update").on("click",()=>{
			this.update();
		});
	},
	
	save: function() {
		//alert('user의 insert함수 호출됨');
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};
		//console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
		}).done(function(resp){
			let obj = Object.values(resp);
			if(obj[0] == 500) {
				alert("글쓰기 실패!");
				//alert(JSON.stringify(resp));
			}else {
				alert("글쓰기 성공!");
				location.href="/";
			}
			console.log(obj);
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	deleteById: function() {
		let id = $("#id").text();
		$.ajax({
			type: "DELETE",
			url: "/api/board/"+id,
			dataType: "json"
		}).done(function(resp){
			alert("삭제 완료!!");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	update: function() {
		let id = $("#id").val();
		
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};
		
		$.ajax({
			type: "PUT",
			url: "/api/board/"+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
		}).done(function(resp){
			alert("수정 완료!!");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
}

index.init();