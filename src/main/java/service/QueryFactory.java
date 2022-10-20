package service;

import exception.InvalidParamsException;
import exception.InvalidQueryException;

import java.util.Arrays;

public class QueryFactory {

	public	Query	getQuery(String	cmd) throws InvalidQueryException, InvalidParamsException {
		cmd = cmd.trim().replaceAll(" {2}", " ");
		String SPACE = " ";
		String[]	split=cmd.split(SPACE);
		String	newCmd=split[0].toUpperCase();
		String[]	params= Arrays.copyOfRange(split,1,split.length);
		switch (newCmd){
			case "C":
				return new	CreateQuery(params);
			case "R":
				return new DrawRectangleQuery(params);
			case "L":
				return new DrawLineQuery(params);
			case "B":
				System.out.println("B");
				return new ColorQuery(params);
			case "Q":
				return new QuitQuery();
				default:
				throw new InvalidQueryException();
		}
	}
}
