#Time complexity: O(log(n))
#Space complexity: O(1)
#Ran on leetcdoe: Yes
# The solution uses a binary search approach. We first find the left occurrence of the target. Ad then we fid the 
# right occurrence of the target and return the result.
class Solution:
    def find_first(self,nums,target):
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=(low+high)//2
            if(nums[mid]==target):
                if((mid==0 or nums[mid-1]<target) and (mid==len(nums)-1 or nums[mid+1]>=target)):
                    return mid
                else:
                    high=mid-1
            elif(nums[mid] <target):
                low=mid+1
            else:
                high=mid-1
        return -1
    def find_last(self,nums,target):
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=(low+high)//2
            if(nums[mid]==target):
                if((mid==0 or nums[mid-1]<=target) and(mid==len(nums)-1 or nums[mid+1]>target)):
                    return mid
                else:
                    low=mid+1
            elif(nums[mid]>target):
                high=mid-1
            else:
                low=mid+1
                
        return -1
    def searchRange(self, nums,target):
        left=self.find_first(nums,target)
        if(left==-1):
            return [-1,-1]
        right=self.find_last(nums,target)
        L=[]
        L.append(left)
        L.append(right)
        return L
s=Solution()
nums = [5,7,7,8,8,10]
target=8
print(s.searchRange(nums,target))