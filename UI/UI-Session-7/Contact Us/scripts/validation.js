window.addEventListener('load', init);

function init() {
	first_name_element = document.getElementsByName("first_name")[0];
	last_name_element = document.getElementsByName("last_name")[0];
	email_element = document.getElementsByName("email")[0];
	phone_number_element = document.getElementsByName("phone_number")[0];
	state_element = document.getElementsByName("state")[0];
	
	first_name_element.addEventListener('change', restoreDefaults);
	last_name_element.addEventListener('change', restoreDefaults);
	email_element.addEventListener('change', restoreDefaults);
	phone_number_element.addEventListener('change', restoreDefaults);
	state_element.addEventListener('change', restoreDefaults);
} 

function restoreDefaults(event) {
	event.target.setCustomValidity("");
}

function validateForm() {
	debugger;
	errorList = [];
	isFormValid = true;

	zipcode_element = document.getElementsByName("zipcode")[0];
	website_element = document.getElementsByName("website")[0];
	hosting_available_element = document.getElementsByName("hosting_available")[0];
	project_desc_element = document.getElementsByName("project_desc")[0];

	if (typeof(element) != 'undefined') {
		zipcode_element.addEventListener('focus', restoreDefaults);
	}
	if (typeof(element) != 'undefined') {
		website_element.addEventListener('focus', restoreDefaults);
	}
	if (typeof(element) != 'undefined') {
		hosting_available_element.addEventListener('focus', restoreDefaults);
	}
	if (typeof(element) != 'undefined') {
		project_desc_element.addEventListener('focus', restoreDefaults);
	}

	isNameValid(first_name_element);
	isNameValid(last_name_element);
	isEmailValid(email_element);
	isContactValid(phone_number_element);			
	isStateValid(state_element);
	isZipcodeValid(zipcode_element);
	isWebsiteValid(website_element);
	isProjectDescValid(project_desc_element);

	if(!isFormValid) {
		var alertMessage = "";
		for(index = 0; index < errorList.length; index++) {
			alertMessage += errorList[index]["label"] + " : " + errorList[index]["errorMessage"] + "\n";
		}
		alert(alertMessage);
	} else {
		getFeedbackDetail();
	}

	return isFormValid;
}

function isNameValid(element) {
	var nameLabel = "";
	if (element == first_name_element) {
		nameLabel = "First name"
	} else {
		nameLabel = "Last name";
	}
	if ( !/^[a-zA-Z ]{2,}$/.test(element.value) ) {
		errorList.push({ 
			label : nameLabel,
			errorMessage : nameLabel + " is invalid."
		});
		element.setCustomValidity("Name should be at least 2 character long with only alphabets!");
		isFormValid = false;
	}
}

function isEmailValid(element) {
	if ( !/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(element.value) ) {
		errorList.push({ 
			label : "Email",
			errorMessage : "Please enter a valid email."
		});
		element.setCustomValidity("Please enter a valid email!");
		isFormValid = false;
	}
}

function isContactValid(element) {
	if (!/^[0-9]{8,12}$/.test(element.value)) {
		errorList.push({ 
			label : "Phone Number",
			errorMessage : "Phone number is invalid."
		});
		element.setCustomValidity("Phone number should be at least 8 character long and only numberics!");
		isFormValid = false;
	}
}

function isStateValid(element) {
	if(element.value == "")	{
		errorList.push({ 
			label : "State",
			errorMessage : "Please select state."
		});
		element.setCustomValidity("Please select state!");
		isFormValid = false;
	}
}

function isZipcodeValid(element) {
	if (typeof(element) != 'undefined') {
		if (!/^[0-9]{6}$/.test(element.value)) {
			errorList.push({ 
				label : "Zipcode",
				errorMessage : "Please enter zipcode."
			});
			element.setCustomValidity("Please enter zipcode!");
			isFormValid = false;
		}
	} 
}

function isWebsiteValid(element) {
	if (typeof(element) != 'undefined') {
		if ( !/^[0-9A-z]+(\.[A-z]{2,3})+$/.test(element.value)) {
			errorList.push({ 
				label : "Website",
				errorMessage : "Please enter your website or domain."
			});
			element.setCustomValidity("Please enter your website or domain!");
			isFormValid = false;
		}
	} 
}

function isProjectDescValid(element) {
	if (typeof(element) != 'undefined') {
		if(element.value == "")	{
			errorList.push({ 
				label : "Project Description",
				errorMessage : "Please enter project description."
			});
			element.setCustomValidity("Please enter project description!");
			isFormValid = false;
		}
	}
}

function getFeedbackDetail() {
	var formData = [];
	var form = document.getElementById("form");
	for (var i = 0; i < form.elements.length; i++) {
		if(form.elements[i].type == 'radio' && form.elements[i].checked == false) {
			continue;
		}
		formData.push({
			label : getLabelName(form.elements[i].name),
			value : form.elements[i].value
		});
	}
	localStorage.setItem("form_data", JSON.stringify(formData));
}

function getLabelName(elementName) {
	switch(elementName) {
		case 'first_name' : return 'First Name';
		case 'last_name' : return 'Last Name';
		case 'email' : return 'Email';
		case 'phone_number' : return 'Phone Number #';
		case 'address' : return 'Address';
		case 'city' : return 'City';
		case 'state' : return 'State';
		case 'zipcode' : return 'Zip Code';
		case 'address' : return 'Address';
		case 'website' : return 'Website or Domain name';
		case 'hosting_available' : return 'Hosting Availability';
		case 'project_desc' : return 'Project Description';
		default : return 'Other';
	}
}