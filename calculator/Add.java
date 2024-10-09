package calculator;

public class Add extends Operators {
    
    public Add (Token left, Token right){
        this.left_side  = left;
        this.right_side = right; 
    }

    @Override
    public double eval(){
        double result = this.left_side.eval() + this.right_side.eval();
        return result;
    }
}
