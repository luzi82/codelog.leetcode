import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    /**
     * for a game in n, divide the game into (n/4)+1 games,
     * which have c+4+4+..+4 stones
     * For each 4-stone game, first player must lose. (ABBB,AABB,AAAB)
     * For the first c-stone game, first player take all stone to win.
     * So, When n%4!=0, first player must win, otherwise lose
     */
    public boolean canWinNim(int n) {
        return (n%4) != 0;
    }
}
