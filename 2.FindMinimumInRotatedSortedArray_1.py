'''
Time Complexity: 0(log n)
Space Complexity: 0(1)
Approach: 
    1. Perform binary search on the rotated sorted array
    2. Initialize minimum to the last element in the array
    3. Potentially update the tgt to the minimum value during binary search and update the range conditionally.
    4. At the end of the binary search, you will be left with the tgt that points to the lowest value in the array
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        
        tgt = nums[-1]
        
        low = 0
        high = len(nums)-1
        
        while(low <= high):
            mid = (high-low)//2 + low
            
            if nums[mid] <= tgt:
                
                # update the tgt
                tgt = nums[mid]
                
                # check on the lhs now 
                high = mid - 1
            
            elif nums[mid] > tgt:
                
                if(nums[low] <= nums[mid] and tgt < nums[low]):
                    # sorted array lhs, check in rhs
                    low = mid + 1
                
                else:
                    high = mid - 1
        '''end of while loop'''
        
        return tgt
                
        