/*
  Author: <Zainab Alfredji>
  Id: <am8171>
  Study program: <DT>
*/

package pizzaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import pizzaController.Controller;
import pizzaModel.Menu;
import pizzaModel.Pizza;

public class LPanel extends JPanel implements Menu {

    //new code
    private Controller controller;


    private JList<Object> menu;
    private JButton showDrinks;
    private JButton showFood;
    private JButton addToOrder;
    private JLabel title;

    private int width;
    private int height;

    public LPanel(int width, int height, Controller controller) {
        this.controller = controller;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(0, 0);
        setUp();
    }

    public void setUp() {
        title = new JLabel("MAU'S Pizzeria");
        title.setLocation((width / 2) - 45, 0);
        title.setSize(90, 20);
        this.add(title);

        menu = new JList<>();
        menu.setLocation(0, 23);
        menu.setSize(width, height - 100);

        //new code
        menu.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String menuselect = menu.getSelectedValue().toString();
                    //1. e. 2. --> {1,e,2}
                    String[] menus = menuselect.split(". ");
                    controller.index_current_pizza = Integer.parseInt(menus[0]) - 1;

                }
            }
        });

        this.add(menu);

        showFood = new JButton("Mat");
        showFood.setEnabled(false);
        showFood.setSize(width / 3, 30);
        showFood.setLocation(0, height - 75);
        this.add(showFood);

        showDrinks = new JButton("Drickor");
        showDrinks.setEnabled(false); // Om du ska köra för VG ändrar du denna till True annars kan du skippa allt med drink att göra
        showDrinks.setSize(width / 3, 30);
        showDrinks.setLocation(width / 3, height - 75);
        this.add(showDrinks);

        addToOrder = new JButton("Lägg till");
        addToOrder.setEnabled(true);
        addToOrder.setSize(width / 3, 30);
        addToOrder.setLocation(width - (width / 3), height - 75);
        //new code
        addToOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Qty = JOptionPane.showInputDialog("Fill Qty of Pizza?");
                try {
                    int qty_pizza = Integer.parseInt(Qty);
                    controller.current_order.addPizza(controller.getList_pizza().get(controller.index_current_pizza), qty_pizza);
                    controller.updateView();
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, "Qty Most be integer only");
                }
            }
        });
        this.add(addToOrder);
    }

    public JList<Object> getMenu() {
        return menu;
    }

    public void setMenuList(JList<Object> menu) {
        this.menu = menu;
    }

    public JButton getShowDrinks() {
        return showDrinks;
    }

    public void setShowDrinks(JButton showDrinks) {
        this.showDrinks = showDrinks;
    }

    public JButton getShowFood() {
        return showFood;
    }

    public void setShowFood(JButton showFood) {
        this.showFood = showFood;
    }

    public JButton getAddToOrder() {
        return addToOrder;
    }

    public void setAddToOrder(JButton addToOrder) {
        this.addToOrder = addToOrder;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //new code
    @Override
    public void setMenu(List<Pizza> list_pizza) {
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < list_pizza.size(); i++) {
            model.addElement((i + 1) + ". " + list_pizza.get(i).toString());
            model.addElement((i + 1) +".            "+list_pizza.get(i).PrintToppings()+" }");
        }
        menu.setModel(model);

    }
}
