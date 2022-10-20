package entity;

import helper.CheckNumbersHelper;
import lombok.Getter;

public class LineEntity implements BaseEntity {

	@Getter
	private int x1;
	@Getter
	private int y1;
	@Getter
	private int x2;
	@Getter
	private int y2;

	public LineEntity(int x1, int y1, int x2, int y2) {
		if (x1 != x2 && y1 != y2) {
			throw new IllegalArgumentException("Draw line does not support diagonal line at the moment");
		}
		System.out.println("draw Line");
		CheckNumbersHelper.isPositive(x1,y1,x2,y2);

		if ((this.x1 == this.x2 && this.y1 > this.y2) || (this.y1 == this.y2 && this.x1 > this.x2)) {
			this.x1 = x2;
			this.y1 = y2;
			this.x2 = x1;
			this.y2 = y1;
		} else {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

}
