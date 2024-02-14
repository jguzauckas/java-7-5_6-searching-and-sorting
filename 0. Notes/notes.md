# Searching and Sorting

Often when we store data in ArrayLists, we want to be able to look through that data and find certain values, or reorganize it to be easier to use.

---

## Searching

While there are many approaches for how to look through an `ArrayList` to find a value, in this course we will only worry about **sequential search**, also known as **linear search**.

The idea of sequential search is straight-forward, just start at the beginning of the `ArrayList` and check each value to see if it is the one you want until you find what you are looking for, or until you have searched the entire `ArrayList` and couldn't find it.

Conveniently, this is extremely similar to the algorithm we covered on identifying if there exists an element with a property. The difference now is that the "property" we are looking for is an exact value (i.e. is the number exactly 5), and instead of just saying `true`, it is there or `false` it is not there, we instead want to say where you can go to get that value if you need it.

Here are the basic steps:
- Iterate over the `ArrayList`.
    - Check if the current value is the value we want.
        - If it is, `return` the current index.
        - If it is not, skip it.
- `return -1` because we did not find the value.

Here is what this could look like from the `NotesSearch1.java` file:

```java
public static int linearSearch(ArrayList<Double> doubleList, double targetValue) {
    for (int i = 0; i < doubleList.size(); i++) {
        if (doubleList.get(i) == targetValue) {
            return i;
        }
    }
    return -1;
}
```

Since objects are slightly different, here is an example with `String` objects from the `NotesSearch2.java` file:

```java
public static int linearSearch(ArrayList<String> strList, String targetValue) {
    for (int i = 0; i < strList.size(); i++) {
        if (strList.get(i).equals(targetValue)) {
            return i;
        }
    }
    return -1;
}
```

Note that the return type `int` did not change between the two examples, since we are always returning an index, which is always an `int`.

---

## Sorting

Sorting is mainly applicable to numerical values, though can be applied to numerical instance variables of objects (i.e., we can sort people by their age).

We will be looking at two different algorithms for searching and sorting: **selection sort** and **insertion sort**.

### Selection Sort

Selection sort is the simpler, yet less efficient of the two sorting algorithms we will look at.

The premise of selection sort is that if we want to get numbers in order, we can keep finding the smallest number in the unsorted part of the list, and swap it with the front-most value, until we've moved all the way through the `ArrayList`.

Here is a visual of what selection sort does:

```
3, 2, 9, 8, 6

Minimum --> 2
Swap 2 with the front value (3)
2, 3, 9, 8, 6

Minimum --> 3
Swap 3 with the front of the remaining values (3 was already at the front of them)
2, 3, 9, 8, 6

Minimum --> 6
Swap 6 with the front of the remaining values
2, 3, 6, 8, 9

Minimum --> 8
Swap 8 with the front of the remaining values (8 was already at the front of them)
2, 3, 6, 8, 9

Last value must already be in the right position
2, 3, 6, 8, 9
```

The general algorithm follows these steps:
- Iterate over the ArrayList:
    - Find the minimum value from your current slot to the end of the ArrayList.
    - Swap the minimum value from its current position to the current slot.

Here is what this would look like in the `NotesSelectionSort1.java` file:

```java
public static void selectionSort(ArrayList<Integer> intList) {
    for (int i = 0; i < intList.size() - 1; i++) {
        int minimum = intList.get(i);
        int indexMin = i;
        for (int j = i; j < intList.size(); j++) {
            if (intList.get(j) < minimum) {
                minimum = intList.get(j);
                indexMin = j;
            }
        }
        intList.set(i, intList.set(indexMin, intList.get(i)));
    }
}
```

We can better understand the algorithm by separating finding the minimum in the rest of the list as its own method. Here is what this would look like from the `NotesSelectionSort2.java` file:

```java
public static int findMinimum(ArrayList<Integer> intList, int start) {
    int minimum = intList.get(start);
    int index = start;
    for (int i = start; i < intList.size(); i++) {
        if (intList.get(i) < minimum) {
            minimum = intList.get(i);
            index = i;
        }
    }
    return index;
}

public static void selectionSort(ArrayList<Integer> intList) {
    for (int i = 0; i < intList.size() - 1; i++) {
        int indexMin = findMinimum(intList, i);
        intList.set(i, intList.set(indexMin, intList.get(i)));
    }
}
```

Interestingly, finding the minimum value for this sorting process is a little bit more complex than it was before, as we need to keep track both of the minimum value and the index we found it at, and the problem really cares more about the index than the value itself.

