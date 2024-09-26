class Solution:
    def findMin(self, nums: List[int]) -> int:
       
    
        
        
        def search(nums):
            low = 0
            high = len(nums)-1

            if nums[low]<=nums[high]:
                return 0
            
            
            while low<=high:

                mid = low + (high-low)//2
                if nums[mid]>nums[mid+1]:
                    return mid+1

                else:
                    if nums[mid]<nums[low]:
                        high = mid-1
                    else:
                        low =mid +1
                    
                    
        i = search(nums)
        
        
        return min(nums[0], nums[i])
        
        
