package main.utils;

public interface Observer {

	public void update(Observed observed, Event event);

}