### Insertion Sort

Insertion sort is a bit more complex than selection sort, but comes with better efficiency (produces the same result faster).

The premise of insertion sort is to take an element, and move it to the left until it is in the right position relative to the elements that are already sorted, then grab the next value and move it to the left, etc. The big difference from selection sort is that we are not swapping elements, we are just shifting which allows values to stay sorted even if they need to be outplaced by smaller values.

Here is a visual of what insertion sort does:

```
3, 2, 9, 8, 6

Current Value --> 2
2 needs to move all the way to the left since it is less than 3.
2, 3, 9, 8, 6

Current Value --> 9
9 does not need to move since it is greater than 3 (the first thing to its left).
2, 3, 9, 8, 6

Current Value --> 8
8 needs to move one position to the left since it is less than 9, but is greater than 3.
2, 3, 8, 9, 6

Current Value --> 6
6 needs to move two positions to the left since it is less than 8, but is greater than 3.
2, 3, 6, 8, 9
```

This algorithm essentially treats values to the left of the current element as already sorted, and values to the right as unsorted, so it sorts the current element into the sorted left side of the list, and now the left side is one larger, and it slowly grows until the whole list is sorted.

The general algorithm follows these steps:
- Iterate over the ArrayList:
    - Find and save the index of the left-most position the current value can go without being less than anything to its left.
    - Remove the current value and insert it to the left-most position found.

Here is what this would look like in the `NotesInsertionSort1.java` file:

```java
public static void insertionSort(ArrayList<Integer> intList) {
    for (int i = 1; i < intList.size(); i++) {
        int index = i - 1;
        while (index >= 0 && intList.get(index) > intList.get(i)) {
            index--;
        }
        intList.add(index + 1, intList.remove(i));
    }
}
```

---

## Informal Runtime Comparisons

We can compare the efficiency of two algorithms by counting how many times given lines of code are executed, referred to as **statement execution counts** to get a sense of **informal runtime comparisons**. If one algorithm has much lower statement execution counts, it could be considered more efficient.

We can compare the efficiency of our two sorting algorithms by providing an example `ArrayList` for them to run on and counting how many times key statements are executed. Let's use the sample `ArrayList` `[5, 2, 4, 6]` with both sorting algorithms:

### Selection Sort

Here is the algorithm from the `NotesSelectionSort1.java` file:

```java
public static void selectionSort(ArrayList<Integer> intList) {
    for (int i = 0; i < intList.size() - 1; i++) {
        int minimum = intList.get(i);
        int indexMin = i;
        for (int j = i + 1; j < intList.size(); j++) {
            if (intList.get(j) < minimum) { // Statement
                minimum = intList.get(j);
                indexMin = j;
            }
        }
        intList.set(i, intList.set(indexMin, intList.get(i)));
    }
}
```

Running this algorithm with `intList` being `[5, 2, 4, 6]`, we count how many times the line marked with the comment `// Statement` is executed!

When the first element `5` is chosen, we evalute the `if` statement for the values `2`, `4`, and `6`, so `3` times. Then the value `2` gets shifted left so the element `5` gets chosen again, and we evalute the `if` statement for the values `4`, and `6`, so `2` times. Then the value `4` gets shifted left, so the element `5` gets chosen again, and we evalute the `if` statement for the value `6`, so `1` time.

Our statement execution count total was `3 + 2 + 1 = 6`.

### Insertion Sort

Here is the algorithm from the `NotesInsertionSort1.java` file:

```java
public static void insertionSort(ArrayList<Integer> intList) {
    for (int i = 1; i < intList.size(); i++) {
        int index = i - 1;
        while (index >= 0 && intList.get(index) > intList.get(i)) { // Statement
            index--;
        }
        intList.add(index + 1, intList.remove(i));
    }
}
```

Running this algorithm with `intList` being `[5, 2, 4, 6]`, we count how many times the line marked with the comment `// Statement` is executed!

When the first element `2` is chosen (this algorithm starts at index `1`), we evalute the `while` statement for the value `5`, so `1` time. Then the value `2` gets shifted left so the element `4` gets chosen, and we evalute the `while` statement for the values `5`, and `2`, so `2` times. Then the value `4` gets shifted left, so the element `6` gets chosen, and we evalute the `while` statement for the value `5`, so `1` time.

Our statement execution count total was `1 + 2 + 1 = 4`.

### Outcome

Informally, this suggests that insertion sort is more efficient than selection sort, as it ran our statement less times. The statements here were purposely picked to be run the most out of any sections of the algorithms.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
