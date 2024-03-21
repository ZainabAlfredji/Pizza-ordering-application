/*
  Author: <Zainab Alfredji>
  Id: <am8171>
  Study program: <DT>
*/

package pizzaController;

import java.util.ArrayList;
import java.util.List;

import pizzaModel.Order;
import pizzaModel.Pizza;
import pizzaView.MainFrame;

public class Controller {

    MainFrame view;
    //new code
    private List<Pizza> list_pizza;  //model
    private List<Order> list_order;
    public Order current_order;
    public int index_current_pizza;

    //new code
    //constructor
    public Controller(List<Pizza> listpizza) {
        list_pizza =listpizza;
        list_order = new ArrayList();
        current_order = new Order(getorderid());
        view = new MainFrame(1300,800,this);
        updateMenuView();
        updateView();
    }

    //Denna metod anropas varje gång någon ändring av modellen förekommer
    public void updateView() {
        view.setOrder(current_order);
    }


    private void updateMenuView() {
        view.setMenu(getList_pizza());
    }

    public List<Pizza> getList_pizza() {
        return list_pizza;
    }

    public void setList_pizza(List<Pizza> list_pizza) {
        this.list_pizza = list_pizza;
    }

    public List<Order> getList_order() { return list_order;}

    public void setList_order(List<Order> list_order) {
        this.list_order = list_order;
    }

    public int getorderid() {
        return  list_order. size() +1;
    }

    public void createOrder() {
        list_order.add(current_order);
        current_order = new Order(getorderid());
    }

}
