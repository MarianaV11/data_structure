//import Stack.StaticStack;
//
//import java.util.*;
//
//public class Main {
//    public static Scanner input = new Scanner(System.in);
//
//    public static String formulaPosfix(char[] formula) {
//        StaticStack dynamicStackOne = new StaticStack(100);
//        StaticStack dynamicStackTwo = new StaticStack(100);
//
//        for(int i = 0; i < formula.length; i++) {
//            if(Character.isLetterOrDigit(formula[i])) {
//                dynamicStackOne.push(formula[i]);
//            } else if(formula[i] == ')') {
//                break;
//            } else if(formula[i] == '(') {
//                String formulaTwo = formulaPosfix(formula);
//                dynamicStackOne.push(formulaTwo);
//            } else {
//                char dynamicTwo = (Character) dynamicStackTwo.peek();
//                while(dynamicStackTwo.size() > 0 && connective(formula[i]) <= connective(dynamicTwo)) {
//                    String aux2 = dynamicStackOne.pop() + "";
//                    String aux = dynamicStackOne.pop() + "";
//                    String result = aux + aux2 + dynamicStackTwo.pop();
//
//                    dynamicStackOne.push(result);
//                }
//                dynamicStackTwo.push(formula[i]);
//            }
//        }
//
//        for(int i = dynamicStackTwo.size(); i > 0; i--) {
//            String aux2 = dynamicStackOne.pop() + "";
//            String aux = dynamicStackOne.pop() + "";
//            dynamicStackOne.push(aux + aux2 + dynamicStackTwo.pop());
//        }
//        return  (String) dynamicStackOne.pop();
//    }
//
//    public static int connective(Character c) {
//        return switch (c) {
//            case '^' -> 2;
//            case '*', '/' -> 1;
//            case '+', '-' -> 0;
//            default -> -1;
//        };
//    }
//
//    public static void main(String[] args) {
//        int n = Integer.parseInt(input.nextLine());
//        String finalResult;
//
//        for(int i = 0; i < n; i++) {
//            String formula = input.nextLine();
//            char []aux = formula.toCharArray();
//
//            finalResult = formulaPosfix(aux);
//
//            System.out.println(finalResult);
//        }
//    }
//}