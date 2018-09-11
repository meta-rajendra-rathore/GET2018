function validateSignUpForm() {
	return  isNameValid(signup_first_name) && 
			isNameValid(signup_last_name) && 
			isEmailValid(signup_email) && 
			isPasswordValid(signup_password) && 
			isPasswordValid(signup_confirm_password) && 
			isContactValid(signup_contact);
}

function validateSignInForm() {
	return  isEmailValid(signin_email);
}

function validateContactForm() {
	if (    isNameValid(contact_name) && 
			isEmailValid(contact_email) &&
			isContactValid(contact_contact) ) {
				alert("Thank you for the feedback. We got your message.");
				return true;
			} else {
				return false;
			}
}

function resetDefault(id) {
	id.style.border="";
}

function isNameValid(id) {
	if ( !/^[a-zA-Z ]{2,}$/.test(id.value) ) {
		id.style.border="1px solid red";
		id.setCustomValidity("Name should be at least 2 character long with only alphabets!");
		return false;
	} else {
		return true;
	}
}

function isEmailValid(id) {
	if ( !/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(id.value) ) {
		id.style.border="1px solid red";
		id.setCustomValidity("Please enter a valid email!");
		return false;
	} else {
		return true;
	}
}

function isPasswordValid(id) {
	if (id.value.length < 8 ) {
		id.style.border="1px solid red";
		id.setCustomValidity("Password should be at least 8 character long!");
		return false;
	} else {
		return true;
	}
}

function checkPassStrength(id) {
	if (id.value.length == 0 ) {
		document.getElementById("pass_strength").innerHTML="";
	} else if (id.value.length < 8 ) {
		document.getElementById("pass_strength").style.color="red";
		document.getElementById("pass_strength").innerHTML="X";
	} else if(/^[a-zA-Z]{8,}$/.test(id.value) || /^[0-9]{8,}$/.test(id.value)){
		document.getElementById("pass_strength").style.color="red";
		document.getElementById("pass_strength").innerHTML="Weak";
	} else if(/^[a-zA-Z0-9]{8,}$/.test(id.value)){
		document.getElementById("pass_strength").style.color="yellow";
		document.getElementById("pass_strength").innerHTML="Medium";
	} else if(/^[a-zA-Z0-9-!$%^&*()_+|~=`{}[:;<>?,.@#]{8,}$/.test(id.value)){
		document.getElementById("pass_strength").style.color="Green";
		document.getElementById("pass_strength").innerHTML="Awesome";
	}
}

function isConfirmPasswordValid(id) {
	if (id.value.length < 8 ) {
		id.style.border="1px solid red";
		id.setCustomValidity("Invalid password Entry!");
		return false;
	} else if(id.value != document.getElementById("signup_password").value) {
		id.style.border="1px solid red";
		id.setCustomValidity("Password doesn't match!");
		return false;
	} else {
		return true;
	}
}

function isContactValid(id) {
	if (!/^[0-9]{8,}$/.test(id.value)) {
		id.style.border="1px solid red";
		id.setCustomValidity("Contact number should be at least 8 character long and only numberics!");
		return false;
	} else {
		return true;
	}
}