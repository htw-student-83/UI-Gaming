public class UI implements GamingUI {

                char [][] gameField = {
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#',},
                        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#',},
                        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#',},
                        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#',},
                        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#',},
                        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#',},
                        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#',},
                        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#',},
                        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#',},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#',},
                        };



    public char[][] getField(){
        return gameField;
    }

    public void setField(char[][] field){
        this.gameField = field;
    }


    @Override
    public void buildUI() {
        for(int i = 0; i<gameField.length; i++) {
            gameField[i][0] = '#';
            gameField[i][9] = '#';
            for (int j = 1; j < (gameField[i].length - 1); j++){
                gameField[i][j] = ' ';
            }
            System.out.println();
        }
    }

//ToDo die Lektion zweidimensionales Array wiederholen
    public void createUI(){
        for(int i = 0; i<gameField.length; i++){
            for(int j = 0; j<gameField[i].length;j++){
                System.out.print(gameField[i][j]);
            }
            System.out.println();
        }
    }
}
