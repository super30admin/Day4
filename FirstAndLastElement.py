#Time Complexity: O(n logn), Since we use binary search
#Space Complexity: O(1)
#approach: Here we find the middle element and compared it with the start and end element from where we can determine weather the left or ringth of the list is sorted or no. Based on the target value we apply binary search and ones 
# we find the target we return the start and end index 

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1, -1]
        if nums[0] == target and nums[len(nums) - 1] == target:
            return [0, len(nums) - 1]
        left = self.binarysearchleft(nums, target)
        if(left == -1):
            return [-1, -1]
        right = self.binarysearchright(nums, target)
        return(left, right)
        

    def binarysearchleft(self, nums: List[int], target: int):
        low, high = 0, len(nums) - 1
        while(low <= high):
            mid = low + (high - low) // 2
            if(nums[mid] == target):
                if(mid == 0 or nums[mid - 1] < nums[mid]):
                    return mid
                else:
                    high = mid - 1
            elif(target < nums[mid]):
                high = mid - 1
                
            else:
                low = mid + 1
        return - 1
    
    
    def binarysearchright(self, nums: List[int], target: int):
        low, high = 0, len(nums) - 1
        while(low <= high):
            mid = int(low + (high - low) // 2)
            
            if(nums[mid] == target):
                if(mid == len(nums) - 1 or nums[mid + 1] > nums[mid]):
                    return mid
                else:
                    low = mid + 1
            elif(target < nums[mid]):
                high = mid - 1

            else:
                low = mid + 1
        return - 1