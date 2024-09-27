# avg TC O(log n )
# SC O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def binarySearch(nums, target):
            start = 0
            end = len(nums) - 1
            
            while start <= end:
                mid = start + (end - start)//2
                if nums[mid] == target:
                    return mid 
                elif nums[mid] < target:
                    start = mid + 1
                elif nums[mid] > target:
                    end = mid -1
            return -1
        
        ind1 = binarySearch(nums, target)
        
        if ind1 != -1:
            left_index = ind1

            while ( (left_index - 1 >= 0) and nums[left_index - 1] == target):
                left_index = left_index - 1


            r_index = ind1

            while ( r_index + 1 <= len(nums) - 1 and nums[r_index + 1] == target):
                r_index = r_index + 1
            
            return left_index, r_index
        else:
            return -1, -1
        