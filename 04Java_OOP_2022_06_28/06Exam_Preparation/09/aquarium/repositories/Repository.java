package aquarium.repositories;

import aquarium.entities.decorations.Decoration;

public interface Repository  {
    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);
}
