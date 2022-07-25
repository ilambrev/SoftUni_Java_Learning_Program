package Animals;

public abstract class Animal {

    private String name;
    private String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.setName(name);
        this.setFavouriteFood(favouriteFood);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getFavouriteFood() {
        return this.favouriteFood;
    }

    private void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s", this.getName(), this.getFavouriteFood());
    }

}