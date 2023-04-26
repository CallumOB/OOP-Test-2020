package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	private int numLines = 30;
	private int namesPart = 150; // the width of the section containing the names
	private float rowHeight = 40;
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
		colorMode(HSB);
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}

	public void displayTasks() {
		int offset = 30;

		textSize(12);
		textAlign(CENTER, CENTER);

		stroke(255);

		for (int i = 1; i <= numLines; i++) {
			float x = map(i, 1, numLines, namesPart, width - offset);
			line(x, offset, x, height - offset);
			fill(255);
			text(i, x, offset * 0.5f);
		}

		textAlign(LEFT, CENTER);

		for (int i = 0; i < tasks.size(); i++) {
			float y = (offset * 2) + rowHeight * i;
			fill(255);
			text(tasks.get(i).getTaskDesc(), offset, y);

			noStroke();
			fill(map(i, 0, tasks.size(), 0, 255), 255, 255);
			float x1 = map(tasks.get(i).getStart(), 1, numLines, namesPart, width - offset);
			float x2 = map(tasks.get(i).getEnd(), 1, numLines, namesPart, width - offset);
			rect(x1, y - 15, x2 - x1, rowHeight - 5, 5.0f);
		}
	}
}
