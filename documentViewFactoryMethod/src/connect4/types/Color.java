package connect4.types;

public enum Color {
    
	RED,
	YELLOW,
	NULL;
	
    public static Color get(int i){
    	assert i >=0 && i < Color.NULL.ordinal();
    	
    	return Color.values()[i];
    }
    
    void write() {
    	String str = this.name(); 
    	if(this.isNull()) {
    		str = " ";
    	}
    	System.out.println(str);
    }

    public boolean isNull(){
    	return this == Color.NULL;
    }
}

