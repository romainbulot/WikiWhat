package wikiwhat.bulotsantini.dev.wikiwhat.model;

/**
 * Created by Administrator on 10/03/2017.
 */

public class Page {
    /**
     * Id of the wiki page
     */
    private int id;
    /**
     * Name of the page
     */
    private String name;

    /**
     * Constructor
     * @param id
     * @param name
     */
    public Page(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Constructor
     * @param p
     */
    public Page(Page p) {
        id = p.getId();
        name = p.getName();
    }

    /**
     * Return the id of the page
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Return the name of the page
     * @return name
     */
    public String getName() {
        return name;
    }
}
