package entity;

import helper.CheckNumbersHelper;
import lombok.Getter;

public class Point {

	@Getter
	private int x;
	@Getter
	private int y;

	public Point(int x,int y){
		CheckNumbersHelper.isNegative(x,y);
		this.x=x;
		this.y=y;

	}
}
