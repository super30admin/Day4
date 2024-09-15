# Binary-Search-2
Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

****
Approach:
1. Perform binarySearch to get to the target.
   Once we get to the target, perform binarySearch on the lhs of the list to get the lowest
   
   Possible value of lowest
   -1 , mid, -1<index<mid-1
	
2. Once we get the lowest, perform binarySearch on the rhs to get the highest.
   Our low = lowest as we will be traversing the remaining rhs half of the array

   Possible value of highest
   -1 , mid, mid+1<index<len(nums)
  
3. Later return [lowest,highest]

Time Complexity 
2 * 0(logn) ==== 0(logn)

Since we ignore constants it's 0(logn)
****

## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0

**********
Approach:

1. Decide a pivot/target; generally we select last element.
2. If target<A[mid]
	2.1. perform recursive binarySearch on the LHS
	2.2. If a MATCH, return the index position
	2.3. If not a MATCH, -1 will be returned
	2.4. If -1 is returned, now perform recursive binarySearch on the RHS
3. If target>A[mid]
	3.1. Our target here is greater than the mid
	3.2. Update the target to A[mid]
	3.3. Once done; update the high == mid and do a recursive binary search
4. We will return index if out target == A[mid]
**********


## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 

             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.

****
Approach: 
1. Find the mid
2. If arr[mid] > arr[mid-1] and arr[mid] > arr[mid+1]; return the mid
3. Else perform binarySearch on lhs if arr[mid]<arr[mid-1]
4. Or perform binarySearch on rhs if arr[mid]<arr[mid+1]
5. Take care for border case i.e. we have [0] i.e. 1 element only

Time Complexity 0(logn)
****
