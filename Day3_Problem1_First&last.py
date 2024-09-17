'''
Time complexity: O(log n) where n is the index and log is of base 2.
Space complexity: O(1) constant time complexity
Executed in Leetcode: Yes finally
Challenges while coding: I kept getting an error in Leetcode until i set the boundary conditions of target less than first element and 
greator than last (which i had already set in sanity check) inside the function itself. I understood why I was wrong. Thanks Yash for the
detailed example in group.

Comments: We find the index of the rightmost occurence of the number to find the 'end index' and rightmost index of the previous number
to add one and obtain the 'start index'. If a number is missing or absent, it would merely return where it can be inserted in the array.
Here, both start index and end index will be same and we can return the prescribed result (-1,-1). While coding, after sanity check, 
a function was defined to find the rightmost index of any number, present or missing in the sorted array. Boundary conditions ensured 
that a number less than the first element (smallest in the array), returned -1 and any number equal to or greator than the last 
element/largest element returned the index of the last element.

'''
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # Sanity check for no array and target clearly absent (lesser than first element and greator than last element in the sorted array)
        if not nums or (target<nums[0]) or (target>nums[-1]):  
            return [-1,-1]
        
        # Search for the rightmost index - for value present (case 1) or missing in the array(case 2) 
        def rightmost(nums, target):
            
            # Initialize parameters
            left,right = 0, len(nums)-1
            
            if target < nums[0]:     # Using function for target -1 may lead us outside the array
                return -1
            if target >= nums[-1]:     # Else at last digit, nums[middle+1] will give runtime error
                return len(nums)-1
            
            # Create a loop that iterates until the middle value is the result
            while (left<=right):
                middle = left+(right-left)//2     # Takes care of integer overflow problem
                if (nums[middle] <= target) and (target < nums[middle+1]):
                    return middle
                                        
                elif nums[middle] <= target:
                    left = middle + 1
                    continue
                else:
                    right =  middle - 1
                    continue  
            return -1
        
        # Find the first and last position
        start = rightmost(nums, target-1) 
        end = rightmost(nums, target)
        
    
        if start != end:              # Case 1
            return [start+1,end]
        else:                         # Case 2
            return [-1,-1]
            
  
