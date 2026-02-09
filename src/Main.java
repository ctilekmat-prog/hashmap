import java.util.HashMap;
import java.util.Map;

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
    }
}