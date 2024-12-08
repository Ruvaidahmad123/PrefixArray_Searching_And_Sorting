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
