package calculator;

public class Subs extends Operators{

    public Subs(Token left, Token right){
        this.left_side  = left;
        this.right_side = right;
    }
    @Override
    public double eval(){
        // both sides are token and i cant substract tokens, i have to substact doubles
        // so if i evaluate each token
        double result = this.left_side.eval() - this.right_side.eval();        
        return result;
    }

}