"""
LC:34
// Time Complexity :O(log n) using Binary search
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :NA
// Any problem you faced while coding this :Getting maximum recursion
depth exceeded while calling a Python object for some input
"""
class Solution:
  def __init__(self):
    self.lindx,self.rindx=-1,-1

  def getIndex(self,arr,l,h,target):
    mid = int(l+(h-l)/2)

    if len(arr) == 0 or arr is None:
      return None

    if l > h:
      return None

    if arr[mid] == target:
      return mid
    elif target < arr[mid]:
      return self.getIndex(arr,l,mid-1,target)
    else:
      return self.getIndex(arr,mid+1,h,target)

  def getLidx(self,arr,l,h,target):
    #Search the left of the mid for lindx
    mid = int(l+(h-l)/2)

    if arr[mid] == target:
      return mid
    elif target < arr[mid]:
      return self.getLidx(arr,l,mid-1,target)
    else:
      return self.getLidx(arr,mid+1,h,target)

  def getRidx(self,arr,l,h,mid):
    #Search the right of the mid for rindx
    mid=int(l+(h-l)/2)

    if arr[mid] == target:
      return mid
    elif target<arr[mid]:
      return self.getRidx(arr,l,mid-1,target)
    else:
      return self.getRidx(arr,mid+1,h,target)


if __name__=="__main__":
  arr=[4,5,7,7,8,8,10]
  target=4
  l=0
  h=len(arr)-1
  s=Solution()
  m=s.getIndex(arr,l,h,target)
  #print("pivot=",m)

  if m is None:
    print([-1,-1])
  else:
    if arr[m-1]<arr[m]:
      print("low index=",m)
    else:
      print("low index=",s.getLidx(arr,l,m-1,target))
    if m!=len(arr)-1 and arr[m]<arr[m+1]:
      print("high index=",m)
    else:
      print("high index=",s.getRidx(arr,m+1,h,target))


#Brute force
#T:O(n)
"""
def getIndex(nums,target):
  res=[]
  arr=nums
  for i in range(len(nums)):
    j=i+1
    if arr[i]==target and j<len(arr) and arr[j]==target :
      res.append(i)
      res.append(i+1)
      return res
  res=[-1,-1]
  return res
"""
