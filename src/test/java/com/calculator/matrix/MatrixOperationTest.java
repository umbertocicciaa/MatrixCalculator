package com.calculator.matrix;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixOperationTest {

    @Test
    public void testCreateIntMatrix() {
        MatrixInterface<Integer> matrix = MatrixFactoryInterface.createMatrix(1, 2);
        matrix.setValueAt(CoordinateFactory.createCoordinate(0, 0), 1);
        matrix.setValueAt(CoordinateFactory.createCoordinate(0, 1), 1);
        assertEquals(1, matrix.getValueAt(CoordinateFactory.createCoordinate(0, 0)));
        assertEquals(1, matrix.getValueAt(CoordinateFactory.createCoordinate(0, 1)));
    }

    @Test
    public void testCreateMatrixFromText() {
        String text = "1 2 3" + "\n" + "4 5 6";
        MatrixInterface<Integer> matrix = MatrixFactoryInterface.createMatrixFromText(text);
        assertEquals("[[1.0, 2.0, 3.0], [4.0, 5.0, 6.0]]", matrix.toString());
    }

    @Test
    public void testNullMatrixElement() {
        MatrixInterface<Integer> matrix = MatrixFactoryInterface.createMatrix(1, 2);
        assertEquals(NullMatrixElement.getInstance(), matrix.getValueAt(CoordinateFactory.createCoordinate(0, 0)));
        assertEquals(NullMatrixElement.getInstance(), matrix.getValueAt(CoordinateFactory.createCoordinate(0, 1)));
    }

    @Test
    public void testLoadIntMatrix() {
        MatrixInterface<Integer> matrix_interger = MatrixFactoryInterface.createMatrix(1, 2);
        for (int i = 0; i < matrix_interger.getRow(); ++i)
            for (int j = 0; j < matrix_interger.getColumn(); ++j)
                matrix_interger.setValueAt(CoordinateFactory.createCoordinate(i, j), 1);
        assertEquals(1, matrix_interger.getValueAt(CoordinateFactory.createCoordinate(0, 0)));
        assertEquals(1, matrix_interger.getValueAt(CoordinateFactory.createCoordinate(0, 1)));
    }

    @Test
    public void testLoadDoubleMatrix() {
        MatrixInterface<Double> matrix_double = MatrixFactoryInterface.createMatrix(1, 2);
        for (int i = 0; i < matrix_double.getRow(); ++i)
            for (int j = 0; j < matrix_double.getColumn(); ++j)
                matrix_double.setValueAt(CoordinateFactory.createCoordinate(i, j), 1.0);
        assertEquals(1.0, matrix_double.getValueAt(CoordinateFactory.createCoordinate(0, 0)));
        assertEquals(1.0, matrix_double.getValueAt(CoordinateFactory.createCoordinate(0, 1)));
    }

    @Test
    public void testLoadFloatMatrix() {
        MatrixInterface<Float> matrix_float = MatrixFactoryInterface.createMatrix(1, 2);
        for (int i = 0; i < matrix_float.getRow(); ++i)
            for (int j = 0; j < matrix_float.getColumn(); ++j)
                matrix_float.setValueAt(CoordinateFactory.createCoordinate(i, j), 1.0f);
        assertEquals(1.0f, matrix_float.getValueAt(CoordinateFactory.createCoordinate(0, 0)));
        assertEquals(1.0f, matrix_float.getValueAt(CoordinateFactory.createCoordinate(0, 1)));
    }

    @Test
    public void testLoadLongMatrix() {
        MatrixInterface<Long> matrix_float = MatrixFactoryInterface.createMatrix(1, 2);
        for (int i = 0; i < matrix_float.getRow(); ++i)
            for (int j = 0; j < matrix_float.getColumn(); ++j)
                matrix_float.setValueAt(CoordinateFactory.createCoordinate(i, j), 1L);
        assertEquals(1L, matrix_float.getValueAt(CoordinateFactory.createCoordinate(0, 0)));
        assertEquals(1L, matrix_float.getValueAt(CoordinateFactory.createCoordinate(0, 1)));
    }


    @Test
    public void testThrowIllegalArgumentExceptionCreateMatrix() {
        assertThrows(IllegalArgumentException.class, () -> MatrixFactoryInterface.createMatrix(-1, 1));
        assertThrows(IllegalArgumentException.class, () -> MatrixFactoryInterface.createMatrix(1, -1));
        assertThrows(IllegalArgumentException.class, () -> MatrixFactoryInterface.createMatrix(0, 1));
        assertThrows(IllegalArgumentException.class, () -> MatrixFactoryInterface.createMatrix(1, 0));
    }

    @Test
    public void testAddMatrix() {
        MatrixInterface<Integer> addend = MatrixFactoryInterface.createMatrix(1, 2);
        addend.setValueAt(CoordinateFactory.createCoordinate(0, 0), 1);
        addend.setValueAt(CoordinateFactory.createCoordinate(0, 1), 1);
        MatrixInterface<Integer> sum = addend.sum(addend);
        assertEquals(BigDecimal.valueOf(2.0), sum.getValueAt(CoordinateFactory.createCoordinate(0, 0)));
        assertEquals(BigDecimal.valueOf(2.0), sum.getValueAt(CoordinateFactory.createCoordinate(0, 1)));
    }

    @Test
    public void testThrowIllegalArgumentExceptionAddMatrixDifferentSize() {
        MatrixInterface<Integer> firstAddend = MatrixFactoryInterface.createMatrix(1, 3), secondAddend = MatrixFactoryInterface.createMatrix(1, 2);
        assertThrows(IllegalArgumentException.class, () -> firstAddend.sum(secondAddend));
    }

    @Test
    public void testEqualsSymmetric() {
        MatrixInterface<Integer> firstMatrix = MatrixFactoryInterface.createMatrix(1, 2);
        firstMatrix.setValueAt(CoordinateFactory.createCoordinate(0, 0), 10);
        firstMatrix.setValueAt(CoordinateFactory.createCoordinate(0, 1), 20);
        MatrixInterface<Integer> secondMatrix = MatrixFactoryInterface.createMatrix(1, 2);
        secondMatrix.setValueAt(CoordinateFactory.createCoordinate(0, 0), 10);
        secondMatrix.setValueAt(CoordinateFactory.createCoordinate(0, 1), 20);
        assertTrue(firstMatrix.equals(secondMatrix) && secondMatrix.equals(firstMatrix));
        assertEquals(firstMatrix.hashCode(), secondMatrix.hashCode());
    }

    @SuppressWarnings("EqualsBetweenInconvertibleTypes")
    @Test
    public void testEqualsFalseBecauseDifferenType() {
        MatrixInterface<Double> firstMatrix = MatrixFactoryInterface.createMatrix(1, 2);
        firstMatrix.setValueAt(CoordinateFactory.createCoordinate(0, 0), 10.0);
        firstMatrix.setValueAt(CoordinateFactory.createCoordinate(0, 1), 20.0);
        MatrixInterface<Integer> secondMatrix = MatrixFactoryInterface.createMatrix(1, 2);
        secondMatrix.setValueAt(CoordinateFactory.createCoordinate(0, 0), 10);
        secondMatrix.setValueAt(CoordinateFactory.createCoordinate(0, 1), 20);
        assertFalse(firstMatrix.equals(secondMatrix) && secondMatrix.equals(firstMatrix));
    }

    @Test
    public void testToString() {
        MatrixInterface<Integer> matrix = MatrixFactoryInterface.createMatrix(1, 1);
        matrix.setValueAt(CoordinateFactory.createCoordinate(0, 0), 1);
        String expected = "[[1]]";
        assertEquals(expected, matrix.toString());
    }

    @Test
    public void testRemoveMatrix() {
        MatrixInterface<Double> suctract = MatrixFactoryInterface.createMatrix(1, 2);
        suctract.setValueAt(CoordinateFactory.createCoordinate(0, 0), 1.0);
        suctract.setValueAt(CoordinateFactory.createCoordinate(0, 1), 1.0);
        MatrixInterface<Double> sum = suctract.subtract(suctract);
        assertEquals(BigDecimal.valueOf(0.0), sum.getValueAt(CoordinateFactory.createCoordinate(0, 0)));
        assertEquals(BigDecimal.valueOf(0.0), sum.getValueAt(CoordinateFactory.createCoordinate(0, 1)));
    }

    @Test
    public void testThrowIllegalArgumentExceptionRemoveMatrixDifferentSize() {
        MatrixInterface<Double> suctract = MatrixFactoryInterface.createMatrix(1, 2), subtrahend = MatrixFactoryInterface.createMatrix(1, 3);
        assertThrows(IllegalArgumentException.class, () -> suctract.subtract(subtrahend));
    }

    @Test
    public void testMultiplyMatrix() {
        MatrixInterface<Double> multiplier = MatrixFactoryInterface.createMatrix(2, 3);
        multiplier.setValueAt(CoordinateFactory.createCoordinate(0, 0), 1.0);
        multiplier.setValueAt(CoordinateFactory.createCoordinate(0, 1), 2.0);
        multiplier.setValueAt(CoordinateFactory.createCoordinate(0, 2), 3.0);
        multiplier.setValueAt(CoordinateFactory.createCoordinate(1, 0), 4.0);
        multiplier.setValueAt(CoordinateFactory.createCoordinate(1, 1), 5.0);
        multiplier.setValueAt(CoordinateFactory.createCoordinate(1, 2), 6.0);
        MatrixInterface<Double> multiplicand = MatrixFactoryInterface.createMatrix(3, 2);
        multiplicand.setValueAt(CoordinateFactory.createCoordinate(0, 0), 1.0);
        multiplicand.setValueAt(CoordinateFactory.createCoordinate(0, 1), 2.0);
        multiplicand.setValueAt(CoordinateFactory.createCoordinate(1, 0), 3.0);
        multiplicand.setValueAt(CoordinateFactory.createCoordinate(1, 1), 4.0);
        multiplicand.setValueAt(CoordinateFactory.createCoordinate(2, 0), 5.0);
        multiplicand.setValueAt(CoordinateFactory.createCoordinate(2, 1), 6.0);
        MatrixInterface<Double> product = multiplier.multiply(multiplicand);
        assertEquals(BigDecimal.valueOf(22.0), product.getValueAt(CoordinateFactory.createCoordinate(0, 0)));
        assertEquals(BigDecimal.valueOf(28.0), product.getValueAt(CoordinateFactory.createCoordinate(0, 1)));
        assertEquals(BigDecimal.valueOf(49.0), product.getValueAt(CoordinateFactory.createCoordinate(1, 0)));
        assertEquals(BigDecimal.valueOf(64.0), product.getValueAt(CoordinateFactory.createCoordinate(1, 1)));


    }

    @Test
    public void testThrowIllegalArgumentExceptionMultiplyMatrix() {
        MatrixInterface<Double> multiplier = MatrixFactoryInterface.createMatrix(1, 2), multiplicand = MatrixFactoryInterface.createMatrix(1, 3);
        assertThrows(IllegalArgumentException.class, () -> multiplier.multiply(multiplicand));
    }

    @Test
    public void testThrowIllegalArgumentExceptionCreateCoordinate() {
        assertThrows(IllegalArgumentException.class, () -> CoordinateFactory.createCoordinate(-1, 1));
        assertThrows(IllegalArgumentException.class, () -> CoordinateFactory.createCoordinate(1, -1));
    }

    @Test
    public void testDeterminatOfMatrix() {
        String text="1 2" + "\n" + "3 4";
        MatrixInterface<Double> matrix = MatrixFactoryInterface.createMatrixFromText(text);
        assertEquals(-2.0, matrix.determinant());
    }

    @Test
    public void testMatrixInversion() {

    }

    @Test
    public void testMatrixRank() {

    }

    @Test
    public void testMatrixTrasport() {
        String text="1 2 3" + "\n" + "4 5 6";
        MatrixInterface<Double> matrix = MatrixFactoryInterface.createMatrixFromText(text);
        MatrixInterface<Double> transposee = matrix.transposeMatrix();
        assertEquals("[[1.0, 4.0], [2.0, 5.0], [3.0, 6.0]]",transposee.toString());
    }

}
