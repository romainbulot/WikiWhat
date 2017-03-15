package wikiwhat.bulotsantini.dev.wikiwhat.model;

import java.io.Serializable;

/**
 * Created by Administrator on 10/03/2017.
 */

public class Category implements Serializable {
    private int id;
    private String name;
    private int nb_pages;

    public Category() {

    }

    public Category(int id, String name) {
        this(id, name, 0);
    }

    public Category(int id, String name, int nb_pages) {
        this.id = id;
        this.name = name;
        this.nb_pages = nb_pages;
    }

    public Category(Category c) {
        id = c.getId();
        name = c.getName();
        nb_pages = c.getNb_pages();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNb_pages(int nb_pages) {
        this.nb_pages = nb_pages;
    }

    public int getNb_pages() {
        return nb_pages;
    }

    public boolean equals(Object o) {
        if (o instanceof Category) {
            Category c = (Category) o;
            return c.getId() == getId();
        }

        return false;
    }

    public String toString() {
        String res = name + " (" + nb_pages + " page";
        if (nb_pages > 1) {
            res += "s";
        }
        res += ")";

        return res.replace("Catégorie:","");
    }
}
