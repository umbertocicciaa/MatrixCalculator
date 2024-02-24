package com.calculator.matrix;

public interface MatrixFactoryInterface {
    static <T extends Number> MatrixInterface<T> createMatrix(int row, int column) {
        return new MatrixConcrete<>(row, column);
    }

    static <T extends Number> MatrixInterface<T> createMatrixFromText(String text) {
        if (!isMatrix(text))
            return new MatrixConcrete<>(1, 1);
        String[] rows = text.split("\n");
        int numRows = rows.length;
        int numCols = rows[0].trim().split("\\s+").length;
        MatrixInterface<T> matrix = new MatrixConcrete<>(numRows, numCols);
        for (int i = 0; i < numRows; i++) {
            String[] elements = rows[i].trim().split("\\s+");
            for (int j = 0; j < numCols; j++)
                matrix.setValueAt(CoordinateFactory.createCoordinate(i, j),(T) (Number) Double.parseDouble(elements[j]));
        }
        return matrix;
    }

    private static boolean isMatrix(String text) {
        try {
            String[] rows = text.split("\n");
            if (rows.length == 0 || rows[0].trim().isEmpty())
                return false;
            int cols = rows[0].split("\\s+").length;
            for (String row : rows) {
                String[] elements = row.split("\\s+");
                if (elements.length != cols)
                    return false;
                for (String element : elements)
                    Double.parseDouble(element);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
