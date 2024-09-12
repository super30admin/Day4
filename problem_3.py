'''https://leetcode.com/problems/find-peak-element/'''

# Time Complexity : O(Log(N)) where N: # of elements in nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        '''
        Given problem conditions: 
            nums[-1] = nums[n] = -∞.
            nums[i] != nums[i + 1] for all valid i.

        Using Binary Search, go to the direction where there is 
        higher valued element. Any sequence of an array is guaranteed to have
        1 peek due to above conditions.
        '''
        if nums == None or len(nums) == 0: return -1
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = int(low+(high-low)/2)
            # 'or' condition evaluates 2nd arg ONLY if first is false
            # simillar for 'and' condition. there are 2 statements tied witrh 'and'
            if (mid == 0 or nums[mid-1] < nums[mid]) and \
            (mid == len(nums)-1 or nums[mid+1] < nums[mid]):  
                return mid
            elif mid != 0 and nums[mid-1] > nums[mid]:
                high = mid-1
            else:
                low = mid+1
                
            
            
        
        
        
        