class Solution {
    public int findMin(int[] nums) {

        int min =0;
        int max= nums.length-1;
        int len = nums.length;

        if(nums[min] <= nums[max]) {
            return nums[min];
        }

        while (min <= max) {
            int mid = (min+max)/2;

            if (nums[mid] <= nums[(mid+1)%len] && nums[mid] <= nums[(mid - 1 + len) % len]) {
                return nums[mid];
            }
            if (nums[mid] > nums[max]) {//unsorted
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return -1;
        
    }
}

