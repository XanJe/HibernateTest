package logic;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PlanetAddress {
    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    @Column(name="planet_address")
    String planet;
    @Column(name="star_address")
    String star;
}
