class Solution {
    boolean sieve[];
    int pre[];
    void calSieve(int r){
        sieve=new boolean[r+1];
        Arrays.fill(sieve,true);
        sieve[1]=false;
        sieve[0]=false;
        for(int i=2;i*i<=r;i++){
            if(sieve[i])
            for(int j=i*i;j<=r;j+=i){
                sieve[j]=false;
            }
        }
    }
    void calPre(){
        pre=new int[sieve.length+1];
        pre[0]=0;
        pre[1]=0;
        for(int i=2;i<sieve.length;i++){
            if(sieve[i]==true){
                pre[i]=pre[i-1]+1;
            }
            else pre[i]=pre[i-1];
        }
    }
    int countPrimes(int L, int R) {
        // code here
        calSieve(R);
        calPre();
        return pre[R]-pre[L-1];
    }
};
