import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        DinamicList dinamicList = new DinamicList();

        dinamicList.add(7);
        dinamicList.add(8);
        dinamicList.add(10);
        dinamicList.add(3);
        dinamicList.add(3);
        dinamicList.add(2);
        dinamicList.add(55);

        System.out.println(dinamicList);
    }
}