# Time Complexity :O(Log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : part for low = mid i didn't take into consideration that the mid might be the lowest


# Your code here along with comments explaining your approach
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums)-1
        while low <= high:
            #if low <= high and this is the first place or position before it is bigger than low return low
            if nums[low] <= nums[high] and(low == 0 or nums[low-1] > nums[low]):
                return nums[low]
            mid = low + (high-low)//2
            # if mid less then high
            if nums[mid] < nums[high] :
                #check  the one before mid is less , high is mid-1 search the part before mid
                if(mid !=0 and nums[mid -1] < nums[mid]):
                    high = mid -1
                    continue
                #check check if mid is the least one or if it is in right part of array
                else:
                    low = mid
                    continue
            else :
                #if mid >= high and high < low search the right part of array for least
                if nums[high] < nums[low]:
                    
                    low= mid+1
                    continue
                # else search left part
                else:
                    high = mid-1
        
        return nums[0]        
            