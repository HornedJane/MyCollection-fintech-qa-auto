import java.util.Arrays;

public class Main {

    public static void main(final String[] args) {
        MyCollection<Integer> collection1 = new MyCollection<>();
        MyCollection<Integer> collection2 = new MyCollection<>();
        String[] array = new String[3];

        collection1.add(0);
        collection1.add(2);
        collection1.add(5);
        collection1.add(null);
        collection1.add(2);

        collection2.add(null);

        System.out.println(Arrays.toString(collection1.toArray()));
        System.out.println(collection1.contains(10));
        System.out.println(collection1.contains(null));
        System.out.println(collection1.containsAll(Arrays.asList(2, 10)));
        System.out.println(collection1.containsAll(collection2));
        //System.out.println(collection1.removeAll(Arrays.asList(null, 2)));
        //System.out.println(collection1.retainAll(Arrays.asList(2, null, 0)));
        //collection1.clear();
        //System.out.println(Arrays.toString(collection1.toArray()));
    }
}
