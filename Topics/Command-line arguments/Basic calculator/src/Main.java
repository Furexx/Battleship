class Problem {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        if(args[0].equals("+")){
            System.out.println(x + y);
        }else if (args[0].equals("-")){
            System.out.println(x - y);
        }else if (args[0].equals("*")){
            System.out.println(x * y);
        }else {
            System.out.println("Unknown operator");
        }
    }
}
