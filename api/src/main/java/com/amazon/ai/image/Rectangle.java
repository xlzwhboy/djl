/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazon.ai.image;

public class Rectangle implements BoundingBox {

    Point point;
    double width;
    double height;

    public Rectangle(double x, double y, double width, double height) {
        this(new Point(x, y), width, height);
    }

    public Rectangle(Point point, double width, double height) {
        this.point = point;
        this.width = width;
        this.height = height;
    }

    @Override
    public Rectangle getBounds() {
        return this;
    }

    @Override
    public PathIterator getPath() {
        return new PathIterator() {

            private int index;

            @Override
            public boolean hasNext() {
                return index < 4;
            }

            @Override
            public void next() {
                if (index > 3) {
                    throw new IllegalStateException("No more path in iterator.");
                }
                ++index;
            }

            @Override
            public Point currentPoint() {
                switch (index) {
                    case 0:
                        return point;
                    case 1:
                        return new Point(point.getX() + width, point.getY());
                    case 2:
                        return new Point(point.getX() + width, point.getY() + height);
                    case 3:
                        return new Point(point.getX(), point.getY() + height);
                    default:
                        throw new AssertionError("Invalid index: " + index);
                }
            }
        };
    }

    public Point getPoint() {
        return point;
    }

    public double getX() {
        return point.getX();
    }

    public double getY() {
        return point.getY();
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}