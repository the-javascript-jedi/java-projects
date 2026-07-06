package exercises;

public class MultiplicationTable {

    public static void multiplyTable(int number){
        for(int i=1;i<=10;i++){

            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

public static void main(String args[]){

    multiplyTable(7 );
}
}
