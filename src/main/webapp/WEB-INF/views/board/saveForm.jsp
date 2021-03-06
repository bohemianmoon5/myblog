<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin: 100px 380px;">
	<form>
		<div class="form-group">
			<label for="title" style="font-size: large;">Title</label> <input type="text"
				class="form-control" placeholder="Enter title" id="title"
				style="width: 600px;">
		</div>
		<div class="form-group">
			<label for="content" style="font-size: large;">Content</label>
			<textarea class="form-control summernote" rows="5" id="content"
				style="width: 600px;"></textarea>
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">글쓰기</button>
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