/*
 * Copyright (C) 2016 Andrea Binello ("andbin")
 *
 * This file is part of the "Java 8 Streams Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.streamsdemos.points.datamodel;

import java.util.Arrays;
import java.util.List;

public class PointsData {
    private PointsData() {}

    /*
     * This Point2D data samples contains:
     *   - 6 points in Quadrant I
     *   - 9 points in Quadrant II
     *   - 7 points in Quadrant III
     *   - 4 points in Quadrant IV
     *   - 1 point in the origin
     *   - 2 points on X axis (y=0)
     *   - 2 points on Y axis (x=0)
     */
    public static List<Point2D> getSamples() {
        return Arrays.asList(
                new Point2D(2, 1),          // Quadrant I
                new Point2D(-2, 3),         // Quadrant II
                new Point2D(-2.5, -0.25),   // Quadrant III
                new Point2D(6, 2.5),        // Quadrant I
                new Point2D(0, 6),          // Y axis
                new Point2D(7.5, 5.5),      // Quadrant I
                new Point2D(-8.5, 2.5),     // Quadrant II
                new Point2D(4, 4),          // Quadrant I
                new Point2D(-0.25, -7),     // Quadrant III
                new Point2D(-7, 0),         // X axis
                new Point2D(5, -9),         // Quadrant IV
                new Point2D(-3, -3.75),     // Quadrant III
                new Point2D(0, 0),          // origin
                new Point2D(-6.5, 4.75),    // Quadrant II
                new Point2D(-1, -2),        // Quadrant III
                new Point2D(3, 7),          // Quadrant I
                new Point2D(-4, 2),         // Quadrant II
                new Point2D(-5.25, -5.5),   // Quadrant III
                new Point2D(-7, -3.5),      // Quadrant III
                new Point2D(0.5, -1),       // Quadrant IV
                new Point2D(4, 0),          // X axis
                new Point2D(6.25, -2.25),   // Quadrant IV
                new Point2D(-5, -1),        // Quadrant III
                new Point2D(3, -4),         // Quadrant IV
                new Point2D(-4.25, 6.75),   // Quadrant II
                new Point2D(-2, 5.5),       // Quadrant II
                new Point2D(0, -2),         // Y axis
                new Point2D(-11, 1),        // Quadrant II
                new Point2D(-3, 4),         // Quadrant II
                new Point2D(10, 3),         // Quadrant I
                new Point2D(-1, 8)          // Quadrant II
        );
    }
}
