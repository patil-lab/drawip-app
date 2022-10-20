package service;

import exception.InvalidParamsException;
import helper.CheckNumbersHelper;
import lombok.Getter;


public class CreateQuery	implements Query {
	private static String	instruction="C w h           Should create a new canvas of width w and height h.";

	@Getter
	private int height;
	@Getter
	private int width;


	public CreateQuery(String... params){
		if(params.length<2)
		{
			throw new InvalidParamsException(CheckNumbersHelper.canvasMsg,instruction);
		}
		try {
			width = CheckNumbersHelper.positiveNumber(params[0]);
			height = CheckNumbersHelper.positiveNumber(params[1]);
		}catch (IllegalArgumentException	e){
			throw new InvalidParamsException(CheckNumbersHelper.positiveNumber,instruction);
		}
	}
}
