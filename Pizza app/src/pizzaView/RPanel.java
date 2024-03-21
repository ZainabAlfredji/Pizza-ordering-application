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
import pizzaController.Controller;
import pizzaModel.Order;
import pizzaModel.OrderInterface;
import pizzaModel.Pizza;

public class RPanel extends JPanel implements OrderInterface {

    //new code
    Controller controller;

    private JList<Object> orderList;
    private JButton showOldOrders;
    private JButton createOrder;
    private JLabel title;
    private JLabel price;

    private int width;
    private int height;

    public RPanel(int width, int height, Controller controller) {
        this.controller = controller;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(width, 0);
        setUp();

    }

    public void setUp() {
        title = new JLabel("ORDER");
        title.setLocation(0, 0);
        title.setSize(width / 2, 20);
        this.add(title);

        price = new JLabel("PRICE: 0:-");
        price.setLocation(width / 2 + 10, 0);
        price.setSize(90, 20);
        this.add(price);

        orderList = new JList<>();
        orderList.setLocation(0, 23);
        orderList.setSize(width, height - 100);
        this.add(orderList);

        showOldOrders = new JButton("Order historik");
        showOldOrders.setEnabled(true);
        showOldOrders.setSize(width / 2, 30);
        showOldOrders.setLocation(width / 2 - 30, height - 75);
        //new code
        showOldOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(null, "Enter Order ID:");
                try {
                    int idInt = Integer.parseInt(id);
                    if (idInt > controller.getList_order().size()) {
                        JOptionPane.showMessageDialog(null, "Not Found Order in this id");
                    } else {
                        setOrder(controller.getList_order().get(idInt - 1));
                    }
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Order Id Most be integer only");
                }

            }
        });
        this.add(showOldOrders);

        createOrder = new JButton("Beställ");
        createOrder.setEnabled(true);
        createOrder.setSize(width / 2 - 30, 30);
        createOrder.setLocation(0, height - 75);
        //new code
        createOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Order Created, ID:[" + controller.getorderid() + "]");
                controller.createOrder();
                clearOrder();
            }
        });
        this.add(createOrder);
    }

    public JList<Object> getOrderList() {
        return orderList;
    }

    public void setOrderList(JList<Object> orderList) {
        this.orderList = orderList;
    }

    public JButton getCreateOrder() {
        return createOrder;
    }

    public void setCreateOrder(JButton createOrder) {
        this.createOrder = createOrder;
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

    public JButton getShowOldOrders() {
        return showOldOrders;
    }

    public void setShowOldOrders(JButton showOldOrders) {
        this.showOldOrders = showOldOrders;
    }

    public JLabel getPrice() {
        return price;
    }

    public void setPrice(JLabel price) {
        this.price = price;
    }

    //new code
    void clearOrder() {
        DefaultListModel model = new DefaultListModel();
        model.addElement(String.format("  %s %20s %20s", "Name Pizza", "Qty", "Price"));
        orderList.setModel(model);
        price.setText("PRICE: 0SEK");
    }

    //new code
    @Override
    public void setOrder(Order order) {

        DefaultListModel model = new DefaultListModel();
        model.addElement(String.format("  %s %20s %20s", "Name Pizza", "Qty", "Price"));
        List<Pizza> items = order.getList_item();
        List<Integer> items_qty = order.getList_quantity();
        for (int i = 0; i < order.getList_item().size(); i++) {

            String s1 = String.format("%d. %s", (i + 1), items.get(i).getName());
            String s2 = String.format("%45d %20.2fSEK", items_qty.get(i), items.get(i).getPrice());
            model.addElement(s1);
            model.addElement(s2);
        }
        orderList.setModel(model);
        price.setText(String.format("PRICE: %.2fSEK", order.getPrice()));
    }
}
