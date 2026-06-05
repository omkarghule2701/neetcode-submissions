class Solution {
    public String reorganizeString(String s) {

        Map<Character, Integer> freq = new HashMap<>();
        int minFreq = (s.length()+1)/2;

        for (Character ch : s.toCharArray()) {

            if (freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch)+1);
            }
            else {
                freq.put(ch, 1);
            }

            if (freq.get(ch) > minFreq) {
                return "";
            }

        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (char ch : freq.keySet()) {
            maxHeap.offer(new int[]{ch, freq.get(ch)});
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = null;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            
            char ch = (char) curr[0];    // extract for readability
            int count = curr[1];

            sb.append(ch);
            curr[1]--;                   // reduce frequency

            if (prev != null && prev[1] > 0) {
                maxHeap.offer(prev);     // prev is safe to re-add now
            }

            prev = curr;
        }

        return sb.toString();

        
        
    }
}