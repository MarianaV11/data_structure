package Hash;

import List.DynamicList;

//Endereçamento fechado
public class HashTableClose {
    private DynamicList[] table;
    public HashTableClose(int size) {
        table = new DynamicList[size];
    }

    public void add(int element) {
        int position = element % table.length;

        if(table[position] == null) {
            table[position] = new DynamicList();
        }

        table[position].add(element);
    }

    public void remove(int element) {
        int position = element % table.length;

        if (table[position] != null) {
            table[position].remove(element);
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (DynamicList dynamicList : table) {
            str += dynamicList + "\n";
        }
        return str;
    }
}
