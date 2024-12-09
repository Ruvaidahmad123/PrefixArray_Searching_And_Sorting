class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int pre[]=new int[nums.length];
        pre[0]=0;
        for(int i=1;i<nums.length;i++){
            if((nums[i]%2==1 && nums[i-1]%2==0) || (nums[i]%2==0 && nums[i-1]%2==1))pre[i]=pre[i-1];
            else pre[i]=pre[i-1]+1;
        }
        for(int x:pre)System.out.print(x+" ");
        boolean ans[]=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            if(pre[right]-pre[left]>=1){
                ans[i]=false;
            }
            else{
                ans[i]=true;
            }
        }
        return ans;
    }
}
