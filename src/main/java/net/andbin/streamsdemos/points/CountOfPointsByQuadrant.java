/*
 * Copyright (C) 2016 Andrea Binello ("andbin")
 *
 * This file is part of the "Java 8 Streams Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.streamsdemos.points;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

import net.andbin.streamsdemos.points.datamodel.Point2D;
import net.andbin.streamsdemos.points.datamodel.PointsData;
import net.andbin.streamsdemos.points.datamodel.Quadrant;

public class CountOfPointsByQuadrant {
    public static void main(String[] args) {
        /*
         * Given the following list of points (see PointsData):
         */

        List<Point2D> pointsList = PointsData.getSamples();

        /*
         * We want to count the points in each quadrant, obtaining a map where:
         *   - the key is the Quadrant
         *   - the value is the number of points in that quadrant
         * Points not in a quadrant must be excluded.
         *
         * e.g.
         *     Quadrant I   --> 6 points
         *     Quadrant II  --> 9 points
         *     Quadrant III --> 7 points
         *     Quadrant IV  --> 4 points
         */

        Map<Quadrant,Long> quadrantToCountMap = countPointsByQuadrantUsingLambdaExpr(pointsList);

        System.out.printf("pointsList = %s%n%n", pointsList);

        quadrantToCountMap.entrySet().forEach(entry -> {
            System.out.printf("Quadrant %-3s --> %d points%n", entry.getKey(), entry.getValue());
        });
    }


    public static Map<Quadrant,Long> countPointsByQuadrantUsingLambdaExpr(List<Point2D> pointsList) {
        return pointsList.stream()
                .filter(point -> point.isInAQuadrant())     // filter: accepts only points in a quadrant
                .collect(groupingBy(
                        point -> point.getQuadrant(),       // classifier: by the Quadrant
                        () -> Quadrant.newEnumMap(),        // map factory: creates an EnumMap<Quadrant,Long>
                        counting()                          // downstream: counts points in a quadrant
                ));
    }

    public static Map<Quadrant,Long> countPointsByQuadrantUsingMethodRef(List<Point2D> pointsList) {
        return pointsList.stream()
                .filter(Point2D::isInAQuadrant)             // filter: accepts only points in a quadrant
                .collect(groupingBy(
                        Point2D::getQuadrant,               // classifier: by the Quadrant
                        Quadrant::newEnumMap,               // map factory: creates an EnumMap<Quadrant,Long>
                        counting()                          // downstream: counts points in a quadrant
                ));
    }
}
