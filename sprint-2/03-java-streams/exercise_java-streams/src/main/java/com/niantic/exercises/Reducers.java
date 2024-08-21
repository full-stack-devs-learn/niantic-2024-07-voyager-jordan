package com.niantic.exercises;

import com.niantic.models.LineItem;

import java.util.Collections;
import java.util.List;

public class Reducers
{

    /*
    1) using one or more Java Stream functions calculate the total sales amount
       for all line items in the given list.

       hint: use the getLineTotal() method to calculate the sales total

     */
    public double totalSales(List<LineItem> lineItems)
    {
        var totalSales = lineItems.stream()
                .map(LineItem::getLineTotal)
                .reduce(0.0, (sum, add)-> sum + add);

        return totalSales;
    }

    /*
    2) using one or more Java Stream functions calculate the average sales amount
       per line items in the given list.

     */
    public double averageSalesPerLineItem(List<LineItem> lineItems)
    {
        var averageSalesPer = lineItems.stream()
                .map(LineItem::getLineTotal)
                .reduce(0.0, (sum, add) -> sum + add);

        return averageSalesPer / lineItems.size();
    }

    /*
    3) using one or more Java Stream functions calculate the average sales amount
       per items in the given list.

       hint: unlike problem number 2, we are not looking for the average of line totals
       we are looking for the average of each item (line items can have multiple quantities
       of a single item)

     */
    public double averageSalesPerItem(List<LineItem> lineItems)
    {
        var itemCount = lineItems.stream()
                .map(LineItem::getQuantity)
                .reduce(0, (sum, qty) -> sum + qty);

        var totalPrice = lineItems.stream()
                        .map(LineItem::getLineTotal)
                        .reduce(0.0, (sum, qty) -> sum + qty);
        
        var average = totalPrice / itemCount;

        return average;
    }

    /*
    4) using one or more Java Stream functions calculate the total number
       of items that were purchased.

       hint: line items can have multiple quantities of an item

     */
    public int totalItemCount(List<LineItem> lineItems)
    {
        var totalItemCount = lineItems.stream()
                .map(LineItem::getQuantity)
                .reduce(0, (total, add) -> total + add);

        return totalItemCount;
    }

    /*
    5) using one or more Java Stream functions calculate the average number
       of items that were purchased per line item.

     */
    public double averageItemCount(List<LineItem> lineItems)
    {

        var itemCount = lineItems.stream()
                .map(LineItem::getQuantity)
                .reduce(0, (sum, qty) -> sum + qty);

        var average = (double) itemCount / lineItems.size();

        return average;
    }

    /*
    6) using one or more Java Stream functions find the most expensive line item.

     */
    public double maxLineItem(List<LineItem> lineItems)
    {
        var listOfTotals = lineItems.stream()
                .map(LineItem::getLineTotal)
                .toList();

        double biggestValue = Collections.max(listOfTotals);

        return biggestValue;
    }

    /*
    7) using one or more Java Stream functions find the least expensive line item.

        hint: the least expensive line item is not $0.00

     */
    public double minLineItem(List<LineItem> lineItems)
    {
        var listOfTotals = lineItems.stream()
                .map(LineItem::getLineTotal)
                .toList();

        double smallestValue = Collections.min(listOfTotals);

        return smallestValue;
    }

}
