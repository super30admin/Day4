class Solution:
    def first_index(self, nums, target):
        low_f = 0
        high_f = len(nums) - 1
        mid_f = -1
        
        while(low_f <= high_f):
            mid_f = (low_f + high_f)//2
            
            if nums[mid_f] == target:
                
                # Check if middle element is first index of the element
                if nums[mid_f - 1] < target:
                    
                    return mid_f
                
            if nums[mid_f] >= target:
                high_f = mid_f - 1
            else:
                low_f = mid_f + 1
        return -1
    
    def last_index(self, nums, target):
        low_l = 0
        high_l = len(nums) - 1
        mid_l = -1
        print("new low: ", nums[low_l])
        
        while(low_l <=  high_l):
            mid_l = (low_l + high_l)//2
            
            if nums[mid_l] == target:
                # Check if mid+1 element is greater than the target or not
                if nums[mid_l + 1] > target:
                    return mid_l
            
            if nums[mid_l] >= target:
                high_l = mid_l - 1
            else:
                low_l = mid_l - 1
        return -1
        
    
    def searchRange(self, nums: List[int], target: int):
        if len(nums) == 1 :
            if nums[0] == target:
            
                return [0,0]
            else:
                return [-1, -1]
        
        print("target : ", target)
        result = []
  

        # Binary search 
        # Perform 2 binary searches to find 1st index of target and last index of target
        
        # 1st binary search
        
        first_binary_search = self.first_index(nums, target)
        if first_binary_search == -1:
            return [-1,-1]
        # print(first_binary_search)
        # print(nums[first_binary_search:])
        result.append(first_binary_search)
    
        last_binary_search = self.last_index(nums[first_binary_search:], target)
        
        
        # Last position for element in sorted array
        result.append(first_binary_search + last_binary_search)
        return result
                
            
            
        
        
 
        
            
        
                
            
        
        
        
        
        
        
        
                
        
        