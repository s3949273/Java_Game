import java.util.ArrayList;

public class NPCs {
    public class shopKeeper{
    
        public class Item{
            public double price;
            public double itemId;
            public String type;
            public String name;
            public String description; 
            public Item(double a){
                this.itemId = a;
                this.price = 10.0;
                this.type = "Weapons.Sword";
                this.name = "sword";
                this.description = "wooden sword";
            }
            //get al the items possible
            public Item[] getAllItems(){
                Item[] ret = new Item[10];
                
                return ret;
            }

            public void printInfo(){
                System.out.println("Name:"+this.name+ ",Description"+this.description+ ", Type:"+this.type+", Price: "+this.price);
            }
        }
        public shopKeeper(){
            //easiser to initialise shop inside of shopkeeper to save memory
            ArrayList<Item> shop = new ArrayList<>();
            for(int i =0; i<10; i++){
                // initialise shop with 10 items
                shop.add(new shopKeeper.Item(i));
            }
        }
        
        
    }
    public class blackSmith{

    }
    public class QuestGiver{
        public class Quest{
            double coinReward;
            String name;
            String description;
            Object otherRewards;
            public Quest(){
                    
            }

        }
        // public Quest[] initialise(){

        // }
    }
}
