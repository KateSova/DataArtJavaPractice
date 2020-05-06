import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(" >Test collections add");
        testCollectionAdd(new ArrayList<>());
        testCollectionAdd(new LinkedList<>());
        testCollectionAdd(new HashSet<>());
        testCollectionAdd(new TreeSet<>());
        System.out.println("\nArrayList быстрее LinkedList, т.к. имеет свою вместимость и не требует перевыделения памяти постоянно");
        System.out.println("Сеты формируются долгое время из-за динамической перестройки структуры");
        System.out.println("======================================================================");

        System.out.println("\n\n >Test lists add to begin");
        testListAddToBegin(new ArrayList<>());
        testListAddToBegin(new LinkedList<>());
        System.out.println("\nArrayList медленнее, т.к. требует переноса всех ранее добавленных значений вперёд");
        System.out.println("======================================================================");

        System.out.println("\n\n >Test set to contains");
        testSetToContains(new HashSet<>());
        testSetToContains(new TreeSet<>());
        System.out.println("\nTreeSet медленнее т.к. имеет логарифмическую сложность поиска, а у HashSet сложнасть примерно равна константе, при редких коллизиях");
        System.out.println("======================================================================");

        System.out.println("\n\n >Test collections to contains");
        testCollectionsToContains(new HashSet<>());
        testCollectionsToContains(new ArrayList<>());
        testCollectionsToContains(new LinkedList<>());
        System.out.println("\nУ List линейная сложность поиска, у HashSet сложность константная.");
        System.out.println("ArrayList быстрее LinkedList, т.к. у массива элементы лежат рядом в памяти");
        System.out.println("======================================================================");
    }

    static void testCollectionAdd(Collection<Float> collection) {
        long start = System.currentTimeMillis();
        for (float parameter = 1; parameter <= 1_000_000; parameter++) {
            collection.add(parameter);
        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(collection.getClass().getSimpleName() + ": " + diff + " ms");
    }

    static void testListAddToBegin(List<Float> list) {
        long start = System.currentTimeMillis();
        for (float parameter = 1; parameter <= 100_000; parameter++) {
            list.add(0, parameter);
        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(list.getClass().getSimpleName() + ": " + diff + " ms");
    }

    static void fillCollection(Collection<Integer> collection, int limit) {
        for (int i = 0; i < limit; i++) {
            collection.add(i);
        }
    }

    static void testSetToContains(Set<Integer> set) {
        int limit = 1_000_000;
        fillCollection(set, limit);
        long start = System.currentTimeMillis();
        for (int i = 0; i < limit; i++) {
            set.contains(i);
        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(set.getClass().getSimpleName() + ": " + diff + " ms");
    }

    static void testCollectionsToContains(Collection<Integer> collection) {
        int limit = 30_000;
        fillCollection(collection, limit);
        long start = System.currentTimeMillis();
        for (int i = 0; i < limit; i++) {
            collection.contains(i);
        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(collection.getClass().getSimpleName() + ": " + diff + " ms");
    }
}
