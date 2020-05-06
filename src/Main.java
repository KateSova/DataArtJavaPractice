import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test collections add");
        testCollectionAdd(new ArrayList<>());
        testCollectionAdd(new LinkedList<>());
        testCollectionAdd(new HashSet<>());
        testCollectionAdd(new TreeSet<>());

        System.out.println("\nTest lists add to begin");
        testListAddToBegin(new ArrayList<>());
        testListAddToBegin(new LinkedList<>());

        System.out.println("\nTest set to contains");
        testSetToContains(new HashSet<>());
        testSetToContains(new TreeSet<>());

        System.out.println("\nTest collections to contains");
        testCollectionsToContains(new HashSet<>());
        testCollectionsToContains(new ArrayList<>());
        testCollectionsToContains(new LinkedList<>());
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
        int limit = 10_000;
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
