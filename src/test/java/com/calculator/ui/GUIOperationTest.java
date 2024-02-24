package com.calculator.ui;

import com.calculator.matrix.CoordinateFactory;
import com.calculator.matrix.MatrixFactoryInterface;
import com.calculator.matrix.MatrixInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GUIOperationTest {
    @Test
    public void testLoadmatrixInGui(){
        //Stub is for test
        MatrixInterface<Double>matrix= MatrixFactoryInterface.createMatrix(3,3);
        matrix.setValueAt(CoordinateFactory.createCoordinate(0,0),1.0);
        matrix.setValueAt(CoordinateFactory.createCoordinate(0,1),2.0);
        matrix.setValueAt(CoordinateFactory.createCoordinate(0,2),3.0);
        matrix.setValueAt(CoordinateFactory.createCoordinate(1,0),4.0);
        matrix.setValueAt(CoordinateFactory.createCoordinate(1,1),5.0);
        matrix.setValueAt(CoordinateFactory.createCoordinate(1,2),6.0);
        matrix.setValueAt(CoordinateFactory.createCoordinate(2,0),7.0);
        matrix.setValueAt(CoordinateFactory.createCoordinate(2,1),8.0);
        matrix.setValueAt(CoordinateFactory.createCoordinate(2,2),9.0);
        MatrixView mainViewStub=MatrixViewFactory.createMatrixViewStub();
        MatrixPresenter presenter=MatrixPresenterFactory.createPresenter(matrix, matrix,mainViewStub);
        mainViewStub.setPresenter(presenter);
        mainViewStub.displayMatrix();
        assertEquals("[[1.0, 2.0, 3.0], [4.0, 5.0, 6.0], [7.0, 8.0, 9.0]]",(mainViewStub.getDisplayedData()));
    }
}
