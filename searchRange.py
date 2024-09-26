# Time Complexity : O(logn) 
# Space Complexity :    O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach



def binarySearch(nums,left,right,target) :
    #initialize first and last index to -1,-1 respectively
    pos = [-1,-1]

    #apply BS to find first index of the target (left BS)
    while (left<=right):
        mid = left+(right-left)//2
        
        #if target is found store it's position in the result array and continue through
        #other conditions to check if target is still present in index lower than
        #currently found
        if target==nums[mid]:
            pos[0]= mid
        
        #check on the left side of the mid index 
        if target<=nums[mid]:
            right=mid-1
        else:
            left=mid+1
    
    
    left = pos[0] #optimization 
    right = len(nums)-1
    
    #apply BS to find last index of the target (right BS)
    while(left<=right):
        mid = left+(right-left)//2
        
        #if target is found store it's position in the result array and continue through
        #other conditions to check if target is still present in index hight than
        #currently found
        if target==nums[mid]:
            pos[1]=mid
        
        #check on the right side of the mid index
        if target>=nums[mid]:
            left = mid+1
        else:
            right=mid-1
    
    return pos
    
def searchRange(nums, target) :
    #call binarySearch algo to find the first and last index
    pos = binarySearch(nums,0,len(nums)-1,target)
    
    return pos
    
nums = [6,7,8,8,8,9,10]
target = 8
print(searchRange(nums,target))
