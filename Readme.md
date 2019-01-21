# Implementation of Four Different Sorting Algorithms  

This repositroy contains the code the four different sorting algorithms, Bubble Sort, Table (Counting) Sort, 
Selection Sort, and Quick Sort. Additionally, the code preforms the sorting algorithm on one of the input 
files given and returns the sorted numbers in an output file as well as provides how long the sorting took.

## Bubble Sort
The code iterates over the set of numbers comparing them in pairs of two. It moves the smaller number in the pair to the right
and the larger number to the left. It repeats this process on the set of numbers until they are all in numerical order.

## Table (Counting) Sort
The code stores every number encountered in the list of numbers into a numerical 1d array, as well as stores the number of times 
the number exists in the array. Then once all the numbers have been registered the algorithm relays the array printing all the 
numbers seen in numerical order and prints them the number of times they were seen in the original input. 

## Selection Sort
The code finds the smallest number in the code, then replaces puts it in the first position of an array, it then repeats 
the process for all the numbers in the input until all numbers have been accounted for and there exists an array filled
with the nputs number in numerical order. 

## Quick Sort 
This version of sorting is most common and known as one of the most efficient. It essentially places a partition in the set 
of numbers and sorts numbers within both sides of the partition. It then runs the same code on both sides on the partition
until 2 new partitions are placed. This process is repeated until the numbers are all sorted in numerical order. 
