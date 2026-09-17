# Day 3: Common Java Mistakes & Pitfalls

This guide covers the most frequent traps you might encounter when transitioning to methods, arrays, and object-oriented logic in Java. Keep these points in mind as you write your code and reference them when you are debugging!

---

## 1. Method Architecture Errors

### Void Methods Returning Values
Declaring a method as `void` but attempting to use the `return` keyword with a value.
*   **Symptom:** Compiler error (`Cannot return a value from a method with void result type`).
*   **Fix:** Ensure the return type in the method signature matches the data type being returned.

### Missing Return in Conditionals
Failing to guarantee a return value for *every* possible logical path.
*   **Mistake:** 
    ```java
    public int check(int x) {
        if (x > 0) { return 1; }
        if (x <= 0) { return 0; }
        // Compiler error: Missing return statement
    }
    ```
*   **Fix:** Use an `else` block or place a default `return` at the bottom of the method.

### Shadowing Variables
Declaring a local variable or parameter inside a method with the exact same name as a class attribute. The local variable "shadows" the class variable, causing the method to ignore the intended class data.
*   **Mistake:**
    ```java
    public class User {
        String name;
        public void setName(String name) {
            name = name; // Assigns the parameter to itself, shadowing the attribute
        }
    }
    ```
*   **Fix:** Use the `this` keyword to explicitly distinguish the class attribute from the local variable or parameter.
    ```java
    this.name = name;
    ```

---

## 2. Array Disasters

### The Array Instantiation Trap
Attempting to assign values or access indices before using the `new` keyword to allocate memory.
*   **Mistake:** `int[] numbers; numbers[0] = 5;`
*   **Symptom:** `NullPointerException` or compiler error (`Variable numbers might not have been initialized`).
*   **Fix:** `int[] numbers = new int[5];`

### Off-by-One (`IndexOutOfBoundsException`)
Looping one index too far because arrays are zero-indexed and the last element is `length - 1`.
*   **Mistake:** `for (int i = 0; i <= arr.length; i++)`
*   **Fix:** `for (int i = 0; i < arr.length; i++)`

### Printing Arrays Directly
Attempting to print the contents of an array directly to the console.
*   **Mistake:** `System.out.println(myArray);`
*   **Symptom:** The console prints a memory reference hash (e.g., `[I@76ed5528`).
*   **Fix:** Iterate through it with a loop or use `System.out.println(Arrays.toString(myArray));`.

### Mixing Up Length Syntax
Using the wrong syntax to find the size of a structure.
*   **Arrays:** `arr.length` (No parentheses)
*   **Strings:** `str.length()` (Parentheses)
*   **ArrayLists:** `list.size()` (Different keyword)

---

## 3. ArrayList Pitfalls

### Primitive Types in Generics
Attempting to create an ArrayList using primitive types instead of their Object wrapper classes.
*   **Mistake:** `ArrayList<int> list = new ArrayList<>();`
*   **Fix:** `ArrayList<Integer> list = new ArrayList<>();`

### Array Syntax on ArrayLists
Attempting to use bracket notation to get or set ArrayList elements.
*   **Mistake:** `list[0] = "Apple";` or `String x = list[0];`
*   **Fix:** `list.set(0, "Apple");` and `String x = list.get(0);`

### Concurrent Modification
Modifying the size of an ArrayList (using `.remove()`) while iterating through it with a standard forward `for` loop.
*   **Symptom:** Elements are skipped because the indices shift downward instantly, or a `ConcurrentModificationException` is thrown.
*   **Fix:** Iterate backward (`for (int i = list.size() - 1; i >= 0; i--)`), or use an `Iterator`, which provides a safe `.remove()` method to use during iteration.
    ```java
    ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Cherry"));
    Iterator<String> iterator = fruits.iterator();

    while (iterator.hasNext()) {
      String fruit = iterator.next();
      if (fruit.equals("Banana")) {
          iterator.remove(); // Safely removes "Banana" without crashing
      }
     }
    ```

---

## 4. String Logic Traps

### The `==` Operator on Strings
Using `==` to compare the actual text of two String objects. The `==` operator compares memory addresses, not the characters. While `==` might occasionally evaluate to `true` if both strings share the same reference in Java's String pool, it is highly unreliable for comparing user input or dynamically generated strings.
*   **Mistake:** `if (password == "admin")` // May fail even if the password is "admin"
*   **Fix:** `if (password.equals("admin"))`

### Ignoring String Immutability
Believing that String methods change the original string, rather than returning a *new* string.
*   **Mistake:** 
    ```java
    String name = "java";
    name.toUpperCase();
    // name is still "java"
    ```
*   **Fix:** `name = name.toUpperCase();`

---

## 5. Parameter Modification (Pass-by-Value)

### Modifying Primitive Parameters
Trying to change the value of an `int` or `boolean` parameter inside a method and expecting the original variable in `main()` to change. Primitives are passed as copies; reassigning them inside the method does nothing to the original.

### Modifying Array/Object Parameters
Conversely, modifying the *contents* of an array parameter (e.g., `arr[0] = 99;`) *will* change the original array in `main()`, because both variables point to the same block of memory.

---

## 6. Execution and Context Errors

### Calling Non-Static Methods from Main
Attempting to call a standard method directly from `public static void main` without creating an instance of the class first.
*   **Symptom:** Compiler error (`Non-static method cannot be referenced from a static context`).
*   **Fix:** Add the `static` keyword to the helper method, or instantiate the class first.

### Ignoring the Return Value
Calling a method that returns a result, but failing to store or print that result.
*   **Mistake:** `Math.max(5, 10);` (Calculates 10, then throws it away)
*   **Fix:** `int max = Math.max(5, 10);`

### The Scope Trap
Declaring a variable inside a block (like an `if` statement or `for` loop) and trying to read it outside that block.

---

## 7. The Classic Scanner Bug

### The `nextInt()` / `nextLine()` Buffer Trap
Reading an integer with `nextInt()` and immediately following it with `nextLine()` to read a string. The `nextInt()` reads the number but leaves the "Enter" keypress (`\n`) in the input buffer. The subsequent `nextLine()` instantly reads that empty newline and skips user input entirely.
*   **Fix:** Add an extra, empty `scanner.nextLine();` immediately after `nextInt()` to consume the leftover newline character.

---

## 8. Deep Array and Reference Pitfalls

### Copying Arrays by Reference
Believing that assigning an array to a new variable creates a copy of the data. 
*   **Mistake:** `int[] copy = original;`
*   **Reality:** Both variables now point to the exact same memory location. Changing `copy[0]` changes `original[0]`.

### Null Elements in Object Arrays
Creating an array of Strings or Objects and immediately trying to call methods on the elements before instantiating them.
*   **Mistake:** 
    ```java
    String[] words = new String[5];
    int len = words[0].length(); 
    ```
*   **Symptom:** `NullPointerException` because the array is full of `null` references, not empty strings.

---

## 9. Syntax and Type Quirks

### Single vs. Double Quotes
Confusing `String` and `char` syntax.
*   **Strings:** Strictly require double quotes (`"Hello"`).
*   **Chars:** Strictly require single quotes (`'A'`).

### Accidental Semicolons after Loops
Placing a semicolon directly after the parenthesis of a `for` or `while` loop.
*   **Mistake:** 
    ```java
    for (int i = 0; i < 5; i++); 
    {
        System.out.println("Hello");
    }
    ```
*   **Symptom:** The loop runs 5 times doing nothing, and "Hello" prints exactly once after the loop finishes.

### Forgetting Imports
Trying to use `Scanner`, `ArrayList`, or `Arrays` without importing them at the top of the file.
