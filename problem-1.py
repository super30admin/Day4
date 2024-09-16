#Time Complexity: O( 2 log n)~ O(log n)
#Space Complexity: O(1)
#Problem sucessfully accepted in leetcode: yes
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = 0
        end = len(nums)-1
        first = self.firstindex(nums, start, end, target)
        second = self.secondindex(nums, start, end, target)
        return [first,second]
#Binary search the array to get the first occurrence index of target  
    def firstindex(self, nums, start, end, target):
        res = -1
        while(start<=end):
            mid = start+(end-start)//2
#Update the index everytime we find mid, and chech if target occurs before current index
            if nums[mid]==target:
                res = mid
                end =mid-1
            elif nums[mid]>target:
                end =mid-1
            else:
                start = mid+1
        return res
#Binary search the array to get the first occurrence index of target 
    def secondindex(self, nums, start, end, target):
        res = -1
        while(start<=end):
            mid = start+(end-start)//2
#Update the index everytime we find mid, and chech if target occurs before current index
            if nums[mid]==target:
                res=mid
                start = mid+1
            elif nums[mid]>target:
                end = mid-1
            else:
                start = mid+1
        return res