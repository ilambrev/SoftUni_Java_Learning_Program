package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class GunRepository implements Repository<Gun> {

    private Collection<Gun> guns;

    public GunRepository() {
        this.guns = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getGuns() {
        return Collections.unmodifiableCollection(this.guns);
    }

    @Override
    public void add(Gun gun) {
        if (find(gun.getName()) == null) {
            this.guns.add(gun);
        }
    }

    @Override
    public boolean remove(Gun gun) {
        return this.guns.remove(gun);
    }

    @Override
    public Gun find(String name) {
        return this.guns.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    }

}