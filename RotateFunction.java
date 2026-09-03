class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length,sum = 0;
        long fn = 0,max = 0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
            fn += (i * nums[i]);
        }
        max = fn;
        for(int last = n-1;last>0;last--){
            fn = fn-(nums[last]*(n-1)) + (sum-nums[last]); 
            max = Math.max(max,fn);
        }
        return (int)max;
    }
}