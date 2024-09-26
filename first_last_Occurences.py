class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        first = self.firstOccurence(nums, target, 0 , len(nums)- 1)
        last = self.lastOccurence(nums, target, 0, len(nums) - 1)
        
        return [first, last]
    
    
    
    def firstOccurence(self, nums, target, start, end) :
        
        while (start <= end) :
            
            mid = start + (end - start) // 2
            
            if nums[mid] == target :
                # previous element is smaller than the mid value , so mid will be the first occurence
                if start == mid or nums[mid - 1] < nums[mid] : 
                    print(mid, start)
                    return mid
                
                # If the previous element is same as value at mid
                else :
                    # do binary search in left region
                    end = mid - 1
                    
            
            # Move to left region
            elif nums[mid] > target :
                end = mid - 1
            
            # Move to right region
            else :
                start = mid + 1
                
        return -1
    
    
    def lastOccurence(self, nums, target, start, end) :
        
        while (start <= end) :
            
            mid = start + (end - start) // 2
            
            if nums[mid] == target :
                # next element is greater than the mid value , so mid will be the last occurence
                if end == mid or nums[mid + 1] > nums[mid] : 
                    return mid
                
                # If the next element is same as value at mid
                else :
                    # do binary search in right region
                    low = mid + 1
                    
            
            # Move to left region
            elif nums[mid] > target :
                end = mid - 1
            
            # Move to right region
            else :
                start = mid + 1
                
        return -1