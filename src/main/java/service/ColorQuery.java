package service;

import exception.InvalidParamsException;
import helper.CheckNumbersHelper;
import lombok.Getter;

public class ColorQuery	implements	DrawQuery {

	@Getter
	private int x;
	@Getter
	private int y;
	@Getter
	private char	character;


	private static final String	instruction="B x y c         Should fill the entire area connected to (x,y) with \"colour\" c. The\n" +
			"\n" +
			"                behaviour of this is the same as that of the \"bucket fill\" tool in paint\n" +
			"\n" +
			"                programs.";

	public ColorQuery(String... params){
		if(params.length<3){
			throw new InvalidParamsException(CheckNumbersHelper.colorMsg,instruction);
		}

		try {
			x=CheckNumbersHelper.positiveNumber(params[0]);
			System.out.println(x);
			y=CheckNumbersHelper.positiveNumber(params[1]);
			System.out.println(y);
			character=params[2].charAt(0);
			System.out.println(character);

		}catch (IllegalArgumentException	e){
			throw new InvalidParamsException(CheckNumbersHelper.positiveNumber,instruction);
		}

	}
}
