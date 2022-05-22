import java.util.HashMap;

public class Enemies {
    public static  HashMap<String, Double> monsterStats = new HashMap<>();
    
    public double get(String key){
        return monsterStats.get(key);
    }
    public void set(String key, double value){
        monsterStats.put(key, value);
    }
    public static void addTo(String key, double value){
        monsterStats.put(key, (monsterStats.get(key)+value));
    }
    public static void takeAwayFrom(String key, double value){
        monsterStats.put(key, (monsterStats.get(key)-value));
    }
    public static class genericMonsters{
        public static class Orc{
            public Orc(){
                monsterStats.put("health", 100.0);
                monsterStats.put("attack", 5.0);
                monsterStats.put("speed", 5.0);
                monsterStats.put("givenMoney", 10.0);
                monsterStats.put("givenExp", 100.0);
            }
        }
        public static class Ghost{
            public Ghost(){
                monsterStats.put("health", 50.0);
                monsterStats.put("attack", 10.0);
                monsterStats.put("speed", 15.0);
                monsterStats.put("givenMoney", 15.0);
                monsterStats.put("givenExp", 110.0);
            }
            
        }
        public static class Ogre{
            public Ogre(){
                monsterStats.put("health", 1000.0);
                monsterStats.put("attack", 10.0);
                monsterStats.put("speed", 5.0);
                monsterStats.put("givenMoney", 25.0);
                monsterStats.put("givenExp", 200.0);
            }
        }
        public static class Troll{
            public Troll(){
                monsterStats.put("health", 1000.0);
                monsterStats.put("attack", 10.0);
                monsterStats.put("speed", 5.0);
                monsterStats.put("givenMoney", 25.0);
                monsterStats.put("givenExp", 150.0);
            }
        }
        public static class Slime{
            public Slime(){
                //for testing purposes
                monsterStats.put("health", 100000000.0);
                monsterStats.put("attack", 0.0);
                monsterStats.put("speed", 1.0);
                monsterStats.put("givenMoney", 1.0);
                monsterStats.put("givenExp", 10.0);
            }
        }
        public static class Goblin{
            public Goblin(){
                monsterStats.put("health", 100.0);
                monsterStats.put("attack", 20.0);
                monsterStats.put("speed", 20.0);
                monsterStats.put("givenMoney", 30.0);
                monsterStats.put("givenExp", 200.0);
            }
        }
        public static class Zombie{
            public Zombie(){
                monsterStats.put("health", 150.0);
                monsterStats.put("attack", 15.0);
                monsterStats.put("speed", 2.0);
                monsterStats.put("givenMoney", 15.0);
                monsterStats.put("givenExp", 80.0);
            }
        }
        public static class Dragon{
            public Dragon(){
                monsterStats.put("health", 5000.0);
                monsterStats.put("attack", 50.0);
                monsterStats.put("speed", 500.0);
                monsterStats.put("givenMoney", 259.0);
                monsterStats.put("givenExp", 2500.0);
            }
        }
        public static class Skeleton{
            public Skeleton(){
                monsterStats.put("health", 10.0);
                monsterStats.put("attack", 10.0);
                monsterStats.put("speed", 15.0);
                monsterStats.put("givenExp", 20.0);
                monsterStats.put("givenMoney", 10.0);
            }
        }
        public static class Phantom{

        }
        public genericMonsters(){
            new Slime();
        }
    }
    public static class evolvedMonsters{
        //have defence, higher attack, higher hp, more loot, maybe equipment
        public static class Vampire{
            public Vampire(){

            };
        }
        public static class Golem{
            public Golem(){}

        }
        public static class Lich{
            public Lich(){}

        }
        public static class Witch{
            public Witch(){};
            
        }
        public static class AlphaDragon{
            public AlphaDragon(){

            }

        }
        public static class Demon{
            public Demon(){}

        }
        public static class GoblinArmy{
            public GoblinArmy(){}

        }
    }
    public static class Boss{
        //has higher defence, has higher attack, higher hp but also drops more loot, own higher tier equipment
        public static class Kraken{
            public Kraken(){}
        }
        public static class KingOfGolems{
            public KingOfGolems(){}
        }
        public static class RogueWarlock{
            public RogueWarlock(){}
        }
        public static class UndeadNecromancer{
            public UndeadNecromancer(){

            }
        }
        public static class Levaithan{
            public Levaithan(){}
        }
        public static class Hades{
            public Hades(){}
        }
        public static class DemonKing{
            public DemonKing(){}
        }
        public static class SigmaDragon{
            //the alpha of alpha dragons
            public SigmaDragon(){}
        }
        public static class Death{
            //the ultimatum, only defeatable by gods
            public Death(){}
        }
        public static class TinTanSan{
            //the ultimatum pt2... only defeatable by gods... thousands of them...
            public TinTanSan(){}
        }
        
    }
    public Enemies(){
        new genericMonsters.Slime();
    }
    public Enemies(String monsterType){
        switch(monsterType){
            case("GenericMonster"):
            case("genericmonster"):
            case("genericMonster"):
            case("g"):
            case("gm"):
            case("generic monster"):
            case("Generic Monster"):
                new Enemies.genericMonsters();
                break;
            case("evolvedMonster"):
            case("EvolvedMonster"):
            case("evolvedmonster"):
            case("e"):
            case("em"):
            case("evolved monster"):
            case("Evolved Monster"):
                new Enemies.evolvedMonsters();
                break;
            case("Boss"):
            case("boss"):
            case("b"):
            case("B"):
                new Enemies.Boss();
                break;
            default:
                new genericMonsters();
        }
    }
    public Enemies(String monsterType, String specificMonster){
        switch(monsterType){
            case("GenericMonster"):
            case("genericmonster"):
            case("genericMonster"):
            case("g"):
            case("gm"):
            case("generic monster"):
            case("Generic Monster"):
                switch(specificMonster){
                    case("Orc"):
                        new Enemies.genericMonsters.Orc();
                        break;
                    case("Ghost"):
                        new Enemies.genericMonsters.Ghost();
                        break;
                    case("Ogre"):
                        new Enemies.genericMonsters.Ogre();
                        break;
                    case("Troll"):
                        new Enemies.genericMonsters.Troll();
                        break;
                    case("Slime"):
                        new Enemies.genericMonsters.Slime();
                        break;                    
                    case("Goblin"):
                        new Enemies.genericMonsters.Goblin();
                        break;
                    case("Zombie"):
                        new Enemies.genericMonsters.Zombie();
                        break;
                    case("Dragon"):
                        new Enemies.genericMonsters.Dragon();
                        break;
                    case("Skeleton"):
                        new Enemies.genericMonsters.Skeleton();
                        break;
                    case("Phantom"):
                        new Enemies.genericMonsters.Phantom();
                        break;


                
                
                    
                    default:
                        System.out.println("Incorrect specific monster, check case sensitivity");
                
                    break;
                }
                break;
            case("evolvedMonster"):
            case("EvolvedMonster"):
            case("evolvedmonster"):
            case("e"):
            case("em"):
            case("evolved monster"):
            case("Evolved Monster"):
                switch(specificMonster){
                    case("Vampire"):
                    new Enemies.evolvedMonsters.Vampire();
                        break;
                    
                    case("Golem"):
                    new Enemies.evolvedMonsters.Golem();
                        break;
                    
                    case("Lich"):
                    new Enemies.evolvedMonsters.Lich();
                        break;
                    
                    case("Witch"):
                    new Enemies.evolvedMonsters.Witch();
                        break;
                    
                    case("AlphaDragon"):
                    new Enemies.evolvedMonsters.AlphaDragon();
                        break;
                    
                    case("Demon"):
                    new Enemies.evolvedMonsters.Demon();
                        break;
                    
                    case("GoblinArmy"):
                    new Enemies.evolvedMonsters.GoblinArmy();
                        break;
                    default:
                        System.out.println("Incorrect specific monster, check case sensitivity");
                        break;
                }               
                break;
            case("Boss"):
            case("boss"):
            case("b"):
            case("B"):
                switch(specificMonster){
                case("Kraken"):
                        new Enemies.Boss.Kraken();
                        break;
                case("KingOfGolems"):
                        new Enemies.Boss.KingOfGolems();
                        break;
                case("RogueWarlock"):
                        new Enemies.Boss.RogueWarlock();
                        break;
                case("UndeadNecromancer"):
                        new Enemies.Boss.UndeadNecromancer();
                        break;
                case("Leviathan"):
                        new Enemies.Boss.Levaithan();
                        break;
                case("Hades"):
                        new Enemies.Boss.Hades();
                        break;
                case("DemonKing"):
                        new Enemies.Boss.DemonKing();
                        break;
                case("SigmaDragon"):
                        new Enemies.Boss.SigmaDragon();
                        break;
                case("Death"):
                        new Enemies.Boss.Death();
                        break;
                case("TinTanSan"):
                        new Enemies.Boss.TinTanSan();
                        break;
                default:
                        System.out.println("Incorrect specific monster, check case sensitivity");
                        break;                    
                }
                break;
            default:
                System.out.println("Incorrect monster type, creating a generic slime");
                new genericMonsters();
        }
    }

}

