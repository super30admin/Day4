
class FindPeaksJ{
    //this is the follow up question from class over find peak in array.
    //the problem can also be named as local Maximas

    //[1,2,3,2,1,-1,3,4,2,3,3,3] --> local maximas is [3,4,3]
    //[1,1,2,2,2,2]--> local maximas is [2]
    //[1,3,2,4,4,4,4] --> local maximas is [3, 4]

    //observation: 1) first element if it is greater than second element then it is a peak
    //              2) last element if it is greater than second last element then it is a peak
    //              3) In case of a plateau where the we have a spike in graph but after that a constant,
    //                  then the start of the plateau is the peak.

/*  this code does not handle plateau
    private static List<Integer> findPeaks(int[] nums){
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        if (nums.length < 4) return list;

        //first check first element if it is greater than second element;
        if (nums[0] > nums[1]){
            list.add(nums[0]);
        }
        //check last element, if it is greater than second last element.
        if (nums[nums.length-1] > nums[nums.length-2]){
            list.add(nums[nums.length-1]);
        }

        for (int i = 1; i < nums.length-1; i++){
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                list.add(nums[i]);
            }
        }
        return list;
    }
*/
    //this code will take care of plateau
    private static List<Integer> findPeaks(int[] nums){

        List<Integer> list = new ArrayList<>();

        boolean leftIncrease = true;
        if (nums.length == 1){
            list.add(nums[0]);
            return list;
        }
        for (int i = 1; i < nums.length-1; i++){
            if (arr[i-1] > arr[i]){
                list.add(arr[i-1]);
                leftIncrease = false;
            }
            else if(arr[i-1] < arr[i]){
                leftIncrease = true;
            }
        }
        //plateau case
        if (leftIncrease){
            list.add(nums[nums.length-1]);
        }

        return list;
    }

    //time complexity will be O(n)
    //I am also thinking about binary search in this.
    /*
    Thought process: peak finding algorithm will always return first peak element of the array.
    As soon as we find the first peak, we will shrink the array and then apply same logic for the rest
    of the array.
     */

}