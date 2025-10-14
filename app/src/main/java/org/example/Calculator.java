package org.example;

public class Calculator {

 private int currentValue;

 public Calculator() {
  this.currentValue = 0;
 }

 public void Sum(int a, int b) {
  int value = a + b;
  this.currentValue = this.currentValue + value;
 }

 public void Multiplicate(int a, int b) {
  int value = a * b;
  this.currentValue = value;
 }

 public void Power(int a, int b) {

  int value = a;

  // for (int i = 0; i < b; i++) {
  for (int i = 1; i < b; i++) { // NOTE: Power starts at 1 and not 0
   value = value * a;
  }
  this.currentValue = value;
 }

 public int Result() {
  return this.currentValue;
 }
}
