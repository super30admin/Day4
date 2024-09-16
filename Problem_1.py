"""
 Problem 1: Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

"""


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
         """
        Finds the upper and lower bounds of the
        occurance of target in the list
        Itype: list, target(int) 
        rtype: list [lower_bound, upper_bound]
        """
        #edge cases
        if nums == []:
            return [-1,-1]
        
        #First calculating the lower_range 
        lower_range = self.find_range(nums, target, True)
        if lower_range == -1:
            return [-1, -1]
        
        #Calculating upper range
        upper_range = self.find_range(nums, target, False)
        
        return [lower_range, upper_range]
        
        
        
    def find_range(self, nums, target, left_bound):
        """
        Helper funtion: find the extreme limits of the range the target
        occures in the list. 
        Itype: list, target(int) and boolean to determine upper or lower
        bound calculation
        rtype: res(int)
        """
       
        start, end = 0, len(nums)-1
        while start <= end:
            mid = (start + end )//2
            if nums[mid] == target:
                #if it is the lower_bound we will skip the right side of the range
                if left_bound:
                    if mid == start or nums[mid -1] < target:
                        return mid
                    end = mid -1
            
                else:
                    # for upper bound skip the left side of the range
                    if mid == end or nums[mid +1] > target:
                        return mid
                    start = mid+1
                    
            elif nums[mid] > target:
                end = mid -1 
            else:
                start = mid +1
                
        return -1
            
    #       Time Complexity: O(log n), where n is the number of elements in the list
    #       Space Complexity: O(1)