"""
A peak element is an element that is greater than its neighbors.
Time = O(log n)
space = O(1)
Successfully excecuted on leetcode

Approach:
Binary Search
1.Here given array of numbers consists multiple sequence of increasing or decreasing order
2.Find the middle element, compare it with the right neighbor to see if it's in increasing or decreasing subsequence
3.If mid>mid+1 ->peak element lie in left subsequence
4.If mid<mid+1 -> peak element lie in right subsequence

"""

class FindPeak:
    def findPeakElement(self,nums):
        left = 0
        right = len(nums)-1
        while left<right:
            mid = left+(right-left)//2
            if nums[mid]>nums[mid+1]:
                right = mid
            else:
                left = mid+1
        return left
            
        