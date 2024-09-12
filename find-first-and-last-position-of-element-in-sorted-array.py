# Reference Video: https://youtu.be/OE7wUUpJw6I
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        #Assign default values to return when there is no target found in the array
        start_index = -1
        end_index = -1
        
        #Binary search left and right assignment
        left = 0
        right = len(nums) - 1
        
        #Binary search to find the starting element equal to target
        while (left<=right):
            mid = left + (right-left) // 2
            #when we find nums[mid] == target, assign mid to start_index
            #check the left side again by moving right to mid - 1 for the previous occurence
            if nums[mid] == target:
                start_index = mid
                right = mid - 1
            elif target <= nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
        
        #Binary search left and right assignment
        left = 0
        right = len(nums) - 1
        
        
        #Binary search to find the ending element equal to target
        while (left<=right):
            mid = left + (right-left) // 2
            #when we find nums[mid] == target, assign mid to end_index
            #check the right side again by moving left to mid + 1 for next occurence
            if nums[mid] == target:
                end_index = mid
                left = mid + 1
            elif target <= nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
            
        
        return [start_index, end_index]
    
        