/*
1.	Claire's cookies cost $12.95 a dozen.

	A customer places an order with a quantity
	of how many dozen cookies they want to order.

	This CalculateSubtotal function should calculate
	the price of an order before the cost of tax
	is added.

	calculateOrderSubtotal(1) -> 12.95
	calculateOrderSubtotal(2) -> 25.90
	calculateOrderSubtotal(5) -> 64.75

*/

function calculateOrderSubtotal(quantity)
{
	const PRICE = 12.95;

	return quantity * PRICE; 
}


/*
2.	Claire's cookies cost $12.95 a dozen.
	The food tax rate is 5.75%

	A customer places an order with a quantity
	of how many dozen cookies they want to order.

	The calculateTax function should calculate
	the amount of tax to charge for an order.

	Hint: search for JavaScript Math functions

	calculateTax(1) -> 13.69
	calculateTax(2) -> 27.39
	calculateTax(5) -> 68.47

*/

function calculateTax(quantity)
{	
	const PRICE = 12.95;
	const TAX_RATE = 5.75 / 100;
	let tax_amount = PRICE * TAX_RATE

	return Math.round(tax_amount * quantity * 100) / 100;
}



/*
3.	Claire's cookies cost $12.95 a dozen.
	The food tax rate is 5.75%

	A customer places an order with a quantity
	of how many dozen cookies they want to order.

	The calculateOrderTotal function should calculate
	the price of an order plus the cost of tax.

	Hint: search for JavaScript Math functions

	calculateOrderTotal(1) -> 13.69
	calculateOrderTotal(2) -> 27.39
	calculateOrderTotal(5) -> 68.47

*/
	
// create your function here
function calculateOrderTotal(quantity){

	const PRICE  = 12.95;
	const TAX_RATE = 5.75 / 100;
	let total = (PRICE + PRICE * TAX_RATE) * quantity;
	

	return Math.round((total * 100)) / 100;

}

/*
3.	With each order Claire needs to generate 
	a receipt to print for the customer
	and to store for her records.

	The receipt must include this information

	Customer name
	quantity (# of cookies in dozens)
	Subtotal
	Tax
	Total

	When a customer places an they specify their
	name, and the quantity of cookies that they 
	want to order (in dozens)

	The place order function should perform all
	calculations and return the receipt in 
	JavaScript object format as follows:

	placeOrder("Sean", 1) =>	{
									customer: "Sean"
									quantity: 1,
									subtotal: 12.95,
									tax: .74,
									total: 13.69
								}
	placeOrder("Sean", 2) =>	{
									customer: "Sean"
									quantity: 2,
									subtotal: 25.90,
									tax: 1.49,
									total: 27.39
								}


*/

// create your function here
function placeOrder(customer, quantity){
	const receiptObj = {
		customer: customer,
		quantity: quantity,
		subtotal: calculateOrderSubtotal(quantity),
		tax: calculateTax(quantity),
		total: calculateOrderTotal(quantity)
	}

	return receiptObj
}


/*
5.	Sean's classes have all earned a cookie party. 
	The number of cookies that each student receives 
	depends on their current grade in Sean's class.

	A students = 4 cookies
	B students = 3 cookies
	everyone else 2 cookies

	Claire's Cookies only sells by the dozen. Create a function
	that calculates how many dozen cookies Sean needs
	to buy based on the students grades	

	calculateCookiesNeeded(2, 4, 8) → 3
	calculateCookiesNeeded(1, 5, 12) → 5
	calculateCookiesNeeded(2, 2) → 8

*/

// create your function here
function calculateCookiesNeeded(aStudents, bStudents, elseStudents){

	const A_TOTAL = aStudents * 4;
	const B_TOTAL = bStudents * 3;
	const ELSE_TOTAL = elseStudents * 2;
	const dozen = 12;

	const cookieTotal = A_TOTAL + B_TOTAL + ELSE_TOTAL;

	return Math.ceil(cookieTotal / dozen)
}