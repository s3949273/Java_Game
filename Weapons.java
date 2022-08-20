public class Weapons {
    public class Sword extends Weapons{
        public double attack;
        public String type;
        public DOT dot;
        public Sword(){
            this.type = "Sword";
            this.attack = 100.0;
            this.dot = new DOT();
            this.dot.type = "none";
        }  
        public double getAttack(){
            return this.attack;
        }
        public void setAttack(double a){
            this.attack = a;
        }
        public boolean hasDOT(){
            return false;   
        }
        public void printInfo(){
            System.out.println("attack: "+this.attack+", Dot: "+this.dot.type);
        }
        
    }
    public class Staff extends Weapons{
        public double attack;
        public String type;
        public DOT dot;
        public Staff(){
            this.attack = 10;
            this.type = "Staff";
            this.dot = new DOT();
            this.dot.type = "burn";
        }
        public double getAttack(){
            return this.attack;
        }
        public void setAttack(double a){
            this.attack = a;
        }
        public boolean hasDOT(){
           for(int i = 0;i<dot.possibleTypes.length; i++){
                if(this.dot.type.equals(dot.possibleTypes[i])){
                    return true;
                }
           }
           return false;
        }
    }

    public String getType(Weapons w){
        try {
            Sword s = (Sword)w;
            return "Sword";
        } catch (Exception e) {
        }
        try {
            Staff s = (Staff) w;
            return "Staff";
        } catch (Exception e) {
        }
        return "None";
    }


}
