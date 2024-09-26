public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {7,8,9,10,12,13,14};

        int low = 0;
        int high = arr.length - 1;

        while(low <= high){

            int mid = low + (high - low)/2;

            if(arr[0] + mid == arr[mid]){
                // it is on the right index
                //Checking the preceding and the next element

                if(arr[0]+ mid - 1 != arr[mid - 1]){
                    System.out.println("Missing Number:"+ (arr[mid] - 1));
                    break;
                }

                if(arr[0]+ mid + 1 != arr[mid + 1]){
                    System.out.println("Missing Number:"+ (arr[mid] + 1));
                    break;
                }

                low = mid + 1;

            }else{

                high = mid - 1;
            }
        }
    }
}
