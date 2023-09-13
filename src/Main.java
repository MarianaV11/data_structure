import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static OrderedDynamicList<OrderedDoubleList<String>> creationOfLists(OrderedDynamicList<OrderedDoubleList<String>> list, String world) {
      if (list != null) {
          for (int i = 0; i < list.size(); i++) {
              OrderedDoubleList<String> x = (OrderedDoubleList<String>) list.get(i);
              if (!x.containsStringLength(world)) {
                  x.add(world);
                  list.add(x);
                  return list;
              }
              System.out.println(list);
          }
      }
        list.add(new OrderedDoubleList<>());
        return creationOfLists(list, world);
    }
    public static void main(String[] args) {
        int n = scanner.nextInt();

        String word;
        OrderedDynamicList<OrderedDoubleList<String>> aux = new OrderedDynamicList<>();
        for (int i = 0; i < n; i++) {
            word = scanner.next();
            aux = (creationOfLists(new OrderedDynamicList<>(), word));;
        }


        for (int i = 0; i < aux.size(); i++) {
            System.out.println(aux.get(i));
        }
    }
}