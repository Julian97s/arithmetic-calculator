package calculator;

public class Division extends Operators{

    public Division(Token left, Token right){
        this.left_side  = left;
        this.right_side = right; 
    }

    @Override
    public double eval(){
        double result = 0;
        try {
         result = this.left_side.eval() / this.right_side.eval();
        } catch (ArithmeticException e){
            System.err.println("Error, division by zero not allowed.");
        }
        
        return result;
    }
    
}
