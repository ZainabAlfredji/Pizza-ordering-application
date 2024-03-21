/*
  Author: <Zainab Alfredji>
  Id: <am8171>
  Study program: <DT>
*/

package pizzaModel;

import java.util.List;

public class Pizza_Veggie extends Pizza_Regular{
    private List<Topping_Veggie> list_veggie_topping;

    public Pizza_Veggie(int id, String name, double price, List<Topping_Regular> list_topping, List<Topping_Veggie> list_veggie_topping) {
        super(id, name, price, list_topping);
        this.list_veggie_topping = list_veggie_topping;
    }

    public List<Topping_Veggie> getList_veggie_topping() {
        return list_veggie_topping;
    }

    public void setList_veggie_topping(List<Topping_Veggie> list_veggie_topping) {
        this.list_veggie_topping = list_veggie_topping;
    }

    @Override
    public String PrintToppings() {
        String toppings = " ";
        if(getList_topping().size() > 0)
        {
            toppings = super.PrintToppings() +", ";
        }
        else
            toppings = "{";
        for (int i = 0; i < list_veggie_topping.size(); i++) {
            toppings += list_veggie_topping.get(i).name();
            if (i != list_veggie_topping.size() - 1)
                toppings += ", ";
        }
        return toppings;
    }

}
