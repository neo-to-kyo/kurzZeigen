package StackADT;

import ListeADT.List;
import java.util.function.Function;


public class Postfix {


    public static Function<Double, Function<Double, Double>> add = x -> y -> x + y;
    public static Function<Double, Function<Double, Double>> sub = x -> y -> x - y;
    public static Function<Double, Function<Double, Double>> mul = x -> y -> x * y;
    public static Function<Double, Function<Double, Double>> div = x -> y -> x / y;
    public static Function<Double, Function<Double, Double>> pow = x -> y -> Math.pow(x, y);
    public static Function<Double, Double> fact = n -> n <= 1 ? 1 : n * Postfix.fact.apply(n - 1);

    public final Function<ListeADT.List<String>, Double> evalRek = expr -> {
        return eval_(ListStack.empty(), expr);
    };


    private Double eval_(Stack<Double> s, List<String> expr) {
        if (expr.isEmpty()) return s.top();
        else {
            switch (expr.head()) {
                case "+":
                    return eval_(binop(s, add), expr.tail());
                case "-":
                    return eval_(binop(s, sub), expr.tail());
                case "*":
                    return eval_(binop(s, mul), expr.tail());
                case "/":
                    return eval_(binop(s, div), expr.tail());
                case "^":
                    return eval_(binop(s, pow), expr.tail());
                case "!":
                    return eval_(unaop(s, fact), expr.tail());
                default:
                    return eval_(opnd(s, expr.head()), expr.tail());
            }
        }
    }


    //public static Stack<Double> binop(Stack<Double> s, Function<Double, Function<Double, Double>> f) {
    // }

    private Stack<Double> unaop(Stack<Double> s, Function<Double, Double> f) {
        double x = f.apply(s.top());
        return s.pop().push(x);
    }


    private Stack<Double> opnd(Stack<Double> s, String head) {

        Double h = Double.valueOf(head);
        System.out.println("--" + h);
        return s.push(h);

    }

    private Stack<Double> binop(Stack<Double> s, Function<Double, Function<Double, Double>> f) {

        double x = f.apply(s.top()).apply(s.pop().top());
        return s.pop().pop().push(x);

    }


}


