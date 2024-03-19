import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class Main {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("one","two","three");
        Grid grid = new Grid(10);
        grid.fillGrid(words);
        grid.displayGrid();

    }
}