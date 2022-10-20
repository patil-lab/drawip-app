package entity;

import helper.CheckNumbersHelper;
import lombok.Getter;

public class ColorFillEntity	implements BaseEntity {
	@Getter
	private int  x;
	@Getter
	private int  y;
	@Getter
	private char ch;

	public ColorFillEntity(int x1, int y1, char ch) {
		CheckNumbersHelper.isPositive(x1,y1,ch);
		this.x = x1;
		this.y = y1;
		this.ch = ch;
	}

}
