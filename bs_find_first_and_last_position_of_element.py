'''
// Time Complexity : O(log(N) + K) K is number of target occurences
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

Reach target through binary search
Go left and right until target repeats and within boundary

'''
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        idx= self.bsi(nums,0,len(nums)-1,target)
        if idx==-1:
            return [-1,-1]
        
        i,j=idx,idx
        while(i>=0 and nums[i]==target):
            i-=1
        
        while(j<len(nums) and nums[j]==target):
            j+=1
        
        i+=1
        j-=1
        
        return [i,j]
        
        
    def bsi(self,arr,l,r,x):
        while True:
            mid=(l+r)//2
            if r>=l:
                if arr[mid]==x:
                    return mid
                elif arr[mid]>x:
                    r=mid-1
                else:
                    l=mid+1
            
            else:
                return -1
