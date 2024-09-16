# O(log(n)) time and O(1) space
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        ranges = [-1,-1]
        self.binarySearch(nums,ranges,target,True)
        if ranges[0] != -1:
            self.binarySearch(nums,ranges,target,False)
        return ranges
    
    def binarySearch(self,nums,ranges,target,isLeft):
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                if isLeft:
                    ranges[0] = mid
                    if mid-1 >= 0 and nums[mid-1] != target:
                        break
                    else:
                        right = mid - 1
                else:
                    ranges[1] = mid
                    if mid + 1 < len(nums) and nums[mid+1] != target:
                        break
                    else:
                        left = mid + 1
            elif target < nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
                
                
                
            
        
        