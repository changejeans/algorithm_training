package week02;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for (int end = 0; end < nums.length; end++) { // 先约束好结束的位置
            int sum = 0;
            for (int  start = end; start <=end && start>=0 ; start--) {  // start 从后往前，确保挨着的
                sum = sum + nums[start]; // 累计求和的结果 加到 sum 中
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        int[] nums = new int[]{1,1,1,2};
        int i = s.subarraySum(nums, 2);
        System.out.println(i);
    }
}
