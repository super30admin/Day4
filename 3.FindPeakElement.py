'''
Time Complexity: 0(log n)
Space Complexity: 0(1)
Approach:
    1. Perform binary search to find the potential peak
    2. If the mid value isnt the peak, move towards the direction that has "largest" value in comparison to the current mid index value.
    Moving towards such direction will help you find the potential "peak".
    3. Return the "index", not the peak value.
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        low = 0
        high = len(nums) - 1
        
        
        while low <= high:
            
            mid = (high-low)//2 + low
            
            # get the left and right value for the current mid
            lft_val = 0
            rt_val = 0
            
            if mid-1 == -1:
                lft_val = float("-inf")
            else:
                lft_val = nums[mid-1]
                
            
            if mid+1 == len(nums):
                rt_val = float("-inf")
            else:
                rt_val = nums[mid+1]
            
            
            # perform the peak search
            if (lft_val < nums[mid] > rt_val):
                # my peak -- return index only
                return mid
            
            elif lft_val > nums[mid]:
                # move towards the highest value
                high = mid - 1
            
            elif nums[mid] < rt_val:
                # move towards the highest value
                low = mid + 1
        
        '''end of while loop'''
        
        # won't reach here anyhow ....
                
                