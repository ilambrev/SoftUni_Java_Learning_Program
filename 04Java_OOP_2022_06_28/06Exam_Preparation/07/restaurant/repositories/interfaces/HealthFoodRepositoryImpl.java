package restaurant.repositories.interfaces;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {

private Collection<HealthyFood> healthyFood;

    public HealthFoodRepositoryImpl() {
        this.healthyFood = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return this.healthyFood.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(this.healthyFood);
    }

    @Override
    public void add(HealthyFood food) {
        this.healthyFood.add(food);
    }

}