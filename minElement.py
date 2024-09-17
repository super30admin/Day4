"""
Intuition: We have to the search for the minimum element inside a rotated sorted array.

A rotated sorted array can have:
1) Either one of its halfs as sorted
2) Can have both of its halfs sorted.

A min element is always present in the half which is not sorted.

If both the halfs are sorted and the right half is search everytime, we know that the min is present at the middle.
#####################################################################
Time Complexity : O(logn) where n = number of elements
Space Complexity : O(1)
#####################################################################

"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        

        low = 0
        high = len(nums) -1
        
        while low <= high:
            
            mid = (low + high) //2
            
            #Checking for base case where min is found. 
            if (mid == 0 or nums[mid] < nums[mid -1] ) and (mid == len(nums)-1 or nums[mid] < nums[mid +1] ):
                return nums[mid]
            
            #Checking if the right half is sorted.
            if nums[mid] < nums[high]:
                high = mid -1
            else:
                low = mid + 1
        return 