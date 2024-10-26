#// Time Complexity : O(log(n)): log(m) + log(n) since we are using binary search twice
#// Space Complexity : O(1) : No aux space used
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this :  Not much. Felt Code is too lengthy. Maybe reduce to 1 function.


#// Your code here along with comments explaining your approach in three sentences only
# We do 2 binary searches to find the first and last element.
# we also need to consider if it is an empty array
# also make sure if target is in array or not. 


class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:

        if len(nums) == 0:                                                  # empty array
            return [-1,-1]
        first = self.binarySearchFirst(nums, target, 0,len(nums)-1)         # element not in array
        if first == -1: 
            return [-1,-1]
        
        last = self.binarySearchLast(nums, target, 0, len(nums)-1)          # no need to check twice
        return [first,last]
    
    def binarySearchFirst(self, nums: list[int], target, low, high):        # binary search for first term
        while low <= high:

            mid = low + (high-low)//2 # find mid
            if nums[mid] == target:    #if  mid is target 
                if (mid == 0 or nums[mid] != nums[mid-1]):                  # check if left of mid is not eq to mid
                    return mid                                          
                else:
                    high = mid -1
            elif  nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
            
    def binarySearchLast(self, nums: list[int], target, low , high):   # binary search for last term
        while low <= high:

            mid = low + (high-low)//2                                  # find mid
            if nums[mid] == target:                                    # if  mid is target 
                if (mid == high or nums[mid] != nums[mid+1]):          # check if right of mid is not eq to mid
                    return mid
                else:
                    low = mid + 1
            elif  nums[mid] > target:                           
                high = mid - 1
            else:
                low = mid + 1
        return -1


#testing
arr = [5,6,6,6,7,7,8,9,9]
target = 6
x = Solution().searchRange(arr,target)
print(x)
    



    
