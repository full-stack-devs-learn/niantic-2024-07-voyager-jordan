package com.niantic.exercises;

import com.niantic.models.OrderLineItem;

import java.util.ArrayList;
import java.util.Objects;


/*
The exercises in this class are optional - this is the challenge exercise
 */
public class Order
{
    // this ArrayList is the container (shopping cart) for all items that are being ordered
    private ArrayList<OrderLineItem> shoppingCart = new ArrayList<>();

    public ArrayList<OrderLineItem> getShoppingCart()
    {
        return shoppingCart;
    }

    /*
    1. Add logic to allow a user to add an Item to a shopping cart
        - if the item already exists in the cart, update the quantity
        - search for a line item by name, and add the new quantity to the original quantity
     */
    public void addItem(OrderLineItem item)
    {
        boolean isAdded = false;

        for(var myItem : shoppingCart){
            if(Objects.equals(myItem.getProduct(), item.getProduct())){
                myItem.setQuantity(myItem.getQuantity() + item.getQuantity());
                isAdded = true;
                break;
            }
        }
        if (!isAdded){
            shoppingCart.add(item);
        }

    }

    /*
    2. Add logic to allow a user to add an Item to a shopping cart
        - search for a line item by name, and remove it from the list
     */
    public void removeItem(OrderLineItem item)
    {
        shoppingCart.remove(item);
    }

    /*
    3. Search for the highest priced item in the shopping cart and return the
        line item that contains that item.

        If the shopping cart is empty return null
     */
    public OrderLineItem findHighestPriceProduct()
    {
        double highestPricedItem = shoppingCart.getFirst().getPrice();
        int indexOfItem = 0;

        for(var i = 1; i < shoppingCart.size(); i++){
            if(shoppingCart.get(i).getPrice() > highestPricedItem){
                highestPricedItem = shoppingCart.get(i).getPrice();
                indexOfItem = i;
            }
        }
        return shoppingCart.get(indexOfItem);
    }

    /*
    4. Search for the most expensive line item in the shopping cart
        and return it

        If the shopping cart is empty return null
     */
    public OrderLineItem findMostExpensiveLineItem()
    {
        double highestPricedItem = shoppingCart.getFirst().getLineTotal();
        int indexOfItem = 0;

        if(shoppingCart.isEmpty()){return null;};

        for(var i = 1; i < shoppingCart.size(); i++){
            if(shoppingCart.get(i).getLineTotal() > highestPricedItem){
                highestPricedItem = shoppingCart.get(i).getLineTotal();
                indexOfItem = i;
            }
        }
        return shoppingCart.get(indexOfItem);

    }

    /*
    5. Calculate and return the order total
     */
    public double getOrderTotal()
    {
        double orderTotal = 0;
        for(var lineItem :shoppingCart){
            orderTotal += lineItem.getLineTotal();
        }
        return orderTotal;
    }

    /*
    6. Return the total number of items in the cart
     */
    public int getTotalItemCount()
    {
        int itemCount = 0;

        for(var item : shoppingCart){
            itemCount += item.getQuantity();
        }

        return itemCount;
    }

    /*
    7. Calculate the average price for all items in the shopping cart
     */
    public double getAveragePricePerItem()
    {
        double average = 0;
        int itemCount = 0;

        for(var item : shoppingCart){
            average += item.getPrice() * item.getQuantity();
            itemCount += item.getQuantity();
        }
        return average / itemCount;
    }
}
