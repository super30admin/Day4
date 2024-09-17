'''
Time Complexity: O(n) because you traverse list with n elements
Space Complexity: O(1) Constant space as it doesn't require extra space to store any elements.
Leetcode: Successful 
Problems: yes, made silly mistakes at the sanity check if statement.

'''


class Solution:
    def findPeakElement(self, nums) -> int:
        # Initialize the low and the high values of the list
        low = 0
        high = len(nums)-1

        # Traverse the list
        while(low <= high):
            # Calculate mid
            mid = low + (high - low)//2     # 0 + (6-0)//2 = 3 |2iter>>| 4 + (6-4)//2 = 5

            # [1,2,1,3,5,6,4]  a-1 < a > a+1
            # nums[mid] = 3  mid-1 = 1  mid+1 = 5 (1<3<5) |2iter>>| nums[mid] = 6 mid-1 = 5 mid+1 = 4 (5<6>4)
            
            # check for whether the mid element is the peak and also do a sanity check
            if((mid==0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1])):

                # if yes return the index of the peak element
                return mid          # you get the index of the peak element |2iter>>| true condition -> return mid = 5 nums[mid]=6
                
            # if not then check whether any of the elements on either side are greater than mid as that section would have a high chance of landing at a peak
            if nums[mid] < nums[mid + 1]:       # 3 < 5
            
                # if on the right side of mid re-assign low to mid + 1
                low = mid + 1                   # low = 4 nums[low] = 5
                
            else:
                # if on the left side of mid re-assign high to mid - 1
                high = mid - 1
                
        # if no peak found or out of bounds then return -1
        return -1


s = Solution()
nums = [1,2,1,3,5,6,4]
nums = [1,2,3,1]
nums = [1,2]
peak = s.findPeakElement(nums)
print("The peak is ", nums[peak], " at index ", peak)
