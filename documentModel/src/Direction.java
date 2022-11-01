enum Direction {
    
	VERTICAL_UP(0,1),
	HORIZONTAL_RIGTH(1,0),
	MAIN_DIAGONAL(1,1),
	INVERSE_DIAGONAL(1,-1);

	public final int x;
	public final int y;

    private Direction (int x, int y){
    	this.x = x;
		this.y = y;
    }
}