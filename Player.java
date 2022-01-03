import java.util.Scanner;

public class Player extends AllgemeinerSpieler{
//Zunächst werden Variablen zum Spieler, der aktuellen Position in x und y-Richtung und einen Counter festgelegt
//die Zeile 6 wird das Zeichen des Spielers representieren
    private char[] playerSign;
    private int counter;


//Dem Konstruktur bekommt das aktuelle Spielfeld als Parameter übergeben
       public Player(UI field){
        super(field);
        //Alle vorkommenden Zustände, die der Spieler annehmen kann, werden festgelegt
        playerSign = new char[4];
        playerSign[0] = '^';
        playerSign[1] = '>';
        playerSign[2] = 'v';
        playerSign[3] = '<';
        }


//Rotation nach rechts
    public void toRotateRight(UI field){
        if(counter==0){
            counter = 1;
        }else if(counter==1){
            counter = 2;
        }else if(counter==2){
            counter = 3;
        }else if(counter==3){
            counter = 0;
        }else{
            System.out.println("Fehler bei der Drehung nach rechts.");
        }
        field.getField()[aktuelle_Zeile_x][aktuelle_Spalte_y] = playerSign[counter];
        //nachdem die Daten aktualisiert wurden muss es noch auf dem Bildschirm angezeigt werden
        field.createUI();
    }

    public int setPosition(UI field){
        aktuelle_Zeile_x = 5;
        aktuelle_Spalte_y = 2;
        counter = 1;
        return field.getField()[aktuelle_Zeile_x][aktuelle_Spalte_y] = playerSign[counter];
    }


    public int getCounter(){
        return this.counter;
    }

//Rotation nach links
    public void toRotateLeft(UI field)  {
        if(counter==0){
            counter = 3;
        }else if(counter==3){
            counter = 2;
        }else if(counter==2){
            counter = 1;
        }else if(counter==1){
            counter = 0;
        }else{
            System.out.println("Fehler bei der Drehung nach links.");
        }
        field.getField()[aktuelle_Zeile_x][aktuelle_Spalte_y] = playerSign[counter];
        //nachdem die Daten aktualisiert wurden muss es noch auf dem Bildschirm angezeigt werden
        field.createUI();
    }

    public void goForward(UI gamefield) throws GameException, NoDataException {
        //1) Der Spieler wird von der aktuellen Position entfernt
        //2) Jetzt wird der Spiele auf die neue Position gebracht
        gamefield.getField()[aktuelle_Zeile_x][aktuelle_Spalte_y] = ' ';

        if (counter == 0 && gamefield.getField()[aktuelle_Zeile_x - 1][aktuelle_Spalte_y] != '#') {
            gamefield.getField()[aktuelle_Zeile_x - 1][aktuelle_Spalte_y] = playerSign[counter];
            aktuelle_Zeile_x -= 1;
            gamefield.createUI();
        } else if (counter == 1 && gamefield.getField()[aktuelle_Zeile_x][aktuelle_Spalte_y + 1] != '#') {
            gamefield.getField()[aktuelle_Zeile_x][aktuelle_Spalte_y + 1] = playerSign[counter];
            aktuelle_Spalte_y += 1;
            gamefield.createUI();
        } else if (counter == 2 && gamefield.getField()[aktuelle_Zeile_x + 1][aktuelle_Spalte_y] != '#') {
            gamefield.getField()[aktuelle_Zeile_x + 1][aktuelle_Spalte_y] = playerSign[counter];
            aktuelle_Zeile_x += 1;
            gamefield.createUI();
        } else if (counter == 3 && gamefield.getField()[aktuelle_Zeile_x][aktuelle_Spalte_y - 1] != '#') {
            gamefield.getField()[aktuelle_Zeile_x][aktuelle_Spalte_y - 1] = playerSign[counter];
            aktuelle_Spalte_y -= 1;
            gamefield.createUI();
        } else{
            throw new GameException("Schritt nach vorne nicht möglich.\n");
        }
    }


    public void toMovePlayer(UI field) throws GameException, NoDataException {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Bitte wählen Sie eines der folgenden Optionen aus:\n r = nach rechts, l = links, u = nach unten, o = nach oben");
        String  eingabe = sc1.nextLine();
        if(eingabe.equals("l")){
            if(getCounter()==0){
                toRotateLeft(field);
                goForward(field);
            }else if(getCounter()==1){
                toRotateLeft(field);
                toRotateLeft(field);
                goForward(field);
            }else if(getCounter()==2){
                toRotateRight(field);
                goForward(field);
            }else if(getCounter()==3){
                goForward(field);
            }else {
                System.out.println("Bewegung nicht möglich.");
            }
        }else if(eingabe.equals("r")){
            if(getCounter()==0){
                toRotateRight(field);
                goForward(field);
            }else if(getCounter()==1){
                goForward(field);
            }else if(getCounter()==2){
                toRotateLeft(field);
                goForward(field);
            }else if(getCounter()==3){
                toRotateLeft(field);
                toRotateLeft(field);
                goForward(field);
            }else {
                System.out.println("Bewegung nicht möglich.");
            }
        }else if(eingabe.equals("u")){
            if(getCounter()==0){
                toRotateLeft(field);
                toRotateLeft(field);
                goForward(field);
            }else if(getCounter()==1){
                toRotateRight(field);
                goForward(field);
            }else if(getCounter()==2){
                goForward(field);
            }else if(getCounter()==3){
                toRotateLeft(field);
                goForward(field);
            }else {
                System.out.println("Bewegung nicht möglich.");
            }
        }else if(eingabe.equals("o")){
            if(getCounter()==0){
                goForward(field);
            }else if(getCounter()==1){
                toRotateLeft(field);
                goForward(field);
            }else if(getCounter()==2){
                toRotateRight(field);
                toRotateRight(field);
                goForward(field);
            }else if(getCounter()==3){
                toRotateRight(field);
                goForward(field);
            }else {
                System.out.println("Bewegung nicht möglich.");
            }
        }
        else{
        System.out.println("Eingabe ist ungültig.");
        }
    }
}
