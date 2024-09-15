#using two pointer brute force 
#time comp- O(n) 
#space comp-O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start=0
        end=len(nums)-1
        while start<=end:
            if nums[start]==target:
                if nums[end]==target:
                    return [start,end]
                else:
                    end=end-1
            else:
                start=start+1
        return [-1,-1]
        
                
                    
        
