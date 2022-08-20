
public class Game {
    public static String filePath = "/Users/t/Desktop/coding/Java/Java_Game-1/Save.txt";
    public static void main(String[] args) {
        User user = new User(filePath);
        Weapons w = new Weapons();
        Weapons.Staff s = w.new Staff();
        NPCs npcs = new NPCs();
        NPCs.shopKeeper sKeeper = npcs.new shopKeeper();
        NPCs.shopKeeper.Item i1 = sKeeper.new Item(1);
       i1.printInfo(); 
    }
}   
