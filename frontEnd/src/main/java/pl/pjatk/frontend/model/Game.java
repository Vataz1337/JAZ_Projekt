package pl.pjatk.frontend.model;

import javax.persistence.*;
import java.util.Objects;

public class Game {
    private int id;
    private String name;
    private String genre;
    private int price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getPrice() {
        return price;
    }



}
