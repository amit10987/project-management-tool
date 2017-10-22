$(document).ready(function() {

	$('#saveToDo').click(function() {
		$('#todoForm').submit();
		$('#todoModal').modal('hide');
	});

	$('.todos').each(function(){
		var status = $(this).find('span.status').text();
		if(status === 'COMPLETED'){
			$(this).children('td, th').css('background-color','#b0fccb');
		}else if(status === 'STARTED'){
			$(this).children('td, th').css('background-color','#82c1f2');
		}else if(status === 'NOT_YET_STARTED'){
			$(this).children('td, th').css('background-color','#f7d9c3');
		}else{
			$(this).children('td, th').css('background-color','#fbfce0');
		}
	});
	
	$('.editToDo').click(function() {
		var todoId = $(this).closest('tr').find('span.todoId').text();

		var activityId = $(this).closest('tr').find('span.activityId').text();
		var propertyId = $(this).closest('tr').find('span.propertyId').text();
		var employeeId = $(this).closest('tr').find('span.employeeId').text();
		var stratDate = $(this).closest('tr').find('span.startDate').text();
		var endDate = $(this).closest('tr').find('span.endDate').text();

		$('#todoModalActivityName').val(activityId);
		$('#todoModalPropertyName').val(propertyId);
		$('#todoModalEmployeeFullName').val(employeeId);

		$('#todoModalStartDate').val(stratDate);
		$('#todoModalEndDate').val(endDate);
		$('#todoModalId').val(todoId);

		$('#todoModalLabel').text('Edit ToDo');
		$('#todoModal').modal('show');

	});

	$('.addNewToDo').click(function() {
		$('#todoModalLabel').text('Add ToDo');
		$('#todoModalStartDate').val('');
		$('#todoModalEndDate').val('');
		$('#todoModalId').val('');
		$('#todoModalPropertyName').val('');
		$('#todoModalEmployeeFullName').val('');
		$('#todoModalActivityName').val('');
		$('#todoModal').modal('show');
	});

	$('.datepicker').datepicker({
		format : 'dd/mm/yyyy',
		autoclose : true
	});
})