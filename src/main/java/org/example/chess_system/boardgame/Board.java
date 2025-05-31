package org.example.chess_system.boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardExeption("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardExeption("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardExeption("Position not on the board");
        }
        return pieces[position.getRow()][position.getColunm()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsApicie(position)) {
            throw new BoardExeption("There is already a piece on positon " + position);
        }
        pieces[position.getRow()][position.getColunm()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColunm());
    }

    public boolean thereIsApicie(Position position) {
        if (!positionExists(position)) {
            throw new BoardExeption("Position not on the board");
        }
        return piece(position) != null;
    }
}
