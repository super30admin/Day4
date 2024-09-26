#Time complexity - O(logn) where n = len(nums)
#Space complexity - O(1)

#To get minimum in the rotated sorted array, we compare middle element to right and left element
#If middle element is > right element, we know that right half is increasing and update left index.
#If middle element is <= right element, we dont have the start of sorted half which is the minimum hence
#we search in left half now
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l,r = 0, len(nums)-1
        while l<r:
            mid = (l+r)//2
            if nums[mid]>nums[r]:
                l = mid +1
            else:
                r = mid
        return nums[l]