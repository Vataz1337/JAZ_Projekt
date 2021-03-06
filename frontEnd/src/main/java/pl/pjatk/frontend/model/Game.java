package pl.pjatk.frontend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="game", schema = "projektjaz")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "genre")
    private String genre;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game games = (Game) o;
        return Objects.equals(id, games.id) && price == games.price && Objects.equals(name, games.name) && Objects.equals(genre, games.genre) && Objects.equals(description, games.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, price, description);
    }
}

