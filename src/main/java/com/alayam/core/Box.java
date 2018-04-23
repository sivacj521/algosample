package com.alayam.core;

public class Box<T> {
	// T stands for "Type"
	private T t;
	
	public void set(T t) { this.t = t; }
	
	public T get() { return t; }
	
	Box<T> createBox(){
		return new Box<T>();
	}
}

/*
public class Box {
    // T stands for "Type"
    private String t;

    public void set(String t) { this.t = t; }
    public String get() { return t; }
}




public class Box {
    // T stands for "Type"
    private Integer t;

    public void set(Integer t) { this.t = t; }
    public Integer get() { return t; }
}


 class Util {
    // Generic static method
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
}
*/