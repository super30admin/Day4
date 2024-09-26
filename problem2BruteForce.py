"""
Time Complexity : O(nlogn) where n is the number of elements in the array.
                  This complexity is the complexity for search algorithm
                  
Space Complexity : O(1), no auxillary data structure is use

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
1. Brute force: 
    Sort the array and return the first element. 

2. Brute Force:
    a. minimum = -inf
    b. Loop through the element and find the minimum
Time Complexity: O(n) where n is the number of elements in the array
Space Complexity: O(1) as no auxillary data structure is use
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return -1
        nums.sort()
        return nums[0]

#Brute Force-2
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return -1
        minimum = float('inf')
        for num in nums:
            minimum = min(num, minimum)
        return minimum
"""