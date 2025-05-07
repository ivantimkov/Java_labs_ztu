import com.education.ztu.Product;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Apple", 10.5, 100);
        Product p2 = new Product("Banana", 5.0, 50);
        Product p3 = new Product("Orange", 8.0, 70);
        Product p4 = new Product("Apple", 10.5, 100); // Same as p1

        // ✅ ArrayList
        List<Product> list = new ArrayList<>(List.of(p1, p2));
        list.add(p3);
        list.addAll(List.of(p4));
        System.out.println("ArrayList: " + list);

        System.out.println("get(1): " + list.get(1));
        System.out.println("indexOf: " + list.indexOf(p1));
        System.out.println("lastIndexOf: " + list.lastIndexOf(p1));

        ListIterator<Product> iter = list.listIterator();
        while (iter.hasNext()) System.out.println("Iterating: " + iter.next());

        list.remove(p2);
        list.set(1, new Product("Grapes", 12.0, 60));
        Collections.sort(list);
        System.out.println("Sorted: " + list);

        System.out.println("SubList(0,2): " + list.subList(0, 2));
        System.out.println("Contains Apple: " + list.contains(p1));
        System.out.println("IsEmpty: " + list.isEmpty());
        System.out.println("Size: " + list.size());

        list.retainAll(List.of(p1));
        list.clear();

        // ✅ ArrayDeque
        ArrayDeque<Product> queue = new ArrayDeque<>();
        queue.push(p1);
        queue.offerLast(p2);
        System.out.println("Queue peekLast: " + queue.peekLast());
        System.out.println("Queue getFirst: " + queue.getFirst());
        queue.pop();
        queue.removeLast();
        System.out.println("Queue after pops: " + queue);

        // ✅ TreeSet
        TreeSet<Product> set = new TreeSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("TreeSet: " + set);
        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());
        System.out.println("HeadSet: " + set.headSet(p3));
        System.out.println("SubSet: " + set.subSet(p1, p3));
        System.out.println("TailSet: " + set.tailSet(p2));
        System.out.println("Higher Banana: " + set.higher(p2));
        System.out.println("Lower Banana: " + set.lower(p2));
        set.pollFirst();
        set.pollLast();
        System.out.println("DescendingSet: " + set.descendingSet());

        // ✅ HashMap
        HashMap<String, Product> map = new HashMap<>();
        map.put(p1.getName(), p1);
        map.put(p2.getName(), p2);
        System.out.println("Map get Banana: " + map.get("Banana"));
        System.out.println("ContainsKey Banana: " + map.containsKey("Banana"));
        System.out.println("ContainsValue p1: " + map.containsValue(p1));
        map.putIfAbsent("Orange", p3);
        map.keySet().forEach(System.out::println);
        map.values().forEach(System.out::println);
        for (Map.Entry<String, Product> entry : map.entrySet()) {
            System.out.printf("Entry: %s = %s%n", entry.getKey(), entry.getValue());
        }

        // ✅ Collections
        List<String> fruits = new ArrayList<>(Arrays.asList("Kiwi", "Mango", "Peach"));
        Collections.sort(fruits);
        System.out.println("Sorted fruits: " + fruits);
        System.out.println("BinarySearch Mango: " + Collections.binarySearch(fruits, "Mango"));

        Collections.reverse(fruits);
        Collections.shuffle(fruits);
        Collections.fill(fruits, "Filled");
        System.out.println("After fill: " + fruits);

        fruits = new ArrayList<>(Arrays.asList("Kiwi", "Mango", "Peach"));
        System.out.println("Max: " + Collections.max(fruits));
        System.out.println("Min: " + Collections.min(fruits));

        List<String> copyList = new ArrayList<>(Arrays.asList("", "", ""));
        Collections.copy(copyList, fruits);
        System.out.println("CopyList: " + copyList);

        Collections.rotate(fruits, 1);
        System.out.println("Rotated: " + fruits);

        Collection<String> checked = Collections.checkedCollection(new ArrayList<>(), String.class);
        checked.add("Safe");

        System.out.println("Frequency of Mango: " + Collections.frequency(fruits, "Mango"));
    }
}