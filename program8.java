public static void main(String args[]) {
    int[] arr={3,4,5,1,2};

    System.out.println(min(arr));
}

public static int min(int[] arr) {
    int temp=arr[0];
    for(int i=1;i<arr.length;i++){
        if(arr[i]<temp){
            temp=arr[i];
	            }

    }

	return temp;
	    }