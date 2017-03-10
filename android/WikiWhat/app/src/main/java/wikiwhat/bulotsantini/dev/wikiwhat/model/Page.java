package wikiwhat.bulotsantini.dev.wikiwhat.model;

/**
 * Created by Administrator on 10/03/2017.
 */

public class Page {
    private int id;
    private String name;

    public Page(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Page(Page p) {
        id = p.getId();
        name = p.getName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
