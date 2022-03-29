import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String word1, String word2) {
                int freq1 = map.get(word1);
                int freq2 = map.get(word2);
                
                if (freq1 == freq2) return word2.compareTo(word1);
                return freq1 - freq2;
            }
        });
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry.getKey());
            if (queue.size() > k) queue.poll();
        }
        
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) result.add(queue.poll());
        
        Collections.reverse(result);
        
        return result;
    }

    public static void main(String[] args) {
        String[] input = {"i","love", "leetcode", "i", "love", "coding"};
        List<String> output = topKFrequent(input, 2);
        System.out.println(output.toString());
    }
}