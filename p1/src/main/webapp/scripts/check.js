let Employee = {};

var el = document.getElementById('myinfo');
if(el){
	el.addEventListener('click', viewEmp);
}

var ttt = document.getElementById('pending');
if(ttt){
	ttt.addEventListener('click', viewPendingReim);
}


var e3 = document.getElementById('p');  // when clicking on buttons do this function
if(e3){
	e3.addEventListener('click', tryThis);
}

var e4 = document.getElementById('resolved');
if(e4){
	e4.addEventListener('click', resPendingReim)
}

var e5 = document.getElementById('myEmp');
if(e5){
	e5.addEventListener('click',myEmployeePendingReim)
}

var e6 = document.getElementById('myEmpRes');
if(e6) {
	e6.addEventListener('click',myEmployeeResolvedReim)
}

var e7 = document.getElementById('singleEmp');
if(e7){
	e7.addEventListener('click',singleEmp)
}


function viewEmp() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8082/p1/session")

	.then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8082/p1/login"
		} else {
			//define behavior for when a user is returned
			Employee = data;
			document.getElementById('id').innerText = "id: " + Employee.id;
			document.getElementById('username').innerText = "username: " + Employee.user;
			document.getElementById('password').innerText = "password: " + Employee.pass;
			document.getElementById('man id').innerText = "maneger id: " + Employee.mid;
			//-------------------------------------------------------
		}
	})
}

function viewPendingReim() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8082/p1/viewRiem") 
		.then(function(response) {
			return response.json(); // parsing json data in the response as a JS object
			//	JSON.parse(response.text());
			//console.log(json);
		}).then(function(data) {
			return data.map(function(user) {
			
			// check whether there is a valid session
			//define behavior for when there is no valid user
			if(data.session === null) {
				window.location = "http://localhost:8082/p1/login"
			} else {
				let li = document.createElement('h4'); //create elements for our html pg
				let div = document.createElement('div');
				div.innerHTML = `Pending Reimbursments: <br> Reim id: ${user.rId} <br> Emp id: ${user.eId}<br> Balance: ${user.balance} <br> 
					Details: ${user.details} <br>
					Status check: ${user.check} <br>`;// got rid of last 2 attributes 
		 /// append elements to show proper img with person details  append 2nd element to first 1
				li.append(div);
				ol.append(li);
			}
			})
			
		})
		.catch(function(error) {
			console.log(error);
		});
}

function resPendingReim() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8082/p1/resRiem") 
		.then(function(response) {
			return response.json(); // parsing json data in the response as a JS object
			//	JSON.parse(response.text());
			//console.log(json);
		}).then(function(data) {
			return data.map(function(user) {
			if(data.session === null) {
				window.location = "http://localhost:8082/p1/login"
			} else {
				let li = document.createElement('h4'); //create elements for our html pg
				let div = document.createElement('div');
				div.innerHTML = `Resolved Reimbursments: <br> Reim id: ${user.rId} <br> Emp id: ${user.eId}<br> Balance: ${user.balance} <br> 
					Details: ${user.details} <br>
					Status check: ${user.check} <br>`;// got rid of last 2 attributes 
		 /// append elements to show proper img with person details  append 2nd element to first 1
				li.append(div);
				ol.append(li);
			}
			})
			
		})
		.catch(function(error) {
			console.log(error);
		});
}

//manager function
function myEmployeePendingReim() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8082/p1/myPendingEmployee") 
	.then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
		//	JSON.parse(response.text());
		//console.log(json);
	}).then(function(data) {
		return data.map(function(user) {
		
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8082/p1/login"
		} else {
			let li = document.createElement('h4'); //create elements for our html pg
			let div = document.createElement('div');
			div.innerHTML = `Pending Reimbursments: <br> Reim id: ${user.rId} <br> Emp id: ${user.eId}<br> Balance: ${user.balance} <br> 
				Details: ${user.details} <br>
				Status check: ${user.check} <br>`;// got rid of last 2 attributes 
	 /// append elements to show proper img with person details  append 2nd element to first 1
			li.append(div);
			ul.append(li);
		}
		})
		
	})
	.catch(function(error) {
		console.log(error);
	});
}

function myEmployeeResolvedReim() {
	fetch( "http://localhost:8082/p1/myResolvedEmployee")
	// send a GET request to SessionServlet to obtain session information
	.then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
		//	JSON.parse(response.text());
		//console.log(json);
	}).then(function(data) {
		return data.map(function(user) {
		
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8082/p1/login"
		} else {
			let li = document.createElement('h4'); //create elements for our html pg
			let div = document.createElement('div');
			div.innerHTML = `Resolved Reimbursments: <br> Reim id: ${user.rId} <br> Emp id: ${user.eId}<br> Balance: ${user.balance} <br> 
				Details: ${user.details} <br>
				Status check: ${user.check} <br> Manage?: ${user.manageId} <br> Manager resolve id: ${user.mangerResId}`; 
	 /// append elements to show proper img with person details  append 2nd element to first 1
			li.append(div);
			ul.append(li);
		}
		})
		
	})
	.catch(function(error) {
		console.log(error);
	});
}




function singleEmp() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8082/p1/singleEmp") 
	.then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
		//	JSON.parse(response.text());
		//console.log(json);
	}).then(function(data) {

		console.log(data);
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8082/p1/login"
		} else {
			//pending request printed out
			document.getElementById('headm').innerText = "All requests made: ";
			document.getElementById('balancem').innerText = "Amount: " + data.balance;
			document.getElementById('detailsm').innerText = "Details: " + data.details;
			document.getElementById('checkm').innerText = "Status: " + data.check;
			document.getElementById('reim idm').innerText = "Reim id: " + data.rId;
			document.getElementById('emp idm').innerText = "emp id: " + data.eId;
			document.getElementById('manage').innerText = "Manage: " + data.manageId;
			document.getElementById('man res').innerText = "Manager resolved id: " + data.mangerResId;//
		}
	})
}



function tryThis() {
	fetch( "http://localhost:8082/p1/myResolvedEmployee")
	.then((resp) => resp.json())
	.then(function(data) {
		
		return data.map(function(user) {         // maps through results
			let li = document.createElement('li'); //create elements for our html pg
			let div = document.createElement('div');
			div.innerHTML = `Reim id: ${user.rId} <br> Emp id: ${user.eId}<br> Balance: ${user.balance} <br> 
				Details: ${user.details} <br>
				Status check: ${user.check} <br> Manage?: ${user.manageId} <br> Manager resolve id: ${user.mangerResId}`;
	 /// append elements to show proper img with person details  append 2nd element to first 1
			li.append(div);
			ol.append(li);
		})
	})
	.catch(function(error) {
		console.log(error);
	});

}
ul = document.getElementById("EmpResMan"); // prints manage rresolved results
ol = document.getElementById("EmpPendMan"); //orints pending rquests for manager
ol = document.getElementById("manpending"); // print in this location where my by tag is located (manager.html)
ol = document.getElementById("manres");