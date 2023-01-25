package viceCity.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getGuns();

    void add(T model);

    boolean remove(T model);

    T find(String name);
}
