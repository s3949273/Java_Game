
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Equipment: (equipment will have a boolean (equipped or not), another boolean correct class)
        - equipment.weapon.gun.pistol
        - pistol 
        - Assualt rifle
        - smg
        - Machine gun
        - sniper
        myuser has a pistol
        User.Pistol myPistol =  new pistol()
        Stringify(){
               for loop:
                     check if the current object is a User.pistol
                     for(i):
                     Object curObj = inventory.get(i);
                       if(curObj instanceof User.Pistol){
                              casting...
                       }
                       
        }
        

              pistol , pistol 2, pistol 3
              Name: pistol, all stats... 

        
        - armour (Chest Plate)
        - helmet
        - gauntlets/gloves
        - rings/ relics
        - leggings/pants
        - sheild
        - shoes
        TO DECICDE: whether all the equipment acts as their own classes e.g. 
        class User has 
              Class equipment which has
                     class weapon
                     class armour
                     ...
 *     
 *  Classes: (affect class bonuses from the class specific equipments)
        - No Class
        - Mage
        - Warrior 
        - Assassin 
        - God (achieved only when all the other classes except [No Class] have been maxxed out)
       Said to be enums 
       Classes have their skill trees which have certain NODES which increase the stats
            of the players, and other NODES which award special skills according to the class
            and sub-classes
       Classes may have other classes which have bonuses against them... e.g. a warrior may be 
            good against a mage or an assassin etc. in this case a god has bonuses against all classes as he is trained
            in all classes
            Warrior > Assassin > Mage > Warrior
    *
    *  Sub-Classes: 
        Mage:
         - Healer
         - Elemental Mage (general)
         - alchemist (allows for forgery of potions etc. other mage types have to buy potions) -> Maybe?
         - Overlord {Hidden}
         - Necromancer(doesn't fight himself, his minions fight for him (necessary to unlock Jin Woo))
         - Summoner (much like the necromancer, but instead of dead things, alive things)
        Warior:
         - Tank
         - Swordsman
         - Ranger (a person who uses guns or other ranged objects)
        Assassin:
         - Jin Woo {Hidden}
         - Rogue (your typical assassin, uses daggers (necessary to unlock Jin Woo))
         - 
        
 *      
 *  User:
        - Hashmap of stats and their names
         stats:
              health, maxHealth, attack, speed, mp, ap, crit chance, crit damage, defence,
              currentExp, neededExp, level, gold, stat-points, 
        - Class specific details
              if they are a mage it gives them information about specific equipments the mage can
              use to gain class specific bonuses.
        - Methods to implement:
        RegenHealth
        fight
        buy -> equipment
        getRandom(for crit chance)
        equip/unequip
        exp handling system (expSys)
       - Stat points are awarded when a player levels up, they can be used by the player to upgrade a stat of their
            choice, can be any of the stat other than (currentExp, neededExp, gold, level or stat-points)
       
 *  Monster:
        - Health
        - Attack
        - Speed
        - Given xp
        - Given money
 *  Titles
        - declared dead {hidden/ secret}
        - regressor {hidden}
        - guild leader 
        - God {hidden}
        - King/Emperor
        - lord
        - noble
        - middle class 
        - peasant
        - mercenary
 *
 *  Prefixes: for all equipment x + x*prefixValue(e.g. Broken= -50%, Epic = +40%)   
        - Celestial/Demonic ( if you have celestical equipment on u cant wear Demonic equipment) +90%
        - Legendary +60%
        - Epic +40%
        - Superior +25%
        - Rare +10%
        - Uncommon +5%
        - common 0%
        -Broken -50% (in order to becom a common equipment you require the )
        Broken, common, Uncommon, Rare, Superior, Epic, Legendary, Celestial, Demonic
 *  Prefixes: for all classes:
       -godly {hidden}
       -Legendary
       -master
       -proficient
       -disciple
       -amateur
 *  Currency:
        - platinum
        - gold
        - silver
        - bronze
        100 -> go up a level of currency
 * Equipment available to craft:
     Weapon
       - Sword (Iron, Titanium, Palladium, Tungsten, Adamantium)
       - Lance/Spear
       - Staff/Wand
       - Bow N' Arrow
       - Gun/Rifle
       - Shield
     Armour: (Gives defence (depending on the prefix of the armour the amount of defence is added))
       - Chest Plate
       - Head accessory
       - Gloves
       -Leggingss
       - boot   
     Other:
       - rings (specific to mages)
       - dagger (specific to assassin)
       - Arm band thing (specific to warrior)
 *  
 * 
 * 
 * Materials:
        - early game materials: Wooden, Leather, cloth
        - metals: Iron, Copper, Titanium, Palladium, Tungsten, Adamantium 
        - dark matter (necessary to forge Demonic equipment)
        - Celestial matter (necessary to forge godly equipment)


 * Quest System:
       A quest system which gives out currency and/or materials, quests become increasingly
       difficult as the player levels up (Comes under USER class)

 *  NPCs:
       - Shop owner
            this man exchanges potions, weapons, materials etc. for currency (does not sell
            energy for gold)
       - Quest giver
            this man gives quests which have rewards which give potions, weapons, materials, currency
            (can be one of the possible rewards or all of them)
       - Blacksmith
            this is the guy you go to, to forge your class specific gear, quests and shop
            can only give you regular equipment
*what goes into the save file:
       -stats & classes
       -equipment
       -inventory
*What goes into the inventory:
       - Coins
       - equips
       - stats
       - materials collected
       - 
 * 
 special skill effects:
        -DOTs (damage over time):
              burns, bleeds, poisons
        -control effects:
              freeze, stun

 * */

public class Game{
       public static final String filepath = "/Users/t/Desktop/coding/Java/game/Java_Game/Save.txt";
       public static void mainMenu(User u){
              Scanner scnr = new Scanner(System.in);
              System.out.println("User: TinTanSan"+"\t\t\t\tLevel: "+u.get("level"));
              System.out.println("\tHealth: "+u.get("health")+"/"+u.get("maxHealth"));
              System.out.println("\tAttack: "+u.get("attack"));
              System.out.println("\tSpeed: "+u.get("speed"));
              System.out.println("\tExp: "+u.get("currentExp")+"/"+u.get("neededExp"));
              System.out.println("\tMoney: "+u.get("money"));
              System.out.println("\n\n\nPress 'f' to fight, 'i' to view inventory, 's' to view shop or 'qq' to quit");
              String input = scnr.next();
              if(!input.equals("qq")){
                     //if the user wants to continue
                     if(input.equals("f")){
                            fightMenu(u);
                     }
                     else if (input.equals("i")){
                            System.out.println("Tintansan's inventory: ");
                            //nothing in it yet though 
                     }else if(input.equals("s")){
                            System.out.println("Going to the Shop Owner");
                            //shop doesn't exist yet
                     }
              }else if (input.equals("qq")){
                     //saves and exits safely
                     System.out.println("saving and exiting");
                     u.setSave(filepath, u.stats);
              
              }
              scnr.close();
       }
       public static void fightMenu(User u){
              Scanner scnr = new Scanner(System.in);
              System.out.println("\nPress any letter to exit this menu, otherwise:");
              System.out.println("Press 1 to fight a slime\nPress 2 to fight a ghost\nPress 3 to fight a goblin\nPress 4 to fight an Orc");
              System.out.println("Press 5 to fight");
              
              if(!scnr.hasNextInt()){
                     System.out.println("aborting to the main menu");
                     mainMenu(u);
              }else{
                     int input = scnr.nextInt();
                     if(input == 1){
                            Enemies a = new Enemies("g", "Slime");
                            u=u.fight(a);
                            //update u with the u returned from fight method and then save to file
                            u.setSave(filepath, u.stats);
                            fightMenu(u);
                     }else if(input ==2){
                            Enemies a = new Enemies("g", "Ghost");
                            u=u.fight(a);
                            u.setSave(filepath, u.stats);

                     }
                     
              }


              scnr.close();
       }
       public static void main(String[] args) {
              User user = new User();
              user.getSave(filepath);
              //mainMenu(user);
              User.Equipment equipment = user.new Equipment();
              User.Equipment.Weapons weapons = equipment.new Weapons();
              User.Equipment.Weapons.Sword s = weapons.new Sword();
              s.dType = User.DotType.BURN;
              s.equip();
              ArrayList<Object> AE = user.activeEquipment;
              System.out.println(user.hasDOT());
              user.fight(new Enemies("g", "Slime"));
       }

}