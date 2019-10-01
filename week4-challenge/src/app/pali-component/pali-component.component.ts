import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'pali-component',
  templateUrl: './pali-component.component.html',
  styleUrls: ['./pali-component.component.css']
})
export class  PalindromeComponent implements OnInit {

  constructor() { }

  
  ngOnInit() {
  }
  //
  


   check(word) {   
    let string = word.toString();

    // reverse string
    //Use the split() method to return a new array
    //Use the reverse() method to reverse the new created array
    // last step join all elements
    let reverse = string.split('').reverse().join('');

    // Check
    const h5 = document.getElementById('display');
    if(string == reverse) {
    h5.innerHTML = word + " is a palindrome!";
    }
    else
    h5.innerHTML = word + " is not a palindomre"; 
    
  }
   
    
}





