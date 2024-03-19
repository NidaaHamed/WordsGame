import java.util.concurrent.ThreadLocalRandom;
import java.util.List;


public class Grid {
    private int gridSize;
    private char[][] content;
    public Grid(int gridSize){
        this.gridSize = gridSize;
        content = new char[gridSize][gridSize];
        for(int i=0 ; i<gridSize ; i++){
            for(int j=0 ; j<gridSize ; j++){
                content[i][j] = '_';
            }
        }
    }
    public void fillGrid(List<String> words){
        for(String word : words) {

            int x = ThreadLocalRandom.current().nextInt(0,gridSize);
            int y = ThreadLocalRandom.current().nextInt(0,gridSize);
            if(y + word.length()>=gridSize) continue;
            for(char c : word.toCharArray()){
                content[x][y++] = word.charAt(0);
            }

        }

    }
    public void displayGrid(){
        for(int i=0 ; i<gridSize ; i++){
            for(int j=0 ; j<gridSize ; j++){
                System.out.print(content[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
