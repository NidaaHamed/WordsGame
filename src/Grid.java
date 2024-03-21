import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;


public class Grid {
    private int gridSize;
    private char[][] content;
    private List<Coordinate> coordinates = new ArrayList<>();
    private enum Direction{
        VERTICAL,
        HORIZONTAL,
        DIAGONAL
    }
    private class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public Grid(int gridSize){
        this.gridSize = gridSize;
        content = new char[gridSize][gridSize];
        for(int i=0 ; i<gridSize ; i++){
            for(int j=0 ; j<gridSize ; j++){
                coordinates.add(new Coordinate(i,j));
                content[i][j] = '_';
            }
        }
    }
    public void fillGrid(List<String> words){
        for(String word : words) {
            Collections.shuffle(coordinates);
            for(Coordinate coordinate:coordinates){
                int x = coordinate.x;
                int y = coordinate.y;
                if(doesFit(word,coordinate)) {
                    for(char c : word.toCharArray()){
                        content[x][y++] = c;
                    }
                    break;
                }
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
    private Direction doesFit(String word, Coordinate coordinate){
        List<Direction> directions = Arrays.asList(Direction.values());
        Collections.shuffle(directions);
        for(Direction direction:directions){
            if(doesFit(word,coordinate,direction)){
                return direction;
            }
        }
        return null;
    }
    private boolean doesFit(String word, Coordinate coordinate, Direction direction){
        int wordLength = word.length();
        switch (direction){
            case DIAGONAL -> {
                if (coordinate.y+wordLength>gridSize || coordinate.x+word.length()>gridSize)return false;
                for(int i = 0 ; i < wordLength; i++){
                    if(content[coordinate.x+i][coordinate.y+i] != '_') return  false;
                }
            }
            case VERTICAL ->{
                if (coordinate.x+wordLength>gridSize)return false;
                for(int i = 0 ; i < wordLength; i++){
                    if(content[coordinate.x+i][coordinate.y] != '_') return  false;
                }
            }
            case HORIZONTAL ->{
                if (coordinate.y+wordLength>gridSize)return false;
                for(int i = 0 ; i < wordLength; i++){
                    if(content[coordinate.x][coordinate.y+i] != '_') return  false;
                }
            }
        }
        return true;
    }

}
