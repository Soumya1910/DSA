# Table of Contents
- [Q1: What is an Exception?](#q1-what-is-an-exception)
- [Q2: How do we handle exceptions in Java?](#q2-how-do-we-handle-exceptions-in-java)
- [Q3: Difference Between Exception and Error](#q3-difference-between-exception-and-error)
- [Q4: Can we write only a try block without catch or finally?](#q4-can-we-write-only-a-try-block-without-catch-or-finally)
- [Q5: Can we write statements between try, catch, or finally blocks?](#q5-can-we-write-statements-between-try-catch-or-finally-blocks)
- [Q6: Do remaining statements in try block execute after an exception occurs?](#q6-do-remaining-statements-in-try-block-execute-after-an-exception-occurs)
- [Q7: Difference Between throw and throws](#q7-difference-between-throw-and-throws)
- [Q8: What happens when an exception is thrown by the main method?](#q8-what-happens-when-an-exception-is-thrown-by-the-main-method)
- [Q9: What is an unreachable catch block error?](#q9-what-is-an-unreachable-catch-block-error)

---

# Java Exception Handling Interview Notes

## Q1: What is an Exception?
An **exception** is an unexpected event that occurs during program execution, disrupting the normal flow. If not handled, it may cause the program to terminate abruptly.

---

## Q2: How do we handle exceptions in Java?
Java provides three main constructs:

- **try**: Contains code that might throw exceptions.
- **catch**: Handles the exception when it occurs.
- **finally**: Executes regardless of whether an exception occurred, typically used for cleanup.

---

## Q3: Difference Between Exception and Error

### Exception:
- Recoverable using `try-catch` or `throw`.
- Compiler enforces handling of checked exceptions.
- Related to application logic.
- Includes checked and unchecked types.
- Defined under `java.lang.Exception`.

### Error:
- Not recoverable.
- Compiler does not enforce handling.
- Related to system environment.
- All errors are unchecked.
- Defined under `java.lang.Error`.

---

## Q4: Can we write only a try block without catch or finally?
No. Either `catch` or `finally` is mandatory.

**Error if omitted:** Compile-time error: *"insert finally to complete try statement"*.

---

## Q5: Can we write statements between try, catch, or finally blocks?
No. `try` must be immediately followed by `catch` or `finally`.

---

## Q6: Do remaining statements in try block execute after an exception occurs?
No. Once an exception occurs, subsequent statements in the `try` block are skipped. Control moves to `catch` or program terminates. Use `finally` for cleanup.

---

## Q7: Difference Between `throw` and `throws`

### throw:
- Used to explicitly throw an exception.
- Cannot propagate checked exceptions alone.
- Used inside a method.
- Cannot throw multiple exceptions.

### throws:
- Declares exceptions in method signature.
- Can propagate checked exceptions.
- Allows multiple exceptions.

---

## Q8: What happens when an exception is thrown by the main method?
The Java Runtime terminates the program and prints the exception message and stack trace to the console.

---

## Q9: What is an unreachable catch block error?
Occurs when a superclass catch block precedes a subclass catch block (e.g., `Exception` before `NullPointerException`).

**Rule:** Order catch blocks from most specific to most general.
