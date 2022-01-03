import java.util.Scanner;

public class Aufgabe {
    private static int punkte = 0;
    public int getPunkte(){
        return punkte;
    }

    public void getExercise() throws GameException, NoDataException {
        GStart start = new GStart();
        Rundenzaehler runde = new Rundenzaehler();

        Scanner sc1 = new Scanner(System.in);

        int summand1 = (int)(Math.random() * 8 + 1);
        int summand2 = (int)(Math.random() * 8 + 1);
        int result = summand1 + summand2;
        System.out.println("Aufgabe: " + summand1 + " + " + summand2 + " = ");
        String eingabe = sc1.nextLine();

        if(eingabe.length()==0){
            throw new NoDataException("Nur die Entertaste drücken ist nicht genug.");
        }

        int zahl = Integer.parseInt(eingabe);

        if(zahl == result){
            punkte++;
        }
        runde.setRunde();
        start.startGame();
    }
}
