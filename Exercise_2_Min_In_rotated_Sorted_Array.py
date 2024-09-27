#Time Complexity: log(n)
#Space Complexity: O(1)


class Solution:
    def findMin(self, nums: List[int]) -> int:#O(log n)
        l=0
        h=len(nums)-1
        while l<h:
            if nums[l]<nums[h]:return nums[l]
            mid=(l+h)//2
            if (mid==0 or nums[mid]<nums[mid-1]) and nums[mid]<nums[mid+1]:
                return nums[mid]
            if nums[mid]>nums[h]:
                l=mid+1
            else:
                h=mid-1
        return nums[l]