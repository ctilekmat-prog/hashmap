import java.util.*;

public class Main {
    public static void main(String[] args) {

                // 12. Word Frequency Counter
                String text = "Java is fun and Java is powerful and fun";
                String[] words = text.toLowerCase().split(" ");
                Map<String, Integer> wordCount = new HashMap<>();

                for (String w : words) {
                    wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
                }
                System.out.println("12) Word Frequency: " + wordCount);

                // 13. Character Frequency (letters only)
                String str = "Mississippi";
                Map<Character, Integer> charCount = new HashMap<>();

                for (char c : str.toCharArray()) {
                    if (Character.isLetter(c)) {
                        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                    }
                }
                System.out.println("13) Character Frequency: " + charCount);

                char maxChar = ' ';
                int max = 0;
                for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                        maxChar = entry.getKey();
                    }
                }
                System.out.println("Most frequent char: " + maxChar);

                // 14. Group Words by Length
                String[] arr = {"hi", "book", "java", "sun", "loop", "map"};
                Map<Integer, ArrayList<String>> groupByLength = new HashMap<>();

                for (String s : arr) {
                    groupByLength
                            .computeIfAbsent(s.length(), k -> new ArrayList<>())
                            .add(s);
                }
                System.out.println("14) Group by Length: " + groupByLength);

                // 15. First Non-Repeating Character
                String input = "swiss";
                Map<Character, Integer> freqMap = new HashMap<>();

                for (char c : input.toCharArray()) {
                    freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
                }

                Character firstUnique = null;
                for (char c : input.toCharArray()) {
                    if (freqMap.get(c) == 1) {
                        firstUnique = c;
                        break;
                    }
                }
                System.out.println("15) First non-repeating: " +
                        (firstUnique != null ? firstUnique : "None"));

                // 16. Two-Sum (Index Map)
                int[] nums = {2, 7, 11, 15};
                int target = 9;
                Map<Integer, Integer> indexMap = new HashMap<>();

                for (int i = 0; i < nums.length; i++) {
                    int complement = target - nums[i];
                    if (indexMap.containsKey(complement)) {
                        System.out.println("16) Two Sum indices: " +
                                indexMap.get(complement) + ", " + i);
                    }
                    indexMap.put(nums[i], i);
                }

                // 17. Detect Duplicates with Map
                String[] fruits = {"apple", "banana", "apple", "orange", "banana", "kiwi"};
                Map<String, Integer> fruitCount = new HashMap<>();

                for (String f : fruits) {
                    fruitCount.put(f, fruitCount.getOrDefault(f, 0) + 1);
                }

                System.out.println("17) Unique items:");
                for (Map.Entry<String, Integer> entry : fruitCount.entrySet()) {
                    if (entry.getValue() == 1) {
                        System.out.println(entry.getKey());
                    }
                }

                System.out.println("Duplicated items:");
                for (Map.Entry<String, Integer> entry : fruitCount.entrySet()) {
                    if (entry.getValue() > 1) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                }
                // 18. Equals & Order-Insensitivity
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 2);
        map2.put("A", 1);

        System.out.println("18) Equals: " + map1.equals(map2));
        System.out.println("HashCodes: " + map1.hashCode() +
                " & " + map2.hashCode());

        // 19. Remove Entries Conditionally
        Map<String, Integer> students = new HashMap<>();
        students.put("Ali", 70);
        students.put("Aida", 50);
        students.put("Nura", 90);

        Iterator<Map.Entry<String, Integer>> iterator = students.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 60) {
                iterator.remove();
            }
        }
        System.out.println("19) After removal: " + students);

        // 20. Merge Scores
        Map<String, Integer> scores1 = new HashMap<>();
        scores1.put("Aida", 40);
        scores1.put("Azat", 35);
        scores1.put("Dana", 50);

        Map<String, Integer> scores2 = new HashMap<>();
        scores2.put("Azat", 10);
        scores2.put("Dana", 5);
        scores2.put("Mira", 45);

        for (Map.Entry<String, Integer> entry : scores2.entrySet()) {
            scores1.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        System.out.println("20) Merged scores: " + scores1);

        // 21. Invert a Map (Handling Collisions)
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Ali", 90);
        studentScores.put("Aida", 80);
        studentScores.put("Nura", 90);

        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            inverted
                    .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                    .add(entry.getKey());
        }
        System.out.println("21) Inverted Map: " + inverted);

        // 22. Top-K Frequent Words
        Map<String, Integer> freq = wordCount; // используем из 12 задания
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("22) Top 2 frequent words:");
        for (int i = 0; i < 2 && i < list.size(); i++) {
            System.out.println(list.get(i).getKey() +
                    " -> " + list.get(i).getValue());
        }
    }
}