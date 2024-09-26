#Running time complexity: O(logn) 
#Space time complexity: Constant or O(1)
class Solution:
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        high = len(nums)-1
        low = 0
        
        l = leftbinarySearch(nums,low,high,target)
        if l == None:
            return [-1,-1]
        r = rightbinarySearch(nums,l,high,target)
        return [l,r]
    
def leftbinarySearch(nums,low,high,target):
    while low<=high:
        mid = int(low+(high-low)/2)
        if nums[mid]==target:
            if mid == 0 or nums[mid-1]<nums[mid]:
                return mid
            else:
                high = mid -1
            
        elif nums[mid]<target:
            low = mid +1
        else:
            high = mid-1
def rightbinarySearch(nums,low,high,target):
    while low<=high:
        mid = int(low+(high-low)/2)
        if nums[mid]==target:
            if mid == len(nums)-1 or nums[mid+1]>nums[mid]:
                return mid
            else:
                low = mid + 1
            
        elif nums[mid]<target:
            low = mid +1
        else:
            high = mid-1    
    
    