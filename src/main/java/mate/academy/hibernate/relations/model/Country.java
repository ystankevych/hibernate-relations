package mate.academy.hibernate.relations.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "countries")
public class Country implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId(mutable = true)
    @Basic(optional = false)
    private String name;

    public Country() {
    }

    public Country(String name) {
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

    @Override
    public Country clone() {
        try {
            return (Country) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't make clone of " + this, e);
        }
    }

    @Override
    public String toString() {
        return "Country{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
