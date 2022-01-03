public class runUIGaming {
    public static void main(String[] args)throws Exception {
        System.out.println("############# Willkommen beim Punktesammler #############");
        GStart start = new GStart();
        try{
            Timer t = new Timer();
            t.countdown();
            start.startGame();
        }catch(NoDataException e){
            e.printStackTrace();
        }
    }
}
