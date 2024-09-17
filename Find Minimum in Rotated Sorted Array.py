'''Time complexity - O(log(n))
Space Complexity - O(1)'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        h = len(nums)-1
        
        while(l<=h):
            mid = l + ((h-l)//2)
            if(nums[mid]<nums[mid-1]):
                return nums[mid]
            if(nums[mid]>nums[h]):
                l = mid+1
            else:
                h = mid-1
        return nums[l]