import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Principal;
import java.util.Scanner;
public class User {
    public String filePath = "/Users/t/Desktop/coding/Java/Java_Game-1/Save.txt";
    /*
     * stats to add:
     * defensive: health, maxhealth, health regen, defence, dodge
     * offensive: attack, DOT, skills 
     * other: currentExp, neededExp, level, stat points, class, speed
     */
    //stats, inventory, armour, weapons, ActiveEquipment
    public HashMap<String, Double> stats = new HashMap<>();
    public Object[] ActiveEquipment = new Object[5];
    public ArrayList<Object> Inventory = new ArrayList<>();
    public Weapons weapons = new Weapons();
    public Armour armour = new Armour();

    //user creation, get and set save methods
    public User(){
        this.stats.put("health", 100.00);
        this.stats.put("maxHealth", 100.00);
        this.stats.put("attack", 10.00);
        this.stats.put("speed", 10.00);
        this.stats.put("level", 1.00);
        this.stats.put("currentExp", 0.00);
        this.stats.put("neededExp", 50.00);
        this.stats.put("defence", 1.00);
        this.stats.put("dodge", 1.00);
        this.stats.put("statPoints", 0.00);
        this.stats.put("healthRegen", 1.00);
        this.stats.put("class", -1.00);
        this.stats.put("gold", 0.0);
    }
    public User(String filePath){
        getSave();
    }
    public void getSave(){
        String contents="";
        File file = new File("/Users/t/Desktop/coding/Java/Java_Game-1/Save.txt");
        try {
            Scanner scnr = new Scanner(file);
            while(scnr.hasNextLine()){
                contents+=scnr.nextLine();
            }
            scnr.close();
            System.out.println("got file contents and closed scanner");
        } catch (Exception e) {
            e.printStackTrace();
        }
        contents = contents.substring(1,(contents.length()-1));
        String[] contentsSplit = contents.split(", ");
        for(int i = 0; i<contentsSplit.length; i++){
            String[] finalSplit = contentsSplit[i].split("=");
            this.stats.put(finalSplit[0], Double.parseDouble(finalSplit[1]));
        }
        System.out.println("successfully got save");
    }
    public void setSave(){
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write(Stringify());
            fw.close();
            System.out.println("successfully wrote to file and closed filewriter");
        } catch (IOException f) {
            f.printStackTrace();
        }
      

    }

    //hashmap helper methods
    public void addTo(String key, double value){
        try{
            this.stats.put(key, (this.stats.get(key)+value));
        }
        catch(NullPointerException e){
            System.out.println("invalid key in addTo method!");
        }
    }
    public void takeAway(String key, double value){
        try{
            this.stats.put(key, (this.stats.get(key)-value));
        }
        catch(NullPointerException e){
            System.out.println("invalid key in takeAway method!");
        }
    }
    public double get(String key){
        return this.stats.get(key);
    }
    //utility methods...
    public String Stringify(){
        String ret = "";
        ret+= this.stats.toString();

        return ret;
    }

    //game related methods
    public double getNeededExp(){
        return (Math.pow(this.get("level"),1.5)*50);
    }
    public void expSys(){
        //only run after a fight...
        while(stats.get("neededExp")<=stats.get("currentExp")){
            takeAway("currentExp", stats.get("neededExp"));
            //remove the needeed exp from current exp and level up the player once
            addTo("level", 1);
            System.out.println("the user has leveled up to: "+stats.get("level")+" and now has: "+stats.get("currentExp")+" exp left");
            stats.put("neededExp", getNeededExp());
            System.out.println("the exp needed to level up again is: "+stats.get("neededExp"));
            //set the neededExp to the new needed exp after level up

        }
    }
    public void fight(Enemies a){
     try {
        Weapons w = (Weapons)this.ActiveEquipment[0];
        String s = w.getType(w);
        // System.out.println(s);
        long timeNow = System.currentTimeMillis()/1000;
        Random random = new Random();
        double rando = random.nextDouble(0,1);
        int DOTpityTimer = 0;
        if(get("speed")>=a.speed){
            while(get("health")>0 && a.health>0){
                
                a.health -= get("attack");
                System.out.println("you attacked the monster, its health is now: "+a.health);
                takeAway("health", a.attack);
                System.out.println("the monster attacked you, your health is now: "+get("health"));
                Thread.sleep(200);
                timeNow = System.currentTimeMillis()/1000;
                rando = random.nextDouble(0,1);
            }
        }else{
            
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
