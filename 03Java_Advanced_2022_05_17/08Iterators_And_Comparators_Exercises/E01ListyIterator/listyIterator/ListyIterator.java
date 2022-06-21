package listyIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator<String> {
    private List<String> strings;
    private int index = 0;

    public ListyIterator(String... strings) {
        this.strings = Arrays.asList(strings);
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        return this.strings.size() - 1 > this.index;
    }

    public void print() {
        try {
            System.out.println(this.strings.get(this.index));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Operation!");
        }
    }

}