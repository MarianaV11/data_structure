import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        OrderedDynamicList<Integer> orderedDynamicList = new OrderedDynamicList();

        orderedDynamicList.add(3);
        orderedDynamicList.add(7);

        System.out.println(orderedDynamicList.contains(10));
    }
}