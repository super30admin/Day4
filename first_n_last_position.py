# // Time Complexity : # we will have O(logn) complexity
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
class Solution:
    def searchRange(self, nums, target) :
        #we will take 2 valrialebe to check the statrt and end index of target element in the array
        
        start= self.helperBinarySearch(nums,target,True)
        end=self.helperBinarySearch(nums,target,False)
        return [start,end]
    
        
        
        #we will define a helper function which will help to apply modified binary search
        
        #to check whether the start positio in left of right we use a boolean vriable which basically sets to true if we have start index at left and false in other case
    def helperBinarySearch(self,nums,target,checkleft):
        s=0
        e=len(nums)-1
            #this will store the current index 
        i=-1
        while s<=e:
            mid=e+s//2
                
            if nums[mid]>target:
                e=mid-1
                    
            elif nums[mid]<target:
                s=mid+1
                
                #when mid==target
            else:
                i=mid
                    #left is true
                if checkleft:
                        #set the end to mid -1
                    e=mid-1
                else:
                        #set the start to mid + 1
                    s=mid+1
        return i
                    