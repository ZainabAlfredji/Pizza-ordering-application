/*
  Author: <Zainab Alfredji>
  Id: <am8171>
  Study program: <DT>
*/

package pizzaModel;

public abstract class Pizza implements IPizza{
    private int Pizza_id;
    private String name;
    private double price;

    public Pizza(int id, String name, double price) {
        Pizza_id = id;
        this.name = name;
        this.price = price;
    }

    public int getPizza_id() {
        return Pizza_id;
    }

    public void setPizza_id(int pizza_id) {
        Pizza_id = pizza_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() { return price;}

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String PrintToppings();

    @Override
    public String toString() {
        return String.format("%s %10.2fSEK", name, price);
    }
}
