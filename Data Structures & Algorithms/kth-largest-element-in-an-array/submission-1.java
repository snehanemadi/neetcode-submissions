class Solution {
    //sort -> n log n
    // heap -> N + K log N
    //Quick sort -> O(n) avg, O(n^2)

    //pick a pivot - last element
    //put every element less than pivot into array once you encounter largerer
    //element than pivot dont move p pointer, at one point
    //every elemebt before p is smaller than pivot and after p and before last element
    // will be greater than pivot, then swap pivot with p

    //kth lement length - k can be left of the p or right of the p
    //after every pivot selection, will be placing the pivot at its correct spot
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k ;
        int left = 0, right = nums.length -1;
        while(left < right){
            int pivot = partition(nums, left, right);
            if(pivot < k){
                left = pivot + 1;
            }
            else if(pivot > k){
                right = pivot -1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right){
        int pivot = nums[right], fill = left;
        for(int i=left; i < right ;i++){
            if(nums[i] <= pivot) {
                int temp = nums[fill];
                nums[fill++] = nums[i];
                nums[i] = temp;
            }
        }
        nums[right] = nums[fill];
        nums[fill] = pivot;
        return fill;
    }
}
