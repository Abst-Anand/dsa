package src.pepcoding.stackandqueue;

import java.util.Set;
import java.util.Stack;

public class StackMain {

    // Q1: Duplicate Brackets => If any two pair of brackets have same content then return true (yes, duplicate brackets are there) else return false
    static boolean isDuplicateBracket(String expression){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            char openingBrace = '(';
            char closingBrace = ')';

            if(ch == closingBrace){
                if(st.peek() == openingBrace){
                    System.out.println(true);
                    return true;
                }

                while (st.peek() != openingBrace){
                    st.pop();
                }
                st.pop();
            }else{
                st.push(ch);
            }

//            System.out.println(st);
        }

        System.out.println(false);
        return false;
    }

    // Q2: Balanced Brackets
    static boolean isBalanedBrackets(String exp){
        Set<Character> openingBraces = Set.of('(', '{', '[');
        Set<Character> closingBraces = Set.of(')', '}', ']');

        Stack<Character> st = new Stack<>();

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if(openingBraces.contains(ch)){
                st.push(ch);
            } else if (closingBraces.contains(ch)) {
                char complement = findComplementBracket(ch);
                if(st.peek() == complement){
                    st.pop();
                }else{
                    break;
                }
            }
        }

        System.out.println(st.size() == 0);
        return st.size() == 0;
    }
    static char findComplementBracket(char ch){
        if(ch == ')') return '(';
        if(ch == '}') return '{';
        if(ch == ']') return '[';
        return 'A';
    }

    public static void main(String[] args) {

        System.out.println("===Q1===================================================================================");
        String exp1 = "((a+b)+(c+d))";
        isDuplicateBracket(exp1);
//===========================================================================================================================================================================

        System.out.println("===Q2===================================================================================");
        String exp2 = "[(a+b)+{(c+d)*(e/f)]}";
        isBalanedBrackets(exp2);



    }
}
