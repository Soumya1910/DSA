# HashMap vs LinkedHashMap vs TreeMap in Java

## 🔹 Key Differences (Summary)

- **HashMap**
    - Unordered — does **not** maintain any order of keys.
    - Fastest on average (O(1) for get/put).
    - Allows one `null` key and multiple `null` values.
    - Backed by **hash table**.

- **LinkedHashMap**
    - Maintains **insertion order** or **access order**.
    - Slightly slower than `HashMap` due to linked list overhead.
    - Allows one `null` key and multiple `null` values.
    - Backed by **hash table + doubly linked list**.

- **TreeMap**
    - Maintains keys in **sorted (natural or custom)** order.
    - Slower operations (O(log n)).
    - Does **not** allow `null` keys (throws `NullPointerException`).
    - Backed by **Red-Black Tree**.

---

## 🔹 Code Example

```java
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Zebra", 1);
        hashMap.put("Lion", 2);
        hashMap.put("Elephant", 3);
        System.out.println("HashMap: " + hashMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Zebra", 1);
        linkedHashMap.put("Lion", 2);
        linkedHashMap.put("Elephant", 3);
        System.out.println("LinkedHashMap: " + linkedHashMap);

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Zebra", 1);
        treeMap.put("Lion", 2);
        treeMap.put("Elephant", 3);
        System.out.println("TreeMap: " + treeMap);
    }
}
```

**Output Example:**
```
HashMap: {Lion=2, Elephant=3, Zebra=1}       // Unordered
LinkedHashMap: {Zebra=1, Lion=2, Elephant=3} // Insertion order
TreeMap: {Elephant=3, Lion=2, Zebra=1}       // Sorted by key
```

---

## 🔹 Comparison Table

| Feature / Property            | **HashMap**                                | **LinkedHashMap**                                      | **TreeMap**                                |
|-------------------------------|--------------------------------------------|--------------------------------------------------------|--------------------------------------------|
| **Order of Elements**         | Unordered                                  | Insertion order (or access order if enabled)           | Sorted by key (natural or comparator)       |
| **Underlying Data Structure** | Hash table                                 | Hash table + doubly linked list                        | Red-Black Tree                             |
| **Performance (get/put)**     | O(1) on average                            | O(1) on average                                        | O(log n)                                   |
| **Null Keys / Values**        | 1 null key, multiple null values           | 1 null key, multiple null values                       | No null key, multiple null values allowed   |
| **Iteration Order**           | Unpredictable                              | Predictable                                            | Sorted                                     |
| **Thread-Safety**             | Not synchronized                           | Not synchronized                                       | Not synchronized                           |
| **When to Use**               | Best for fast lookups and inserts          | When insertion/access order matters                    | When sorted key order is required           |

