//Fonction permettant de faire la v�rification et de l'afficher au client

function verification(){
		var name = document.getElementById("nameRequired");
		var dateI = document.getElementById("dateInitRequired");
		var dateD = document.getElementById("dateDiscRequired");
		
		if(name.innerHTML.trim)
		name.innerHTML = "";
		dateI.innerHTML = "";
		dateD.innerHTML = "";
	
	}

//fonction qui renvoie true si l'entr�e n'est pas vide
function isNotEmpty(id, messageError) {
   var input = document.getElementById(id);
   var error = document.getElementById(id + "required");
   var inputValue = input.value.trim();
   var isVerified = (inputValue.length != 0);  // boolean
   showErrorMessage(isVerified, input, messageError, error);
   return isVerified;
}