jQuery(document).ready(function(){
		$("#editComputer").validate({
		                rules: {
		                    "computerName" : {
		                    	required:true
		                    },
		                    "introducedDate" : {
		                    	required:true
		                    },
		                    "discontinuedDate" : {
		                    	required:true
		                    }
		                },
		                messages: {
		                    computerName: "Please enter the computer name",
		                    introducedDate: "Please enter the introduced date",
		                    discontinuedDate:"Please enter the discontinued date"
		                },
		                submitHandler: function(form) {
		                    form.submit();
		                }
		            });

});