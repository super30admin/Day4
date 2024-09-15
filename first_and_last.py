# Time Complexity : log n
# Space Complexity : n
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No major problems. Yesterday's progblems helped me form an 
#intuition for this one.

# Your code here along with comments explaining your approach
# I use binary search to find the element and then find where arr[i] < arr[i+1] at one end and similar logic at
# the other end. so 2 binary searches i.e 2 * log n

class Solution:
    def searchRange(self, nums, target):
        length = len(nums)
        start = self.bin_search_min(nums, 0, length-1, target)
        end = self.bin_search_max(nums, 0, length-1, target)
        return [start, end]
    
    def bin_search_max(self, nums, start, end, target):
        while start <= end:
            mid = start +((end-start) // 2)
            if nums[mid] > target:
                end = mid - 1
            elif nums[mid] < target:
                start = mid + 1
            else:
                print(mid)
                if mid+1>=len(nums) or nums[mid+1] != target:
                    return mid
                else:
                    start = mid + 1
        return -1
    
    def bin_search_min(self, nums, start, end, target):
        while start <= end:
            mid = start +((end-start) // 2)
            if nums[mid] > target:
                end = mid - 1
            elif nums[mid] < target:
                start = mid + 1
            else:
                if mid<=0 or nums[mid-1] != target:
                    return mid
                else:
                    end = mid - 1
        return -1

if __name__ == "__main__":
    s = Solution()
    nums = [3,4,4,5,1,2]
    print(s.searchRange(nums, 4))