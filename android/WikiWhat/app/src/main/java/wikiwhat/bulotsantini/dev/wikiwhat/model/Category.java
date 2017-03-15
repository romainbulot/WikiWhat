package wikiwhat.bulotsantini.dev.wikiwhat.model;

import java.io.Serializable;

/**
 * Created by Administrator on 10/03/2017.
 */

public class Category implements Serializable {
    /**
     * Id of the category
     */
    private int id;
    /**
     * Name of the category
     */
    private String name;
    /**
     * Number of page include in this category
     */
    private int nb_pages;

    /**
     * Default constructor
     */
    public Category() {

    }

    /**
     * Constructor
     * @param id
     * @param name
     */
    public Category(int id, String name) {
        this(id, name, 0);
    }

    /**
     * Constructor
     * @param id
     * @param name
     * @param nb_pages
     */
    public Category(int id, String name, int nb_pages) {
        this.id = id;
        this.name = name;
        this.nb_pages = nb_pages;
    }

    /**
     * Copying constructor
     * @param c
     */
    public Category(Category c) {
        id = c.getId();
        name = c.getName();
        nb_pages = c.getNb_pages();
    }

    /**
     * Return the id of the category
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Change the id of the category
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return the name of the category
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Change the name of the category
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Change the number of pages of the category
     * @param nb_pages
     */
    public void setNb_pages(int nb_pages) {
        this.nb_pages = nb_pages;
    }

    /**
     * Return the number of pages of the category
     * @return
     */
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
