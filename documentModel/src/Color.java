
enum Color {
    
	RED,
	YELLOW,
	NULL;
	
    static Color get(int i){
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

    boolean isNull(){
    	return this == Color.NULL;
    }
}

