package examples.shapes;

import java.awt.*;

public class SaveDetails {//Here we are using Flyweight Pattern

    Color lineColour = Color.BLUE;
    float lineWidth = 2.0f;
    Color fillColor = Color.RED;
    int xAxis = 3;
    int yAxis = 3;

    public Color getLineColour() {
        return lineColour;
    }

    public void setLineColour(Color lineColour) {
        this.lineColour = lineColour;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getxPosition() {
        return xAxis;
    }

    public void setxPosition(int xPosition) {
        this.xAxis = xPosition;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

}
