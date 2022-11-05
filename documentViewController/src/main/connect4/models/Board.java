package models;

import java.util.HashMap;
import java.util.Map;

import types.Color;
import types.Direction;


public class Board {

    public static final int NUM_ROWS = 6;
    public static final int NUM_COLUMNS = 7;

    private Map<Coordinate, Color> boardCoordinates;
    private Coordinate lastToken;

    Board() {
		this.boardCoordinates = new HashMap<>();
        this.lastToken = null;
		this.reset();
	}

    private Board(Map<Coordinate, Color> boardCoordinates, Coordinate lastToken) {
		this.boardCoordinates = boardCoordinates;
        this.lastToken = lastToken;
	}

    Board cloneBoard(){
        Map<Coordinate, Color> boardCoordinatesCopy = new HashMap<>();
        for (Map.Entry<Coordinate, Color> entry : this.boardCoordinates.entrySet()) {
            Coordinate coordinate = entry.getKey().cloneCoordinate();
            Color color = entry.getValue();
            
            boardCoordinatesCopy.put(coordinate, color);
        }
        Coordinate lastCoordinateCopy = null;
        if(this.lastToken != null){
            lastCoordinateCopy = this.lastToken.cloneCoordinate();
        }
        return new Board(boardCoordinatesCopy, lastCoordinateCopy);
    }

    void reset() {
        this.boardCoordinates = new HashMap<>();
        this.lastToken = null;
    }

    void putToken(int column, Color color){

        int row = 0;
        Coordinate coordinate = new Coordinate(row, column);
        while (row < NUM_ROWS && this.boardCoordinates.containsKey(coordinate)){
            coordinate.moveCoordinate(Direction.VERTICAL_UP, 1);
            row++;
        }
        
        if(!this.boardCoordinates.containsKey(coordinate)){
            this.lastToken = coordinate;
            this.boardCoordinates.put(this.lastToken, color);
        }
    }

    boolean isColumnFull(int column){
        return this.boardCoordinates.containsKey(new Coordinate(NUM_ROWS - 1, column));
    }

    boolean isConnect4(Color color) {
        
        for(Direction direction : Direction.values()){
            for(int displacement = -3; displacement <= 0; displacement++){

                if(isLine(color, direction, displacement)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isLine(Color color, Direction direction, int displacement){

        int i=0;
        while(i<4 && isCoordinateWithSameColor(color, direction, displacement + i))
            i++;

        return i==4;
    }

    private boolean isCoordinateWithSameColor(Color color, Direction direction, int displacement){
        
        if (this.lastToken == null){
            return false;
        }

        Coordinate referenceCoordinate = this.lastToken.referenceCoordinate(direction, displacement);

        return this.boardCoordinates.containsKey(referenceCoordinate) && this.boardCoordinates.get(referenceCoordinate).equals(color);
    }
   
    boolean isDraw() {
        
        int column = 0;
        while (column < NUM_COLUMNS && isColumnFull(column))
            column++;

        return column == NUM_COLUMNS;
    }

    Color getColor(Coordinate coordinate) {

        if(this.boardCoordinates.containsKey(coordinate)){
            return this.boardCoordinates.get(coordinate);
        }else{
            return Color.NULL;
        }
    }
}
