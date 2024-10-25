"Generally we can use two functions seperately to get the first and last occurence"
"But instead what we can do is since, the operation is going to be very same, we can use same function and add a check if of boolean"
"What is this boolean here in this case is isfirst checks if we are trying to get the first or last occurence"

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def helperfunction(nums:List[int], target:int, isfirst: bool) -> int:
            start = 0
            end = len(nums)-1
            position = -1

            while start <= end:
                mid = (start + end) // 2

                if nums[mid] == target:
                    position = mid
                    if isfirst:
                        end = mid - 1
                    else:
                        start = mid + 1
                elif nums[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1

            return position
        
        firstoccurence = helperfunction(nums, target, True)
        secondoccurence = helperfunction(nums, target, False)

        result = [firstoccurence, secondoccurence] 

        return result