import java.io.File;
import java.util.Random;
import java.util.Scanner;
public class encryptDecrypt {
    //silent class: should NOT produce ANY outputs EVEN BY MISTAKE
    //all keyboard chars' ascii codes lie within 32->126 (94 characters)
    //all unicode characters include 65536 characters
    protected String key;
    // public String encrypt(String a){
    //     String ret = "";
    //     char[] myChars = a.toCharArray();
    //     for(char c: myChars){
    //         c += this.key;
    //         ret+=c;
    //     }
        //System.out.println(ret);

       // return ret;
    //}
    // public String decrypt(String a){
    //     String ret = "";      
    //     char[] myChars = a.toCharArray();
    //     for(char c: myChars){
    //         c -= this.key;
    //         ret+=c;
    //     }
    //     return ret;
    // }
    public int getKey(){
        int i = 0; 
        return i;
    }

    public void test(String a, int offset){
        String ret = "";
        char[] charArr = a.toCharArray();
        Random rand = new Random();
        for(int i = 0; i<charArr.length; i++){
            ret+= charArr[i];
            int rando= rand.nextInt(32,126);
            key+= rando;
            key = key.substring(4,key.length());
            ret+=key;
            ret +=(char)rando;
        }
        this.key = key.substring(4, key.length());
        System.out.println(ret);
        System.out.println(key);
       
    }

}
