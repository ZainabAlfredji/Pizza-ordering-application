/*
  Author: <Zainab Alfredji>
  Id: <am8171>
  Study program: <DT>
*/

package pizzaView;

import pizzaController.Controller;
import pizzaModel.Menu;
import pizzaModel.Order;
import pizzaModel.OrderInterface;
import pizzaModel.Pizza;

import javax.swing.*;
import java.util.List;

public class MainPanel extends JPanel implements Menu, OrderInterface {
    //new code
    Controller controller;

    private LPanel lPanel;
    private RPanel rPanel;

    public MainPanel(int width, int height,Controller controller)
    {
        super(null);
        this.controller = controller;
        this.setSize(width, height);

        lPanel = new LPanel(width / 2 - 2, height,controller);
        add(lPanel);

        rPanel = new RPanel(width / 2 + 10, height,controller);
        add(rPanel);
    }


    public LPanel getlPanel() {
        return lPanel;
    }

    public void setlPanel(LPanel lPanel) {
        this.lPanel = lPanel;
    }

    public RPanel getrPanel() {
        return rPanel;
    }

    public void setrPanel(RPanel rPanel) {
        this.rPanel = rPanel;
    }


    //new code
    @Override
    public void setOrder(Order order) {
        rPanel.setOrder(order);
    }

    //new code
    @Override
    public void setMenu(List<Pizza> list_pizza) {
        lPanel.setMenu(list_pizza);
    }
}
