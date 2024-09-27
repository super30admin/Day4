# Time Complexity : O(log n)  Since Binary search operation                                                                                                                                      
# Space Complexity :O(1)                                                                                                                                       
# Did this code successfully run on Leetcode : Yes                                                                                                             
# Any problem you faced while coding this : No 
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if len(nums) == 0:
            return [-1,-1]
        
        if (target<nums[0] or target>nums[len(nums)-1]):
            return [-1,-1]
        
        def binary_search_first(nums,target):
            low=0
            high=len(nums)-1
            
            while(low<=high):
                mid = (low+high) // 2
                
                if (target==nums[mid]):
                    if (mid==0 or nums[mid-1]<nums[mid]):
                        return mid
                    elif (nums[mid-1]==nums[mid]):
                        high = mid - 1
                elif (target>nums[mid]):
                    low = mid + 1
                else:
                    high = mid - 1
            return -1
        
        def binary_search_last(nums,target):
            low=0
            high=len(nums)-1
            
            while(low<=high):
                mid = (low+high) // 2
                
                if (target==nums[mid]):
                    if (mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                        return mid
                    elif (nums[mid+1]==nums[mid]):
                        low = mid + 1
                elif (target>nums[mid]):
                    low = mid + 1
                else:
                    high = mid - 1
            return -1
        a = binary_search_first(nums,target)
        b = binary_search_last(nums,target)
        return [a,b]