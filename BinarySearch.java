class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right)
        {
            int mid = left + (right - left) / 2;
            if(target < nums[mid])
            {
                right = mid;
            }
            else
            {
                left = mid;
            }
        }
        return target == nums[left] ? left : target == nums[right] ? right : -1;
    }
}
