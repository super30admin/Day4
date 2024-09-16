class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int left = 0;
        int right = size(nums) - 1;
         vector<int> result(2);
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        return result;   //to store the start and end index
    }

    public:
        int findStartingIndex(vector<int>& nums, int target){
            int index = -1;
            int start = 0;
            int end = size(nums) - 1;

            while (start <= end){
                int mid = start + (end - start) /2;
                if (nums[mid] >= target){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }

                if (nums[mid] == target) index = mid;
            }
            return index;
        }


        int findEndingIndex(vector<int>& nums, int target){
            int index = -1;
            int start = 0;
            int end = size(nums) - 1;

            while (start <= end){
                int mid = start + (end - start) /2;
                if (nums[mid] <= target){
                    start = mid + 1;
                }else{
                    end = mid -1;
                }

             if (nums[mid] == target) index = mid;
            }

            return index;
        }

};
