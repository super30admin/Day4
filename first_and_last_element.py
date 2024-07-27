# Approach : Find the indexes separate in two binary searches 
# Time Complexity : O(logn)+O(logn)
# important cases : for finding last ele we can optimize search by setting first index as low
# if first index -1 then second -1 hi hoga means element nahi hai 
# also check nums should not be empty if empty [-1,-1]

# first check mid == target hai kya nahi then for first index then check mid target se geater ya smaller agr greater h and first index find krna hai then move to left 
# agr mid target se smaller hai and find last index then move towards the right

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # Check if the list is empty
        if not nums:
            return [-1, -1]

        n = len(nums)
        first = self.binary_first(nums, 0, n - 1, target)

        # If the target is not found, return [-1, -1]
        if first == -1:
            return [-1, -1]

        last = self.binary_last(nums, first, n - 1, target)
        return [first, last]

    def binary_first(self,nums,low,high,target):
        while(low<=high):
            mid=low+(high-low)//2
            #if mid == target
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
        