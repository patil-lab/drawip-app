package entity;

import service.ColorQuery;
import service.DrawLineQuery;
import service.DrawQuery;
import service.DrawRectangleQuery;

public class EntityFactory {

	public BaseEntity getEntity(DrawQuery command) {
		if (command instanceof DrawLineQuery) {
			DrawLineQuery cmd = (DrawLineQuery) command;
			return new LineEntity(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
		} else if (command instanceof DrawRectangleQuery) {
			DrawRectangleQuery cmd = (DrawRectangleQuery) command;
			return new RectangleEntity(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
		} else if (command instanceof ColorQuery) {
			ColorQuery cmd = (ColorQuery) command;
			return new ColorFillEntity(cmd.getX(), cmd.getY(), cmd.getCharacter());
		}
		return null;
	}
}
