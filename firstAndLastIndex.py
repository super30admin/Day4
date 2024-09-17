"""
Intuition: We have to the target value twice. Hence, we apply binary search twice.

We reduce our search space by 2 by focusing on either the left or right half.
#####################################################################
Time Complexity : O(2* log (n)) where n = number of elements
Space Complexity : O(1)
#####################################################################

"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        low = 0
        high = len(nums) -1
        goLeft = True
        leftIndex = self.binarySearch(low, high, nums, target, goLeft)
        goLeft = False
        rightIndex = self.binarySearch(low, high, nums, target, goLeft)
        finalRange = [leftIndex, rightIndex]
        return finalRange if leftIndex != -1 and rightIndex != -1 else [-1,-1]
    
    def binarySearch(self, low, high, nums, target, goLeft):
        
        while low <= high:
            
            mid = (low+ high)//2
            
            if nums[mid] == target:
                #Going left to search for the first index
                if goLeft:
                    if mid == 0 or nums[mid] != nums[mid-1]:
                        return mid
                    else:
                        high = mid -1
                #Going right to search for the first index
                else:
                    if mid == len(nums)-1 or nums[mid] != nums[mid+1]:
                        return mid
                    else:
                        low = mid +1
                
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
                
        return -1