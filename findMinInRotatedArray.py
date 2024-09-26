// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        start = 0 
        end = len(nums) - 1 
        
        # The min element will be present in the unsorted region
        
        while (start < end) :
            
            mid =  start + (end - start) // 2
            
            if ((mid == 0 or nums[mid - 1] > nums[mid]) and nums[mid] < nums[mid + 1] ) :
                return nums[mid]
            
            # sorted region is left region. Move towards right unsorted region 
            elif nums[mid] > nums[end] :
                start = mid  + 1
            
            else :
                end = mid - 1
                
        
        return nums[start]