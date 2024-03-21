/*
  Author: <Zainab Alfredji>
  Id: <am8171>
  Study program: <DT>
*/

package pizzaController;

import java.util.ArrayList;
import java.util.List;

import pizzaModel.*;

public class MainProgram {
    public static void main (String[]args){
        List<Pizza> list = new ArrayList();

        List<Topping_Regular> regularToppings = new ArrayList();
        regularToppings.add(Topping_Regular.Tomato);
        regularToppings.add(Topping_Regular.Cheese);
        regularToppings.add(Topping_Regular.Sauce);

        List<Topping_Meat> chickenTopping = new ArrayList();
        chickenTopping.add(Topping_Meat.Chicken);

        List<Topping_Meat> pepperoniTopping = new ArrayList();
        pepperoniTopping.add(Topping_Meat.Pepperoni);

        List<Topping_Meat> vesuvioTopping = new ArrayList();
        vesuvioTopping.add(Topping_Meat.Ham);

        List<Topping_Veggie> funghiTopping = new ArrayList();
        funghiTopping.add(Topping_Veggie.Mushroom);

        List<Topping_Veggie> quattroFormaggiTopping = new ArrayList();
        quattroFormaggiTopping.add(Topping_Veggie.Gorgonzola);
        quattroFormaggiTopping.add(Topping_Veggie.Brie);
        quattroFormaggiTopping.add(Topping_Veggie.Emmenthal);
        quattroFormaggiTopping.add(Topping_Veggie.Parmesan);

        List<Topping_Veggie> vegetarianaTopping = new ArrayList();
        vegetarianaTopping.add(Topping_Veggie.Zucchini);
        vegetarianaTopping.add(Topping_Veggie.Aubergine);
        vegetarianaTopping.add(Topping_Veggie.Pepper);

        //polymorfism
        Pizza regular = new Pizza_Regular(1, "Margaritha", 100, regularToppings);
        Pizza chicken = new Pizza_Meat(2, "Chicken", 120, regularToppings, chickenTopping);
        Pizza pepperoni = new Pizza_Meat(3, "Pepperoni", 130, regularToppings, pepperoniTopping);
        Pizza vesuvio = new Pizza_Meat(4, "Vesuvio", 110, regularToppings, vesuvioTopping);
        Pizza funghi = new Pizza_Veggie(5, "Funghi", 120, regularToppings, funghiTopping);
        Pizza quattroFormaggi = new Pizza_Veggie(6, "Quattro Formaggi", 140, regularToppings, quattroFormaggiTopping);
        Pizza vegetariana = new Pizza_Veggie(7, "Vegetariana", 120, regularToppings, vegetarianaTopping);


        list.add(regular);
        list.add(chicken);
        list.add(funghi);
        list.add(pepperoni);
        list.add(quattroFormaggi);
        list.add(vegetariana);
        list.add(vesuvio);

        Controller controller = new Controller(list);
    }
}
