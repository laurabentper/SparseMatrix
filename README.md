# SparseMatrix

This project implements a data structure for handling sparse matrices in Java. The code includes two approaches to representing sparse matrices: a static implementation using arrays and a dynamic implementation using linked lists.

## 📌 Features

- Insertion and removal of elements
- Search for elements in the matrix
- Matrix printing
- Verification of specific properties:
    - Empty matrix
    - Diagonal matrix
    - Row or column matrix
    - Lower and upper triangular matrices
    - Symmetric matrix
- Matrix operations:
  - Addition
  - Multiplication
  - Transpose retrieval

## 📂 Code Structure

The project contains the following main classes:

🔹 MatrizEsparsa (Interface)

Defines the fundamental methods for sparse matrix manipulation.

🔹 MatrizEstatica (Array-Based Implementation)

Represents a sparse matrix using a two-dimensional array (int[][]).

🔹 MatrizListas (Linked List Implementation)

Represents a sparse matrix using linked lists to store only nonzero elements.
