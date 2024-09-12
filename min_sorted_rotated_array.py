#Time Complexity :  O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no



class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l =0 
        h = len(nums)-1
        
        if nums[0] <nums[h]: #check if starting element is less than ending element , then means its not rotated or rotated len times
            return nums[0]
        
        while l<h:  #shouldnt check == case it runs to infinte loop
            mid = l+(h-l)//2
            if nums[mid]>nums[h]:  # check if mid is > right, i.e pivot is in right side which is basically minimum
                l = mid+1
            else:
                h = mid
        return nums[l]