import java.util.*;

public class TopKFrequentWord {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if (map.get(o1).equals(map.get(o2))) {
                            return o2.compareTo(o1);
                        }
                        return map.get(o1) - map.get(o2);
                    }
                }
        );
        for (String s : map.keySet()) {
            queue.offer(s);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> list = new ArrayList<String>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
