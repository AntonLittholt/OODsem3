package se.kth.iv1350.retailStore.view;

import java.util.ArrayList;
import se.kth.iv1350.retailStore.controller.Controller;
import se.kth.iv1350.retailStore.model.*;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution
 *  with calls to all system operations in the controller.
 */
public class View {
    private Controller contr;
    /**
     * creates a new instance that uses the specified controller for all calls to other layers. 
     * 
     * @param contr Controller used for all calls to other layers.
     */
    public View(Controller contr){
        this.contr = contr;

    }

    /**
    * Performs a fake sale by calling all system operations in controller.
    */
    public void runFakeExecution(){
        contr.initiateSale();
        System.out.println("A new Sale has begun");
        printSaleinfo(contr.enterItem(0, 3));
        printSaleinfo(contr.enterItem(1, 2));
        printSaleinfo(contr.enterItem(10, 2));
        printSaleinfo(contr.enterItem(2, 1));
        int totalPrice = contr.endSale();
        int change = contr.paidAmount(500);

    }

    private void printSaleinfo(Sale saleInfo){

        if (saleInfo == null) {
            System.out.println("ERROR: ITEM COULD NOT BE IDENTIFIED\n");
            return;
        }
   
        System.out.println("Current Sale:");
        System.out.println("Description:  Price: ");
        System.out.println("--------------------------");
        Cart cart = saleInfo.getCart();
        ArrayList<Item> cartItems = cart.getItemsInCart();
        for (int i = 0; i < cartItems.size(); i++) {
            Item item = cartItems.get(i);
            System.out.println(item.getItemName() + "           " + item.getItemPrice()+"x"+item.getQuantity());
        }
   
        System.out.println("Running Total: " + saleInfo.getRunningTotal());
        System.out.println("--------------------------\n");
   
    }
}
