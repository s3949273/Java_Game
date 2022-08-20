import java.util.HashMap;

public class Armour {
    public double armourHp;
    public double armourDefence;
    public Materials materials;
    public class Modifiers{
        public HashMap<String, Double> Modifiers = new HashMap<>();
        public Modifiers(){
            this.Modifiers.put("unfixable", -0.25);
            this.Modifiers.put("broken", -0.1);
            this.Modifiers.put("normal", 0.0);
            this.Modifiers.put("enhanced", 0.1);
            this.Modifiers.put("epic", 0.25);
            this.Modifiers.put("legendary", 0.5);
            this.Modifiers.put("celestial", 1.0);
            this.Modifiers.put("Demonic", 1.0);
        }
        public  HashMap<String, Double> get(){
            return this.Modifiers;
        }
    }
    public class Helmet{
        public double givenHp;
        public double givenDefence;
        public Materials mat;
        public Modifiers mod;
        public Helmet(){
            this.givenDefence = 1;
            this.givenHp = 10;
        }
        public void setHp(double a){
            this.givenHp = a;
        }
        public void setDef(double a){
            this.givenDefence =a;
        }
    }
    public class chestPiece{
        public double givenHp;
        public double givenDefence;
        public chestPiece(){
            this.givenDefence = 1;
            this.givenHp = 10;
        }
    }
    public class leggings{
        public double givenHp;
        public double givenDefence;
        public leggings(){
            this.givenDefence = 1;
            this.givenHp = 10;
        }
    }
    public class boots{
        public double givenHp;
        public double givenDefence;
        public boots(){
            this.givenDefence = 1;
            this.givenHp = 10;
        }
    }
    public Armour(){
        Helmet helmet = new Helmet();
        chestPiece cp = new chestPiece();
        leggings lg = new leggings();
        boots boots = new boots();
        this.armourHp = helmet.givenHp + cp.givenHp + lg.givenHp + boots.givenHp;
        this.armourDefence = helmet.givenDefence + cp.givenDefence + lg.givenDefence + boots.givenDefence;
    }

}
