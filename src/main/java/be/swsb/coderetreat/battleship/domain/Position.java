package be.swsb.coderetreat.battleship.domain;

/**
 * Definition of a position in a matrix, using mathematical convention.
 * A matrix of size MxN has M rows and N columns.
 * Given matrix A -> (Arc) post(r,c) is the element on row r and column c
 *  A = [3 , 5 , 7] => A12 => A.get(pos(1,2) = 5
 *  rowNumber ~ verticalPosition
 *  columnNumber ~ horizontalPosition
 */
public record Position(
    int rowNumber,
    int columnNumber
){

    public static Position pos(int rowNumber, int columnNumber) {
        return new Position(rowNumber, columnNumber);
    }
}
