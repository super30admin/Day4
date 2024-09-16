#Time Complexity : O(log n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no



def FindFirstOccurence(nums,start,end,target):  #function to find the first position in the array
    first =-1      #initiating the first position as -1 as default
    if nums[start] == target:
        return start   #checking if first index is itself a target, then return the first index
    while start <= end:
        mid = start + (end-start)//2     #calculate the mid value
        if mid > 0 and nums[mid]==target and nums[mid-1] != target:   #when checking for the first position, check whether mid is greater than first index, then mid equals the target and element before mid must not be the target
            first = mid  #then assign mid to the first position
            break
        elif nums[mid] >= target: #now check if mid element is greater than or equal to target, then shift the left pointer to index before mid
            end = mid - 1 
        else:
            start = mid + 1 #else, then shift the start pointer to index after mid
    return first 

def FindLastOccurence(nums,start,end,target): #function to find the last position in the array
    last =-1  #initiating the last position as -1 as default
    if nums[end] == target:
        return end    #checking if last index is itself a target, then return the last index
    while start <= end:
        mid = start +(end-start)//2  #calculate the mid value
        if mid < len(nums)-1 and nums[mid] == target and nums[mid+1] != target:  #when checking for the first position, check whether mid is lesser than last index, then mid equals the target and element after mid must not be the target
            last = mid #then assign mid to the last position
            break
        elif nums[mid] <= target:  #now check if mid element is lesser than or equal to target, then shift the right pointer to index after mid
            start = mid+1
        else:
            end = mid - 1 #else, then shift the left pointer to index before mid
    return last


class Solution:
    def searchRange(self, nums, target):
        start =0
        end = len(nums) - 1
        l=[]
        if len(nums) == 0:
            return [-1,-1]    
        if len(nums) == 1 and nums[start] == target:
            l.append(start)
            l.append(start)
            return l
            
        firstOccurence = FindFirstOccurence(nums,start,end,target)
        lastOccurence = FindLastOccurence(nums,start,end,target)
        l.append(firstOccurence)
        l.append(lastOccurence)
        return l
