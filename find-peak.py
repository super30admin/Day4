"""
Runtime Complexity:
O(log n)- runtime for binary search is O(log n). In this algorithm, we calculate the mid and we check whether the mid is greater than the previous and the next element and if that's the case
then we return the mid element. If the next element to mid is greater than mid then we move to right side by updating low to mid+1 else we move to left side by updating
high to mid-1. This is done because we have more chance of finding the peak element in the subarray of greater elements than smaller elements.
Space Complexity: O(1) - constant time, as no extra data structure is used to compute the solution.
Yes, the code worked on leetcode.
"""



class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums)==1:
            return 0
        low =0
        high = len(nums)-1
        while(low<=high):
            mid = (low +(high-low)//2)
            
            
            if ((mid-1 < low or nums[mid] > nums[mid-1]) and
            (mid+1 > high or nums[mid]> nums[mid+1])):
                return mid
                
            else:
                if mid + 1> len(nums) or nums[mid +1] > nums[mid]:
                    low = mid+1
                else:
                    high = mid-1
        return mid
