#time complexity: O(log(n))
#space complexity: O(1)
#run on leetcode: yes
#using binary search operation we find the middle index. If the middle index is greater then its left and right 
#neighbor, then return this value that is pointed by the middle index. If not, then move towards a side whose neighbor is greater than 
# nums[mid]. We are guaranteed to find a peek element.
class Solution:
    def findPeakElement(self, nums) -> int:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=(low+high)//2
            if((mid==0 or nums[mid-1]<nums[mid]) and (mid==len(nums)-1 or nums[mid+1]<nums[mid])):
                return mid
            else:
                if(mid!=0 and nums[mid-1]>nums[mid]):
                    high=mid-1
                else:
                    low=mid+1
        return 80980
s=Solution()
nums=[1,2,1,3,5,6,4]
print(s.findPeakElement(nums))