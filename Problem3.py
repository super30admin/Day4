# Python program to Find Peak Element
''' Time complexity : O(log N)
Space Complexity: O(1)


Did this code successfully run on Leetcode : yes
Any problem you faced while coding this :no '''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <=high:
            mid = (low + high) // 2
            if ((mid == low or nums[mid] > nums[mid - 1]) and (mid== len(nums)-1 or nums[mid]> nums[mid+1])):
                return mid
            
            elif (mid> low and nums[mid]< nums[mid-1]): # mid>low -> because mid could go to 0 or low values than 0 .but we do not need case of mid<len(nums)-1 or high as mid could never go beyond high in binary search
                high = mid-1
            else:
                low = mid +1
        return -1
                
