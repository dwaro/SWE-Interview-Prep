# Data Structures

## Array

An array is a collection of elements stored in a continguous memory space. Elements in an array must all be of the same type. Each element in the array can be accessed via its unique index. Arrays are static, and have a fixed length. Once their space is full, you must create an entirely new, larger array object and copy over array values.

- It requires **O(1)** constant time to store a value at the ith position of an array: arr[i] = ___

- It requires **O(1)** constant time to access the value at the ith position of the array: arr[i]

- The space complexity of an array is equal to the number of elements in the array, or the array's size. **O(n)** linear space.

#### Sorting an Array

To easily sort an array, we can use the util api: java.util.Arrays.sort(arr), which sorts the array in place.

## Stack



## Queues

### `Queue`

### `Priority Queue`

## Lists

### `Singly Linked List`

### `Doubly Linked List`

### `ArrayList`

Implements the List<E> interface. An ArrayList is dynamic, meaning that its size grows as the user adds more items to the list. ArrayLists may have duplicate items, and are asynchronous. When an arraylist grows, it technically grows 50% of the current arrays size when it exceeds capacity. An ArrayList has an implementable iterator for traversal.

ArrayLists are faster than Vectors because they are not thread safe. ArrayLists perform a faster get operation compared to linkedlists, however, its add method is slightly slower and its remove method is much slower than linkedlists.

#### Important ArrayList Methods

- get(): time = O(1)

- add(): time = O(1)

- remove(): time = O(n)

- clear()

- clone()

- contains()

- forEach()

- isEmpty()

- indexOf()

- iterator()

- size()

- set()

- sort()

- toArray()

### `Vector`

Implements the List<E> interface. Vectors are dynamic and similar to ArrayLists. Vectors are slower than ArrayLists, as they are synchronous and require locks. Secondly, vectors grow at 100% when the current array capacity is exceeded.

## Sets

### `HashSet`

### `TreeSet`

### `LinkedHashSet`

## Maps

### `HashMap`

### `TreeMap`

### `LinkedHashMap`

## HashTable

## Trees

### `Binary Tree`

### `Binary Search Tree`

### `Min Heap`

### `Max Heap`

## Graphs

## Numbers

### `int`

### `double`

### `double`

### `float`

### `long`

### `byte`

### `short`

## char

## String

### `String`

### `StringBuilder`

## boolean