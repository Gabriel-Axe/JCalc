package org.example;

public class Calculator {

 private int leftOperand; // NOTE: aka, {2} * 3
 private int rightOperand; // NOTE: aka, 2 * {3}

 private Operation operator;

 private int currentValue;

 // NOTE: it would be interesting to use enum functions to
 // "apply" operations
 public enum Operation {
  SUM("+", 1) {
   @Override
   public int Apply(int a, int b) {
    return a + b;
   }
  },
  MULTIPLY("*", 2) {
   @Override
   public int Apply(int a, int b) {
    return a * b;
   }
  },
  POWER("^", 3) {
   @Override
   public int Apply(int a, int b) {

    int value = a;
    for (int i = 1; i < b; i++) { // NOTE: Power starts at 1 and not 0
     value = value * a;
    }

    return value;
   }
  };

  private final String symbol;
  private final int id;

  Operation(String symbol, int id) {
   this.symbol = symbol;
   this.id = id;
  }

  public abstract int Apply(int a, int b);

  // WARN: Beware the pratice of adding stuff freely without
  // testing
  public static Operation fromId(int value) {
   for (Operation op : values()) {
    if (value == op.id)
     return op;
   }
   throw new IllegalArgumentException("Invalid operation ID: " + value);
  }

  public String getSymbol() {
   return this.symbol;
  }

  public int getId() {
   return this.id;
  }
 }

 public Calculator() {
  this.currentValue = 0;
 }

 public int getLeftOperand() {
  return this.leftOperand;
 }

 public int getRightOperand() {
  return this.rightOperand;
 }

 public void setLeftOperand(int value) {
  this.leftOperand = value;
 }

 public void setRightOperand(int value) {
  this.rightOperand = value;
 }

 public void operate(int a, int b) {
  System.out.println("What opperation would you like to do");
  System.out.println("1: + (sum)");
  System.out.println("2: * (multiply)");
  System.out.println("3: ^ (power)");

  int choice = 0;
  Operation operation = Operation.fromId(choice);
  switch (operation) {
   case SUM:
    this.Multiplicate(a, b);
    break;

   case MULTIPLY:
    this.Multiplicate(a, b);
    break;

   case POWER:
    this.Power(a, b);
    break;

   default:
    throw new IllegalArgumentException("Invalid operation ID: " + choice);
  }
 }

 public void setOperator(Operation operator) {
  this.operator = operator;
 }

 public void ApplyOpperation() {
  this.currentValue = this.operator.Apply(this.leftOperand, this.rightOperand);
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
