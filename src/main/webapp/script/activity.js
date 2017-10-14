$(document).ready(function(){
	$("#addNewProjectButtonId").click(function(){
		var markup = "<tr><td></td><td><input type='text'></td><td style='text-align:right;'><input class='btn btn-default' type='button' value='Save' /></td></tr>";
		$("#projectTableBodyId").append(markup);
	});
})