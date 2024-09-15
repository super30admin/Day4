# Time Complexity : log n
# Space Complexity : n
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No major problems. Took me long time to test and fix for all the
# edge-cases. Took me around an hour to finish this one.

# Your code here along with comments explaining your approach
# I use binary search to find if value at mid is greated than start or lower than end and move towards the side
# which is illegal and find the pivot point and then get the next possible element which will be the min.

class Solution:
    def findMin(self, nums):
        length = len(nums)
        if length == 1:
            return nums[0]
        return self.bin_search_pivot(nums, 0, length-1)
    
    def bin_search_pivot(self, nums, start, end):
        while start < end:
            mid = start + (end-start) // 2
            print(start, mid, end)
            if nums[mid] > nums[end]:
                start = mid+1
            elif nums[mid] < nums[start]:
                end=mid-1
            else:
                return nums[start]
        return min(nums[start], nums[start+1])

if __name__ == "__main__":
    s = Solution()
    nums = [3,4,5,1,2]
    print(s.findMin(nums))