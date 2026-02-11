import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1. Create & Put
        System.out.println("1) Create & Put");
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Aida", 85);
        scores.put("Azat", 92);
        scores.put("Dana", 77);

        System.out.println("Map: " + scores);
        System.out.println("Size: " + scores.size());
        System.out.println();

        // 2. Get & ContainsKey
        System.out.println("2) Get & ContainsKey");
        System.out.println("Aida score: " + scores.get("Aida"));
        System.out.println("Mira score: " + scores.get("Mira"));

        if (scores.containsKey("Mira")) {
            System.out.println("Mira found: " + scores.get("Mira"));
        } else {
            System.out.println("Mira not found");
        }
        System.out.println();

        // 3. Update Existing Value
        System.out.println("3) Update Existing Value");
        Integer oldValue = scores.put("Dana", 80);
        System.out.println("Old Dana score: " + oldValue);
        System.out.println("Updated map: " + scores);
        System.out.println();

        // 4. Remove by Key
        System.out.println("4) Remove by Key");
        Integer removed = scores.remove("Azat");
        System.out.println("Azat removed: " + (removed != null));

        Integer removedFake = scores.remove("NonExisting");
        System.out.println("NonExisting removed: " + (removedFake != null));
        System.out.println("Map now: " + scores);
        System.out.println();

        // 5. isEmpty & clear
        System.out.println("5) isEmpty & clear");
        System.out.println("Before clear isEmpty: " + scores.isEmpty());
        scores.clear();
        System.out.println("After clear isEmpty: " + scores.isEmpty());

        // re-insert
        scores.put("Aida", 85);
        scores.put("Dana", 80);
        scores.put("Azat", 92);
        System.out.println("Re-inserted map: " + scores);
        System.out.println();

        // 6. getOrDefault
        System.out.println("6) getOrDefault");
        int miraScore = scores.getOrDefault("Mira", -1);
        if (miraScore == -1) {
            System.out.println("Mira: Not found");
        }

        System.out.println("Aida: " + scores.getOrDefault("Aida", -1));
        System.out.println("Dana: " + scores.getOrDefault("Dana", -1));
        System.out.println();

        // 7. putIfAbsent
        System.out.println("7) putIfAbsent");
        scores.putIfAbsent("Aida", 90);
        scores.putIfAbsent("Mira", 88);
        System.out.println("Map after putIfAbsent: " + scores);
        System.out.println();

        // 8. replace
        System.out.println("8) replace");
        boolean replaced = scores.replace("Aida", 85, 86);
        System.out.println("Conditional replace Aida (85→86): " + replaced);
        scores.replace("Aida", 91);
        System.out.println("Unconditional replace Aida → 91");
        System.out.println("Try replace missing key: " + scores.replace("John", 70));
        System.out.println("Map now: " + scores);
        System.out.println();

        // 9. Iterate over keys, values, entries
        System.out.println("9) Iteration");
        System.out.println("Keys:");
        for (String key : scores.keySet()) {
            System.out.println(key);
        }

        System.out.println("Values:");
        for (Integer value : scores.values()) {
            System.out.println(value);
        }

        System.out.println("Entries:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();

        // 10. Count how many have score >= 80
        System.out.println("10) Count score >= 80");
        int count = 0;
        for (int value : scores.values()) {
            if (value >= 80) {
                count++;
            }
        }
        System.out.println("Count: " + count);
        System.out.println();
        // 11. Find max score and who has it
        System.out.println("11) Max score");
        int maxScore = Integer.MIN_VALUE;
        for (int value : scores.values()) {
            if (value > maxScore) {
                maxScore = value;
            }
        }

        System.out.println("Max score: " + maxScore);
        System.out.println("Who has it:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getValue() == maxScore) {
                System.out.println(entry.getKey());
            }
        }
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