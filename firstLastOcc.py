class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # If the list is empty or None, return [-1, -1]
        if len(nums)==0 or nums == None:
            return [-1,-1]
        start = 0
        end = len(nums)-1  
        # Find the first occurrence of the target    
        first = self.firstOccurance(start, end, nums,target )
        # If the target is not found, return [-1, -1]
        if first == -1:
            return [-1,-1]
        # Find the last occurrence of the target
        last = self.lastOccurance(start, end, nums,target )
        return [first,last]


    # Find the first occurrence of the target
    def firstOccurance(self,start:int, end:int, nums: List[int],target: int)-> int:
        
        while start <= end:
            mid = start +(end-start)//2 # prevent integer overflow
            if nums[mid] == target:
                if mid == start or nums[mid-1] != target:
                    return mid
                else:
                    end = mid-1
            elif nums[mid] < target:
                start = mid +1
            else:
                end = mid -1
        return -1



    # Find the last occurrence of the target
    def lastOccurance(self,start:int, end:int, nums:List[int], target:int)-> int:
        while start <= end:
            mid = start +(end -start)//2 
            if nums[mid] == target:
                if mid == end or nums[mid+1] != target:
                    return mid
                else:
                    start = mid +1
            elif nums[mid] < target:
                start = mid +1
            else:
                end = mid -1
        return -1

                

        
