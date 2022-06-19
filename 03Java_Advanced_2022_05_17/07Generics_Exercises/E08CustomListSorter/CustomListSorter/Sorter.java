package CustomListSorter;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        if (list.size() > 1) {
            int i = 0;
            while (i < list.size() - 1) {
                if (list.get(i + 1).compareTo(list.get(i)) < 0) {
                    list.swap(i, i + 1);
                    i = 0;
                } else {
                    i++;
                }
            }
        }
    }
}