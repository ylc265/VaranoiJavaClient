/**
 * Created by ylc265 on 10/24/15.
 */
public class SimpleVaranoiSecondPlayer extends VaranoiClient{

    int[][] grid;
    SimpleVaranoiSecondPlayer(String server, int port, String username, int n) {
        super(server, port, username);
        grid = new int[n][n];
    }
    @Override
    public String process(String command) {

        return null;
    }
}
