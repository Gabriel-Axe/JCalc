package org.example;

import java.util.Scanner;

public class Calculator {

 private int leftOperand; // NOTE: aka, {2} * 3
 private int rightOperand; // NOTE: aka, 2 * {3}

 private Operation operator;

 private int currentValue;

 public Calculator() {
  this.currentValue = 0;
 }

 // NOTE: it would be interesting to use enum functions to
 // "apply" operations
 public enum Operation {
  SUM("+", 1) { // WARN: It was really tiresome to modify id
                // by id at the addition of a new operation
   @Override
   public int apply(int a, int b) {
    return a + b;
   }
  },
  SUB("-", 2) {
   @Override
   public int apply(int a, int b) {
    return a - b;
   }
  },
  MULTIPLY("*", 3) {
   @Override
   public int apply(int a, int b) {
    return a * b;
   }
  },
  DIVIDE("/", 4) {
   @Override
   public int apply(int a, int b) {
    return a / b;
   }
  },
  POWER("^", 5) {
   @Override
   public int apply(int a, int b) {

    int value = a;
    for (int i = 1; i < b; i++) { // NOTE: Power starts at 1 and not 0
     value = value * a;
    }

    return value;
   }
  },
  ROOT("√", 6) {
   @Override
   public int apply(int a, int b) {
    // NOTE: I dont understand exactly how this works, but
    // i have seen it from more them 1 source

    if (a == 0)
     return 0;
    if (a == 1)
     return 1;
    if (b == 0)
     return 1;

    int low = 1;
    int high = a;
    int result = 1;

    while (low <= high) {
     int mid = low + (high - low) / 2;

     int power = 1;
     boolean overflow = false;
     for (int i = 0; i < b; i++) {
      if (power > a / mid) {
       overflow = true;
       break;
      }
      power = power * mid;
     }
     if (overflow || power > a) {
      high = mid - 1;
     } else if (power < a) {
      result = mid;
      low = mid + 1;
     } else {
      return mid;
     }
    }

    return result;
   }

   public int apply(int a) {
    return this.apply(a, 2);
   }
  };

  private final String symbol;
  private final int id;

  Operation(String symbol, int id) {
   this.symbol = symbol;
   this.id = id;
  }

  public abstract int apply(int a, int b);

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

 public int enterNumber(Scanner scanner) {
  String s = scanner.next(); // WARN: The user could input a letter, symbol or more them 1 number
  int i = Integer.parseInt(s);
  return i;
 }

 public void run() {
  // WARN: there is a tinisy possibility that im missing and this
  // loop is capable of running forever
  boolean loop = true;
  while (true) {

   int i = 0;

   // WARN: This wont fit a test
   Scanner scanner = new Scanner(System.in); // PERF: We could inject this scanner

   System.out.println("Please select a operator:");
   for (Operation op : Operation.values()) {
    System.out.println(op.id + ": " + op.symbol);
   }

   i = enterNumber(scanner);
   this.selectOperator(i);

   System.out.print("The left operand: ");
   i = this.enterNumber(scanner);
   this.setLeftOperand(i);

   System.out.print("\nThe right operand: ");
   i = this.enterNumber(scanner);
   this.setRightOperand(i);

   this.applyOpperation();
   System.out.println("Final result: " + this.Result());

   continue;
  }
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
 }

 public void selectOperator(int id) {
  for (Operation op : Operation.values()) {
   if (op.id == id) {
    this.setOperator(op);
    return;
   }
  }
  // WARN: Maybe its a bit overkill to just throw an exception...
  throw new IllegalArgumentException("A operation with the given ID " + id + " doesnt exist");
 }

 public Operation getOperator() {
  return this.operator;
 }

 public void setOperator(Operation operator) {
  this.operator = operator;
 }

 public void applyOpperation() {
  this.currentValue = this.operator.apply(this.leftOperand, this.rightOperand);
 }

 public int Result() {
  return this.currentValue;
 }
}
