/*
1.	Pizza Shack sells the best pizza in town.

	When customers are ready to order, they should
	be able to see a list of toppings that are 
	included on each type of pizza.

	getToppings("Hawaiian") => ["Ham","Pineapple","Mushroom"]
	getToppings("Cowboy") => ["Pepperoni", "Sausage", "Beef"]
	getToppings("Supreme") => ["Pepperoni", "Sausage", "Pepper", "Onion", "Black Olives"]
	getToppings("Vegetarian") => ["Spinach", "Zucchini", "Mushroom", "Artichoke", "Tomato", "Onion"]
	getToppings("Cheese") => ["Cheese"]

*/
function getToppings(pizzaString){

	const loweredPizzaType = pizzaString.toLowerCase();
	

	switch(loweredPizzaType){
		case "hawaiian":
			return ["Ham","Pineapple","Mushroom"]
		case "cowboy":
			return ["Pepperoni", "Sausage", "Beef"]
		case "supreme":
			return ["Pepperoni", "Sausage", "Pepper", "Onion", "Black Olives"]
		case "vegetarian":
			return ["Spinach", "Zucchini", "Mushroom", "Artichoke", "Tomato", "Onion"]
		case "cheese":
			return ["Cheese"]
		default:
			return []
	}
}


/*
2.	Pizza Shack sells the best pizza in town.

	When a customer places an order we make the pizza.
	the makePizza function should return a 
	pizza object with a name, and the list of toppings.

	makePizza("Hawaiian") => {
								name: "Hawaiian",
								toppings: ["Ham","Pineapple","Mushroom"]
							}

*/
function makePizza(pizzaString){


	let formattedPizza = pizzaString.charAt(0).toUpperCase() + pizzaString.toLowerCase().slice(1)

	const pizzaObj = {
		name: formattedPizza,
		toppings: getToppings(pizzaString)
	}

	//Check for invalid pizza
	if(pizzaObj.toppings.length == 0){
		return {}
	}

	return pizzaObj
}



/*
3.	Pizza Shack sells the best custom pizza in town.

	If a customer wants to order a custom pizza they
	can order up to 3 toppings. The makeCustom function
	should create the new pizza as follows...

	makeCustom("chicken") => 
					{
						name: "Custom",
						toppings: ["chicken"]
					}

	makeCustom("chicken", "mushroom") => 
					{
						name: "Custom",
						toppings: ["chicken", "mushroom"]
					}

	makeCustom("chicken", "mushroom", "artichokes") => 
					{
						name: "Custom",
						toppings: ["chicken", "mushroom", "artichokes"]
					}

	// a custom order with no toppings is not allowed an should return
	// an empty object
	makeCustom() => {}

*/
function makeCustom(){
	
	let toppingsArr = [];

	for(let key in arguments){
		toppingsArr.push(arguments[key])
	}

	//Check for empty pizza toppings
	if(toppingsArr.length === 0){return {}}

	let pizzaObj = {
		name: "Custom",
		toppings: toppingsArr
	}

	return pizzaObj;
}


/*
4.	Customers may want to order multiple pizzas on a single order.

	When a customer places an order you should create an order object.
	This includes the customer name, and an array of all the pizzas
	that they have ordered.

	createOrder("Gary", true, false, false, false, false) => 
		{
			customer: "Gary",
			pizzas: [
				{
					name: "Hawaiian",
					toppings: [
						"Ham",
						"Pineapple",
						"Mushroom"
					]
				}
			]
		}
	

	createOrder("Gary", true, false, false, false, true) => 
		{
			customer: "Gary",
			pizzas: [
				{
					name: "Hawaiian",
					toppings: [
						"Ham",
						"Pineapple",
						"Mushroom"
					]
				},
				{
					name: "Cheese",
					toppings: [
						"Cheese"
					]
				}
			]
		}


*/
function createOrder(customerName){

	//Return Value
	let receiptObj = {
		customer: customerName,
		pizzas: []
	}
	
	//Isolates Pizza Selections
	let pizzaChoices = [];
	for(let key in arguments){
		if(key == 0){
			continue;
		}
		pizzaChoices.push(arguments[key])
	}

	//EDGECASE -> IF NO TRUE VALUE EXISTS RETURN EMPTY OBJ
	if(pizzaChoices.indexOf(true) === -1){ return {} }

	//Construct pizza
	for(let i = 0 ; i < pizzaChoices.length; i++){
		switch(i){
			case 0:
				if(pizzaChoices[i] === true){
					receiptObj.pizzas.push(makePizza("Hawaiian"))
					break;
				}
			case 1:
				if(pizzaChoices[i] === true){
					receiptObj.pizzas.push(makePizza("Cowboy"))
					break;
				}
			case 2:
				if(pizzaChoices[i] === true){
					receiptObj.pizzas.push(makePizza("Supreme"))
					break;
				}
			case 3:
				if(pizzaChoices[i] === true){
					receiptObj.pizzas.push(makePizza("Vegetarian"))
					break;
				}
			case 4:
				if(pizzaChoices[i] === true){
					receiptObj.pizzas.push(makePizza("Cheese"))
					break;
				}
		}
	}
	
	return receiptObj

}
