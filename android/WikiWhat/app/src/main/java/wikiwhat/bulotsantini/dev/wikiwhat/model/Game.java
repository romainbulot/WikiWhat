package wikiwhat.bulotsantini.dev.wikiwhat.model;

/**
 * Created by Administrator on 07/03/2017.
 */

public class Game {
    private int[] nb_pages_cat = new int[3];
    private int nb_hint = 0;
    private int final_score = 0;

    public Game() {

    }

    public Game(int nb_hint, int current_score) {
        this.nb_hint = nb_hint;
        this.final_score = current_score;
    }
}
