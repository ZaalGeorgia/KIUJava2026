# Assignment 2: Refactoring Code Smells

## Overview

In this assignment, you will refactor the examples in `Java2026/src/badsmells`.

Each example contains:

- a concrete code smell
- client code that shows why the current design is problematic
- a short list of proposed refactorings

Your job is to improve the design of each example by applying the proposed refactorings in code.

## What You Need to Do

For every example in the `badsmells` package:

1. Explain briefly what is wrong with the current design.
2. Apply the proposed refactorings.
3. Preserve the original observable behavior.
4. Improve the structure so the design flaw is meaningfully reduced or removed.

You are expected to work on all examples in the package.

## What a Good Result Looks Like

After refactoring, your code should show improvements such as:

- clearer names
- smaller and more focused methods
- cleaner class responsibilities
- less duplication
- lower coupling
- higher cohesion
- better encapsulation
- simpler and clearer client code

## What to Submit

Your submission must include:

- refactored Java code for all examples
- a short note for each example describing the original smell, the refactorings you applied, and why the result is better

You may place these notes:

- in a separate markdown file, or
- as short comments near the refactored code

## Constraints

- Use Java 8 style.
- Do not remove an example completely unless the correct solution is an inline or removal refactoring.
- Do not turn the assignment into a full redesign of the whole package.
- Prefer small, justified refactoring steps instead of unnecessary rewriting.
- If the proposed refactorings are not enough by themselves, you may add other sensible refactorings.

## Grading

Internal evaluation is on a `0-100` scale.

This document defines:

- the regular grading points for Assignment 2
- the assignment-specific bonus for Assignment 2

Course-level bonuses such as:

- early submission bonus
- strong first-submission bonus

are defined separately in `docs/assignment_evaluation_process.md` and apply in addition to the assignment-specific rules below.

### 1. Correct Identification of Smells — 20 marks

- You correctly understand the design flaw in each example.
- Your explanation matches the actual problem, not only the smell name.

### 2. Quality of Refactoring — 35 marks

- The refactorings you apply are relevant.
- The result reduces the original design problem.
- The final code is cleaner and easier to maintain.

### 3. Preservation of Behavior — 15 marks

- The refactored code keeps the original intended behavior.
- No obvious regressions are introduced.

### 4. Code Quality After Refactoring — 10 marks

- better naming
- better decomposition
- clearer responsibilities
- less duplication
- better encapsulation and cohesion

### 5. Completeness and Consistency — 20 marks

- You address all examples.
- Your work is consistent across the assignment.
- The submission is organized and readable.

## Bonus

You may earn up to `1` bonus point.

This is the Assignment 2 specific bonus.

It is separate from the course-level bonuses described in `docs/assignment_evaluation_process.md`.

The assignment-specific bonus is for work that is clearly stronger than a normal full-credit submission.

Typical reasons for bonus credit:

- especially strong and disciplined refactoring across all examples
- especially clear explanation of design improvements
- thoughtful use of tests or checks to preserve behavior
- especially strong handling of difficult examples such as `Repeated Switches`, `Refused Bequest`, `Large Class`, or `Divergent Change`

The bonus is not automatic.
You can receive the full `4` grading points without receiving the bonus.

## Conversion from Internal Marks to Grading Points

The table below converts internal marks into the regular grading points for Assignment 2 only.

It does not include:

- early-submission bonus
- first-submission `90+` bonus
- the Assignment 2 specific bonus point

| Internal Marks | Regular Grading Points |
|---|---:|
| `0-49` | `0` |
| `50-59` | `1` |
| `60-69` | `2` |
| `70-84` | `3` |
| `85-100` | `4` |

## How to Read the Conversion

- `0-49`: insufficient work
- `50-59`: minimal acceptable result
- `60-69`: satisfactory result
- `70-84`: solid result
- `85-100`: strong result, full regular grading points

Bonus note:
The assignment-specific `+1` bonus is evaluated separately and may be awarded on top of the regular `4` points.

## Suggested Workflow

For each example:

1. Read the smell comment and the client code.
2. Identify why the current design is weak.
3. Apply one or more proposed refactorings.
4. Check that the behavior still makes sense.
5. Write a short explanation of what changed and why it is better.

## Important

Cosmetic cleanup alone is not enough.

## Deadlines:

Wednesday, April 8 is soft deadline. +1 grading point. 
Wednesday April 15 - hard deadline.


To score well, your refactoring must actually improve the design of the example, not just change formatting or rename one or two symbols while leaving the smell essentially unchanged.
