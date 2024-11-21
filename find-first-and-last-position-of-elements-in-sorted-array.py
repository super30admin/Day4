# Time Complexity : log(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Yes, in edge cases

class Solution:
    def leftsearchRange(self, nums: List[int], target: int) -> List[int]:
        low=0
        high=len(nums)-1
        while low<=high:           
            mid=low+high-low//2
            if nums[mid]>target:
                high=mid-1
            elif nums[mid]<target:
                low=mid+1
            elif nums[mid]==target:          
                if mid==0 or nums[mid-1]<nums[mid]:
                    return mid
                else:
                    high=mid-1
        return -1
   
    def rightsearchRange(self, nums: List[int], target: int) -> List[int]:
        print("rightnums", nums)
        low=0
        high=len(nums)-1
        while low<=high:           
            mid=low+high-low//2
            if nums[mid]>target:
                high=mid-1
            elif nums[mid]<target:
                low=mid+1
            elif nums[mid]==target:
                if mid==len(nums)-1 or nums[mid+1]>nums[mid]:
                    return mid
                else:
                    low=mid+1
        return -1   
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:  
        low=0
        high=len(nums)-1
        print("hi")
        if len(nums)==0:
            return [-1,-1]
        if nums[0]>target or target>nums[len(nums)-1]:
            return [-1,-1]                   
        print("@@@@")
        while low<=high:           
            mid=low+high-low//2
            if nums[mid]>target:
                high=mid-1
            elif target>nums[mid]:
                low=mid+1
            elif nums[mid]==target:
                left_idx=self.leftsearchRange(nums,target)
                right_idx=self.rightsearchRange(nums,target)
                if right_idx==-1 or left_idx==-1:
                    return [-1,-1]
                return [left_idx,right_idx]
        return [-1,-1]