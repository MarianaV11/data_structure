import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        OrderedDoubleList<String> orderedDoubleList = new OrderedDoubleList<>();

        int n = scanner.nextInt();

        String word;

        for (int i = 0; i < n; i++) {
            word = scanner.next();
            orderedDoubleList.add(word);
        }


        Node aux = orderedDoubleList.first;
        OrderedDoubleList<String> compareLength = new OrderedDoubleList();
        for (int i = 0; i < orderedDoubleList.size() - 1; i++) {
            while (aux != null) {
                if (!compareLength.contains((String) aux.data)) {
                    compareLength.add((String) aux.data);
                }
                aux = aux.next;
            }
            aux = orderedDoubleList.first;
            System.out.println(compareLength);
            compareLength.clear();
        }
        System.out.println(orderedDoubleList);
    }
}