# Time Complexity : O(log n) 47ms //Based on leetcode runtime
#  Space Complexity : O(1) 14.2 //Based on leetcode
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        
        #if start element is smaller than the end we have reached to our original array
        if nums[0] <= nums[right]:
            return nums[0]
        
        #Do binary serach to acquire the desired element
        while (left <= right):
            mid = (left + right) // 2
            
            #The below two if statements are to check if the minimum value is near mid
            if nums[mid] > nums[mid +1]:
                return nums[mid+1]
            
            if nums[mid-1] > nums[mid]:
                return nums[mid]
            
            #If not then adjust the lower or upper bound
            if(nums[mid] > nums[0]):
                left = mid + 1
            else:
                right = mid - 1
        return nums[left]
        