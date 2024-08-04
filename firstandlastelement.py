# Time Complexity : O(logn)+O(logn)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # Check if the list is empty
        if not nums:
            return [-1, -1]

        n = len(nums)
        first = self.binary_first(nums, 0, n - 1, target)

        if first == -1:
            return [-1, -1]

        last = self.binary_last(nums, first, n - 1, target)
        return [first, last]

    def binary_first(self,nums,low,high,target):
        while(low<=high):
            mid=low+(high-low)//2
            
            if nums[mid]==target:
                #check here if mid is not = mid-1 then there that element is at first index
                if mid==0 or nums[mid]!=nums[mid-1]:
                    return mid
                # otherwise keep searching in left side 
                high=mid-1
            #if mid is not equal to target
            elif nums[mid]>target:
                    # if mid is > target then move high to mid -1
                    high=mid-1
            else:
                    low=mid+1
        return -1

    def binary_last(self,nums,low,high,target):
        while(low<=high):
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid == len(nums)-1 or nums[mid]!=nums[mid+1]:
                    return mid
                low=mid+1
            elif nums[mid]>target:
                    high=mid-1
            else:
                    low=mid+1
        return -1