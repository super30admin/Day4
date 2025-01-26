# Time Complexity : O(log n)
# Space Complexity :o(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Your code here along with comments explaining your approach in three sentences only

# edge cases like if the array is empty or if the target is not in the range of array return [-1,-1]
# find first occurrence of the target in the array by doing BS, if mid is found and the left of mid is not target then return mid
# else go left and if nums[mid] > target also go left else go right
# similarly for the last occurrence of the target do bs, if mid is found and the right of mid is not target then return mid
# else go right and if nums[mid] > target also go left else go right

class Solution:
    #bs to find the first occurrence of target
    def bsfirst(self,nums: List[int], low: int, high: int, target: int) ->int:
        while(low <= high):
            mid = low + (high - low)//2
            if nums[mid] == target: # if target is found and left of it is not equal to that return that mid
                if mid == 0 or nums[mid] != nums[mid-1]:
                    return mid
                else: # else go left
                    high = mid -1
            elif nums[mid] > target: # if nums[mid] > target go left
                high = mid - 1
            else:   # else go right
                low = mid + 1
        return -1

    #bs to find the last occurrence of target
    def bslast(self,nums: List[int], low: int, high: int, target: int) ->int:
        n = len(nums)
        while(low <= high):
            mid = low + (high - low)//2
            if nums[mid] == target: # if target is found and right of it is not equal to that return that mid
                if mid == n-1 or nums[mid] != nums[mid+1]:
                    return mid
                else: # else go right
                    low = mid +1
            elif nums[mid] > target: # if nums[mid] > target go left
                high = mid - 1
            else: # else go right
                low = mid + 1
        return -1


    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        if (n == 0 or nums == None): #if array is null return -1,-1
            return [-1,-1]
        if target < nums[0] or target > nums[n-1]: # if target is not in the range in array return -1,-1
            return [-1,-1]
        
        first = self.bsfirst(nums,0,n-1,target) #bs to find the first occurrence of target
        if(first == -1):
            return [-1,-1]
        last = self.bslast(nums,first,n-1,target) #bs to find the last occurrence of target
        return [first,last]