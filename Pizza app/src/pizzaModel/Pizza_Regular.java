/*
  Author: <Zainab Alfredji>
  Id: <am8171>
  Study program: <DT>
*/

package pizzaModel;

import java.util.List;

public class Pizza_Regular extends Pizza{
    private List<Topping_Regular> list_topping;

    public Pizza_Regular(int id, String name, double price, List<Topping_Regular> list_topping) {
        super(id, name, price);
        this.list_topping = list_topping;
    }

    public List<Topping_Regular> getList_topping() {
        return list_topping;
    }

    public void setList_topping(List<Topping_Regular> list_topping) {
        this.list_topping = list_topping;
    }

    @Override
    public String PrintToppings() {
        String toppings = "{";
        for (int i = 0; i < list_topping.size(); i++) {
            toppings += list_topping.get(i).name();
            if (i != list_topping.size() - 1)
                toppings += ", ";
        }
        return toppings;
    }
}
