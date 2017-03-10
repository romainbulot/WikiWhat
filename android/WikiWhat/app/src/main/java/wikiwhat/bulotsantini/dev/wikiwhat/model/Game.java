package wikiwhat.bulotsantini.dev.wikiwhat.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 07/03/2017.
 */

public class Game {
    private int score = 0;
    private Category[] categories = new Category[3];
    private Page current_page;
    private List<String> hints = new ArrayList<>();

    public Game(Page newPage) {
        this(0, newPage);
    }

    public Game(int current_score, Page newPage) {
        score = current_score;
        current_page = new Page(newPage);
    }

    public Game(Game g) {
        this(g.getScore(), g.getCurrent_page());
    }

    public int getScore() {
        return score;
    }

    public Category[] getCategories() {
        return categories;
    }

    public Page getCurrent_page() {
        return current_page;
    }

    public List<String> getHints() {
        return hints;
    }
}
