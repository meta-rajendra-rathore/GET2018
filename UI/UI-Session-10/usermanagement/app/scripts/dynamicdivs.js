window.addEventListener('load', loadStateChange);

function loadStateChange() {
	document.getElementsByName("state")[0].addEventListener('change', createFieldsForState);
}

function restoreDefaults(event) {
	event.target.setCustomValidity("");
}

function createFieldsForState(event) {
	var elements = document.getElementsByClassName("dynamic_block");
    while(elements.length > 0){
        elements[0].parentNode.removeChild(elements[0]);
    }

	if (document.getElementsByName("state")[0].value == "Rajasthan") {
		createWebsiteRow();
		createProjectDescRow();
	} else if (document.getElementsByName("state")[0].value == "Haryana") {
		createZipcodeRow();
		createHostingRow();
	} else if (document.getElementsByName("state")[0].value == "Maharashtra") {
		createZipcodeRow();
		createProjectDescRow();
	}
}

function createWebsiteRow() {
	var website_row = document.createElement("div");
	website_row.setAttribute("id", "website_row");
	website_row.setAttribute("class", "dynamic_block");
	var label_website = document.createElement("label");
	var website = document.createTextNode("Website or Domain name");
	var icon_div = document.createElement("div");
	var icon = document.createElement("i");
	icon.setAttribute("class", "fa fa-home icon");
	var input_website = document.createElement("input");
	input_website.setAttribute("type", "text");
	input_website.setAttribute("name", "website");
	input_website.setAttribute("class", "entries");
	input_website.setAttribute("placeholder", "Website or Domain name");

	label_website.appendChild(website);
	icon_div.appendChild(icon);

	website_row.appendChild(label_website);
	website_row.appendChild(icon_div);
	website_row.appendChild(input_website);

	document.getElementById("form").insertBefore(website_row, document.getElementById("submit_row"));
	website_element = document.getElementsByName("website")[0];
	website_element.addEventListener('change', restoreDefaults);
} 

function createProjectDescRow() {
	var project_desc_row = document.createElement("div");
	project_desc_row.setAttribute("id", "project_desc_row");
	project_desc_row.setAttribute("class", "dynamic_block");
	var label_project_desc = document.createElement("label");
	var project_desc = document.createTextNode("Project Description");
	var icon_div = document.createElement("div");
	var icon = document.createElement("i");
	icon.setAttribute("class", "fa fa-pen icon");
	var input_project_desc = document.createElement("textarea");
	input_project_desc.setAttribute("type", "text");
	input_project_desc.setAttribute("name", "project_desc");
	input_project_desc.setAttribute("class", "entries");
	input_project_desc.setAttribute("rows", 3);
	input_project_desc.setAttribute("placeholder", "Project Description");

	label_project_desc.appendChild(project_desc);
	icon_div.appendChild(icon);

	project_desc_row.appendChild(label_project_desc);
	project_desc_row.appendChild(icon_div);
	project_desc_row.appendChild(input_project_desc);

	document.getElementById("form").insertBefore(project_desc_row, document.getElementById("submit_row"));
	project_desc_element = document.getElementsByName("project_desc")[0];
	project_desc_element.addEventListener('change', restoreDefaults);
}

function createZipcodeRow() {
	var zipcode_row = document.createElement("div");
	zipcode_row.setAttribute("id", "zipcode_row");
	zipcode_row.setAttribute("class", "dynamic_block");
	var label_zipcode = document.createElement("label");
	var zipcode = document.createTextNode("Zip Code");
	var icon_div = document.createElement("div");
	var icon = document.createElement("i");
	icon.setAttribute("class", "fa fa-home icon");
	var input_zipcode = document.createElement("input");
	input_zipcode.setAttribute("type", "text");
	input_zipcode.setAttribute("name", "zipcode");
	input_zipcode.setAttribute("class", "entries");
	input_zipcode.setAttribute("placeholder", "Zip Code");

	label_zipcode.appendChild(zipcode);
	icon_div.appendChild(icon);

	zipcode_row.appendChild(label_zipcode);
	zipcode_row.appendChild(icon_div);
	zipcode_row.appendChild(input_zipcode);

	document.getElementById("form").insertBefore(zipcode_row, document.getElementById("submit_row"));
	zipcode_element = document.getElementsByName("zipcode")[0];
	zipcode_element.addEventListener('change', restoreDefaults);
}

function createHostingRow() {
	var hosting_row = document.createElement("div");
	hosting_row.setAttribute("id", "hosting_row");
	hosting_row.setAttribute("class", "dynamic_block");
	var label_hosting = document.createElement("label");
	var hosting = document.createTextNode("Do you have hosting?");
	var hosting_radio_group_div = document.createElement("div");
	hosting_radio_group_div.setAttribute("class","vertical_flex_container");
	var hosting_radio_yes_div = document.createElement("div");
	var hosting_radio_no_div = document.createElement("div");
	var input_radio_yes = document.createElement("input");
	var input_radio_no = document.createElement("input");
	var text_yes = document.createTextNode("Yes");
	var text_no = document.createTextNode("No");

	label_hosting.appendChild(hosting);
	
	input_radio_yes.setAttribute("type", "radio");
	input_radio_yes.setAttribute("name", "hosting_available");
	input_radio_yes.setAttribute("value", "yes");
	
	input_radio_no.setAttribute("type", "radio");
	input_radio_no.setAttribute("name", "hosting_available");
	input_radio_no.setAttribute("value", "no");
	input_radio_no.checked="true";
	
	hosting_radio_yes_div.appendChild(input_radio_yes);
	hosting_radio_yes_div.appendChild(text_yes);
	hosting_radio_no_div.appendChild(input_radio_no);
	hosting_radio_no_div.appendChild(text_no);

	hosting_radio_group_div.appendChild(hosting_radio_yes_div);
	hosting_radio_group_div.appendChild(hosting_radio_no_div);
	hosting_row.appendChild(label_hosting);
	hosting_row.appendChild(hosting_radio_group_div);

	document.getElementById("form").insertBefore(hosting_row, document.getElementById("submit_row"));
	hosting_available = document.getElementsByName("hosting_available")[0];
	hosting_available.addEventListener('change', restoreDefaults);
}