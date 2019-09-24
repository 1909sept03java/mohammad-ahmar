const url = "https://randomuser.me/api/?results=25";
const ol = document.getElementById("users");

var age = 0;
var total = 0;
var totalAge=0;
fetch(url)
.then((resp) => resp.json())
.then(function(data) {
 let users = data.results;
 console.log(data.results);
 return users.map(function(user) {         // maps through results
   let li = document.createElement('li'); //create elements for our html pg
   let img = document.createElement('img');
   let div = document.createElement('div');
   img.src = user.picture.thumbnail;
   //displays results using div tag
   div.innerHTML = `Firstname: ${user.name.first} <br> 
   Lastname: ${user.name.last} <br>
   Age: ${user.dob.age} <br>`; 
   li.appendChild(img); /// append elements to show proper img with person details  append 2nd element to first 1
   li.appendChild(div);
   ol.appendChild(li);

   document.getElementById("avg").innerText = 'Average age: ' + avg(users); //gets the avg from data.results

 })
})
.catch(function(error) {
 console.log(error);
});

function avg(data) {
    total = 0;
    for (var i = 0; i < data.length; i++) {
        total = total + data[i].dob.age;
    }
    total = total/25;
    return total;
    console.log(total);
}