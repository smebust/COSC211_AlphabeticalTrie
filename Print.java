class Print{

    public static void main(String[] args){
        for(int i = 0; i < 164; i++){
            System.out.print(i + " ");
            System.out.println((char) i);
        }
        System.out.println();
        String hi = "a";
        System.out.println(hi);
        String hello = hi.substring(1, hi.length());
        System.out.println(hello);
        //hello = hello + "0";
        //System.out.println(hello);
        boolean idgaf = (hello.equals(""));
        System.out.println(idgaf);
    }
}