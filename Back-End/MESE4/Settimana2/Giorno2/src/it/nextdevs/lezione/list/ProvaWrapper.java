package it.nextdevs.lezione.list;

public class ProvaWrapper {
    public static void main(String[] args) {

        //Classi Wrapper
        //Byte, Short, Integer, Long, Float, Double, Character, Boolean


        Integer iObject =4;

        int i =iObject;
        System.out.println(i);

        int j=Integer.parseInt("123");//per strasformare la stringa in numero
        System.out.println(j);

        System.out.println(Integer.MIN_VALUE);// per conoscere il valore minimo
        System.out.println(Integer.MAX_VALUE);//per conoscere il valore massimo
    }
}
