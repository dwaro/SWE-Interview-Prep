# Important Algorithms to know

- [Sorting Algorithms](./readme.md#sorting)

- [Search Algorithms](./readme.md#search)

- Generate Permutations (Heap's Algorithms)

# Sorting

### `Bubble Sort`

- Asmyptotic Runtime Complexity: O( n² )
- Asmyptotic Space Complexity: O( 1 )

Bubble Sort entails moving through an array, and swapping pairs of adjacent elements. First, we compare elements. 
at positions 0 and 1. If element at 0 is greater than the element in position 1, we swap the elements. Next, we
compare elements at positions 1 and 2. This continues until the end of the array, and bubble sort requires n sweeps 
of the array to guarantee it's sorted. After each sweep, we start at the beginning of the array and repeat the
comparisons.

After the first sweep, we are guaranteed the largest element is placed at the end of the array. After the second
sweep, we are guaranteed the second largest element is placed second from the end of the array and so on.

Bubble Sort is considered a slow sorting algorithm, suitable only for smaller data sizes. Bubble sort is a stable
sorting algorithm.

```java
public static void bubbleSort(int[] values) {
    // n sweeps
    for (int i = 0; i < values.length - 1; i++) {

        // compare adjacent neighbors up to (i - 1) position from the end
        for (int j = 0; j < values.length - 1 - i; j++) {

            // swap values
            if (values[j] > values[j + 1]) {
                int tmp = values[j+1];
                values[j+1] = values[j];
                values[j] = tmp;
            }
        }
    }
}
```

**Improving Bubble Sort**

Quadratic time complexity is the worst case scenario, in which our array is only guaranteed to be completely sorted
after n sweeps. But, we may very well likely finish sorting our array prior to n sweeps. To quit early, we can introduce
a swap tracker to indicate when we haven't made any swaps (i.e. the array is now sorted).

```java
public static void bubbleSort(int[] values) {
    // Track swaps
    boolean swapped = true;

    // n sweeps
    for (int i = 0; i < values.length - 1 && swapped; i++) {
        swapped = false;

        // compare adjacent neighbors up to (i - 1) position from the end
        for (int j = 0; j < values.length - 1 - i; j++) {

            // swap values
            if (values[j] > values[j + 1]) {
                int tmp = values[j+1];
                values[j+1] = values[j];
                values[j] = tmp;
                swapped = true;
            }
        }
    }
}
```

### `Selection Sort`

- Asmyptotic Runtime Complexity: O( n² )
- Asmyptotic Space Complexity: O( 1 )

An easy way to describe selection sort is that it is sorting the array backwards. In the first pass, we **select** the
largest element and place it at the end of the array. For the second pass, we then find the largest element in the array
from index 0 up to second last position of the array, and place it at the second to last position of the array. We repeat
this for n - 1 sweeps to guarantee the array is sorted.

On average, selection sort requires less swaps than bubble sort or insertion sort; however, it is still an inefficient
sorting algorithm. Also note, that the algorithm can be implemented in reverse, putting the smallest at the beginning
of the array and building the array forward.

![Selection Sort](https://raw.githubusercontent.com/dwaro/SWE-Interview-Prep/master/media/selection-sort.png)

```java
public static void selectionSort(int[] values) {
    // n - 1 sweeps
    for (int i = 0; i < values.length - 1; i++) {
        
        // index of max element in unsorted portion of the array 
        int max = 0;

        // compare if we have a new max
        for (int j = 0; j < values.length - 1 - i; j++) {
            if (values[j] > values[max]) {
                max = j;
            }
        }
        
        // swap max element to the end of unsorted array
        int tmp = values[values.length - 1 - i];
        values[values.length - 1 - i] = values[max];
        values[max] = tmp;
    }   
}
```

### `Merge Sort`

- Asmyptotic Runtime Complexity: O( n log(n) )
- Asmyptotic Space Complexity: O( n )

The merge sort algorithm recursively splits the array into halves into it is down in n 1-sized arrays. I then **merges**
the arrays back together in sorted order.

This is usually regarded as a superior method to bubble, insertion, and selection sorts. However, it is important to
note its space requirements, which could be worrisome for large data. Merge sort is a stable sorting method.

### `Quick Sort`

- Asymptotic Runtime Complexity: average --> O( n * log(n) ), worst case --> O( n² )
- Asmyptotic Space Complexity: O( log (n) )

Using a randomly chosen pivot:
![Quick Sort](https://raw.githubusercontent.com/dwaro/SWE-Interview-Prep/master/media/quick-sort.png)

Quick Sort is a recursive algorithm, where we pivot around a randomly chosen element in the array. All elements
smaller than the pivot element move to the left side of the array, and all elements larger than the pivot move to the
right side of the array.

With an average runtime of n*log(n) and a space complexity of log(n), quicksort can be an attractive sorting option.
However, it is important to note that because the randomly chosen partition may not noecessarily be the median, we
can run into inefficiencies, causing our sorting to be slow and on quadratic terms.

Quick sort is not a stable sorting method.

### `Radix Sort`

- Asmyptotic Runtime Complexity: O( k * n ) where n is the number of elements and k is the number of digits of the
largest number to sort (the number of sweeps needed)
- Asymptotic Space Complexity: O( n + r ) where r is the range of the input

Unlike most of the other sorting algorithms, radix sort does not use a comparison based approach, instead, it utilizes
integers to sort bits. The idea of this algorithm is to do digit by digit sorting and it utilizes counting sort to do the
heavy lifting. One way to implement this is to move from the least significant bit (the 1s place for integers) to the
most significant bit.

e.g. Values = [34, 12, 59, 52, 132, 98, 46, 77, 105, 260, 4]

--> 1st pass (sort by 1s place) [260, 12, 52, 132, 34, 4, 105, 46, 77, 98, 59]

--> 2nd pass (sort by 10s place) [105, 4, 12, 132, 34, 46, 52, 59, 260, 77, 98]

--> 3rd pass (sort by 100s place) [4, 12, 34, 46, 52, 59, 77, 98, 105, 132, 260] --> sorted

```java
public static void radixSort(int[] values) {
    if (values != null && values.length > 1) {
        int max = getMax(values);

        int maxLength = String.valueOf(max).length();

        radixSort(values, maxLength);
    }
}
    
// Gets the max number in an array of integers.
public static int getMax(int[] values) {
    int max = Integer.MIN_VALUE;

    for (int num: values) {
        if (num > max)
            max = num;
    }

    return max;

}
    
// Overloaded helper method to do the heavy lifting counting sorting for the radix sort.
public static void radixSort(int[] values, int passes) {

    // take a pass for each digit of the max number
    for (int i = 0, divisor = 1; i < passes; i++, divisor *= 10 ) {
        int[] tmp  = new int[values.length];
        int[] counting = new int[10];

        // populate counts
        for (int num: values) {
            counting[ (num / divisor)  % 10 ]++;
        }

        // change counts to actual output positions
        for (int j = 1; j < 10; j++)
            counting[j] += counting[j-1];

        // now update tmp
        for (int j = values.length - 1; j >= 0; j--) {
            tmp[counting[ (values[j] / divisor) % 10 ] - 1] = values[j];
            counting[ (values[j]/divisor) % 10 ]--;
        }

        // copy output from tmp back into values
        for (int z = 0; z < values.length; z++)
            values[z] = tmp[z];
    }
}
```


### `Counting Sort`

### `Insertion Sort`

### `Heap Sort`

### `Bucket Sort`

# Search

### `Linear Search`

- Asymptotic Runtime Complexity: O( n )

### `Binary Search`

- Asymptotic Runtime Complexity: O( log(n) )

A binary search is similar to how most people intuitively perform a search in everyday lives. For example, let's say we
have a large textbook, and we want to get to page 514. Let's say the textbook is roughly 900 pages, so we start by
opening the book about half way. We first open to page 467. We know we are lower than 514, so we then flip to a
new page in the book, having taken a rough guess of about 50 pages deeper. Let's say we've now ended up on page
525. We now grab a few pages to move backwards and open to 512. At this point, we can just flip two more pages to
reach the goal. This isn't necessarily a binary search, as we are not necessarily reducing the search space in
a binary fashion; however, it shows how a binary search can be a quick process.

To implement a binary search, our data must be sorted. This search uses three tracker variables: low, midpoint, and 
high, each representing an index position of the array. We begin by calculating the midpoint between low (index 0)
and high (index n - 1). If the value at the midpoint is larger than the value we are searching for, then high is changed
to midpoint - 1. If the value at the midpoint is lower than the value we are searching for, then we set low = midpoint
+1. The process of calculating the midpoint is repeated until the value being searched for is found or low is
greater than high.

```java
public static int binarySearch(int[] values, int val) {
    // edge cases
    if (values.length == 0 || values == null) return -1;
    if (values.length == 1) return 0;

    int low = 0;
    int high = values.length - 1;
    int mid;

    // loop until values[mid] == val or low > high
    while (low <= high) {

        mid = (high - low ) / 2 + low;

        // val is to the right
        if  (values[mid] < val)  low = mid + 1;

        // val is to the left
        else if (values[mid] > val) high = mid - 1;

        // we found the val
        else return mid;
    }

    // error in finding the value
    return -1;
}
```

### `Depth First Search (DFS)`

### `Breadth First Search (BFS)`

### `Binary Search Tree`

## Heap's Algorithm

Heap's algorithm is used to generate all permutations.

```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> output = new ArrayList<List<Integer>>();
    generatePermutations(nums, nums.length, output);
    return output;
}

private void generatePermutations(int[] arr, int size, List<List<Integer>> output) {
    
    // size becomes 1 we add the permutation to the output
    if (size == 1) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num: arr) list.add(num);
        output.add(list);
    }

    for (int i=0; i<size; i++) { 
        generatePermutations(arr, size-1, output); 

        // size is odd, swap first and last element 
        if (size % 2 == 1) { 
            int temp = arr[0]; 
            arr[0] = arr[size-1]; 
            arr[size-1] = temp; 
        } 

        // size is even, swap ith and last element 
        else { 
            int temp = arr[i]; 
            arr[i] = arr[size-1]; 
            arr[size-1] = temp; 
        } 
    }
}
```
