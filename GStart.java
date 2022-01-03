public class GStart {
    public void startGame() throws GameException, InvalidInputException,
            InvalidNumberException, NoDataException {
        Rundenzaehler runde = new Rundenzaehler();
        System.out.println("Runde: " + runde.getRunde());
        UI fieldgame = new UI();
        Gegenstand g1 = new Gegenstand(fieldgame);
        Player p1 = new Player(fieldgame);
        p1.setPosition(fieldgame);
        g1.move(fieldgame);
        fieldgame.createUI();

        int px = p1.getAktuelle_Zeile_x();
        int py = p1.getAktuelle_Spalte_y();

        while (fieldgame.getField()[px][py] !=
                fieldgame.getField()[g1.aktuellePositionxGegenstand][g1.aktuellePositionyGegenstand]) {
            p1.toMovePlayer(fieldgame);
        }
        Aufgabe excersice = new Aufgabe();
        excersice.getExercise();
        runde.setRunde();
        startGame();
    }
}
