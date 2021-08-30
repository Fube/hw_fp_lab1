import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleTest {

    private Circle circle;
    private final double DEFAULT_RADIUS = 10;
    private final double DEFAULT_AREA = Math.PI * Math.pow(DEFAULT_RADIUS, 2);

    @BeforeEach
    public void setUp() {
        circle = new Circle(DEFAULT_RADIUS);
    }

    @Test
    @DisplayName("Get default radius")
    void getRadius() {
        assertEquals(circle.getRadius(), DEFAULT_RADIUS);
    }

    @Test
    @DisplayName("Get default area")
    void getArea() {
        assertEquals(circle.getArea(), DEFAULT_AREA);
    }

    @Test
    @DisplayName("Change radius")
    void setRadius() {
        final int RADIUS = 5;
        circle.setRadius(RADIUS);
        assertEquals(circle.getRadius(), RADIUS);
    }

    @Test
    @DisplayName("Get default diameter")
    void getDiameter() {
        assertEquals(circle.getDiameter(), DEFAULT_RADIUS * 2);
    }

    @Test
    void testToString() {
        assertEquals(circle.toString(), "Circle{radius="+ DEFAULT_RADIUS +"}");
    }
}