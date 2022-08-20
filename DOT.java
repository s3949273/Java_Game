public class DOT {
    public String[] possibleTypes = {"burn", "poison", "corrode"};
    public String type;
    public double percentageDMG;
    public double activationRate;
    public int seconds;
    public DOT(){
        this.type = "Burn";
        this.percentageDMG = 1000;
        this.activationRate = 0.1;
        this.seconds = 10;
    }
    public boolean hasDot(String a){
        for(int i=0; i<possibleTypes.length; i++){
            if(a == possibleTypes[i]){
                return true;
            }
        }
        return false;
    }


    public DOT(String a){
        if(this.hasDot(a)){
            this.type = a;
            this.percentageDMG = 1000;
            this.activationRate = 0.1;
            this.seconds = 10;
        }else{
            System.out.println("Given type of DOT is not a valid type ");
        }
    }
    public DOT(String a, double dmg, double ar, int s){
        boolean hasDot = this.hasDot(a);
        if(a=="none" || a=="None"){
            // allow the 'none' DOT type to pass through override the percentage damage, activationrate, and seconds given.
            this.type = a;
            this.percentageDMG = 0;
            this.activationRate = 0;
            this.seconds = 0;

        }
        else if(hasDot){
            //has a valid DOT type
            this.type = a;
            this.percentageDMG = dmg;
            this.activationRate = ar;
            this.seconds = s;

        }else{
            //a is not a valid DOT type
            System.out.println("Given type of DOT is not a valid type");
        }
    }
    public String Stringify(){
        String ret = "";
        ret+=this.type;
        ret+=this.percentageDMG;
        ret+=this.seconds;
        return ret;
    }
}
