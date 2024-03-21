/*
  Author: <Zainab Alfredji>
  Id: <am8171>
  Study program: <DT>
*/

package pizzaView;

import java.util.List;
import javax.swing.*;
import pizzaController.Controller;
import pizzaModel.Menu;
import pizzaModel.Order;
import pizzaModel.OrderInterface;
import pizzaModel.Pizza;


public class MainFrame extends JFrame implements Menu, OrderInterface {
    //new code
    Controller controller;

    private MainPanel mainPanel;

    public MainFrame(int width, int height,Controller controller) {
        super("Restaurant");
        this.controller = controller;
        this.setResizable(false);
        this.setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainPanel = new MainPanel(width, height,controller);
        this.setContentPane(mainPanel);
        this.setVisible(true);

    }


    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }


    //new code
    @Override
    public void setOrder(Order order) {
        mainPanel.setOrder(order);
    }

    //new code
    @Override
    public void setMenu(List<Pizza> list_pizza) {
        mainPanel.setMenu(list_pizza);
    }

}
