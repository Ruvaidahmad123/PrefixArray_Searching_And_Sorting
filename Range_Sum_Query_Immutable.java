class NumArray {
    int arr[];
    int pre[];
    public void calculate(){
        pre=new int[arr.length];
        pre[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            pre[i]=pre[i-1]+arr[i];
        }
    }
    public NumArray(int[] nums) {
        arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        calculate();
    }
    public int sumRange(int left, int right) {
        return pre[right]-pre[left]+arr[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
