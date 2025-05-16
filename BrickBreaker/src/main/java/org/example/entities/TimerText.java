package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TimerText extends TextEntity {

    private int secondsPassed = 0;

    public TimerText(Coordinate2D initialLocation) {
        super(initialLocation, "Time: 0s");
        setFill(Color.WHITE);
        setFont(Font.font("Arial", 24));
    }

    /**
     * Roep deze methode aan om de timer met 1 seconde te verhogen en tekst aan te passen.
     */
    public void incrementTime() {
        secondsPassed++;
        setText("Time: " + secondsPassed + "s");
    }

    /**
     * Optioneel: reset de timer terug naar 0.
     */
    public void reset() {
        secondsPassed = 0;
        setText("Time: 0s");
    }

    /**
     * Geeft het aantal seconden terug dat verstreken is.
     */
    public int getSecondsPassed() {
        return secondsPassed;
    }
}
