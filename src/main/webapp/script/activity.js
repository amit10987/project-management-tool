$(document).ready(function(){
	$('#saveActivityId').click(function(){
		$('#activityFormId').submit();
		$('#activityModal').modal('hide');
	});
})