package sliding_window;

public class No1343 {

    public static int numOfSubarrays(int[] arr, int k, int threshold) {

        int result = 0;
        int sum = 0;
        for (int right = 0; right < arr.length; right++) {
            sum  +=arr[right];

            int left = right - k + 1;
            if (left < 0) {
                continue;
            }
            double avg = (double) sum /k;
            if(avg >= threshold){
                result++;
            }
            sum -=arr[left];

        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{2,2,2,2,5,5,5,8},3,4));
        System.out.println(numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3},3,5));
    }


}
