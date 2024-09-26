# time complexity = O(log n)
# space Complexity = O(1)
# All test cases passed in Leetcode

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        n = len(nums)
        low = 0
        high = n-1
        
        while(low<=high):
            mid = low + (high-low) // 2
            
            if((mid == 0 or nums[mid] > nums[mid-1]) and ( mid == high or nums[mid] > nums[mid+1])):
                return mid
            elif(mid == high or nums[mid] < nums[mid + 1]):
                low = mid + 1
            else:
                high = mid -1
                
                