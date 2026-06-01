class Solution {
    public String foreignDictionary(String[] words) {

        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();

        // seed all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // invalid case
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int minLength = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    char smaller = word1.charAt(j);
                    char bigger  = word2.charAt(j);

                    graph.get(smaller).add(bigger);
                    indegree.put(bigger, indegree.get(bigger) + 1);
                    break;   
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) q.offer(c);
        }

        // Kahn's BFS
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            char curr = q.poll();
            sb.append(curr);

            for (char neighbor : graph.get(curr)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }

        // if cycle exists, not all chars are in result
        if (sb.length() != indegree.size()) return "";

        return sb.toString();
      
    }
}
