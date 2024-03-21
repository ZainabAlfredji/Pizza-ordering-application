/*
  Author: <Zainab Alfredji>
  Id: <am8171>
  Study program: <DT>
*/

package pizzaModel;

import java.util.ArrayList;
import java.util.List;

public class Order{
    private int Order_Id;
    private List<Pizza> list_item;
    private List<Integer> list_quantity;
    private double price;

    public Order(int id)
    {
        Order_Id = id;
        list_item = new ArrayList();
        list_quantity = new ArrayList();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrder_Id() {
        return Order_Id;
    }

    public void setOrder_Id(int Order_Id) {
        this.Order_Id = Order_Id;
    }

    public void addPizza(Pizza p , int qty)
    {
        for (int i = 0; i < list_item.size(); i++) {
            if(list_item.get(i).getPizza_id()== p.getPizza_id())
            {
                list_quantity.set(i, (list_quantity.get(i) + qty));
                price += list_item.get(i).getPrice() *qty;
                return;
            }
        }
        list_item.add(p);
        list_quantity.add(qty);
        price += p.getPrice() *qty;
    }

    public List<Pizza> getList_item() {
        return list_item;
    }

    public void setList_item(List<Pizza> list_item) {
        this.list_item = list_item;
    }

    public List<Integer> getList_quantity() {
        return list_quantity;
    }

    public void setList_quantity(List<Integer> list_quantity) {
        this.list_quantity = list_quantity;
    }
}
