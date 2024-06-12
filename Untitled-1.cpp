
// Time Complexity : log(n);
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : binary search
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        
        int n = nums.size();
        if(nums.size() == 0) return -1;
        
        int l = 0;
        int r = n-1;
        
        while(l<=r) {
            int mid = l + (r-l)/2;
            
            if((mid == n-1 || nums[mid]> nums[mid +1]) && (mid == 0 || nums[mid] > nums[mid-1])) {
                return mid;
            } else if (mid != 0 && nums[mid] < nums[mid -1]) {
               r = mid -1; 
            } else {
               l = mid +1;
            }
        }
        
        return -1;
    }
};


// probem first and last
// Time Complexity : log(n);
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : binary search

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
         vector<int> results;
        
        if (nums.size() == 0)  {
            results = {-1,-1};
            return results;
        }
        
        if(target < nums[0] || target > nums[nums.size()-1]) return {-1,-1};
        
        int n = nums.size();
       
        int first = firstOccurrence(nums,target);
        if(first == -1) {
            return {-1,-1};
        }
        int second = SecondOccurrence(nums,target);
        results = {first,second};
        
        return results;
        
    }
    
    
    int firstOccurrence(vector<int> &nums,int target) {
        
        int n = nums.size();
        int l = 0;
        int r = n-1;
        
        while(l<=r){
            
            int mid = l+(r-l)/2;
            cout<<l<<mid<<r<<endl;
            if(nums[mid] == target){
                
                if(mid == 0 || nums[mid] > nums[mid -1]){
                    return mid;
                }else {
                    r = mid -1;
                }
                
            } else if(nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
    
    int SecondOccurrence(vector<int> &nums,int target) {
       int n = nums.size();
        int l = 0;
        int r = n-1;
        
        while(l<=r){
            
            int mid = l+(r-l)/2;
            if(nums[mid] == target){
                
                if(mid == n -1 || nums[mid] < nums[mid + 1]){
                    return mid;
                }else {
                    l = mid +1;
                }
                
            } else if(nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        } 
        return -1;
    }
};

// search in sorted-array in unknown array size.




class Solution {
    public int search(ArrayReader reader, int target) {
     
int low = 0;
int high = 1;

     while(reader.get(high) < target) {
         low = high;
         high = 2*high;
     }

     return binarySearch(reader, target, l,h);
    }


    int binarySearch(ArrayReader reader, int target,int l,int h) {

        while(l<=h){

            int mid = l + (h-l)/2;

            if(reader.get(mid)  == target) {
               return mid; 
            } else if(reader.get(mid) > target) {
               h = mid -1; 
            } else {
               l = mid +1;
             }
            }

            return -1;
        }
    }
}