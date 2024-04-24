package NexDevs.lezione.Lambda;

import java.util.ArrayList;
import java.util.List;

public class ProvaLambda4 {
    public static void main(String[] args) {
       List<Integer>numeriImmutabili= List.of(2,4,8,6,7,3,86,874);//lista non mutabile (non modificabile)
        ArrayList<Integer> numeri =new ArrayList<>(numeriImmutabili);


        numeri.sort(((i1,i2) -> i1.compareTo(i2)));
        numeri.forEach(integer ->  System.out.println(integer) );

        System.out.println("-----------");
        numeri.replaceAll(Integer->Integer+10);
        numeri.forEach(integer ->  System.out.println(integer) );
    }
}
