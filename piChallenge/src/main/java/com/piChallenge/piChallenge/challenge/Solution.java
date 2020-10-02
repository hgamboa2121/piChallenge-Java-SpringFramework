import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/*
* Author: Hector Gamboa
* Start Date: 9-23-20
* Last Edit: 9-30-20
*/
public class Solution{

    public static String answer = "";
    public static long avgTimeTaken = 0; 
    public static int nthDecimalPlace = 0;

    public static void main(String[] args) throws IOException{
        findAnswer();
        System.out.println("Answer: "+answer);
        System.out.println("Decimal Place/Position: "+ nthDecimalPlace);
        executionTime();
        System.out.println("Average time taken: ~" + avgTimeTaken + " ns." );
    }
    /*
    *findAnswer takes the output string of the method
    * getpi() and takes only seven digits and computes the answer
    * using isPalindrom() &  isPrime()
    */
    private static void findAnswer()throws IOException{
        try{
           String pi = getPi(); 
           for(int i = 0; i < pi.length(); i++){
               if(i+7 > pi.length()) break;
               String sevenDigits = pi.substring(i, i+7);
               if(isPalindrome(sevenDigits) && isPrime(Integer.parseInt(sevenDigits))){
                   answer = sevenDigits;
                   nthDecimalPlace++;
                   break;
               }
               nthDecimalPlace++;
           }
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }
    /*
    * getPi gets the text(numbers of pi) inside the text file named
    * "pi.txt" and 
    */
    private static String getPi() throws IOException {
		File piFile = new File("pi.txt");
        FileReader fr = new FileReader(piFile);
        BufferedReader br = new BufferedReader(fr);
      	return br.readLine(); 
    }
    /*
    * isPlaindrome takes seven digits as a string and ueses the 
    * StringBuilder class reverses the string and compares it
    * to the original string to check if its a palindrome  
    */
    private static Boolean isPalindrome(String sevenDigits){
        StringBuilder sb = new StringBuilder(sevenDigits);
        return sevenDigits.equals(sb.reverse().toString());
    }
    /*
    * isPrime finds if a given number(input) is prime or not.
    * This is done by finding if there modulus to a set of range of numbers
    */
    private static Boolean isPrime(int sevenDigits){
        //Handling numbers less than seven digits for debugging 
        if(sevenDigits <= 1) return false;
        if(sevenDigits <= 3) return true;
        if(sevenDigits%2 == 0 || sevenDigits%3 == 0) return false;
        for (int i=5; (i*i) <= sevenDigits; i++) {
            if (sevenDigits % i == 0 ) return false;
        }
        return true;
    }
    /*
    * executionTime is only used to find the average
    * exectuion time of this code
    */
    private static void executionTime()throws IOException{
        long start = System.nanoTime();
        for (int i = 0; i < 100; ++i) {findAnswer();} // <- Average of 100 iterations
        //findAnswer(); //<- 1 iteration
        long elapsed = System.nanoTime() - start;
        avgTimeTaken = elapsed / 100;
    }
}