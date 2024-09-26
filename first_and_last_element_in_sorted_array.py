# Time Complexity: O(log(n))
# Space Complexity: O(1)
class Solution:
    def binarysearchleft(self, nums: List[int], target: int) ->int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid= low+(high-low)//2
            if nums[mid]==target:
                if mid==0 or nums[mid-1]<nums[mid]:
                    return mid
                else:
                    high=mid-1
            elif nums[mid]<target:
                low=mid+1
            else:
                high=mid-1
        return -1
    def binarysearchright(self, nums: List[int], target: int) ->int:
        low=lowright
        high=len(nums)-1
        while low<=high:
            mid= low+(high-low)//2
            if nums[mid]==target:
                if mid==len(nums)-1 or nums[mid+1]>nums[mid]:
                    return mid
                else:
                    low=mid+1
            elif nums[mid]<target:
                low=mid+1
            else:
                high=mid-1
        return -1
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums==None or len(nums)==0: return [-1,-1]
        if nums[0]>target or nums[len(nums)-1]<target: return [-1,-1]
        global lowright
        left=self.binarysearchleft(nums,target)
        if left==-1:
            return [-1,-1]
        lowright=left
        right=self.binarysearchright(nums,target)
        return [left,right]
        