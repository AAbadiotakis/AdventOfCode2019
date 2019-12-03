package hidden.style.day.three;

public class Coordinate {

    private Long x;
    public Long getX() { return x; }
    private Long y;
    public Long getY() { return y; }

    public Coordinate(Long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public boolean matches(Long x, Long y) {
        return this.x == x && this.y == y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate) {
            return this.x == ((Coordinate) obj).x && this.y == ((Coordinate) obj).y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return x.hashCode() ^ y.hashCode();
    }
}
