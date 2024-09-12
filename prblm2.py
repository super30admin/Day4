class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #O(logN) divide and search
        #O(1)
        l=0
        h=len(nums)-1
        while l<=h:
            m=l+((h-l)//2)
            #12345
            if nums[l]<nums[h]:
                return nums[l]
            #45612
            if (m==0 or nums[m]<nums[m-1]) and (m==h or nums[m]<nums[m+1]):
                return nums[m]
            #left half is sorted, probable to find element in unsorted half
            elif nums[l]<=nums[m]:
                l=m+1
            else:
                h=m-1
        return -1