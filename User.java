import java.io.File;
import java.lang.reflect.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
/*
    TO DO: 
       
        
        enemy lores:
            tintansan's legacy
        enemy loot drops;
        new tests
    IN PROGRESS:
        stringify()
        setSave()
        getSave()
        checkNames()
        fight()
             DOTs
    DONE:
        create stats hashmap
        create inventory
        create active equipment
        make only one of a type of object equippable in active equipment
        enums for prefixes and materials
        add to
        take away from


*/
public class User {
    public static final String filepath = "/Users/t/Desktop/coding/Java/game/Save.txt";
    public enum Prefixes{
        Torn,Broken, Common, Uncommon, Rare, Superior, Epic, Legendary, Celestial, Demonic
    }
    public enum materials{
        Wooden, Leather, Iron, Copper, Titanium, Palladium, Tungsten, Adamantium, DarkMatter, CelestialMatter;
    }
    public enum DotType{
        BLEED, BURN, POISON, CORROSION, NONE;
    }
    public enum CrowdControl{
        FREEZE, STUN, PARALYSE, HORRIFY, CHARM, DISORIENT, INCAPACITATE, NONE;
    }
    public HashMap<String, Double> stats = new HashMap<>();
    public static ArrayList<Object> activeEquipment = new ArrayList<>();
    //activeEquipment should only allow for one object of each type
    public static ArrayList<Object> inventory = new ArrayList<>();
    public ArrayList<Object> minerals = new ArrayList<>();
    public static HashMap<String,Double> getSave(String filePath){
        HashMap<String, Double> a = new HashMap<>();
        //this is to return a hashmap... if you look to the bottom of this method, there is return a; we are storing all the 
        //file contents to the hashmap and then returning the hashmap
        try{
            File file = new File(filePath);
            Scanner reader = new Scanner(file);
            
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                //data = myEd.decrypt(data);
                data = data.substring(1,(data.length()-1));
                String[] allSplit = data.split(", ");
                for(int i=0; i<allSplit.length; i++){
                    String [] subSplit = allSplit[i].split("=");
                    a.put(subSplit[0], Double.parseDouble(subSplit[1]));
                }
            }
            reader.close();
            System.out.println("got save successfully! closed reader");
        }catch(Exception e){
            System.out.println("error occured");
            e.printStackTrace();
        }
        return a;
    }
    public static void setSave(String filepath, HashMap<String, Double>a){
        File file = new File(filepath);
        String toWrite = a.toString();
        String tooWrite = stringify();
        try{

            FileWriter fw = new FileWriter(file);
            fw.write(toWrite +"\n");
            //create a new line and then append the inventory
            fw.append(tooWrite);
            fw.close();
            System.out.println("successfully wrote to file and closed the filewriter");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static double getNeededExp(double level){
        return Math.pow(level, 1.5)*50;
    }
    public double get(String key){
        return this.stats.get(key);
    }
    public void set(String key, double value){
        this.stats.put(key, value);
    }
    public void addTo(String key, double value){
        this.stats.put(key, (this.stats.get(key)+value));
    }
    public void takeAwayFrom(String key, double value){
        this.stats.put(key, (stats.get(key)-value));
    }
    public static boolean checkIsObjEquipped(Object a){
        if(a instanceof Equipment.Weapons.Gun){
            for(int i = 0; i<activeEquipment.size(); i++){
                Object curObject = activeEquipment.get(i);
                if(curObject instanceof Equipment.Weapons.Gun){
                    return true;
                }
            }
        }else if(a instanceof Equipment.Weapons.Bow){
            for(int i = 0; i<activeEquipment.size(); i++){
                Object curObject = activeEquipment.get(i);
                if(curObject instanceof Equipment.Weapons.Bow){
                    return true;
                }
            }
        }else if(a instanceof Equipment.Weapons.Staff){
            for(int i = 0; i<activeEquipment.size(); i++){
                Object curObject = activeEquipment.get(i);
                if(curObject instanceof Equipment.Weapons.Staff){
                    return true;
                }
            }

        }else if(a instanceof Equipment.Weapons.Sword){
            for(int i = 0; i<activeEquipment.size(); i++){
                Object curObject = activeEquipment.get(i);
                if(curObject instanceof Equipment.Weapons.Sword){
                    return true;
                }
            }

        }
        /*else if(a instanceof Equipment.Weapons.shield){
        //     for(int i = 0; i<activeEquipment.size(); i++){
        //         Object curObject = activeEquipment.get(i);
        //         if(curObject instanceof Equipment.Weapons.shield){
        //             return true;
        //         }
        //     }
        }
        */
        else if(a instanceof Equipment.Armour.helmet){
            for(int i = 0; i<activeEquipment.size(); i++){
                Object curObject = activeEquipment.get(i);
                if(curObject instanceof Equipment.Armour.helmet){
                    return true;
                }
            }
        }
        else if(a instanceof Equipment.Armour.chestPiece){
            for(int i = 0; i<activeEquipment.size(); i++){
                Object curObject = activeEquipment.get(i);
                if(curObject instanceof Equipment.Armour.chestPiece){
                    return true;
                }
            }
        }
        else if(a instanceof Equipment.Armour.leggings){
            for(int i = 0; i<activeEquipment.size(); i++){
                Object curObject = activeEquipment.get(i);
                if(curObject instanceof Equipment.Armour.leggings){
                    return true;
                }
            }
        }
        else if(a instanceof Equipment.Armour.boots){
            for(int i = 0; i<activeEquipment.size(); i++){
                Object curObject = activeEquipment.get(i);
                if(curObject instanceof Equipment.Armour.boots){
                    return true;
                } 
            }
        }
        else if(a instanceof Equipment.accessory.ring){
            int counter=0;
            for(int i = 0; i<activeEquipment.size(); i++){
                Object curObject = activeEquipment.get(i);
                if(curObject instanceof Equipment.accessory.ring){
                    counter+=1;
                }
                if(counter == 5){               
                    if(counter >5){
                        System.out.println("You have too many rings equipped!");
                        return true;
                    }
                    return true;
                }
                
            }
        }
        else if(a instanceof Equipment.accessory.dagger){
            int counter=0;
            for(int i = 0; i<activeEquipment.size(); i++){
                Object curObject = activeEquipment.get(i);
                if(curObject instanceof Equipment.accessory.dagger){
                    counter+=1;
                }
                if(counter == 2){               
                    if(counter >2){
                        System.out.println("You have too many daggers equipped!");
                        return true;
                    }
                    return true;
                }
                
            }
        }
        else if(a instanceof Equipment.accessory.armBand){
            int counter=0;
            for(int i = 0; i<activeEquipment.size(); i++){
                Object curObject = activeEquipment.get(i);
                if(curObject instanceof Equipment.accessory.armBand){
                    counter+=1;
                }
                if(counter == 5){               
                    if(counter >5){
                        System.out.println("You have too many arm bands equipped!");
                    }
                    return true;
                }
                
            }
        }
        return false;
    }
    public static void checkNames(int index){
          /**
         * checks if the names of two Objects in the inventory are the same, e.g. Object a = Broken wooden sword and  Object b = Broken wooden sword
         * so we want to loop through the whole inventory and check how many occurances of name duplications are happening.
         * we need a counter so that we can add that counter's value to the end of the names once we have identified the duplicates.
         * want to go through the inventory only once, so if we are checking the first item, we only want to check that particular item against the others
         * not all items against all other items, what we can rather do is that then we can recursively call the checknames function until the index 
         * parameter is equal to or above the size of the inventory in which case just print out something and do nothing
         */
        System.out.println("starting at index: "+index);
        if(index == inventory.size()){
            //if you are already at the end of the inventory don't do anything
            System.out.println("reached end of inventory");
        }else{
            //you are not at the end of the inventory
        Object comparing = inventory.get(index);
        int counter = 1;
        for(int i =0; i<inventory.size(); i++){
            //search for instances where two object names are the same
            Object comparingTo = inventory.get(i);
            if(comparingTo instanceof User.Equipment.Weapons.Bow && comparing instanceof User.Equipment.Weapons.Bow && index != i){
                //the two objects are both instances of Bow but are not the same object
                User.Equipment.Weapons.Bow a = (User.Equipment.Weapons.Bow)comparing;
                User.Equipment.Weapons.Bow b = (User.Equipment.Weapons.Bow)comparingTo;
                //cast the two objects into Bow type
                if(a.name.equalsIgnoreCase(b.name)){
                    //if their names are equal even without case sensitivity add it to the indexes arrayList and add a number to the counter
                    //add the number of the counter;
                    System.out.println("new occurance between:"+ a.name+" "+b.name+" ");
                    b.name = b.name + "("+counter+")";
                    System.out.println("changed the latter's name to: "+b.name);
                    counter+=1;
                }
            }else if(comparingTo instanceof User.Equipment.Weapons.Gun && comparing instanceof User.Equipment.Weapons.Gun && index != i){
                //the two objects are both instances of Bow but are not the same object
                User.Equipment.Weapons.Gun a = (User.Equipment.Weapons.Gun)comparing;
                User.Equipment.Weapons.Gun b = (User.Equipment.Weapons.Gun)comparingTo;
                //cast the two objects into Bow type
                if(a.name.equalsIgnoreCase(b.name)){
                    //if their names are equal even without case sensitivity add it to the indexes arrayList and add a number to the counter
                    //add the number of the counter;
                    System.out.println("new occurance between:"+ a.name+" "+b.name+" ");
                    b.name = b.name + "("+counter+")";
                    System.out.println("changed the latter's name to: "+b.name);
                    counter+=1;
                }
            }else if(comparingTo instanceof User.Equipment.Weapons.Sword && comparing instanceof User.Equipment.Weapons.Sword && index != i){
                //the two objects are both instances of Bow but are not the same object
                User.Equipment.Weapons.Sword a = (User.Equipment.Weapons.Sword)comparing;
                User.Equipment.Weapons.Sword b = (User.Equipment.Weapons.Sword)comparingTo;
                //cast the two objects into Bow type
                if(a.name.equalsIgnoreCase(b.name)){
                    //if their names are equal even without case sensitivity add it to the indexes arrayList and add a number to the counter
                    //add the number of the counter;
                    System.out.println("new occurance between:"+ a.name+" "+b.name+" ");
                    b.name = b.name + "("+counter+")";
                    System.out.println("changed the latter's name to: "+b.name);
                    counter+=1;
                }
            }else if(comparingTo instanceof User.Equipment.Weapons.lance && comparing instanceof User.Equipment.Weapons.lance && index != i){
                //the two objects are both instances of Bow but are not the same object
                User.Equipment.Weapons.lance a = (User.Equipment.Weapons.lance)comparing;
                User.Equipment.Weapons.lance b = (User.Equipment.Weapons.lance)comparingTo;
                //cast the two objects into Bow type
                if(a.name.equalsIgnoreCase(b.name)){
                    //if their names are equal even without case sensitivity add it to the indexes arrayList and add a number to the counter
                    //add the number of the counter;
                    System.out.println("new occurance between:"+ a.name+" "+b.name+" ");
                    b.name = b.name + "("+counter+")";
                    System.out.println("changed the latter's name to: "+b.name);
                    counter+=1;
                }
            }else if(comparingTo instanceof User.Equipment.Weapons.Staff && comparing instanceof User.Equipment.Weapons.Staff && index != i){
                //the two objects are both instances of Bow but are not the same object
                User.Equipment.Weapons.Staff a = (User.Equipment.Weapons.Staff)comparing;
                User.Equipment.Weapons.Staff b = (User.Equipment.Weapons.Staff)comparingTo;
                //cast the two objects into Bow type
                if(a.name.equalsIgnoreCase(b.name)){
                    //if their names are equal even without case sensitivity add it to the indexes arrayList and add a number to the counter
                    //add the number of the counter;
                    System.out.println("new occurance between:"+ a.name+" "+b.name+" ");
                    b.name = b.name + "("+counter+")";
                    System.out.println("changed the latter's name to: "+b.name);
                    counter+=1;              
                }
            }else if(comparingTo instanceof User.Equipment.Armour.helmet && comparing instanceof User.Equipment.Armour.helmet && index != i){
                //the two objects are both instances of Bow but are not the same object
                User.Equipment.Armour.helmet a = (User.Equipment.Armour.helmet)comparing;
                User.Equipment.Armour.helmet b = (User.Equipment.Armour.helmet)comparingTo;
                //cast the two objects into Bow type
                if(a.name.equalsIgnoreCase(b.name)){
                    //if their names are equal even without case sensitivity add it to the indexes arrayList and add a number to the counter
                    //add the number of the counter;
                    System.out.println("new occurance between:"+ a.name+" "+b.name+" ");
                    b.name = b.name + "("+counter+")";
                    System.out.println("changed the latter's name to: "+b.name);
                    counter+=1;
                }
            }else if(comparingTo instanceof User.Equipment.Armour.chestPiece && comparing instanceof User.Equipment.Armour.chestPiece && index != i){
                //the two objects are both instances of Bow but are not the same object
                User.Equipment.Armour.chestPiece a = (User.Equipment.Armour.chestPiece)comparing;
                User.Equipment.Armour.chestPiece b = (User.Equipment.Armour.chestPiece)comparingTo;
                //cast the two objects into Bow type
                if(a.name.equalsIgnoreCase(b.name)){
                    //if their names are equal even without case sensitivity add it to the indexes arrayList and add a number to the counter
                    //add the number of the counter;
                    System.out.println("new occurance between:"+ a.name+" "+b.name+" ");
                    b.name = b.name + "("+counter+")";
                    System.out.println("changed the latter's name to: "+b.name);
                    counter+=1;
                }
            }else if(comparingTo instanceof User.Equipment.Armour.leggings && comparing instanceof User.Equipment.Armour.leggings && index != i){
                //the two objects are both instances of Bow but are not the same object
                User.Equipment.Armour.leggings a = (User.Equipment.Armour.leggings)comparing;
                User.Equipment.Armour.leggings b = (User.Equipment.Armour.leggings)comparingTo;
                //cast the two objects into Bow type
                if(a.name.equalsIgnoreCase(b.name)){
                    //if their names are equal even without case sensitivity add it to the indexes arrayList and add a number to the counter
                    //add the number of the counter;
                    System.out.println("new occurance between:"+ a.name+" "+b.name+" ");
                    b.name = b.name + "("+counter+")";
                    System.out.println("changed the latter's name to: "+b.name);
                    counter+=1;
                }
            }else if(comparingTo instanceof User.Equipment.Armour.boots && comparing instanceof User.Equipment.Armour.boots && index != i){
                //the two objects are both instances of Bow but are not the same object
                User.Equipment.Armour.boots a = (User.Equipment.Armour.boots)comparing;
                User.Equipment.Armour.boots b = (User.Equipment.Armour.boots)comparingTo;
                //cast the two objects into Bow type
                if(a.name.equalsIgnoreCase(b.name)){
                    //if their names are equal even without case sensitivity add it to the indexes arrayList and add a number to the counter
                    //add the number of the counter;
                    System.out.println("new occurance between:"+ a.name+" "+b.name+" ");
                    b.name = b.name + "("+counter+")";
                    System.out.println("changed the latter's name to: "+b.name);
                    counter+=1;
                }
            }

        }
        System.out.println("changed: "+(counter-1)+" names");
        checkNames(index+1);
        //index +1 becomes the new index to start at for the method
    }
        //starts the recursive loop which goes through all the items
    }
    public static String stringify(){
        //goes through the active equipment and inventory to stringify all of them to prepare to save them
        //knowing inventory contains more things we can use active equipment as a template, copy paste the for loop for ease
        //then just add the remaining elements which are not in active equipment
        String ret="{";
        for(int i = 0; i<inventory.size(); i++){
            Object curObj = inventory.get(i);
            if(curObj instanceof Equipment.Weapons.Bow){
                Equipment.Weapons.Bow bow = (Equipment.Weapons.Bow)curObj;
                ret+= bow.material + ":"+bow.prefix+":"+bow.name + ":"+bow.ammo + ":"+bow.bonus+":"+bow.damage+":"+bow.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Weapons.Gun){
                Equipment.Weapons.Gun a = (Equipment.Weapons.Gun)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.ammo + ":"+a.bonus+":"+a.damage+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Weapons.Sword){
                Equipment.Weapons.Sword a = (Equipment.Weapons.Sword)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.damage+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Weapons.Staff){
                Equipment.Weapons.Staff a = (Equipment.Weapons.Staff)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.damage+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Weapons.lance){
                Equipment.Weapons.lance a = (Equipment.Weapons.lance)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.damage+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Armour.helmet){
                Equipment.Armour.helmet a = (Equipment.Armour.helmet)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.defence+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Armour.chestPiece){
                Equipment.Armour.chestPiece a = (Equipment.Armour.chestPiece)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.defence+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Armour.leggings){
                Equipment.Armour.leggings a = (Equipment.Armour.leggings)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.defence+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Armour.boots){
                Equipment.Armour.boots a = (Equipment.Armour.boots)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.defence+":"+a.equipped;
                ret += ", ";
            }
        } 
        ret+="}\n{";
        for(int i = 0; i<activeEquipment.size(); i++){
            Object curObj = activeEquipment.get(i);
            if(curObj instanceof Equipment.Weapons.Bow){
                Equipment.Weapons.Bow bow = (Equipment.Weapons.Bow)curObj;
                ret+= bow.material + ":"+bow.prefix+":"+bow.name + ":"+bow.ammo + ":"+bow.bonus+":"+bow.damage+":"+bow.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Weapons.Gun){
                Equipment.Weapons.Gun a = (Equipment.Weapons.Gun)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.damage+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Weapons.Sword){
                Equipment.Weapons.Sword a = (Equipment.Weapons.Sword)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.damage+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Weapons.Staff){
                Equipment.Weapons.Staff a = (Equipment.Weapons.Staff)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.damage+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Weapons.lance){
                Equipment.Weapons.lance a = (Equipment.Weapons.lance)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.damage+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Armour.helmet){
                Equipment.Armour.helmet a = (Equipment.Armour.helmet)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.defence+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Armour.chestPiece){
                Equipment.Armour.chestPiece a = (Equipment.Armour.chestPiece)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.defence+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Armour.leggings){
                Equipment.Armour.leggings a = (Equipment.Armour.leggings)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.defence+":"+a.equipped;
                ret += ", ";
            }else if(curObj instanceof Equipment.Armour.boots){
                Equipment.Armour.boots a = (Equipment.Armour.boots)curObj;
                ret+= a.material + ":"+a.prefix+":"+a.name + ":"+a.bonus+":"+a.defence+":"+a.equipped;
                ret += ", ";
            }
        }
        ret = ret.substring(0,(ret.length()-2));
        //get rid of the last ','
        ret+="}";
        //close off the string with a curly bracket to neaten things up
        //System.out.println(ret);
        //just for testing
        return ret;
    }
    public void setUserClass(){
        if(get("userClass")==-1){
            System.out.println("please enter the class you would like to be.");
            System.out.println("The classes to choose from are: \nMage\nAssassin\nWarrior");
            System.out.println("press 1, M, m, Mage, or mage for Mage");
            System.out.println("press 2, A, a, Assassin or assassin for Assassin");
            System.out.println("press 3, W, w, Warrior or warrior for Warrior");
            Scanner scnr = new Scanner(System.in);
            String input = scnr.next();
            switch(input){
                case("1"):
                case("M"):
                case("m"):
                case("Mage"):
                case("mage"):
                    set("userClass", 1.0);
                    break;
                case("2"):
                case("A"):
                case("a"):
                case("Assassin"):
                case("assassin"):
                    set("userClass", 2.0);
                    break;
                case("3"):
                case("W"):
                case("w"):
                case("Warrior"):
                case("warrior"):
                    set("userClass", 3.0);   
                    break; 
                default:
                    set("userClass", -1.0);
                    setUserClass();
            }
            scnr.close();
            setSave(filepath, stats);
            System.out.println("Class selected: "+get("userClass"));     
        }
    }
    public User(){
        stats.put("userClass",-1.0);
        stats.put("health", 100.0);
        stats.put("maxHealth", 100.0);
        stats.put("attack", 10.0);
        stats.put("speed", 10.0);
        stats.put("level", 1.0);
        stats.put("currentExp", 0.0);
        stats.put("neededExp", 50.0);
        stats.put("money", 0.0);
        stats.put("critChance", 0.1);
        stats.put("critDamage", 100.0);
        stats.put("skillPoints", 0.0);
        stats.put("defence", 0.0);
        stats.put("ap", 0.0);
        stats.put("mp", 0.0);
        stats.put("dodge", 0.01);

    }
    public User(HashMap<String, Double> a){
        //order does not matter in a hashmap, its just so i know that i have all the stats from the default constructor here
        //as well
        set("userClass", a.get("userClass"));
        set("health", a.get("health"));
        set("maxHealth", a.get("maxHealth"));
        set("attack", a.get("attack"));
        set("speed", a.get("speed"));
        set("level", a.get("level"));
        set("currentExp", a.get("currentExp"));
        set("neededExp", a.get("neededExp"));
        set("money", a.get("money"));
        set("critChance", a.get("critChance"));
        set("critDamage", a.get("critDamage"));
        set("skillPoints", a.get("skillPoints"));
        set("defence", a.get("defence"));
        set("mp", a.get("mp"));
        set("ap", a.get("ap"));
        set("dodge", a.get("dodge"));
    }
    public User fight(Enemies a){
        Random rand = new Random();
        int weapInd=-1;
        String objClass;
        Boolean hasDot = hasDOT();
        if(a.get("speed")<get("speed")){
            //if the user's speed is faster than the monster's speed...
            while(a.get("health")>0 && get("health")>0){
                long timeNow = System.currentTimeMillis();
                if(hasDOT()){
                    try{
                        
                        //activate a dot for 10 seconds, which deals 1000% damage
                        //sharp people will pick up that the DOT lasts 10 seconds, however each set of attacks only last 400 milliseconds,
                        // the dot will stack to crazy amounts, usually the dot will not last 10 seconds, just maybe 2, 3 seconds
                        // and 200% or 300%
                        a.takeAwayFrom("health", get("attack"));
                        System.out.println("monster health: "+a.get("health"));
                        takeAwayFrom("health", a.get("attack"));
                        System.out.println("your health: "+this.get("health"));
                        Thread.sleep(200);
                        //attack the monster then the monster attacks you then wait 200 milliseconds before going again
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }else{
            while(a.get("health")>0 && get("health")>0){
                try{
                    //needed to handle thread exception when trying to get the thread to sleep
                    takeAwayFrom("health", a.get("attack"));
                    System.out.println("your health: "+get("health"));
                    a.takeAwayFrom("health", get("attack"));
                    System.out.println("monster health: "+a.get("health"));
                    //order matters
                    Thread.sleep(200);
                    //attack the monster then the monster attacks you then wait 200 milliseconds before going again
                }catch(Exception e){
                }
            }
        }
        //the fight is over, now to see who has won
        if(get("health")>0){
            //we only want the user to regen health if he is not dead lol, if he is dead we don't care
            RegenHealth();
            System.out.println("you've killed the monster");
            addTo("currentExp", a.get("givenExp"));
            return this;
        }else{
            System.out.println("you died, resetting world");
            return new User();
        }
    }
    public void RegenHealth(){
        while(get("health")<get("maxHealth")){
            try{
                addTo("health", 1);
                //add 1 point to health while health is less than maxHealth
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    //probably don't need the method below for a while
    // public boolean contains(Enum a , String b){
    
    //     return false;
    // }
    public boolean hasDOT(){
        if(activeEquipment.get(0) instanceof User.Equipment.Weapons.Sword){
            Equipment.Weapons.Sword a = (Equipment.Weapons.Sword)activeEquipment.get(0);
            if(a.getDotType() != DotType.NONE){
                return true;
            }
        }else if(activeEquipment.get(0) instanceof User.Equipment.Weapons.Bow){
            Equipment.Weapons.Bow a = (Equipment.Weapons.Bow)activeEquipment.get(0);
            if(a.getDotType() != DotType.NONE){
                return true;
            }
        }else if(activeEquipment.get(0) instanceof User.Equipment.Weapons.Gun){
            Equipment.Weapons.Gun a = (Equipment.Weapons.Gun)activeEquipment.get(0);
            if(a.getDotType() != DotType.NONE){
                return true;
            }
        }else if(activeEquipment.get(0) instanceof User.Equipment.Weapons.lance){
            Equipment.Weapons.lance a = (Equipment.Weapons.lance)activeEquipment.get(0);
            if(a.getDotType() != DotType.NONE){
                return true;
            }
        }
        else if(activeEquipment.get(0) instanceof User.Equipment.Weapons.Staff){
            Equipment.Weapons.Sword a = (Equipment.Weapons.Sword)activeEquipment.get(0);
            if(a.getDotType() != DotType.NONE){
                return true;
            }
        }
        return false;
    }
    public void setDotType(int a){
        //set dots to the stats
        stats.put("dot", (double)a);

    }
    public DotType getDotType(){
        DotType ret = DotType.NONE;
        if(get("dot") == 0){
            ret = DotType.NONE;
        }else if(get("dot") == 1){
            ret = DotType.BLEED;
        }else if(get("dot")== 2){
            ret = DotType.BURN;
        }else if(get("dot")== 3){
            ret = DotType.CORROSION;
        }else if(get("dot")==4){
            ret = DotType.POISON;
        }
        return ret;
    }
    public void sellIron(){
        int index = 0;
        for(int i =0; i<minerals.size(); i++){
            if(minerals.get(i) instanceof Materials.Iron){
                index = i;
            }
        }
        Materials.Iron iron = (Materials.Iron)this.minerals.get(index);
        double moneyMade= iron.sell();
        addTo("money", moneyMade);
    }
    public Equipment.Weapons.Sword castSword(Object a){
        Equipment.Weapons.Sword ret = (Equipment.Weapons.Sword)a;
        return ret;
    }
    public Equipment.Weapons.Bow castBow(Object a){
        Equipment.Weapons.Bow ret = (Equipment.Weapons.Bow)a;
        return ret;
    }
    public Equipment.Weapons.Gun castGun(Object a){
        Equipment.Weapons.Gun ret = (Equipment.Weapons.Gun)a;
        return ret;
    }
    public Equipment.Weapons.lance castLance(Object a){
        Equipment.Weapons.lance ret = (Equipment.Weapons.lance)a;
        return ret;
    }
    public Equipment.Weapons.Staff castStaff(Object a){
        Equipment.Weapons.Staff ret = (Equipment.Weapons.Staff)a;
        return ret;
    }
    public class Equipment{
        public static String[] getWeponNames(){
            String[] ret = {"Sword", "Staff", "Bow", "Gun", "Staff", "lance"};
            return ret;
        }
        public static String[] getArmourNames(){
            String[] ret = {"Helmet", "chestPiece", "leggings", "boots"};
            return ret;
        }
        public static String[] getAccNames(){
            String[] ret = {"ring", "dagger", "armband"};
            return ret;
        }
        public static double getBonus(Prefixes p, materials m){
            double ret = 0.0;
            switch(p){
                case Broken:
                ret-=0.5;
                break;
                case Common:
                ret +=0;
                break;
                case Uncommon:
                ret+=0.05;
                break;
                case Rare:
                ret+=0.1;
                break;
                case Superior:
                ret+=0.2;
                break;
                case Epic:
                ret+=0.4;
                break;
                case Legendary:
                ret+=0.6;
                break;
                case Celestial:
                ret+=0.9;
                break;
                case Demonic :
                ret+=0.9;
                break;
                default:
                break;
            }
            switch(m){
                case Leather:
                ret-=0.5;
                break;
                case Wooden:
                ret+= 0;
                break;
                case Iron:
                ret+=0.05;
                break;
                case Copper:
                ret+=0.1;
                break;
                case Titanium:
                ret+=0.15;
                break;
                case Palladium:
                ret+=0.25;
                break;
                case Tungsten:
                ret+=0.4;
                break;
                case Adamantium:
                ret+=0.6;
                break;
                case DarkMatter:
                ret+=0.9;
                break;
                case CelestialMatter:
                ret+=0.9;
                break;
                default:
                ret=0;
                break;

            }
            return ret;
        }
        public  class Weapons{
            public class Sword{
                double bonus, damage;
                Prefixes prefix;
                String name;
                Boolean equipped = false;
                materials material;
                int DotTime, dotPercDmg = -1;
                DotType dType = DotType.NONE;
                public Sword(){
                    this.prefix = Prefixes.Broken;
                    this.material = materials.Wooden;
                    this.bonus = getBonus(prefix, material);
                    this.damage = 10 + 10*bonus;
                    this.name = prefix+" "+material+" sword";
                    this.DotTime = -1;
                    this.equipped = false;
                    inventory.add(this);
                }
                //more than likely to never use this next constructor
                public Sword(Object o){
                    Sword a = (Sword)o;
                    this.damage = a.damage;
                    this.bonus = a.bonus;
                    this.material = a.material;
                    this.name = a.name;
                }
                public Sword(double baseDmg, Prefixes p, materials m){
                    this.bonus = getBonus(p, m);
                    this.damage = baseDmg+baseDmg*bonus;
                    this.material = m;
                    this.prefix = p;
                    this.name = this.prefix+" "+this.material+" sword";
                    this.equipped = false;
                    inventory.add(this);
                }
                public Sword(String name){
                    String[] a = name.split(" ");
                    if(a.length<3){
                        System.out.println("incorrect format");
                    }else if(a.length == 3){
                        if(a[0].equals(Prefixes.Common.toString())|| a[0].equals(Prefixes.Broken.toString())|| a[0].equals(Prefixes.Uncommon.toString())|| a[0].equals(Prefixes.Rare.toString())||
                        a[0].equals(Prefixes.Legendary.toString())|| a[0].equals(Prefixes.Epic.toString())||a[0].equals(Prefixes.Legendary.toString())|| a[0].equals(Prefixes.Demonic.toString())|| 
                        a[0].equals(Prefixes.Celestial.toString())|| a[0].equals(Prefixes.Torn.toString())){
                            //the first thing is right, is a prefix, continue onto the next thing
                            if(a[1].equals(materials.Iron.toString())){
                                
                            }
                        }else{
                            System.out.println("incorrect Prefix Type or is not a prefix, check first parameter in overloading parameter for sword in: Game.JAVA");
                        }
                    }else{
                        System.out.println("unkown error");
                    }
                }
                public void equip(){
                    boolean acceptable = checkIsObjEquipped(this);
                    //check if an object of gun is already inside of active equipment, 
                    //we want it to return false other wise just print out there is already a weapon in the weapon slot
                    if(!equipped){
                        //check if the weapon is already equipped
                        if(!acceptable){
                            //add the gun's damage to the attack of the player
                            addTo("attack", this.damage);
                            //add the gun to the active equipment
                            this.equipped = true;
                            activeEquipment.add(this);
                            inventory.remove(this);
                            //add the weapon to the active equipment and remove it from inventory
                            acceptable = checkIsObjEquipped(this);
                            if(acceptable){
                                //everything went well
                                System.out.println("successfully equipped");
                            }else{
                                //some completely different problem has happened... this should never happen
                                System.out.println("something went wrong!");
                            }
                        }else{
                            //this weapon is not equipped but another weapon i
                            System.out.println("Another weapon is already equipped!");
                        }
                    }else{
                        //if its already equipped
                        System.out.println("this weapon is already equipped");
                    }
                }
                public void unequip(){
                    //firstly check if the weapon thinks itself is equipped
                    if(equipped){
                        //check if activeEquipment also agrees
                        if(checkIsObjEquipped(this)){
                            //yes the weapon IS equipped, take away the damage from user's stats
                            takeAwayFrom("attack", this.damage);
                            //change the weapon's equipped state to false
                            this.equipped = false;
                            //take the equipment out of active equipment and put it in inventory
                            activeEquipment.remove(this);
                            inventory.add(this);
                            System.out.println("successfully removed gun from active equipment");
                        }else{
                            System.out.println("ERROR: weapon state is equipped but weapon is not in active Equipment");
                        }
                    }else{
                        System.out.println("this weapon is not equipped");
                    }
                }
                public DotType getDotType(){
                    return this.dType;
                }

            }
            public  class Gun{
                
                int ammo;
                public enum type{
                    pistol, AR, SMG, machineGun, sniper;
                }
                double bonus, damage;
                String name;
                boolean equipped=false;
                Prefixes prefix;
                type type;
                DotType dType;
                materials material;
                public DotType getDotType(){
                    return this.dType;
                }
                public void addAmmo(int a){
                    this.ammo +=a;
                }
                public Gun(){
                    this.type = type.pistol;
                    this.equipped = false;
                    this.ammo = 10;
                    this.prefix = Prefixes.Broken;
                    this.material = materials.Iron;
                    this.name = prefix+" "+material+" "+type;
                    this.bonus = getBonus(prefix, material);
                    this.damage = 10 +10*bonus;
                    inventory.add(this);
                }
                //constructor below is helpful for getting any weapon or amour from activeEquipment or inventory, as both of them store Object types
                //we take that object and cast it into whatever object type we need (gun or bow or whatever) this makes us able to get that object's 
                //properties e.g. damage name, material prefix etc...
                public Gun(Object a){
                    Gun gun = ((Gun)a);
                    this.ammo = gun.ammo;
                    this.bonus = gun.bonus;
                    this.damage = gun.damage;
                    this.material = gun.material;
                    this.prefix = gun.prefix;
                }
                public Gun(int ammo, double baseDmg, Prefixes p, materials m, type t){
                    this.ammo = ammo;
                    this.type = t;
                    this.bonus = getBonus(p, m);
                    this.damage = baseDmg+baseDmg*bonus;
                    this.material = m;
                    this.prefix = p;
                    this.name = prefix+" "+material+" "+type;
                }
                public void equip(User user){
                    boolean acceptable = checkIsObjEquipped(this);
                    //check if an object of gun is already inside of active equipment, 
                    //we want it to return false!
                    if(!equipped){
                        //check if the weapon is already equipped
                        if(!acceptable){
                            //add the gun's damage to the attack of the player
                            user.addTo("attack", this.damage);
                            //add the gun to the active equipment
                            this.equipped = true;
                            activeEquipment.add(this);
                            inventory.remove(this);
                            //add the weapon to the active equipment
                            acceptable = checkIsObjEquipped(this);
                            if(acceptable){
                                //everything went well
                                System.out.println("successfully equipped");
                            }else{
                                //some completely different problem has happened... this should never happen
                                System.out.println("something went wrong!");
                            }
                        }else{
                            //this weapon is not equipped but another weapon i
                            System.out.println("Another weapon is already equipped!");
                        }
                    }else{
                        //if its already equipped
                        System.out.println("this weapon is already equipped");
                    }
                }
                public void unequip(User u){
                    //firstly check if the weapon thinks itself is equipped
                    if(equipped){
                        //check if activeEquipment also agrees
                        if(checkIsObjEquipped(this)){
                            //yes the weapon IS equipped, take away the damage from user's stats
                            u.takeAwayFrom("attack", this.damage);
                            //change the weapon's equipped state to false
                            this.equipped = false;
                            //take the equipment out of active equipment and put it in inventory
                            activeEquipment.remove(this);
                            inventory.add(this);
                            System.out.println("successfully removed gun from active equipment");
                        }else{
                            System.out.println("ERROR: weapon state is equipped but weapon is not in active Equipment");
                        }
                    }else{
                        System.out.println("this weapon is not equipped");
                    }
                }
            }
            public class Bow{
                //coding wise, bow is basically a gun
                int ammo;
                double bonus, damage;
                boolean equipped = false;
                String name;
                Prefixes prefix;
                DotType dType;
                materials material;
                public void addAmmo(int a){
                    this.ammo +=a;
                }
                public DotType getDotType(){
                    return this.dType;
                }
                public Bow(){
                    this.equipped = false;
                    this.ammo = 10;
                    this.prefix = Prefixes.Broken;
                    this.material = materials.Iron;
                    this.name = prefix+" "+material+" Bow";
                    this.bonus = getBonus(prefix, material);
                    this.damage = 10 +10*bonus;
                    inventory.add(this);
                }
                public Bow(Object a){
                    Bow bow = (Bow)a;
                    this.ammo = bow.ammo;
                    this.material = bow.material;
                    this.prefix = bow.prefix;
                    this.bonus = bow.bonus;
                    this.damage = bow.damage;
                    this.name= bow.name;
                    this.equipped = bow.equipped;
                }
                public void equip(User u){
                    boolean acceptable = checkIsObjEquipped(this);
                    //check if an object of gun is already inside of active equipment, 
                    //we want it to return false other wise just print out there is already a weapon in the weapon slot
                    if(!equipped){
                        //check if the weapon is already equipped
                        if(!acceptable){
                            //add the gun's damage to the attack of the player
                            u.addTo("attack", this.damage);
                            //add the gun to the active equipment
                            this.equipped = true;
                            activeEquipment.add(this);
                            inventory.remove(this);
                            //add the weapon to the active equipment and remove it from inventory
                            acceptable = checkIsObjEquipped(this);
                            if(acceptable){
                                //everything went well
                                System.out.println("successfully equipped");
                            }else{
                                //some completely different problem has happened... this should never happen
                                System.out.println("something went wrong!");
                            }
                        }else{
                            //this weapon is not equipped but another weapon i
                            System.out.println("Another weapon is already equipped!");
                        }
                    }else{
                        //if its already equipped
                        System.out.println("this weapon is already equipped");
                    }
                }
                public void unequip(User u){
                    //firstly check if the weapon thinks itself is equipped
                    if(equipped){
                        //check if activeEquipment also agrees
                        if(checkIsObjEquipped(this)){
                            //yes the weapon IS equipped, take away the damage from user's stats
                            u.takeAwayFrom("attack", this.damage);
                            //change the weapon's equipped state to false
                            this.equipped = false;
                            //take the equipment out of active equipment and put it in inventory
                            activeEquipment.remove(this);
                            inventory.add(this);
                            System.out.println("successfully removed gun from active equipment");
                        }else{
                            System.out.println("ERROR: weapon state is equipped but weapon is not in active Equipment");
                        }
                    }else{
                        System.out.println("this weapon is not equipped");
                    }
                }
            }
            public class Staff{
                double bonus, damage;
                Prefixes prefix;
                String name;
                Boolean equipped = false;
                materials material;
                DotType dType;
                public DotType getDotType(){
                    return this.dType;
                }
                public Staff(){
                    this.prefix = Prefixes.Broken;
                    this.material = materials.Wooden;
                    this.bonus = getBonus(prefix, material);
                    this.damage = 10 + 10*bonus;
                    this.name = prefix+" "+material+" Staff";
                    this.equipped = false;
                    inventory.add(this);
                }
                //more than likely to never use this next constructor
                public Staff(Object o){
                    Sword a = (Sword)o;
                    this.damage = a.damage;
                    this.bonus = a.bonus;
                    this.material = a.material;
                    this.name = a.name;
                }
                public Staff(double baseDmg, Prefixes p, materials m){
                    this.bonus = getBonus(p, m);
                    this.damage = baseDmg+baseDmg*bonus;
                    this.material = m;
                    this.prefix = p;
                    this.name = this.prefix+" "+this.material+" Staff";
                    this.equipped = false;
                    inventory.add(this);
                }
                public void equip(User u){
                    boolean acceptable = checkIsObjEquipped(this);
                    //check if an object of gun is already inside of active equipment, 
                    //we want it to return false other wise just print out there is already a weapon in the weapon slot
                    if(!equipped){
                        //check if the weapon is already equipped
                        if(!acceptable){
                            //add the gun's damage to the attack of the player
                            u.addTo("attack", this.damage);
                            //add the gun to the active equipment
                            this.equipped = true;
                            activeEquipment.add(this);
                            inventory.remove(this);
                            //add the weapon to the active equipment and remove it from inventory
                            acceptable = checkIsObjEquipped(this);
                            if(acceptable){
                                //everything went well
                                System.out.println("successfully equipped");
                            }else{
                                //some completely different problem has happened... this should never happen
                                System.out.println("something went wrong!");
                            }
                        }else{
                            //this weapon is not equipped but another weapon i
                            System.out.println("Another weapon is already equipped!");
                        }
                    }else{
                        //if its already equipped
                        System.out.println("this weapon is already equipped");
                    }
                }
                public void unequip(User u){
                    //firstly check if the weapon thinks itself is equipped
                    if(equipped){
                        //check if activeEquipment also agrees
                        if(checkIsObjEquipped(this)){
                            //yes the weapon IS equipped, take away the damage from user's stats
                            u.takeAwayFrom("attack", this.damage);
                            //change the weapon's equipped state to false
                            this.equipped = false;
                            //take the equipment out of active equipment and put it in inventory
                            activeEquipment.remove(this);
                            inventory.add(this);
                            System.out.println("successfully removed gun from active equipment");
                        }else{
                            System.out.println("ERROR: weapon state is equipped but weapon is not in active Equipment");
                        }
                    }else{
                        System.out.println("this weapon is not equipped");
                    }
                }

            }
            public class lance{
                double bonus, damage;
                Prefixes prefix;
                String name;
                Boolean equipped = false;
                materials material;
                DotType dType;
                public DotType getDotType(){
                    return this.dType;
                }
                public lance(){
                    this.prefix = Prefixes.Broken;
                    this.material = materials.Wooden;
                    this.bonus = getBonus(prefix, material);
                    this.damage = 10 + 10*bonus;
                    this.name = prefix+" "+material+" Lance";
                    this.equipped = false;
                    inventory.add(this);
                }
                //more than likely to never use this next constructor
                public lance(Object o){
                    Sword a = (Sword)o;
                    this.damage = a.damage;
                    this.bonus = a.bonus;
                    this.material = a.material;
                    this.name = a.name;
                }
                public lance(double baseDmg, Prefixes p, materials m){
                    this.bonus = getBonus(p, m);
                    this.damage = baseDmg+baseDmg*bonus;
                    this.material = m;
                    this.prefix = p;
                    this.name = this.prefix+" "+this.material+" sword";
                    this.equipped = false;
                    inventory.add(this);
                }
                public void equip(User u){
                    boolean acceptable = checkIsObjEquipped(this);
                    //check if an object of gun is already inside of active equipment, 
                    //we want it to return false other wise just print out there is already a weapon in the weapon slot
                    if(!equipped){
                        //check if the weapon is already equipped
                        if(!acceptable){
                            //add the gun's damage to the attack of the player
                            u.addTo("attack", this.damage);
                            //add the gun to the active equipment
                            this.equipped = true;
                            activeEquipment.add(this);
                            inventory.remove(this);
                            //add the weapon to the active equipment and remove it from inventory
                            acceptable = checkIsObjEquipped(this);
                            if(acceptable){
                                //everything went well
                                System.out.println("successfully equipped");
                            }else{
                                //some completely different problem has happened... this should never happen
                                System.out.println("something went wrong!");
                            }
                        }else{
                            //this weapon is not equipped but another weapon i
                            System.out.println("Another weapon is already equipped!");
                        }
                    }else{
                        //if its already equipped
                        System.out.println("this weapon is already equipped");
                    }
                }
                public void unequip(User u){
                    //firstly check if the weapon thinks itself is equipped
                    if(equipped){
                        //check if activeEquipment also agrees
                        if(checkIsObjEquipped(this)){
                            //yes the weapon IS equipped, take away the damage from user's stats
                            u.takeAwayFrom("attack", this.damage);
                            //change the weapon's equipped state to false
                            this.equipped = false;
                            //take the equipment out of active equipment and put it in inventory
                            activeEquipment.remove(this);
                            inventory.add(this);
                            System.out.println("successfully removed gun from active equipment");
                        }else{
                            System.out.println("ERROR: weapon state is equipped but weapon is not in active Equipment");
                        }
                    }else{
                        System.out.println("this weapon is not equipped");
                    }
            }
        }
        //public class shield{
        //}
        }
        public class Armour{
            public class helmet{
                double defence, bonus;
                String name;
                boolean equipped;
                Prefixes prefix;
                materials material;
                public helmet(){
                    this.prefix = Prefixes.Torn;
                    this.material = materials.Leather;
                    this.bonus = getBonus(prefix, material);
                    this.defence =1+this.bonus;
                    this.equipped = false;
                    this.name = prefix+" "+material+" Helmet";
                    inventory.add(this);
                }
                public void equip(User u){
                    boolean acceptable = checkIsObjEquipped(this);
                    //check if an object of gun is already inside of active equipment, 
                    //we want it to return false other wise just print out there is already a weapon in the weapon slot
                    if(!equipped){
                        //check if the weapon is already equipped
                        if(!acceptable){
                            //add the gun's damage to the attack of the player
                            u.addTo("attack", this.defence);
                            //add the gun to the active equipment
                            this.equipped = true;
                            activeEquipment.add(this);
                            inventory.remove(this);
                            //add the weapon to the active equipment and remove it from inventory
                            acceptable = checkIsObjEquipped(this);
                            if(acceptable){
                                //everything went well
                                System.out.println("successfully equipped");
                            }else{
                                //some completely different problem has happened... this should never happen
                                System.out.println("something went wrong!");
                            }
                        }else{
                            //this weapon is not equipped but another weapon i
                            System.out.println("Another weapon is already equipped!");
                        }
                    }else{
                        //if its already equipped
                        System.out.println("this weapon is already equipped");
                    }
                }
                public void unequip(User u){
                       //firstly check if the weapon thinks itself is equipped
                       if(equipped){
                        //check if activeEquipment also agrees
                        if(checkIsObjEquipped(this)){
                            //yes the weapon IS equipped, take away the damage from user's stats
                            u.takeAwayFrom("attack", this.defence);
                            //change the weapon's equipped state to false
                            this.equipped = false;
                            //take the equipment out of active equipment and put it in inventory
                            activeEquipment.remove(this);
                            inventory.add(this);
                            System.out.println("successfully removed gun from active equipment");
                        }else{
                            System.out.println("ERROR: weapon state is equipped but weapon is not in active Equipment");
                        }
                    }else{
                        System.out.println("this weapon is not equipped");
                    }
                }
                
            }
            public class chestPiece{
                double defence, bonus;
                String name;
                boolean equipped;
                Prefixes prefix;
                materials material;
                public chestPiece(){
                    this.prefix = Prefixes.Torn;
                    this.material = materials.Leather;
                    this.bonus = getBonus(prefix, material);
                    this.defence =1+this.bonus;
                    this.equipped = false;
                    this.name = prefix+" "+material+" Helmet";
                    inventory.add(this);
                }
                public void equip(User u){
                    boolean acceptable = checkIsObjEquipped(this);
                    //check if an object of gun is already inside of active equipment, 
                    //we want it to return false other wise just print out there is already a weapon in the weapon slot
                    if(!equipped){
                        //check if the weapon is already equipped
                        if(!acceptable){
                            //add the gun's damage to the attack of the player
                            u.addTo("attack", this.defence);
                            //add the gun to the active equipment
                            this.equipped = true;
                            activeEquipment.add(this);
                            inventory.remove(this);
                            //add the weapon to the active equipment and remove it from inventory
                            acceptable = checkIsObjEquipped(this);
                            if(acceptable){
                                //everything went well
                                System.out.println("successfully equipped");
                            }else{
                                //some completely different problem has happened... this should never happen
                                System.out.println("something went wrong!");
                            }
                        }else{
                            //this weapon is not equipped but another weapon i
                            System.out.println("Another weapon is already equipped!");
                        }
                    }else{
                        //if its already equipped
                        System.out.println("this weapon is already equipped");
                    }
                }
                public void unequip(User u){
                       //firstly check if the weapon thinks itself is equipped
                       if(equipped){
                        //check if activeEquipment also agrees
                        if(checkIsObjEquipped(this)){
                            //yes the weapon IS equipped, take away the damage from user's stats
                            u.takeAwayFrom("attack", this.defence);
                            //change the weapon's equipped state to false
                            this.equipped = false;
                            //take the equipment out of active equipment and put it in inventory
                            activeEquipment.remove(this);
                            inventory.add(this);
                            System.out.println("successfully removed gun from active equipment");
                        }else{
                            System.out.println("ERROR: weapon state is equipped but weapon is not in active Equipment");
                        }
                    }else{
                        System.out.println("this weapon is not equipped");
                    }
                }

            }
            public class leggings{
                double defence, bonus;
                String name;
                boolean equipped;
                Prefixes prefix;
                materials material;
                public leggings(){
                    this.prefix = Prefixes.Torn;
                    this.material = materials.Leather;
                    this.bonus = getBonus(prefix, material);
                    this.defence =1+this.bonus;
                    this.equipped = false;
                    this.name = prefix+" "+material+" Helmet";
                    inventory.add(this);
                }
                public void equip(User u){
                    boolean acceptable = checkIsObjEquipped(this);
                    //check if an object of gun is already inside of active equipment, 
                    //we want it to return false other wise just print out there is already a weapon in the weapon slot
                    if(!equipped){
                        //check if the weapon is already equipped
                        if(!acceptable){
                            //add the gun's damage to the attack of the player
                            u.addTo("attack", this.defence);
                            //add the gun to the active equipment
                            this.equipped = true;
                            activeEquipment.add(this);
                            inventory.remove(this);
                            //add the weapon to the active equipment and remove it from inventory
                            acceptable = checkIsObjEquipped(this);
                            if(acceptable){
                                //everything went well
                                System.out.println("successfully equipped");
                            }else{
                                //some completely different problem has happened... this should never happen
                                System.out.println("something went wrong!");
                            }
                        }else{
                            //this weapon is not equipped but another weapon i
                            System.out.println("Another weapon is already equipped!");
                        }
                    }else{
                        //if its already equipped
                        System.out.println("this weapon is already equipped");
                    }
                }
                public void unequip(User u){
                       //firstly check if the weapon thinks itself is equipped
                       if(equipped){
                        //check if activeEquipment also agrees
                        if(checkIsObjEquipped(this)){
                            //yes the weapon IS equipped, take away the damage from user's stats
                            u.takeAwayFrom("attack", this.defence);
                            //change the weapon's equipped state to false
                            this.equipped = false;
                            //take the equipment out of active equipment and put it in inventory
                            activeEquipment.remove(this);
                            inventory.add(this);
                            System.out.println("successfully removed gun from active equipment");
                        }else{
                            System.out.println("ERROR: weapon state is equipped but weapon is not in active Equipment");
                        }
                    }else{
                        System.out.println("this weapon is not equipped");
                    }
                }

            }
            public class boots{
                double defence, bonus;
                String name;
                boolean equipped;
                Prefixes prefix;
                materials material;
                public boots(){
                    this.prefix = Prefixes.Torn;
                    this.material = materials.Leather;
                    this.bonus = getBonus(prefix, material);
                    this.defence =1+this.bonus;
                    this.equipped = false;
                    this.name = prefix+" "+material+" Helmet";
                    inventory.add(this);
                }
                public void equip(User u){
                    boolean acceptable = checkIsObjEquipped(this);
                    //check if an object of gun is already inside of active equipment, 
                    //we want it to return false other wise just print out there is already a weapon in the weapon slot
                    if(!equipped){
                        //check if the weapon is already equipped
                        if(!acceptable){
                            //add the gun's damage to the attack of the player
                            u.addTo("attack", this.defence);
                            //add the gun to the active equipment
                            this.equipped = true;
                            activeEquipment.add(this);
                            inventory.remove(this);
                            //add the weapon to the active equipment and remove it from inventory
                            acceptable = checkIsObjEquipped(this);
                            if(acceptable){
                                //everything went well
                                System.out.println("successfully equipped");
                            }else{
                                //some completely different problem has happened... this should never happen
                                System.out.println("something went wrong!");
                            }
                        }else{
                            //this weapon is not equipped but another weapon i
                            System.out.println("Another weapon is already equipped!");
                        }
                    }else{
                        //if its already equipped
                        System.out.println("this weapon is already equipped");
                    }
                }
                public void unequip(User u){
                       //firstly check if the weapon thinks itself is equipped
                       if(equipped){
                        //check if activeEquipment also agrees
                        if(checkIsObjEquipped(this)){
                            //yes the weapon IS equipped, take away the damage from user's stats
                            u.takeAwayFrom("attack", this.defence);
                            //change the weapon's equipped state to false
                            this.equipped = false;
                            //take the equipment out of active equipment and put it in inventory
                            activeEquipment.remove(this);
                            inventory.add(this);
                            System.out.println("successfully removed gun from active equipment");
                        }else{
                            System.out.println("ERROR: weapon state is equipped but weapon is not in active Equipment");
                        }
                    }else{
                        System.out.println("this weapon is not equipped");
                    }
                }

            }
        }
        public class accessory{
            public class ring{
                double givenMp;
                materials material;
                boolean equipped;
                Prefixes prefix;
                String name ="";
                public ring(){
                    this.material = materials.Iron;
                    this.prefix = Prefixes.Broken;
                    this.name = this.prefix + " "+this.material+" ring";  
                    this.givenMp = 5+ 5*getBonus(prefix, material);
                    this.equipped = false;

                }
                public void equip(User u){
                    boolean acceptable = checkIsObjEquipped(this);
                    if(u.get("userClass") == 1){
                        //the user is a mage
                        if(!equipped){
                            if(acceptable){
                                this.equipped = true;
                                u.addTo("mp", this.givenMp);
                                activeEquipment.add(this);
                                inventory.remove(this);
                                System.out.println("successfully equipped");
                            }else{
                                System.out.println("you already have enough rings you've ran out of finger buddy");
                            }
                        }else{
                            System.out.println("you already have the ring equipped");
                        }
                    }else{
                        //the user is not a mage
                        System.out.println("incorrect class, you will not get any benefits from equipping the rings,");
                        System.out.println("hence the rings will not be equipped");
                    }
                }
            }
            public class dagger{
                double givenAp;
                materials material;
                boolean equipped;
                Prefixes prefix;
                String name ="";
                public dagger(){
                    this.material = materials.Iron;
                    this.prefix = Prefixes.Broken;
                    this.name = this.prefix + " "+this.material+" ring";  
                    this.givenAp = 5+ 5*getBonus(prefix, material);
                    this.equipped = false;

                }
                public void equip(User u){
                    boolean acceptable = checkIsObjEquipped(this);
                    if(u.get("userClass") == 1){
                        //the user is a mage
                        if(!equipped){
                            if(acceptable){
                                this.equipped = true;
                                u.addTo("mp", this.givenAp);
                                activeEquipment.add(this);
                                inventory.remove(this);
                                System.out.println("successfully equipped");
                            }else{
                                System.out.println("you already have enough rings you've ran out of finger buddy");
                            }
                        }else{
                            System.out.println("you already have the ring equipped");
                        }
                    }else{
                        //the user is not a mage
                        System.out.println("incorrect class, you will not get any benefits from equipping the rings,");
                        System.out.println("hence the rings will not be equipped");
                    }
                }

            }
            public class armBand{
                double givenAp;
                materials material;
                boolean equipped;
                Prefixes prefix;
                String name ="";
                public armBand(){
                    this.material = materials.Iron;
                    this.prefix = Prefixes.Broken;
                    this.name = this.prefix + " "+this.material+" ring";  
                    this.givenAp = 5+ 5*getBonus(prefix, material);
                    this.equipped = false;

                }
                public void equip(User u){
                    boolean acceptable = checkIsObjEquipped(this);
                    if(u.get("userClass") == 1){
                        //the user is a mage
                        if(!equipped){
                            if(acceptable){
                                this.equipped = true;
                                u.addTo("mp", this.givenAp);
                                activeEquipment.add(this);
                                inventory.remove(this);
                                System.out.println("successfully equipped");
                            }else{
                                System.out.println("you already have enough rings you've ran out of finger buddy");
                            }
                        }else{
                            System.out.println("you already have the ring equipped");
                        }
                    }else{
                        //the user is not a mage
                        System.out.println("incorrect class, you will not get any benefits from equipping the rings,");
                        System.out.println("hence the rings will not be equipped");
                    }
                }

            }
        }
    }
    public class SkillTree{
        public double uClass = get("userClass");
        public class generalNode{
            double userClass = uClass;
            //this is because generalnode can't access uClass
            boolean active, unlocked = false;
            double givenHp, givenAttack, givenSpeed, givenDefence, givenAp, givenMp = 0;
            String name = "Node of ";
            String[] prefixes = new String[]{"devastating", "amazing", "lethal", "blissful", "senseless", "arcane", "unmatched"};
            public generalNode(int i){
                Random rand= new Random();
                int a = rand.nextInt(7);
                this.name += this.prefixes[a];
                this.unlocked = false;
                this.active = false;
                switch(i){
                    case(1):
                        this.givenHp= 10;
                        this.name += " health";
                        break;
                    case(2):
                        this.givenAttack = 2;
                        this.name +=" attack";
                        break;
                    case(3):
                        this.givenSpeed = 5;
                        this.name +=" speed";
                        break;
                    case(4):
                        this.givenDefence = 5;
                        this.name +=" defence";
                    case(5):
                        if(this.userClass== 1){
                            this.givenMp = 10;
                            this.name += " mana";
                        }else if(this.userClass == 2 || this.userClass == 3){
                            this.givenAp = 10;
                            this.name += " vitality";
                        } 
                        break;               
                    default:
                        System.out.println("please pick a number between 0 and 5 for 'i', otherwise the general node will not be created"); 
                    }   
            
            }
            public void unlockNode(generalNode a, User u){
                if(u.get("skillPoints")>0){
                    if(!unlocked){
                        u.takeAwayFrom("skillPoints", 1);
                        this.unlocked = true;
                        this.active = false;
                    }
                }else{
                    System.out.println("you do not have the skill points to unlock nodes, level up before try to unlock the node");
                }
            }
            public void activateNode(generalNode a, User u){
                u.addTo("attack", a.givenAttack);
                u.addTo("maxHealth", a.givenHp);
                u.addTo("speed", a.givenSpeed);
                u.addTo("defence", a.givenDefence);
                u.addTo("ap", givenAp);
                u.addTo("mp", givenMp);
            }
        }
        
        public class SkillNode{
            double userClass = uClass;
            //entirely dependent on the user's class
            public SkillNode(){
                String name = "";
                DotType dType;
                CrowdControl cType = CrowdControl.NONE;
                String DOT = "";
                boolean active, unlocked, DOTenabled, hasCC;
                Random rand = new Random();
                //active means that it is one of the 5 active skills that the user can use, unlocked means just the ones the
                //user has unlocked, not necessarily active
                if(uClass== 1){
                    //if the user is a mage;
                    //he has dots which pertain burns or poisions can haves a control effect of freeze, horrify or paralyze
                    DOTenabled = rand.nextBoolean();
                    hasCC = rand.nextBoolean();
                    if(DOTenabled){
                        int dotType = rand.nextInt(4);
                        setDotType(dotType);
                        dType = getDotType();
                        DOT = dType.toString();
                    }
                    if(hasCC){
                        //set the cc in the same way as the dot
                        cType =CrowdControl.NONE;
                    }
                    name+="Skill of: ";
                    if(DOTenabled){
                        name += DOT;
                        if(hasCC){
                            name += cType.toString();
                        }
                    }
                }else if(uClass == 2){
                    //user is an assassin
                    //has dots which pertain bleeds control effects such as stuns, disorient, freeze or incapacitate
                }else if(uClass == 3){
                    //user is a warrior
                    //warriors do not have dots but they have a control effect stuns, incapacitate, disorient
                }else{
                    System.out.println("CRITICAL ERROR: there is an error in the userClass, the user's current user class is invalid!");
                    System.out.println("CHEAT/HACKS WILL NOT BE PERMITTED");
                }
            }
        }
        public SkillTree(){
            ArrayList<generalNode> allGNodes = new ArrayList<>();
            //all general nodes, doesn't matter whether or not they are unlcoked   
            ArrayList<SkillNode> allSNodes = new ArrayList<>();
            //all skill nodes
            





        }
        

    }
}
