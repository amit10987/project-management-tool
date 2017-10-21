$(document).ready(function(){
	$('#saveToDo').click(function(){
		$('#todoForm').submit();
		$('#todoModal').modal('hide');
	});
	
	$('.editToDo').click(function(){
		var todoId = $(this).closest('tr').find('span.todoId').text();
		
		var activityId = $(this).closest('tr').find('span.activityId').text();
		var propertyId = $(this).closest('tr').find('span.propertyId').text();
		var employeeId = $(this).closest('tr').find('span.employeeId').text();
		var stratDate = $(this).closest('tr').find('span.startDate').text();
		var endDate = $(this).closest('tr').find('span.endDate').text();
		var statusId = $(this).closest('tr').find('span.statusId').text();
		
		$('#todoModalActivityName').val(activityId);
		$('#todoModalPropertyName').val(propertyId);
		$('#todoModalEmployeeFullName').val(employeeId);
		
		$('#todoModalStartDate').val(stratDate);
		$('#todoModalEndDate').val(endDate);
		$('#todoModalStatus').val(statusId);
		
		$('#todoModalLabel').text('Edit ToDo');
		$('#todoModal').modal('show');
		
	});
	
	$('.addNewToDo').click(function(){
		$('#todoModalLabel').text('Add ToDo');
		$('#todoModalStartDate').val('');
		$('#todoModalEndDate').val('');
		$('#todoModalId').val('');
		$('#todoModal').modal('show');
	});
	
	$('.datepicker').datepicker({
	    format: 'dd/mm/yyyy',
	    autoclose : true
	});
})