//package Hash;
//
//import List.DynamicList;
//
////Endereçamento fechado
//public class HashTableOpen {
//    private int[] table;
//
//    public HashTableOpen(int size) {
//        table = new int[size];
//    }
//
//    public int hash(int element) {
//        return element % table.length;
//    }
//
//    public void add(int element) {
//        int position = hash(element);
//
//        int i = 0;
//        while(table[position] != 0) {
//            i++;
//            position = hash(element+i);
//        }
//
//        table[position].add(element);
//    }
//
//    public void remove(int element) {
//        int position = hash(element);
//
//        while(table[position] != 0 && ) {
//            table[position].remove(element);
//        }
//    }
//
//    @Override
//    public String toString() {
//        String str = "";
//        for (Integer table : table) {
//            str += table + "\n";
//        }
//        return str;
//    }
//}
