import java.util.*;

public class TopKFrequentNum {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x: nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return map.get(o1) - map.get(o2);
                    }
                }
        );
        for (int x: map.keySet()) {
            heap.offer(x);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> list = new ArrayList<>(heap);
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(topKFrequent(nums, 2).toString());
    }
}
