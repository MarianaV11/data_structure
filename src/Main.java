import java.util.*;
import Stack.DynamicStack;
public class Main {
    public static int position = 0;
    public static Scanner input = new Scanner(System.in);
    public static String formulaPosfix(char[] formula) {
        DynamicStack dynamicStackOne = new DynamicStack<>();
        DynamicStack dynamicStackTwo = new DynamicStack<>();

        while (position < formula.length) {
            if(Character.isLetterOrDigit(formula[position])) {
                dynamicStackOne.push(formula[position]+"");
                position++;
            } else if (formula[position] == '(') {
                position++;
                String aux = formulaPosfix(formula);
                dynamicStackOne.push(aux);
            } else if(formula[position] == ')') {
                position++;
                break;
            } else {
                while(dynamicStackTwo.size() > 0 && connective(formula[position]) <= connective((Character)
                        dynamicStackTwo.peek())) {
                    String aux2 = dynamicStackOne.pop() + "";
                    String aux = dynamicStackOne.pop() + "";
                    String result = aux + aux2 + dynamicStackTwo.pop();

                    dynamicStackOne.push(result);
                }
                dynamicStackTwo.push(formula[position]);
                position++;
            }
        }

        while (dynamicStackTwo.size() > 0) {
            String operand2 = dynamicStackOne.pop() + "";
            String operand1 = dynamicStackOne.pop() + "";
            String result = operand1 + operand2 + dynamicStackTwo.pop();
            dynamicStackOne.push(result);
        }

        return  (String) dynamicStackOne.pop();
    }

    public static int connective(Character c) {
        return switch (c) {
            case '^' -> 2;
            case '*', '/' -> 1;
            case '+', '-' -> 0;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        int n = input.nextInt();
        input.nextLine();
        String finalResult;

        for(int i = 0; i < n; i++) {
            String formula = input.nextLine();
            char []aux = formula.toCharArray();
            position = 0;
            finalResult = formulaPosfix(aux);

            System.out.println(finalResult);
        }
    }
}