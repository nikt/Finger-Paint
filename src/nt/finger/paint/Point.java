package nt.finger.paint;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Point {
	public final float x, y;
	public final int col;
	
	public Point(final float x, final float y, final int col) {
		this.x = x;
		this.y = y;
		this.col = col;
	}
	
	public void draw(final Canvas canvas, final Paint paint) {
		paint.setColor(col);
		canvas.drawCircle(x, y, 5, paint);
	}
	
	@Override
	public String toString() {
		return x + ", " + y + ", " + col;
	}
}
