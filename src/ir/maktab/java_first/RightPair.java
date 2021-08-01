package ir.maktab.java_first;

import java.util.ArrayList;

public class RightPair<T extends Comparable<T>> {

    private final ArrayList<T> list;

    public RightPair(ArrayList<T> list) {
        this.list = list;
    }

    public void deleteWrongPairs() {
        int listSize = list.size();
        if(listSize > 0) {
            if(listSize % 2 != 0) list.remove(listSize - 1);
            int i = 0;
            while (i < list.size()) {
                if(list.get(i).compareTo(list.get(i+1)) > 0) {
                    list.remove(i);
                    list.remove(i);
                    continue;
                }
                i+=2;
            }
        }
    }
}
