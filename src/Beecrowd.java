import java.util.Scanner;

public class Beecrowd {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        OrderedDoubleList<String> orderedDoubleList = new OrderedDoubleList<>();
        String line;
        String[] word;

        int n = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            line = scanner.nextLine();
            word = line.split(" ");
            for (int j = 0; j < word.length; j++) {
                if (!orderedDoubleList.contains(word[j]))
                    orderedDoubleList.add(word[j]);
            }

            System.out.println(orderedDoubleList);
            orderedDoubleList.clear();
        }
    }
}
