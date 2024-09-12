// Time Complexity :O(log n) where n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
public:
    int findMin(vector<int>& arr) {
        int sz = arr.size() - 1;
        if(arr.size() == 1) return arr[0];
        int low = 0;
        int high = sz;
        while(low <= high){
            int mid = low + (high-low)/2;
            cout<<mid<<endl;
            if(arr[mid] > arr[mid+1]) return arr[mid+1];   //only at the pivot mid > mid+1
            else if(arr[mid] < arr[mid+1]){         // left sort
                if(arr[mid] < arr[sz]){
                    high = mid-1;    
                }
                else{
                    low=mid+1;                     //right sort
                }
            }
        }
        return arr[0];
    }
};