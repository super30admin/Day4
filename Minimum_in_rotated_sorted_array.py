#time:O(logn)
#space:O(1)
#LeetCode: Accepted
#Problem Faced:what should i return
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #if arraylength is 0 the return None
        if len(nums)==0:
            return None
        #if the array is already sorted then return the first element
        if nums[0]<=nums[len(nums)-1]:
            return nums[0]
        s=0
        e=len(nums)-1
        while(s<e):
            mid=s+(e-s)//2
            #comparing mid element with the last element if the mid element is bigger then the last element then we have a pivot in this half
            if nums[mid]>nums[e]:
                s=mid+1
            #otherwise we find the pivot in the other half
            else:
                e=mid
        return nums[s]
                