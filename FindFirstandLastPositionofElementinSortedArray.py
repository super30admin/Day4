# T.C. - O(log N) N is the element
# S.C. - O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        
        first=self.BinarSearchFirst(nums, target)
        if first == -1:
            return [-1,-1]
        second=self.BinarSearchSecond(nums,target)
        return [first,second]
        
    def BinarSearchFirst(self,nums,target):
        low=0
        high=len(nums)-1
        
        while(low<=high):
            mid=(low+high)//2
            if nums[mid]==target:
                if mid==0 or (mid!=0 and nums[mid-1]!=target):
                    return mid
                else:
                    high=mid -1
            elif(target<nums[mid]):
                high=mid-1
            else:
                low=low+1
        return -1
                
    def BinarSearchSecond(self,nums,target):
        low=0
        high=len(nums)-1
        
        while(low<=high):
            mid=(low+high)//2
            if nums[mid]==target:
                if mid==len(nums)-1 or (mid!=len(nums)-1 and nums[mid+1]!=target):
                    return mid
                else:
                    low = mid +1
            elif(target<nums[mid]):
                high=mid-1
            else:
                low=mid+1
        return -1