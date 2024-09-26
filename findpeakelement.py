# T.C. - O(log N) N is the element
# S.C. - O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        h=len(nums)-1
        
        while (l<=h):
            mid=l+h//2
            if (mid-1 < 0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            elif (mid != 0 and nums[mid-1]>nums[mid]):
                high=mid-1
            else:
                low=mid+1
                
        return 564839