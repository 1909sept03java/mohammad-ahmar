import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-array',
  templateUrl: './array.component.html',
  styleUrls: ['./array.component.css']
})
export class ArrayComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

 
  sort(numbers){
  
 const ans = document.getElementById('display');
  let sorted = numbers.split(","); // split then use sort method
  sorted.sort();
  ans.innerHTML= sorted;
  
  
  
  }
  
    






}
