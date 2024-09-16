class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
     
        left=self.binary_search(nums,target,True)
        right=self.binary_search(nums,target,False)
        return [left,right]
    
    
    def binary_search(self,nums,target,leftbais):
        low,high=0,len(nums)-1
        i=-1
        while low<=high:
            mid=(low+high)//2
            if target>nums[mid]:
                low=mid+1
            elif target<nums[mid]:
                high=mid-1
            else:
                i=mid
                if leftbais:
                    high=mid-1
                else:
                    low=mid+1
        return i    