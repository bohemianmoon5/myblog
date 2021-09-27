<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<script src="/js/calendar.js" defer></script>
<div id="body">
	<div id='calendar'></div>
</div>
<style>
#body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
<%@ include file="../layout/footer.jsp"%>