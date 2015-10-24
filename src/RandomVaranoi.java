import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by ylc265 on 10/24/15.
 */
public class RandomVaranoi extends VaranoiClient{
    Random rand = new Random();
    int[][] grid;
    RandomVaranoi(String server, int port, String username, int n) {
        super(server, port, username);
        grid = new int[n][n];
    }

    // random strategy
    @Override
    public String process(String command) {
        StringTokenizer tk = new StringTokenizer(command, "\n ");
        String op = tk.nextToken();
        if (op.equals("TEAM")) {
            return super.username;
        }
        if (op.equals("MOVE")) {
            int myx = rand.nextInt(grid.length);
            int myy = rand.nextInt(grid.length);
            grid[myx][myy] = 1;
            return String.format("%d %d", myx, myy);
        }
        
        int x = Integer.parseInt(tk.nextToken());
        int y = Integer.parseInt(tk.nextToken());
        grid[x][y] = 1;
        int myx, myy;
        do {
            myx = rand.nextInt(grid.length);
            myy = rand.nextInt(grid.length);
        } while (grid[myx][myy] != 0);
        grid[myx][myy] = 1;
        return String.format("%d %d", myx, myy);
    }

    public static void main(String[] args) {
        RandomVaranoi client = new RandomVaranoi("localhost", 1337, "myname", 1000);
        client.start();
    }
}
