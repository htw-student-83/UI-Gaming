public class Gegenstand extends Player{
    private final char gegenstand = 'x';
    public int aktuellePositionxGegenstand;
    public int aktuellePositionyGegenstand;

    public Gegenstand(UI field) {
        super(field);
    }

    //Methode, um den Gegenstand innerhalb des Feldes wandern zu lassen
    //neue Position soll zufällig festgelegt werden
    public void move(UI field){
        //Position des Gegenstandes wird zufällig bestimmt
        int zufalls_position_x = (int)(Math.random()*8 + 1);
        int zufalls_position_y = (int)(Math.random()*8 + 1);
        this.aktuellePositionxGegenstand = zufalls_position_x;
        this.aktuellePositionyGegenstand = zufalls_position_y;
        //final int positionx = 3;
        //final int positio//this.aktuellePositionyGegenstand = positiony;

        //befindet sich der Gegenstand nicht am Rand des Spielfeldes?

        //field.getField()[positionx][positiony] = gegenstand;

        if(field.getField()[zufalls_position_x][zufalls_position_y] != '#' &&
                field.getField()[zufalls_position_x][zufalls_position_y]!=field.getField()[5][2]){
            // final int positionx = 5;
            // final int positiony = 3;
            // Sind die Positionen von Gegenstand und Spieler verschieden?
            if(!(field.getField()[getAktuelle_Zeile_x()][getAktuelle_Spalte_y()] ==
                    field.getField()[zufalls_position_x][zufalls_position_y])){
              field.getField()[zufalls_position_x][zufalls_position_y] = gegenstand;
            }
        }else{
            System.out.println("Position x = " + zufalls_position_x +"\n" + "Position y = " + zufalls_position_y);
        }

    }

    public int getPosition_x(){
        return this.aktuellePositionxGegenstand;
    }

    public int getPosition_y(){
        return this.aktuellePositionyGegenstand;
    }

    public int getFinalPosition_x(){
        return this.aktuellePositionxGegenstand;
    }

    public int getFinalPosition_y(){
        return this.aktuellePositionyGegenstand;
    }
}
