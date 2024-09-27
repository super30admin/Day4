#Time Complexity : Same as Binary Search O(log N)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes                                                                                                             
# Any problem you faced while coding this : No 
#Similar to Binary search find the mid element and identify the part of array which is sorted and check if the least element in the sorted side smaller than the boundries of the other side of the array. 
#If its smaller we can return that element else we can do a binary search in the other side.
class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        low=0
        high=len(nums)-1
        
        if (len(nums) == 0 or nums == None):
            return -1

        if len(nums) == 1:
            return nums[0]
        
        while(low<=high):
            mid = (low + high)//2
            
            if nums[high] > nums[0]:
                return nums[0]
            
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]

            if nums[mid - 1] > nums[mid]:
                return nums[mid]

            if nums[mid] > nums[0]:
                low = mid + 1

            else:
                high = mid - 1