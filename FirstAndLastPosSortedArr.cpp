// Time Complexity - It is O(logn) for both the functions findLast() and findFirst() since we are using Binary search to find the element and reducing the search space by half in every iteration.
// Space Complexity - It is O(n) since it depends on the number of elements in the array. Is my answer correct for Space complexity?
// Problems Faced - No!
// It runs on Leetcode.

class Solution {
    private:
    int lowForLast;
    vector<int> answer =  vector<int> (2, -1);
  
    // This function takes in a vector and a target value and finds the last index of the target in the vector.
    // We use binary search. To refine our search space we use the fact the array is sorted and based on the value at "mid" we move our "low" and "high" with respect to the value of "target".
    // If we find the element we make sure that it is the last by checking if the element to the right of it is greater.
    int findLast(vector<int>& arr, int target){
            int low = lowForLast;
            int high = arr.size() - 1;
            
            while(low <= high){
                int mid = low + (high - low)/2;
                if(arr[mid] == target){
                    if(mid == (arr.size() - 1) || arr[mid] < arr[mid + 1])
                        return mid;
                    else
                        low = mid + 1;
                }
                else if(arr[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return -1;
        }
    
    // This function takes in a vector and a target value and finds the first index of the target in the vector.
    // We use binary search. To refine our search space we use the fact the array is sorted and based on the value at "mid" we move our "low" and "high" with respect to the value of "target".
    // If we find the element we make sure that it is the first by checking if the element to the left of it is lesser.
     int findFirst(vector<int>& arr, int target){
            int low = 0;
            int high = arr.size() - 1;
            
            while(low <= high){
                int mid = low + (high - low)/2;
                if(arr[mid] == target){
                    if(mid == 0 || arr[mid] > arr[mid - 1])
                        return mid;
                    else
                        high = mid - 1;
                }
                else if(arr[mid] > target){
                    high = mid - 1;
                }
                else
                    low = mid + 1;
            }
            return -1;
        }
    
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size() == 0)
            return answer;
        if(nums[0] > target || nums[nums.size() - 1] < target)
            return answer;
        int first = findFirst(nums, target);
        if(first == -1)
            return answer;
        lowForLast = first;
        int last = findLast(nums, target);
        answer[0] = first;
        answer[1] = last;
        return answer;
    }
};
