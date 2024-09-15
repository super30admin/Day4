# Time Complexity : log n
# Space Complexity : n
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No major problems. One edge case was giving me trouble but not too much

# Your code here along with comments explaining your approach
# I implemented this as explained in the class. moving towards the bigger number halving the space every time.

class Solution:
    def findPeakElement(self, nums):
        length = len(nums)
        return self.bin_peak_search(nums, 0, length-1)
    
    def bin_peak_search(self, nums, start, end):
        if start <= end:
            mid = start + (end - start) // 2
            length = len(nums)
            if((mid==0 or nums[mid-1]<nums[mid]) and 
               (mid==length-1 or nums[mid+1]<nums[mid])):
                return mid
            else:
                if(mid>0 and nums[mid-1]>nums[mid]):
                    return self.bin_peak_search(nums, start, mid-1)
                elif(mid<length-1 and nums[mid+1]>nums[mid]):
                    return self.bin_peak_search(nums, mid+1, end)
        else:
            return -1

if __name__ == "__main__":
    s = Solution()
    print(s.findPeakElement([1,2]))