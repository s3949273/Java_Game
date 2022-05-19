
import java.util.ArrayList;
public class NPCS {
    public class shopOwner{
        ArrayList<Item> shop = new ArrayList<>();      
        /**
         * UI:      |     armour     |       weapons     |       buy with ur money and go broke|
         *  -> public class Item -> name, price etc.. 
         *   
         */
        public static class Item{
            double price;
            String description;
            Object type;
            String name;
            public Item(){
                this.name = " Common Wooden Sword";
                this.description = "Wooden sword but it isn't broken this time";
                User a= new User();
                User.Equipment b = a.new Equipment();
                User.Equipment.Weapons c= b.new Weapons();
                User.Equipment.Weapons.Sword d = c.new Sword();
                this.type = d;
                this.price = 10;
            }
            public Item(String name, double price){
                this.name = name;
                this.price = price;
                this.description = "No description given";
            }
            public Item(String name, String description, double price){
                this.name = name;
                this.description = description;
                this.price = price;
            }
        }
        public void buyItem(Item i, User u){
            if(shop.contains(i)){
                System.out.println("");
                if(u.get("money")>=i.price){
                    System.out.println("beginning the buying process...");
                    shop.remove(i);
                    System.out.println("removed item from shop...");
                    u.takeAwayFrom("money", i.price);
                    System.out.println("taken the funds from user...");
                    u.inventory.add(i);
                    System.out.println("added item to user's inventory...");
                    System.out.println("transaction complete!");
                    u.setSave("/Users/t/Desktop/coding/Java/game/Save.txt", u.stats);
                }else{
                    System.out.println("you do not have the funds to complete this transaction");
                }
            }else{
                System.out.println("Internal error: shop does not contain the item you wish to purchase");
            }
        }




    }
    public class QuestGiver{
    }
    public class Blacksmith{
        
    }
}
