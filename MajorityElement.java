import java.util.Stack;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        /**
         * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
         *
         * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/majority-element
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */

        //消消乐方法
        for (int i = 0; i < nums.length; i++) {
            if (stack.empty() || nums[i] == stack.peek()) {
                stack.push(nums[i]);
            } else {
                stack.pop();
            }
        }
        return stack.peek();
    }
}
