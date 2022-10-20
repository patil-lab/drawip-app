package service.canvas;

import entity.BaseEntity;
import entity.ColorFillEntity;
import entity.LineEntity;
import entity.Point;
import entity.RectangleEntity;
import exception.InvalidEntityException;
import exception.InvalidParamsException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CanvasImpl implements Canvas {

	private final int width;

	private final int height;

	private static final char HORIZONTAL_CHAR='-';
	private static final char VERTICAL_CHAR='|';
	private static final char CROSS ='x';

	private final char[][] printEmptyChar;

	private final String printHorizontal;

	private LinkedList<BaseEntity>	entities;


	public CanvasImpl(int w,int h){
		width=w;
		height=h;
		printEmptyChar =new char[this.height][this.width];
		entities=new LinkedList<>();
		Arrays.stream(printEmptyChar).forEach(chars -> Arrays.fill(chars,' '));

		printHorizontal= Stream.generate(()-> String.valueOf(HORIZONTAL_CHAR)).limit(width).collect(Collectors.joining());

	}
	@Override
	public void drawEntity(BaseEntity entity) {
		entities.add(entity);
		if(entity instanceof LineEntity){
			drawLineEntity((LineEntity) entity);
		}else if(entity instanceof RectangleEntity){
			drawRectangleEntity((RectangleEntity) entity);
		}else if(entity instanceof ColorFillEntity){
			fillColorEntity((ColorFillEntity) entity);
		}
	}

	private void fillColorEntity(ColorFillEntity entity) {

		if (isOutOfRange(entity.getX(), entity.getY())) {
			throw new InvalidEntityException("point is out of range");
		}
		fillColor(entity.getX(),entity.getY(),entity.getCh());
	}

	private boolean isOutOfRange(int x, int y) {
		return x<1 || x>= width || y<1 || y>= height;
	}

	private void fillColor(int x, int y, char ch) {
		char prevChar=printEmptyChar[y-1][x-1];
		Stack<Point>	stack=new Stack<>();
		stack.add(new Point(y-1,x-1));
		while (!stack.isEmpty()){
			Point pop=stack.pop();
			if(printEmptyChar[pop.getX()][pop.getY()]==prevChar){
				printEmptyChar[pop.getX()][pop.getY()]=ch;
			}
			//check boundary conditions

			if(pop.getX()-1>=0 &&printEmptyChar[pop.getX()-1][pop.getY()]==prevChar){
				stack.add(new Point(pop.getX()-1,pop.getY()));
			}
			if(pop.getX()+1<height &&printEmptyChar[pop.getX()+1][pop.getY()]==prevChar){
				stack.add(new Point(pop.getX()+1,pop.getY()));
			}
			if(pop.getY()-1>=0 &&printEmptyChar[pop.getX()][pop.getY()-1]==prevChar){
				stack.add(new Point(pop.getX(),pop.getY()-1));
			}
			if(pop.getY()+1<width &&printEmptyChar[pop.getX()][pop.getY()+1]==prevChar){
				stack.add(new Point(pop.getX(),pop.getY()+1));
			}
		}

	}


	private void drawRectangleEntity(RectangleEntity entity) {
		drawRectangle(entity.getX1(),entity.getY1(),entity.getX2(),entity.getY2());
	}

	private void drawRectangle(int x1, int y1, int x2, int y2) {

		drawLine(x1, y1, x2, y1);

		drawLine(x1, y1, x1, y2);

		drawLine(x2, y1, x2, y2);

		drawLine(x1, y2, x2, y2);
	}

	private void drawLineEntity(LineEntity entity) {

		drawLine(entity.getX1(), entity.getY1(), entity.getX2(), entity.getY2());

	}

	private void drawLine(int x1,int y1,int x2,int y2){
		for(int row=y1-1;row<=y2-1 && row<height;row++){
			for(int col=x1-1;col<=x2-1 && col<width;col++){
				printEmptyChar[row][col]=CanvasImpl.CROSS;
			}
		}
	}


	@Override
	public String show() {
		StringBuilder	sb=new StringBuilder();
		sb.append(printHorizontal).append("\n");
		for(int i=0;i<this.height;i++){
			sb.append(VERTICAL_CHAR);
			for (int j=0;j<this.width;j++) {
				sb.append(printEmptyChar[i][j]);

			}
			sb.append(VERTICAL_CHAR);
			sb.append("\n");
		}
		sb.append(printHorizontal);
		return sb.toString();
	}
}
