package calculator;

import calculator.Number;
import java.util.*;

public abstract class Token {

    private static List<Token> tokens = new ArrayList<>();    // likely not needed
    

    //on eval im recollecting and parsing into a doubles 
    public abstract double eval();

    public static Token parseToken(String str_operation){
        Token result = new Number(0);
        //String[] operators = {"\\-","\\+","\\/","\\*"};
        List<String> operatorsList = new ArrayList<>();
        operatorsList.add("-");
        operatorsList.add("\\+");
        operatorsList.add("\\*");
        operatorsList.add("/");
        String[] operationArray;

        // base case will be if str_operation.length() == 2
        // then i will split the string i evaluate the symbol to make an operation and i evakuate that last number so i cen get a double to operate with the last 
        // token in the list. wich will lakely have a symbol before the number so i have to do the same thing 
        for (int i = 0 ; i< operatorsList.size() ; i++){
            if (str_operation.contains(operatorsList.get(i))){ // why is this not evaluating to true when it reads "5-5"? it evaluates contains as false 
                operationArray = str_operation.split(operatorsList.get(i));
                //now i will parse EACH half 
                Token first_token = Token.parseToken(operationArray[0]);
                Token second_token = Token.parseToken(operationArray[1]);

                if ("-".equals(operatorsList.get(i))){ // minus is the symbol i just split on above, do a subst Token 
                    Subs substraction = new Subs(first_token, second_token);
                    return substraction;
                    // i have a feeling thet this tokens should be added somewhere to have a strack of them
                } else if ("+".equals(operatorsList.get(i))){
                    Add addition = new Add(first_token,second_token);
                    return addition;
                } else if ("/".equals(operatorsList.get(i))){
                    Division division = new Division(first_token,second_token);
                    return division;
                } else if ("*".equals(operatorsList.get(i))){
                    Mlpt product = new Mlpt(first_token,second_token);
                    return product;
                }
            } else if (str_operation.length() == 1){
                Number number = new Number(Double.parseDouble(str_operation));
                return number;
            }
        }   
        // im missing the return.. after im done evaluating the operators, WHAT DO I DO NEXT?
        // if im done with operations it means that i can evaluate those last 2 numbers so i can say that i will split that last pair of numbers and create 
        // Token left_number = new Number(operationArray[0])
        // Token right_number = new Number(operationArray[1])

        // return 
        return result;

    }
}
/*
 * im gonna recieve a string, which first I will split right on the substraction "-".
 * i will have two partd of the operation now. left and right. 
 * if left.length == 1 it means its a number alone and can be treated as such. and will be the first item in my tokens list
 * then i can parse the remaining of the operation.
 * this is saved in the 0th slot of my tokes (List).
 * 
 * i will look for the lowest precedence operator on the remaining of the operation. that's substraction.
 * run the remaining of the operation and split on the next substraction. but now it will have a "-" sign in it that i will have to split.
 * after i split it, i will keep the other number and evaluate the operation between the last token in my list of tokens and this new token 
 * subs(previous token in the list, next token)
 *
 *  or actually, when the i want to evaluate the substraction if the new substring contains the "-" then,
 *      substracts the first number in the list and substracts it from the token from the left.
 *      then i will parse the right part again  
 * 
 */