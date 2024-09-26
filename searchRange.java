class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums==null || nums.length==0) return new int[]{-1,-1};
        if(nums[0]>target || nums[nums.length-1]<target) return new int[]{-1,-1};


        int first = binaryLeft(nums, target);
        if(first == -1){
            return new int[]{-1,-1}; 
        }
        int last = binaryRight(nums, target);
    


        return new int[]{first,last};
    }


    private int binaryLeft( int [] arr,int x){
        
        int l=0; 
        int h=arr.length-1;
        
        while(l<=h){
            int mid = l+ (h-l)/2;
            
            if(arr[mid] == x){
            if(mid == 0 || arr[mid-1]<x){
                return mid;
                
            }
            else{
                h=mid-1;
            }
        }

        else if(arr[mid]>x){
            h=mid-1;
        }
        else{
            l=mid+1;
        }
        }

        return -1;

    }

    private int binaryRight(int [] arr,int x){
       int l=0; 
        int h=arr.length-1;
      
    
        while(l<=h){
            
            int mid = l+ (h-l)/2;
            if(arr[mid] == x){
            if(mid == arr.length-1 || arr[mid+1]>x){
                 return mid;
            }
            else{
                l=mid+1;
               
            }
            }

            else if(arr[mid]>x){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
            
    }
            return -1;
    }


}