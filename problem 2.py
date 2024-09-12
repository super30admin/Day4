# // Time Complexity :O(logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :YES
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        if high==1:
            return min(nums[0],nums[1])
        # using binary search with a bit of two pointer approach 
        while(low<=high):
            mid=(low+high)//2
            # if element is found as in element is less than left element and less than right element than element is found 
            if (mid==len(nums)-1 or nums[mid]<nums[mid+1]) and (mid==0 or nums[mid]<nums[mid-1]):
                return nums[mid]
            else:
                # checking if all the elements are sorted than just move towards mid-1
                if nums[low]<nums[mid] and nums[mid]<nums[high]:
                    high=mid-1
                else:
                #    we are here means array is rotated than check if we are at first element so we can move right if high is less than current element
                    if mid-1>=0:
                        if nums[high] < nums[mid-1]:
                            low=mid+1
                        else: 
                            # or the other side
                            high=mid-1
                    else:
                        # or the other side 
                        low=mid+1
                    
        