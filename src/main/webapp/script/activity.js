$(document).ready(function(){
	$('#saveActivity').click(function(){
		$('#activityForm').submit();
		$('#activityModal').modal('hide');
	});
	
	$('.editActivity').click(function(){
		var activityId = $(this).closest('tr').find('span.activityId').text();
		var activityName = $(this).closest('tr').find('span.activityName').text();
		$('#activityModalName').val(activityName);
		$('#activityModalId').val(activityId);
		$('#activityModalLabel').text('Edit Activity');
		$('#activityModal').modal('show');
	});
	
	$('.addNewActivity').click(function(){
		$('#activityModalLabel').text('Add Activity');
		$('#activityModalName').val('');
		$('#activityModalId').val('');
		$('#activityModal').modal('show');
	});
})