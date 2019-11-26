public class SingleNumber {
    public int singleNumber (int[] nums) {
        int result = 0;
        for(int x: nums) {
            result ^= x;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(nums));
    }
}
