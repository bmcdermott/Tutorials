function go(url)
{
    window.location = url;
}

function deleteProduct(url)
{
    var isOK = confirm("Are you sure you want to delete?");
    if(isOK)
    {
        go(url);
    }
}

//JQuery UI 
$( "#dialog" ).dialog({
	autoOpen: false,
	width: 400,
	buttons: [
		{
			text: "Ok",
			click: function() {
				var aForm = $(this).data('callingForm'); 
				aForm.submit();

			}
		},
		{
			text: "Cancel",
			click: function() {
				$( this ).dialog( "close" );
			}
		}
	]
});

// Link to open the dialog
$( ".dialog-link" ).click(function( event ) {
	$( "#dialog" )
	.data('callingForm', $(this))
	.dialog( "open" );
	
	event.preventDefault();
});



// Hover states on the static widgets
$( "#dialog-link, #icons li" ).hover(
	function() {
		$( this ).addClass( "ui-state-hover" );
	},
	function() {
		$( this ).removeClass( "ui-state-hover" );
	}
);