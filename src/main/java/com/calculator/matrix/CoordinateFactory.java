package com.calculator.matrix;

public interface CoordinateFactory {
     static CoordinateInterface createCoordinate(int x,int y){
         CoordinateInterface coordinate=new Coordinate();
         coordinate.setCoordinate(x,y);
         return coordinate;
     }
}
