#Time complexity: log n and space complexity : o(1)
class Solution: 
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums)==0:
            return [-1,-1]
        first= self.binarySearchFirst(nums,target)
        if first == -1:
            return[-1,-1]
        last= self.binarySearchLast(nums,target)
        return[first, last]
    
    def binarySearchFirst(self, nums: List[int], target: int) -> int:
        low=0
        high= len(nums) -1
        while low<=high:
            mid= (low+high) // 2
            if target == nums[mid] :
                if(mid==0) or target != nums[mid-1]:
                    return mid
                # move left side 
                else:
                     high =mid-1           
            elif target<=nums[mid]:
                high= mid -1
            else:
                low= mid+1
        return -1
    

    def binarySearchLast(self, nums: List[int], target: int) -> int:
        low=0
        high= len(nums)-1
        while low<=high:
            mid= (low+high) // 2
            if target == nums[mid] :
                if (mid == len(nums) -1) or target != nums[mid+1]:
                    return mid
                # move left side 
                else:
                    low =mid+1
            elif target<=nums[mid]:
                high= mid -1
            else:
                low= mid+1
        return -1
    

        

    