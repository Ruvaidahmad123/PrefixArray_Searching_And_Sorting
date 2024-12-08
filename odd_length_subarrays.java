class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            //all left subarray having that element
           int left_subarray=i+1;
            //all right subarray having that element
           int right_subarray=n-i;
           //total subarrays having that element
           int total_subarray=left_subarray*right_subarray;
           //now each element should contribute in odd length subarrays so possible odd length subarray would be (total+1)/2 and element would be contributing to each of them

        //    eg {1, 2, 3, 4} totalsubarrays{ n=1 n=2 total oddlength  subarray=1  n=3 n=4 total oddsubarray 2  sly total odd length subarray=(n+1)/2 }
           int contribution=(total_subarray+1)/2;
           sum+=contribution*arr[i];
        }
        return sum;
    }
}
