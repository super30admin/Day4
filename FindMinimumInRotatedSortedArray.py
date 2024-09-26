class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        left = 0
        right = len(nums) - 1
        result = nums[0]
        
        while left <= right:
            
            # If the entire array is sorted or we reach a state where left and right are at the start and end of the sorted array then insted of finding mid we can just return the left most index
            if nums[left] < nums[right]:
                result = min(result,  nums[left])
                break
            
            mid = (left + right) // 2
            result  = min(result, nums[mid])
            
            # If the left part is sorted then look in the right because the smaller value will always be on the right sorted portion
            if nums[left] <= nums[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return result
    
    # Time Complexity: O(log(n))
    # Space Complexity: O(1)
        