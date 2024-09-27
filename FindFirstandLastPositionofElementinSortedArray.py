class Solution:
    
    def binarySearchFirst(self, nums : List[int], target : int) -> int:
        l = 0 
        h = len(nums)-1
     #   print("1st if ",type(l),type(h))
            
        
        while(l<=h): 
            mid = int(l+(h-l)/2)
     #      print("mid ",mid)
            if(nums[mid]==target):
                if(mid==0 or nums[mid-1] < nums[mid]):
      #              print("first - if1")
                    return  mid
                else:
                    h = mid - 1
       #                 print("111 ",h,l,mid)
            elif nums[mid] > target:
                h = mid-1
       #         print("elif1 ",h,l,mid)

            else: 
                l = mid+1
        #        print("elif2 ",h,l,mid)
            
        return -1

    def binarySearchSecond(self, nums : List[int], target : int, first) -> int:
        l = first
        h = len(nums)-1
        #print("2nd if ",l,h)

        while(l <= h):
            mid = int(l+(h-l)/2)
         #   print("mid ",mid)

            if(nums[mid]==target):
                if(mid== len(nums)-1 or nums[mid+1] > nums[mid]):
          #          print("second - if1")
                    return  mid
                else:
                    h = mid + 1
           #             print("222 ",h,l,mid)
            elif nums[mid] > target:
                h = mid-1
            #    print("elif1 ",h,l,mid)

            else: 
                l = mid+1
             #   print("elif2 ",h,l,mid)
            
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        
        if(nums is None or len(nums) == 0):
            return [-1,-1]
        
        #smallest element is greater than target or 
        #largest element is smaller than target
        if (nums[0]>target) or (nums[len(nums)-1]<target):
            return [-1,-1]
            
        first_grp = self.binarySearchFirst(nums,target)
        if first_grp == -1:
            return [-1,-1]
        second_grp = self.binarySearchSecond(nums,target,first_grp)
        
        return[first_grp,second_grp]
        
        
