import entity.EntityFactory;
import exception.InvalidParamsException;
import exception.InvalidQueryException;
import service.CreateQuery;
import service.DrawQuery;
import service.Query;
import service.QueryFactory;
import service.QuitQuery;
import service.canvas.Canvas;
import service.canvas.CanvasImpl;

import java.util.Scanner;

public class Drawing {

	static Scanner	scanner;
	static QueryFactory queryFactory;

	static Canvas	canvas;

	static EntityFactory	entityFactory;


	public static void main(String[] args) throws NumberFormatException {
		scanner = new Scanner(System.in);
		queryFactory = new QueryFactory();
		entityFactory = new EntityFactory();

		System.out.println("Please Enter command:");

		while (true) {
			process(scanner.nextLine());
			System.out.println("Please Enter command:");
		}
	}

	private static void process(String cmd) {
		Query command = null;

		try {
			command = queryFactory.getQuery(cmd);

		} catch (InvalidQueryException e) {
			System.out.println("Wrong query.");
		} catch (InvalidParamsException invalidParams) {
			System.out.println("Query  is not correct: " + invalidParams.getMessage());
			System.out.println("correct syntax: \n" + invalidParams.getInstruction());
		}

		if (command instanceof QuitQuery) {
			quit();
		}

		if (command instanceof CreateQuery) {
			createNewCanvas((CreateQuery) command);
			return;
		}

		if (command instanceof DrawQuery) {
			draw((DrawQuery) command);
		}
	}

	private static void draw(DrawQuery command) {
		if (canvas == null) {
			System.out.println("You need to create a canvas first");
			return;
		}

		canvas.drawEntity(entityFactory.getEntity(command));
		System.out.println(canvas.show());
	}

	private static void createNewCanvas(CreateQuery command) {
		canvas=new CanvasImpl(command.getWidth(),command.getHeight());
		System.out.println(canvas.show());
	}

	private static void quit() {
		System.exit(0);
	}
}
