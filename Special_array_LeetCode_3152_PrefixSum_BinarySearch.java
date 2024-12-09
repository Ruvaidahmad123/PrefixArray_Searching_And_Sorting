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


//Approach-2 (Using 2 pointers)
//T.C : O(n + m)
//S.C : O(n)
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int[] validRightMostIdx = new int[n];
        // validRightMostIdx[i] = j; the rightmost index starting from i which is a special subarray [i..j]

        int i = 0;
        int j = 0;

        while (i < n) {
            if (j < i) {
                j = i;
            }

            while (j + 1 < n && nums[j] % 2 != nums[j + 1] % 2) {
                j++;
            }

            validRightMostIdx[i] = j;
            i++;
        }

        boolean[] result = new boolean[m];

        for (int k = 0; k < m; k++) {
            int start = queries[k][0];
            int end = queries[k][1];

            if (end <= validRightMostIdx[start]) {
                result[k] = true;
            } else {
                result[k] = false;
            }
        }

        return result;
    }
}


class Solution {
    private boolean bSearch(List<Integer> vi, int sp, int ep) {
        int l = 0;
        int r = vi.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (vi.get(mid) < sp) {
                l = mid + 1;
            } else if (vi.get(mid) > ep) {
                r = mid - 1;
            } else {
                // Found a violating index
                return true;
            }
        }

        return false;
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        List<Integer> vi = new ArrayList<>(); // List of violating indices

        for (int i = 1; i < n; i++) { // O(n)
            if (nums[i] % 2 == nums[i - 1] % 2) {
                vi.add(i); // Always in sorted order
            }
        }

        boolean[] result = new boolean[m];

        for (int i = 0; i < m; i++) { // O(m)
            int start = queries[i][0];
            int end = queries[i][1];

            boolean hasViolatingIndexInRange = bSearch(vi, start + 1, end); // O(log(n))

            if (!hasViolatingIndexInRange) { // No violating index found
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}
