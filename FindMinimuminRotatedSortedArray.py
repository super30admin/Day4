
# T.C. - O(N) - N is number of elements in the array
# S.C. - O(1)


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        l=0
        h=len(nums)-1
        
        while(l<=h):
            if(nums[l]<=nums[h]):
                return nums[l]
            mid=(l+h)//2
            if (mid==0 or nums[mid-1]>nums[mid]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            elif (nums[l]>nums[mid]):
                h=mid-1
            else:
                l=mid+1
                
        return 0