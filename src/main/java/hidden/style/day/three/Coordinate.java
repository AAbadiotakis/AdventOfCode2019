package hidden.style.day.three;

import java.util.Objects;

public class Coordinate {

    private Integer x;
    public int getX() { return x; }
    private Integer y;
    public int getY() { return y; }
    private Integer distanceTravelled;
    public int getDistanceTravelled() { return distanceTravelled; }


    public Coordinate(int x, int y, int distanceTravelled) {
        this.x = x;
        this.y = y;
        this.distanceTravelled = distanceTravelled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate) {
            return this.x == ((Coordinate) obj).x && this.y == ((Coordinate) obj).y;
        }
        return false;
    }
}
