class Solution(object):
    def firstoccur(self,list_arr,key):
      start=0
      end=(len(list_arr)-1)
      fs=-1
      while start<=end:
        mid=start+(end-start)//2
        if key==list_arr[mid]:
          fs=mid
          end=mid-1
        elif key<list_arr[mid]:
          end=mid-1
        elif key>list_arr[mid]:
          start=mid+1
      return fs

    def lastoccur(self,list_arr,key):
      start=0
      end=(len(list_arr)-1)
      ls=-1
      while start<=end:
        mid=start+(end-start)//2
        if key==list_arr[mid]:
          ls=mid
          start=mid+1
        elif key<list_arr[mid]:
          end=mid-1
        elif key>list_arr[mid]:
          start=mid+1
      return ls
    
    def searchRange(self, list_arr, key):
        first=self.firstoccur(list_arr, key)
        last=self.lastoccur(list_arr, key)
        return first,last
    

        