import java.util.Scanner;

/*public class Materials {
    public class Iron{
        int units;
        String name = "Iron";
        final double sellPrice = 0.1;
        //sellprice is per item
        public int getAmount(){
            return this.units;
        }
        public void setAmount(int a){
            this.units = a;
        }
        public Iron(){
            this.units = 10;
        }
        public Iron(int units){
            this.units = units;
        }
        public double sell(){
            int amount=-1;
            Scanner scnr = new Scanner(System.in);
            System.out.println("enter the amount you would like to sell");
            if(!scnr.hasNextInt()){
                System.out.println("please enter a numeric value for the amount!, transaction cancelled!");
            }else{
                amount = scnr.nextInt();
            }
            double ret = 0;
            if(amount > 0){
                if(units>=amount){    
                    ret = amount*sellPrice;
                    System.out.println("transaction details: ");
                    System.out.println("\t units to sell: "+amount);
                    System.out.println("\t awarded money: "+ret);
                    System.out.println("\t please confirm: y/n");
                    String confirm = scnr.next();
                    if(confirm.equals("y")){
                        System.out.println("transaction successful, "+amount+" iron will be deducted now");
                        this.units -= amount;
                    }else if(confirm.equals("n")){
                        System.out.println("transaction aborted by user");
                    }
                    else{
                        System.out.println("transaction aborted, invalid response");
                    }
                }else{
                    System.out.println("you do not have enough materials to do this transaction");

                }
            }else if(amount == -1){
                System.out.println("Internal error setting amount");
            }
            else{
                System.out.println("you need to sell more than 0 units of copper");
            }
            scnr.close();
            return ret;
           
        }
    }
    public boolean checkMatType(String type){
        if(type.equals("Iron")){
            return true;
        }
        return false;
    }

}

*/