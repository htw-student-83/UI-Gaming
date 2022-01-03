import org.junit.Assert;
import org.junit.Test;

public class Examples {
    /**
     * the player is on his final position, when the game is started
     */
    @Test
    public void IsOnStartPosition(){
        UI field = new UI();
        Player p = new Player(field);
        Assert.assertEquals(p.setPosition(field), field.getField()[5][2]);
    }

    /**
     * to set the object in the field
     */

    @Test
    public void toSetObject(){
        UI field = new UI();
        Gegenstand object = new Gegenstand(field);
        object.move(field);
        Assert.assertEquals(field.getField()[object.getFinalPosition_x()][object.getFinalPosition_y()],
                field.getField()[3][1]);
    }


    /**
     * to set the object somewhere in the field
     */
    @Test
    public void toMoveTheObjekt(){
        UI field = new UI();
        Gegenstand object = new Gegenstand(field);
        object.move(field);
        Assert.assertTrue( field.getField()[object.getPosition_x()][object.getPosition_y()] != '#');
    }


    /**
     * The player must be on the field
     */
    @Test(expected = InvalidInputException.class)
    public void MoveFailure()throws Exception {
        UI field = new UI();
        Player p = new Player(field);
        p.setPosition(field);
        p.toRotateLeft(field);
        p.toRotateLeft(field);
        p.goForward(field);
        p.goForward(field);
    }


    /**
     * the player moves toward in the field
     * @throws InvalidInputException
     */
    @Test
    public void toMoveThePlayerToTheRight() throws GameException, NoDataException {
        UI field = new UI();
        Player p = new Player(field);
        p.setPosition(field);
        p.goForward(field);
        Assert.assertTrue(field.getField()[p.aktuelle_Zeile_x][p.aktuelle_Spalte_y] != '#');
    }


    /**
     * The player moves one step up
     * @throws InvalidInputException
     */
    @Test
    public void toMoveThePlayerUp() throws GameException, NoDataException {
        UI field = new UI();
        Player p = new Player(field);
        p.setPosition(field);
        p.toRotateLeft(field);
        p.goForward(field);
        Assert.assertTrue(field.getField()[p.aktuelle_Zeile_x][p.aktuelle_Spalte_y] != '#');
    }


    /**
     * The player moves on step down
     * @throws InvalidInputException
     */
    @Test
    public void toMoveThePlayerDown() throws GameException, NoDataException {
        UI field = new UI();
        Player p = new Player(field);
        p.setPosition(field);
        p.toRotateRight(field);
        p.goForward(field);
        Assert.assertTrue(field.getField()[p.aktuelle_Zeile_x][p.aktuelle_Spalte_y] != '#');
    }


    /**
     * The player moves one step to the left
     * @throws InvalidInputException
     */
    @Test
    public void toMoveThePlayerToTheLeft() throws GameException, NoDataException {
        UI field = new UI();
        Player p = new Player(field);
        p.setPosition(field);
        p.toRotateLeft(field);
        p.toRotateLeft(field);
        p.goForward(field);
        Assert.assertTrue(field.getField()[p.aktuelle_Zeile_x][p.aktuelle_Spalte_y] != '#');
    }

    //Randtests

    /**
     * The player moves to the left margin.
     * @throws Exception
     */
    @Test(expected = InvalidInputException.class)
    public void toMoveToTheLeftMargin()throws Exception{
        UI field = new UI();
        Player p = new Player(field);
        p.setPosition(field);
        p.toRotateLeft(field);
        p.toRotateLeft(field);
        p.goForward(field);
        p.goForward(field);
    }


    /**
     * The player moves to the right still the margin is arrived
     * @throws InvalidInputException
     */
    @Test(expected = InvalidInputException.class)
    public void toMoveThePlayerToTheRightMargin() throws GameException, NoDataException {
        UI field = new UI();
        Player p = new Player(field);
        p.setPosition(field);
        p.goForward(field);
        p.goForward(field);
        p.goForward(field);
        p.goForward(field);
        p.goForward(field);
        p.goForward(field);
        p.goForward(field);
    }


    /**
     * The player moves to the opper margin.
     * @throws Exception
     */
    @Test(expected = InvalidInputException.class)
    public void toMoveToTheOpperMargin()throws Exception{
        UI field = new UI();
        Player p = new Player(field);
        p.setPosition(field);
        p.toRotateLeft(field);
        p.goForward(field);
        p.goForward(field);
        p.goForward(field);
        p.goForward(field);
        p.goForward(field);
    }


    /**
     * The player moves to the bottom margin.
     * @throws Exception
     */
    @Test(expected = InvalidInputException.class)
    public void toMoveToTheLowerMargin()throws Exception{
        UI field = new UI();
        Player p = new Player(field);
        p.setPosition(field);
        p.toRotateRight(field);
        p.goForward(field);
        p.goForward(field);
        p.goForward(field);
        p.goForward(field);
    }


    /**
     * The player moves to the object.
     * @throws Exception
     */

    @Test
    public void positionPlayerAsPositionObject()throws Exception{
        UI field = new UI();
        Gegenstand object = new Gegenstand(field);
        Player p = new Player(field);
        object.move(field);
        p.setPosition(field);
        p.toRotateLeft(field);
        p.goForward(field);
        p.goForward(field);
        p.toRotateLeft(field);
        p.goForward(field);
        Assert.assertEquals(field.getField()[p.aktuelle_Zeile_x][p.aktuelle_Spalte_y],
                field.getField()[object.getFinalPosition_x()][object.getFinalPosition_y()]);
    }


    /**
     * to play a complete round.
     * @throws GameException
     */
    @Test
    public void completeRound() throws GameException, NoDataException {
        UI field = new UI();
        Gegenstand object = new Gegenstand(field);
        Aufgabe ex = new Aufgabe();
        Player p = new Player(field);
        object.move(field);
        p.setPosition(field);
        p.toRotateLeft(field);
        p.goForward(field);
        p.goForward(field);
        p.toRotateLeft(field);
        p.goForward(field);
        p.toRotateLeft(field);
        p.goForward(field);
        Assert.assertEquals(ex,ex);
    }


    /**
     * to play a complete round an to come to the next.
     * @throws Exception
     */
    @Test
    public void arriveTheNextRound() throws GameException, NoDataException {
        UI field = new UI();
        Gegenstand object = new Gegenstand(field);
        Rundenzaehler runde = new Rundenzaehler();
        Aufgabe ex = new Aufgabe();
        Player p = new Player(field);
        object.move(field);
        p.setPosition(field);
        p.toRotateLeft(field);
        p.goForward(field);
        p.goForward(field);
        p.toRotateLeft(field);
        p.goForward(field);
        p.toRotateLeft(field);
        p.goForward(field);
        Assert.assertEquals(ex,ex);
        runde.setRunde();
        int currentRound = runde.getRunde();
        Assert.assertEquals(2, currentRound);
    }
}
