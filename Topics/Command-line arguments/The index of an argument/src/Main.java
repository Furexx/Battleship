class Problem {
    public static void main(String[] args) {
        int sum = 0 ;
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("test")){
                sum = 2;
            }else {
                sum = -1;
            }
        }
        System.out.println(sum);
    }
}
