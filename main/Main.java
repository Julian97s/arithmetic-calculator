package main;

import calculator.Token;
import java.util.*;
public class Main {
    public static void main(String[] args) {
    
        System.out.println("\nPlease give an operation to be evaluated:\n");
        Scanner s = new Scanner(System.in);
        String result = "Invalid input";
        if (s.hasNext() ){
            result = s.nextLine().trim();
            Token calculation = Token.parseToken(result);            
            System.out.println(calculation.eval());
        } else {
            System.out.println(result);
        }
    }
    

    
     
}
