package calculator;

public class Number extends Token{
    private double number;

    public Number(double g_number){
        this.number = number;
    }

    @Override
    public double eval() {
        return this.number;
    }
}