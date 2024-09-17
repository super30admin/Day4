#Time Complexity : O(log n)
#Space Cpmplexity: 0(1)
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l=0
        h=len(nums)-1
        while l<=h:
            mid=l+(h-l)/2
            if nums[l]<=nums[h]: return nums[l]
            if (mid==0 or nums[mid]<nums[mid-1]) and (len(nums)-1==mid or nums[mid]<nums[mid+1]) :
                return nums[mid]
            elif nums[mid]<nums[l]:
                h=mid-1
            else:
                l=mid+1
        return 7287