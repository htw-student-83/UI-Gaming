public class AllgemeinerSpieler {

    public int aktuelle_Zeile_x;
    public int aktuelle_Spalte_y;


    public AllgemeinerSpieler(UI field) {
    }

    /*

    public UI AllgemeinerSpieler(UI field) {
        return field;
    }
*/
    public int getAktuelle_Zeile_x(){
        return this.aktuelle_Zeile_x;
    }

    public int getAktuelle_Spalte_y(){
        return this.aktuelle_Spalte_y;
    }

}
