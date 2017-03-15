package wikiwhat.bulotsantini.dev.wikiwhat.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 07/03/2017.
 */

public class Game {
    /**
     * The current score
     */
    private int score = 0;
    /**
     * The categories selected of the game
     */
    private Category[] categories = new Category[3];
    /**
     * The current page selected
     */
    private Page current_page;
    /**
     * The current hints given
     */
    private List<String> hints = new ArrayList<>();

    /**
     * Constructor of a game
     * @param categories
     * @param newPage
     */
    public Game(Category[] categories, Page newPage) {
        this(0, categories, newPage);
    }

    /**
     * Constructor of a game
     * @param current_score
     * @param categories
     * @param newPage
     */
    public Game(int current_score, Category[] categories, Page newPage) {
        score = current_score;
        this.categories[0] = categories[0];
        this.categories[1] = categories[1];
        this.categories[2] = categories[2];
        current_page = new Page(newPage);
    }

    /**
     * Constructor of a game
     * @param g
     */
    public Game(Game g) {
        this(g.getScore(), g.getCategories(), g.getCurrent_page());
    }

    /**
     * Update the score and return it
     * @return the current score
     */
    public int getScore() {

        for (Category cat : categories) {
            score += cat.getNb_pages();
        }
        score -= hints.size();

        return score;
    }

    /**
     * Return the categories
     * @return the categories
     */
    public Category[] getCategories() {
        return categories;
    }

    /**
     * Return the current page
     * @return the current page
     */
    public Page getCurrent_page() {
        return current_page;
    }

    /**
     * Return the list of hints
     * @return the list of hints
     */
    public List<String> getHints() {
        return hints;
    }
}
