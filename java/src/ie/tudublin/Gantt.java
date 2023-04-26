package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	

	ArrayList<Task> tasks = new ArrayList<>();
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table taskTable = loadTable("java/data/tasks.csv", "header");

		for (TableRow tr : taskTable.rows()) {
			tasks.add(new Task(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End")));
		}
	}

	public void printTasks()
	{
		for (Task task : tasks) {
			println(task.toString());
		}
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
		ganttSetup();
	}

	public void displayTasks() {
		float colour = 255 / (float) tasks.size();
		
		for (Task task : tasks) {
			
		}
	}

	public void ganttSetup() {
		int offset = 30;
		int gap = 0;
		int numLines = 30;
		stroke(255);
		for (int i = 0; i < numLines; i++) {
			line(offset + gap, offset, offset + gap, height - offset);
			gap += 20;
		}
	}
}
