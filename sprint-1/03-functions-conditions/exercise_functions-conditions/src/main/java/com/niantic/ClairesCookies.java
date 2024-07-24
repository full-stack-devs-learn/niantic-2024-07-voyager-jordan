package com.niantic;

public class ClairesCookies
{
    @SuppressWarnings("unused") 
    private final double TaxRate = .0575;

    /*
     * Claire's cookies cost $12.95 a dozen.
     *
     * A customer places an order with a quantity
     * of how many dozen cookies they want to order.
     *
     * This calculateSubtotal function should calculate
     * the price of an order before the cost of tax
     * is added.
     *
     * calculateSubtotal(1) -> 12.95
     * calculateSubtotal(2) -> 25.90
     * calculateSubtotal(5) -> 64.75
     */
    public double calculateSubtotal(int quantity)
    {
        double pricePerDozen = 12.95;
        return quantity * pricePerDozen;
    }

    /*
     * Claire is required to charge her customers
     * a 5.75% tax rate on all orders.
     *
     * Her cookies cost $12.95 a dozen.
     *
     * A customer places an order with a quantity
     * of how many dozen cookies they want to order.
     *
     * The calculateTotal function should calculate
     * the price of an order BEFORE the cost of tax
     * is added.
     *
     * calculateTotal(1) -> 13.69
     * calculateTotal(2) -> 27.39
     * calculateTotal(5) -> 68.47
     */
    public double calculateTotal(int quantity)
    {
        //Declared a taxRate Variable
        double taxRate = 5.75;
        //Convert to percentRate to be able to calculate the tax total
        double percentRate = taxRate / 100;
        //Used previous function to get total before tax
        double beforeTaxTotal = calculateSubtotal(quantity);
        //Calculate tax amount
        double taxTotal = beforeTaxTotal * percentRate;
        //Return the before price and tax price together
        return beforeTaxTotal + taxTotal;
    }

    /*
     * Snicker Doodles, Chocolate Chip and Frosted Chocolate Chip
     * cookies are the most popular cookies that Claire sells.
     *
     * Following is the cost of the cookies:
     * -------------------------------------
     * Snicker Doodles:        $12.95 / dz
     * Chocolate Chip:         $13.95 / dz
     * Frosted Chocolate Chip: $15.95 / dz
     *
     * For these popular orders, customers
     * can just choose how many dozen of each popular
     * cookie they would like to have.
     *
     * Parameters:
     * snickerDozen = quantity of Snicker Doodles Dozens
     * chocolateDozen = quantity of Chocolate Chip Dozens
     * frostedDozen = quantity of Frosted Chocolate Chip Dozens
     *
     * Calculate the total price of an order.
     * (Don't forget to add the tax)
     *
     * calculateQuickOrder(1,1,1) -> 45.31
     * calculateQuickOrder(0,3,2) -> 77.99
     * calculateQuickOrder(3,1,0) -> 55.84
     * calculateQuickOrder(2,0,2) -> 61.12
     */
    public double calculateQuickOrder(int snickerDozen, int chocolateDozen, int frostedDozen)
    {
        double taxRate = 5.75;
        double percentRate = taxRate / 100;
        double snickerDoodlePrice = 12.95;
        double chocolateChipPrice = 13.95;
        double frostedChipPrice = 15.95;

        double grandTotal = 0;
        // Cookie * percentRate gives TAX AMOUNT + cookie price gives TAXED TOTAL of ONE order than multiplied for qty
        double snickerDoodleTotal = (snickerDoodlePrice * percentRate + snickerDoodlePrice) * snickerDozen;
        double chocolateChipTotal = (chocolateChipPrice * percentRate + chocolateChipPrice) * chocolateDozen;
        double frostedChipTotal = (frostedChipPrice * percentRate + frostedChipPrice) * frostedDozen;

        // Adds all totals and returns
        grandTotal = snickerDoodleTotal + chocolateChipTotal + frostedChipTotal;

        return grandTotal;
    }


    /*
     * Claire also allows customers to customize their
     * cookies. They can choose to add chocolate chips
     * or add frosting to any of her cookies for an
     * additional cost.
     *
     * Extra ingredient cost
     * ---------------------
     * base cookie price: $12.95 / dz
     * chocolate chips:   $ 1.00 / dz
     * frosting:          $ 2.00 / dz
     *
     * Parameters:
     * quantity = the number of dozens of cookies ordered
     * hasChocolateChips = if true, add $1.00 to the cost of each dozen
     * hasFrosting = if true, add $2.00 to the cost of each dozen
     *
     * calculateCustomOrder (1, true, true) -> 16.87
     * calculateCustomOrder (2, true, false) -> 29.50
     * calculateCustomOrder (3, false, true) -> 47.43
     * calculateCustomOrder (5, true, false) -> 73.76
     */
    public double calculateCustomOrder (int quantity, boolean hasChocolateChips, boolean hasFrosting)
    {
        double currentTotal = 0;
        double taxRate = 5.75;
        double percentRate = taxRate / 100;

        for (int i = 0; i < quantity; i++){
            double cookiePrice = 12.95;
            //Adds extras
            if (hasChocolateChips){
                cookiePrice += 1;
            }
            if (hasFrosting){
                cookiePrice += 2;
            }
            //Calculates tax then adds to cookie price; Adds to current total
            currentTotal += cookiePrice * percentRate + cookiePrice;
        }
        return currentTotal;


    }

}