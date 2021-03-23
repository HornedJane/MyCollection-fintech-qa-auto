import java.util.Arrays;

public class Main {

    public static void main(final String[] args) {
        MyCollection<String> collection1 = new MyCollection<>();
        MyCollection<String> collection2 = new MyCollection<>();
        String[] array = new String[3];

        collection1.add("A");
        collection1.add("B");
        collection1.add("C");
        collection1.add("D");
        collection1.add("E");

        collection2.add("A");
        collection2.add("B");
        collection2.add("C");
        collection2.add("D");
        collection2.add("E");

        collection1.remove("A");
        collection1.remove("E");
        collection1.remove("C");

        System.out.println(Arrays.toString(collection1.toArray()));

        System.out.println(collection1.contains("D"));

        System.out.println(collection2.containsAll(collection1));

        System.out.println(collection1.containsAll(collection2));

        collection2.addAll(collection1);
        System.out.println(Arrays.toString(collection2.toArray()));

        collection1.toArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(collection2.toArray(array)));
        System.out.println(Arrays.toString(array));
    }
}
