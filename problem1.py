"""
Time Complexity : O(2logn) where n is the number of elements in the input array.
                  2logn as we are perfroming binary search twice.
Space Complexity : O(1), no auxillary data structure is use

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Brute force: 
Use linear search and find the first and last occurance. 
Time Complexity: O(n) where n is the number of elements in the input array. And O(n) because we need to iterate through all the elements
Space Complexity: O(1) No auxillary data structure is used

Binary Search:
1. Perform the binary search and find the mid element.
2. Continue the binary search until we get mid == target
3. Once we get the mid == target, check if it a first occurance, (nums[mid] > nums[mid]-1)
   If it is a first occurance, return the mid.
   If it is not then perform binary search on left space
4. If no element is found for first occurance, then element is not present in the input array so return [-1,-1]
5. Otherwise, continue to find the last occurance by perfroming binary search from firstOccurance to len(nums)-1
6. At the end return index of first and last occurances
"""
class Solution:
    def binarySearchFirst(self,nums, target):
        low = 0
        high = len(nums) - 1
        
        while(low <= high):
            mid = (low + high) // 2
            
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
    def binarySearchLast(self, nums, target, low, high):
        while(low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid+1] > nums[mid]:
                    return mid
                else:
                    low = mid+1
            elif nums[mid] < nums[low]:
                low = mid+1
            else:
                high = mid - 1
        return -1
            
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        if nums[0] > target and nums[len(nums)-1] < target: 
            return [-1,-1]
        first = self.binarySearchFirst(nums, target)
        print(first)
        if first == -1:
            return [-1,-1]
        last = self.binarySearchLast(nums, target, first, len(nums)-1)
        
        return [first, last]