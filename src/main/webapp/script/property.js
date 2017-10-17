$(document).ready(function(){
	$('#saveProperty').click(function(){
		$('#propertyForm').submit();
		$('#propertyModal').modal('hide');
	});
	
	$('.editProperty').click(function(){
		var propertyId = $(this).closest('tr').find('span.propertyId').text();
		var propertyName = $(this).closest('tr').find('span.propertyName').text();
		$('#propertyModalName').val(propertyName);
		$('#propertyModalId').val(propertyId);
		$('#propertyModalLabel').text('Edit Property');
		$('#propertyModal').modal('show');
	});
	
	$('.addNewProperty').click(function(){
		$('#propertyModalLabel').text('Add Property');
		$('#propertyModalName').val('');
		$('#propertyModalId').val('');
		$('#propertyModal').modal('show');
	});
})