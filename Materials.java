import java.util.HashMap;

public class Materials {
    public HashMap<String, Materials>Materials = new HashMap<>();
    public class metals extends Materials{  
        public class Iron extends metals{
            public double amount =0;
            public final String name = "Iron";
            public void add(int amount){
                this.amount += amount;
                System.out.println("added: "+amount);
            }
            public int use(int amount){
                if (amount <= this.amount){
                    this.amount -= amount;
                    System.out.println("Used: "+amount+" Iron");
                    return amount;
                }
                else{
                    System.out.println("Not enough Iron");
                    return 0;
                }
            }
        }
        public class Copper extends metals{
            public double amount =0;
            public final String name = "Copper";
            public void add(int amount){
                this.amount += amount;
            }
            public int use(int amount){
                if (amount <= this.amount){
                    this.amount -= amount;
                    System.out.println("Used: "+amount+" Copper");
                    return amount;
                }
                else{
                    System.out.println("Not enough Copper");
                    return 0;
                }
            }
        }
        public class Lead extends metals{
            public double amount =0;
            public final String name = "Lead";
            public void add(int amount){
                this.amount += amount;
            }
            public int use(int amount){
                if (amount <= this.amount){
                    this.amount -= amount;
                    System.out.println("Used: "+amount+" Lead");
                    return amount;
                }
                else{
                    System.out.println("Not enough Lead");
                    return 0;
                }
            }

        }
        public class Platinum extends metals{
            public double amount =0;
            public final String name = "Platinum";
            public void add(int amount){
                this.amount += amount;
            }
            public int use(int amount){
                if (amount <= this.amount){
                    this.amount -= amount;
                    System.out.println("Used: "+amount+" Platinum");
                    return amount;
                }
                else{
                    System.out.println("Not enough Platinum");
                    return 0;
                }
            }
        }
        public class Vantanium extends metals{
            public double amount =0;
            public final String name = "Vantanium";
            public void add(int amount){
                this.amount += amount;
            }
            public int use(int amount){
                if (amount <= this.amount){
                    this.amount -= amount;
                    System.out.println("Used: "+amount+" Vantanium");
                    return amount;
                }
                else{
                    System.out.println("Not enough Vantanium");
                    return 0;
                }
            }
        }
        public class Zhorium extends metals{
            public double amount =0;
            public final String name = "Iron";
            public void add(int amount){
                this.amount += amount;
            }
            public int use(int amount){
                if (amount <= this.amount){
                    this.amount -= amount;
                    System.out.println("Used: "+amount+" Iron");
                    return amount;
                }
                else{
                    System.out.println("Not enough Iron");
                    return 0;
                }
            }
        }
        public class Yggdrasilium extends metals{
            public double amount =0;
            public final String name = "Iron";
            public void add(int amount){
                this.amount += amount;
            }
            public int use(int amount){
                if (amount <= this.amount){
                    this.amount -= amount;
                    System.out.println("Used: "+amount+" Iron");
                    return amount;
                }
                else{
                    System.out.println("Not enough Iron");
                    return 0;
                }
            }
        }
        public class Zyentium extends metals{
            public double amount =0;
            public final String name = "Iron";
            public void add(int amount){
                this.amount += amount;
            }
            public int use(int amount){
                if (amount <= this.amount){
                    this.amount -= amount;
                    System.out.println("Used: "+amount+" Iron");
                    return amount;
                }
                else{
                    System.out.println("Not enough Iron");
                    return 0;
                }
            }
        }
    }
    public class NonMetals{
        public class Leather{
                public double amount =0;
                public final String name = "Iron";
                public void add(int amount){
                    this.amount += amount;
                }
                public int use(int amount){
                    if (amount <= this.amount){
                        this.amount -= amount;
                        System.out.println("Used: "+amount+" Iron");
                        return amount;
                    }
                    else{
                        System.out.println("Not enough Iron");
                        return 0;
                    }        
                }
        }
        
    }
    public Materials(){
        Materials.metals m = new metals();
        Materials.put("Iron", m.new Iron());
        Materials.put("Copper", m.new Copper());

    }
}
