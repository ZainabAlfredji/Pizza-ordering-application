/*
  Author: <Zainab Alfredji>
  Id: <am8171>
  Study program: <DT>
*/

package pizzaModel;

import java.util.List;

public class Pizza_Meat extends Pizza_Regular{
    private List<Topping_Meat> list_meat_topping;

    public Pizza_Meat(int id, String name, double price, List<Topping_Regular> list_topping, List<Topping_Meat> list_meat_topping) {
        super(id, name, price, list_topping);
        this.list_meat_topping = list_meat_topping;
    }

    public List<Topping_Meat> getList_meat_topping() {
        return list_meat_topping;
    }

    public void setList_meat_topping(List<Topping_Meat> list_meat_topping) {
        this.list_meat_topping = list_meat_topping;
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
        for (int i = 0; i < list_meat_topping.size(); i++) {
            toppings += list_meat_topping.get(i).name();
            if (i != list_meat_topping.size() - 1)
                toppings += ", ";
        }
        return toppings;
    }
}
