package hidden.style.day.six;

import com.google.gson.Gson;

public class OrbitalMap {

    private String planet;
    public String getPlanet() { return planet; }

    private final String previousOrbitalPlanet;
    public String getPreviousOrbitalPlanet() { return previousOrbitalPlanet; }

    private int orbitsFromCenterOfMass;
    public int getOrbitsFromCenterOfMass() {  return orbitsFromCenterOfMass; }
    public void setOrbitsFromCenterOfMass(int orbitsFromCenterOfMass) { this.orbitsFromCenterOfMass = orbitsFromCenterOfMass; }

    public OrbitalMap(String planet, String previousOrbitalPlanet) {
        this.planet = planet;
        this.previousOrbitalPlanet = previousOrbitalPlanet;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
