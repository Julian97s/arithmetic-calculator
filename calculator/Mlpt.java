package calculator;

public class Mlpt extends Operators{

    public Mlpt (Token left, Token right){
        this.left_side  = left;
        this.right_side = right; 
    }
    @Override
    public double eval(){
        double result = this.left_side.eval() * this.right_side.eval();;
        return result;
    }
    
    
}
