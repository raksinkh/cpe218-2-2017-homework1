import java.util.*;

public class Homework1 {

    static int i = -1;
    static String[] ary;
    public static Stack<Character> mystack = new Stack<Character>();
    public static Node mtree;

    public static void main(String[] args) {
        String s = args[0];
        for (int i = 0; i < s.length(); i++) {
            mystack.add(s.charAt(i));
        }
        mtree = new Node(mystack.pop());
        infix(mtree);
        inorder(mtree);
        System.out.println("=" + calculate(mtree));
    }


    public static class Node {
        Character key;
        Node Left = null;
        Node Right = null;

        public Node() {
        }

        public Node(Character key) {
            this.key = key;
        }
    }

    public static void inorder(Node n) {
        if (n.key == '*' || n.key == '/' || n.key == '+' || n.key == '-') {
            if (n != mtree) {
                System.out.println("(");
            }
            inorder(n.Left);
            System.out.println(n.key);

            inorder(n.Right);

            if (n != mtree) {
                System.out.println(")");
            } else {
                if ((n != mtree)) {
                    System.out.println(n.key);
                }
            }
        }
    }

    public static void infix(Node n) {
        if (n.key == '*' || n.key == '/' || n.key == '+' || n.key == '-') {   //Check Operator
            //pop 2 top stacks
            n.Right = new Node(mystack.pop());
            infix(n.Right);
            n.Left = new Node(mystack.pop());
            infix(n.Left);

        }
    }

    public static boolean IsOperator(Character a) {
        switch (a) {
            case '+':
                return true;
            case '-':
                return true;
            case '*':
                return true;
            case '/':
                return true;
            default:
                return false;
        }
    }

    public static int calculate(Node n) {
        if(IsOperator(n.key)){
            switch(n.key){
                case '+':return calculate(n.Left) + calculate(n.Right);
                case '-':return calculate(n.Left) - calculate(n.Right);
                case '*':return calculate(n.Left) * calculate(n.Right);
                case '/':return calculate(n.Left) / calculate(n.Right);
                default : System.out.println("Not Operator || Number");return 0;
            }
        }
        else{
            return Integer.parseInt(n.key.toString());
        }
    }
}

