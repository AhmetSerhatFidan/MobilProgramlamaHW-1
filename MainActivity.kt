package com.ahmetserhatfidan.hw_1

//Item Class
open class   Item(var name : String, var price : Double){   
}

//Food Class
class Food(name : String, price : Double, var weight : String) : Item(name, price){
}

//Cloth Class
class Cloth(name : String, price : Double, var type : String) : Item(name, price){   
}

//Shopping List Class
class ShoppingList(){
    var itemList = mutableListOf<Item>()

// İtem Adding Fuction
    fun addItem(){

        print("Please enter the item type you want to add: (1->Food, 2->Cloth)")
        var item = readln().toInt()
        if(item == 1){
            print("Please enter the food name:")
            var foodName = readln()
            print("Please enter the food price:")
            var foodPrice = readln().toDouble()
            var foodWeight = readln()
            itemList.add(Food(foodName,foodPrice,foodWeight))
            println("${foodName} is added successfully.")
        }

        else if (item == 2){
            print("Please enter the cloth name:")
            var clothName = readln()
            print("Please enter the cloth price:")
            var clothPrice = readln().toDouble()
            print("Please enter the cloth type:")
            var clothType = readln()
            itemList.add(Cloth(clothName,clothPrice, clothType))
            println("${clothName} is added successfully.")
        }
        
	else{
            println("Error: Item not found !")
            addItem()			        }
    }

//Displaying Item Function
    fun displayItem(){
        for (i in itemList){
            if(i is Food) {
                println("${i.name} , ${i.price}$, ${i.weight}kg")
            }

            if(i is Cloth) {
                println("${i.name} , ${i.price}$, ${i.type}")
            }
        }

    }

//Deleting Item Function
    fun deleteItem(){
        println("Please enter the item name you want to delete:")
        var item = readln()
        for (i in itemList){
            if(item == i.name) {
                itemList.remove(i)
                println("$item is deleted successfully.")
                break
            }
        }
    }

}

fun main(){
    println("----SHOPPING LIST APP----")

    var shoppingList = ShoppingList()
    while (true){
        println("Make your choice: (1-2-3-4)")
        println("1. Add Item")
        println("2. Display Item")
        println("3. Delete Item")
        println("4. Exit")
        print("Your choice is: ")
        var choice = readln().toInt()

        if(choice ==1) shoppingList.addItem()
        else if (choice == 2) shoppingList.displayItem()
        else if (choice == 3) shoppingList.deleteItem()
        else if (choice == 4){
            println("Exiting...")
            break
        }
        else println("Error: Wrong choice! Please try again.")
    }
}
