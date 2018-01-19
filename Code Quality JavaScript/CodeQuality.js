// Function description:
// input: number or string
// functionality:
// -using the checkbox we toggle between the number and name divisions.
// -if number is selected, then it is sent to analyzeNumber where it checks its value, giving the description (range, to be specific) of the number
// -if number is not selected, then UI asks for gender, name and age. After validation, it adds the data to the table.

function analyzeNumber() {
	var input = document.getElementById('inpNo').value;
	if (input>1000 || input<0) 
		document.getElementById('para').innerText = "Invalid input ";
	else if (input<50) 
		document.getElementById('para').innerText = "Number is less than 50";
	else if (input>100) 
		document.getElementById('para').innerText = "Number is greater than 100";
	else 
		 document.getElementById('para').innerText = "Number is between 50 and 100";
}

function analyzeString() {
	var input = document.getElementById('inpName').value;
	var flag=1;
	var age = document.getElementById('inpAge').value;
	if(input=="" || !isNaN(input)) {
		//alert('Input Name');
		document.getElementById('para').innerText = "Input name";
		flag=0;
	}
	else {
		var str="The name is ";
		var gender="";
		
		if (document.getElementById("male").checked == true){
			gender="Male";
			str+="Mister "+input;
			document.getElementById('para').innerText = str;
		}		
		else if (document.getElementById("female").checked == true){
			str += "Miss " + input;
			gender="Female";
			document.getElementById('para').innerText = str;
		}
		else {
			document.getElementById('para').innerText = "Select gender";
			flag=0;
		}
		if(age=="") {
			flag=0;
			document.getElementById('para').innerText = "Input age";
		}	
		if(flag==1){
		var table = document.getElementById("displayTable");
		var row="<td>" + input + "</td><td>" + gender + "</td><td>" + age + "</td><td>" + str + "</td>";
		var tbody = document.querySelector("#displayTable tbody");
		var tr = document.createElement("tr");
		tr.innerHTML = row;
		tbody.appendChild(tr);
		}
	}
}

function analyze(){
	//console.log("Clickkk");
	var clickk= document.getElementById('chkBox').checked;
	if(clickk==true)
		analyzeNumber();
	else analyzeString();
}

function onClickHandler(){
	var clickk= document.getElementById('chkBox').checked;
	if(clickk==false){
		document.getElementById('name').style.display = 'block';
		document.getElementById('num1').style.display = 'none';
		//alert("false");
	}
	else{
		//alert("true");
		document.getElementById('num1').style.display = 'block';
		document.getElementById('name').style.display = 'none';
	}
}
