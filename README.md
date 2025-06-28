# Algorithms 1 – Assignment 4

**Semester B • Second Year • B.Sc. in Computer Science**
**Instructor: Dr. Paul Avrahami**

---

## Overview

This assignment focuses on topological sorting and dynamic programming techniques.

You will implement solutions for:

1. **Finding all paths ending at a specific node in a DAG**
2. **Counting the number of paths ending at every node using topological order**
3. **Counting colorings of an array with constraints on the number of red cells being even**

---

## Question 1 – Paths in a DAG

### A. List All Paths Ending at Node D

Given the directed acyclic graph:

```
A → B → D
     ↓
      C → D
```

### Output:

```
All paths ending at D:
A → B → C → D
A → B → D
B → C → D
B → D
C → D
D
```

### B. Count All Paths Ending at Every Node

Using topological sort and dynamic programming:

### Output:

```
Number of paths ending at A: 1
Number of paths ending at B: 2
Number of paths ending at C: 3
Number of paths ending at D: 6
```

### Time Complexity:

* Topological sort: `O(V + E)`
* Path count propagation: `O(V + E)`
* **Total:** `O(V + E)`

---

## Question 2 – Coloring Cells with Even Red Count

You are given an array of length `n`, and each cell can be colored Red, Blue, or Green.

### A. Recursive Formula

Let `T(n)` be the number of valid colorings of `n` cells such that the number of red cells is even.

Recurrence:

```
T(n) = T(n-1) + 3^(n-1)
T(0) = 1
```

Explanation:

* If the first cell is blue/green (2 options), it doesn't change red count parity → contributes `2*T(n-1)`.
* If the first is red (1 option), it flips the parity → contributes `total(n-1) - T(n-1)` = `3^(n-1) - T(n-1)`.
* Total: `T(n) = 2*T(n-1) + (3^(n-1) - T(n-1)) = T(n-1) + 3^(n-1)`

### B. Dynamic Programming (Bottom-Up)

```java
int[] T = new int[n + 1];
T[0] = 1;
for (int i = 1; i <= n; i++) {
    T[i] = T[i - 1] + (int)Math.pow(3, i - 1);
}
return T[n];
```

### Example Output for n = 5:

```
----- Recursive method -----
Number of colorings with even red  cells: 122
Recursion complexity = O(n^2)

----- Dynamic method -----
Number of colorings with even red cells: 122
Dynamic complexity = O(n)
```

### Time Complexity:

* Recursive (naive): `O(n^2)` due to recomputation and power
* Dynamic programming: `O(n)` if powers are computed incrementally

---

## Author

| Name           | Contribution                               |
| -------------- | ------------------------------------------ |
| Yakov Ben-Hamo | Full implementation, testing, and write-up |

---

## Notes

* The assignment highlights how topological sorting can support efficient path counting in DAGs.
* It also demonstrates how to handle parity constraints via recursive logic and optimize using bottom-up dynamic programming.
* Both sections reflect the importance of identifying structure in recursive problems to enable fast DP solutions.
