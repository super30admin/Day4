# Time compliexity: O(log n)
# Space Complexity: O(1)
# Ran on Leetcode: Yes
# No issues faced

# Approach Description:
# - using two binary searches for first occurence and the last
# - since the array is sorted, we know that if an element is the target, and if if's left element is not same as target, then that element is the first occurence
# - similarly, if nums[mid] == target and the next element is not, then mid is the last occurence
# - in other cases we perform normal binary search, where on the bases of values bring greater or smaller than target we choose to move left or right


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        def firstPositionSearch(nums, target):
            low = 0
            high = len(nums) - 1
            
            if target == nums[low]:
                    return low

            while(low <= high):
                # calculating mid
                mid = low + (high - low) / 2

                if nums[mid] == target:
                    # check if it's the first occurence
                    if nums[mid - 1] != target:
                        # this means mid is the first occurence
                        return mid
                    else:
                        # left element is also target, we have to move left
                        high = mid - 1
                
                else:
                    # mid is not same as target
                    if nums[mid] > target:
                        # move left
                        high = mid - 1
                    else:
                        # move right
                        low = mid + 1

            return -1
        
        def lastPositionSearch(nums, target):
            low = 0
            high = len(nums) - 1

            if (nums[high] == target):
                return high
            
            while low <= high:
                mid = low + (high - low) / 2
                if nums[mid] == target:
                    # check if it's the last occurence
                    if nums[mid + 1] != target:
                        # mid is the last occurence
                        return mid
                    else:
                        # next occurence is also same as target
                        # we will have to move right to find the last occurence
                        low = mid + 1
                else:
                    # mid element is not same as target
                    # so we check which side to move
                    if (nums[mid] > target):
                        # move left
                        high = mid - 1
                    else:
                        # move right
                        low = mid + 1

            return -1

        if len(nums) == 0:
            return [-1, -1]

        n = len(nums) - 1
        if (target < nums[0] or target > nums[n]):
            return [-1, -1]

        first = firstPositionSearch(nums, target)
        if first == -1:
            return [-1,-1]
        
        last = lastPositionSearch(nums, target)

        return [first, last]

        