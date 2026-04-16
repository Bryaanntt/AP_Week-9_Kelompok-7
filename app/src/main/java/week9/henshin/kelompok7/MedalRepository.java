package week9.henshin.kelompok7;

import java.util.*;

public class MedalRepository<T> {

    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }
}