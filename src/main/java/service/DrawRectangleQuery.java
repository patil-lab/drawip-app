package service;

import exception.InvalidParamsException;
import helper.CheckNumbersHelper;
import lombok.Getter;

public class DrawRectangleQuery 	implements DrawQuery{

	@Getter
	private int x1;
	@Getter
	private int y1;
	@Getter
	private int x2;
	@Getter
	private int y2;


	private static final String	instruction="R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n" +
			"\n" +
			"                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" +
			"\n" +
			"                using the 'x' character.";

	public DrawRectangleQuery(String... params){
		if(params.length<4){
			throw new InvalidParamsException(CheckNumbersHelper.rectangleMsg,instruction);
		}
		try{
			x1=CheckNumbersHelper.positiveNumber(params[0]);
			y1=CheckNumbersHelper.positiveNumber(params[1]);
			x2=CheckNumbersHelper.positiveNumber(params[2]);
			y2=CheckNumbersHelper.positiveNumber(params[3]);
		}catch (IllegalArgumentException	e){
			throw new InvalidParamsException(CheckNumbersHelper.positiveNumber,instruction);
		}

	}
}
