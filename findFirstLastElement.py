'''
Time Complexity: O(log n) as O(2 log n ) -> becoz of two binary searches = O(log n)
Space Complexity: O(1) Constant Space as no extra space is being Allocated
Leetcode: Two-Function: Sucess! One-function: not Successful!

//Problems: Facing problem with One-function optimization: my idea is to store it in a list and then return the list but it is currently
storing only one value, as shown in the output.

|-> I'd really appreciate if you could point me to direction or point out where I might be going wrong?

'''


class Solution:
    def searchRange(self, nums, target):

        # Sanity check to check whether the list passed is not None or empty
        if nums == None or len(nums)==0:
            return [-1,-1]

        # Check-point for whether the target lies in the range of the list
        if nums[0] > target or nums[len(nums)-1]<target:
            return [-1,-1]

        first = self.BSfirst(nums, target)
        last = self.BSlast(nums, target)
        return [first,last]

    def BSfirst(self,nums,target):
        low = 0
        high = len(nums) - 1
        while low<=high:
            mid = low + (high - low)//2
            if(nums[mid]==target):
                if (mid==0 or nums[mid]>nums[mid-1]):
                    return mid
                else:
                    high = mid - 1
            elif nums[mid]>target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def BSlast(self, nums, target):
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if (nums[mid] == target):
                if (mid == len(nums)-1 or nums[mid] < nums[mid + 1]):
                    return mid
                else:
                    low = mid + 1
            elif nums[mid]<target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
"""
ONE FUNCTION OPTIMIZATION:
 
class Solution:
    def searchRange(self, nums, target):

        # Sanity check to check whether the list passed is not None or empty
        if nums == None or len(nums)==0:
            return [-1,-1]

        # Check-point for whether the target lies in the range of the list
        if nums[0] > target or nums[len(nums)-1]<target:
            return [-1,-1]

        low = 0
        high = len(nums) - 1
        r = []
        while low<=high:
            mid = low + (high - low)//2
            if(nums[mid]==target):
                if mid==0 or nums[mid]>nums[mid-1]:
                    r.append(mid)
                else:
                    high = mid - 1

                if mid==len(nums)-1 or nums[mid]<nums[mid+1]:
                    r.append(mid)
                else:
                    low = mid - 1
            elif nums[mid]>target:
                high = mid - 1
            else:
                low = mid + 1
            return r
        return -1
        
OUTPUT: The target  7  is found at  [2]
"""

nums = [5,7,7,8,8,10]
target = 7
'''
nums = [5,7,7,8,8,10]
target = 6
nums = []
target = 0
'''
s = Solution()
pos = s.searchRange(nums,target)
print("The target ",target," is found at ",pos)
