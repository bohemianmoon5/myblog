<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin: 100px 380px;">
	<form>
		<input type="hidden" id="id" value="${board.id}"/>
		<div class="form-group">
			<label for="title">Title</label> <input value="${board.title}" type="text"
				class="form-control" placeholder="Enter title" id="title"
				style="width: 600px;">
		</div>
		<div class="form-group">
			<label for="content">Content</label>
			<textarea class="form-control summernote" rows="5" id="content"
				style="width: 600px;">${board.content}</textarea>
		</div>
	</form>
	<button id="btn-update" class="btn btn-primary">수정하기</button>
	<button id="btn-back" class="btn btn-secondary" onclick="history.back()">돌아가기</button>
</div>

<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>