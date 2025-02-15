package mate.academy.hibernate.relations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "actors")
public class Actor implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "actors_country_fk"))
    private Country country;

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public Actor clone() {
        try {
            Actor actor = (Actor) super.clone();
            if (country != null) {
                actor.setCountry(country.clone());
            }
            return actor;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't make clone of " + this, e);
        }
    }

    @Override
    public String toString() {
        return "Actor{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", country='" + country + '\''
                + '}';
    }
}
