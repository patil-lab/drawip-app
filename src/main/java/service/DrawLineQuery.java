package service;

import exception.InvalidParamsException;
import helper.CheckNumbersHelper;
import lombok.Getter;

public class DrawLineQuery	implements DrawQuery {

	@Getter
	private int x1;
	@Getter
	private int y1;
	@Getter
	private int x2;
	@Getter
	private int y2;

	private static final String instruction="L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only\n" +
			"\n" +
			"                horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
			"\n" +
			"                will be drawn using the 'x' character.";

	public DrawLineQuery(String... params){

		if(params.length<4){
			throw new InvalidParamsException(CheckNumbersHelper.lineMsg,instruction);
		}
		try{
			System.out.println("Hi");
			x1= CheckNumbersHelper.positiveNumber(params[0]);
			y1=CheckNumbersHelper.positiveNumber(params[1]);
			x2=CheckNumbersHelper.positiveNumber(params[2]);
			y2=CheckNumbersHelper.positiveNumber(params[3]);

		}catch (IllegalArgumentException	e){
			throw new InvalidParamsException(CheckNumbersHelper.positiveNumber,instruction);
		}

	}
}
