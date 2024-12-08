class Solution {
    public int pivotIndex(int[] nums) {
        int prefix[]=new int[nums.length];
        int suffix[]=new int[nums.length];
        int rs=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=rs;
            rs+=nums[i];
        }
        // for(int x:prefix)System.out.print(x+" ");
        rs=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suffix[i]=rs;
            rs+=nums[i];
        }
        // System.out.println();
        // for(int x:suffix)System.out.print(x+" ");
        for(int i=0;i<nums.length;i++){
            if(prefix[i]==suffix[i]){
                return i;
            }
        }
        return -1;
    }
}


OPTIMIZATION USING TWO VARIABLES
    class Solution {
    public int pivotIndex(int[] nums) {
        int total_sum=0;
        int curr_sum=0;
        for(int x:nums)total_sum+=x;
        for(int i=0;i<nums.length;i++){
            curr_sum+=nums[i];
            int left_sum=curr_sum-nums[i];
            int right_sum=total_sum-curr_sum;
            if(left_sum==right_sum)return i;
        }
        return -1;
    }
}
