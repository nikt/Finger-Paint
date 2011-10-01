package nt.finger.paint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener {
	private static final String TAG = "DrawView";
	
	List<Point> points = new ArrayList<Point>();
	Paint paint = new Paint();
	Random gen;
	int col_mode = 0;	// set default colour to white
	
	public DrawView(Context context) {
		super(context);
		setFocusable(true);
		setFocusableInTouchMode(true);
		
		this.setOnTouchListener(this);
		
		paint.setAntiAlias(true);
	}
	
	// used to clear the screen
	public void clearPoints () {
		points.clear();
		// force View to redraw
		// without this, points aren't cleared until next action
		invalidate();
	}
	
	// used to set drawing colour
	public void changeColour (int col_in) {
		col_mode = col_in;
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		// for each point, draw on canvas
		for (Point point : points) {
			switch (point.col) {
				case 0 : {
					paint.setColor(Color.WHITE);
					break;
				}
				case 1 : {
					paint.setColor(Color.BLUE);
					break;
				}
				case 2 : {
					paint.setColor(Color.CYAN);
					break;
				}
				case 3 : {
					paint.setColor(Color.GREEN);
					break;
				}
				case 4 : {
					paint.setColor(Color.MAGENTA);
					break;
				}
				case 5 : {
					paint.setColor(Color.RED);
					break;
				}
				case 6 : {
					paint.setColor(Color.YELLOW);
					break;
				}
				case 7 : {
					paint.setColor(Color.BLACK);
					break;
				}
			}
			
			//paint.setColor(Color.CYAN);		// Color.WHITE
			
			canvas.drawCircle(point.x, point.y, 5, paint);
			// Log.d(TAG, "Painting: "+point;
		}
	}
	
	public boolean onTouch(View view, MotionEvent event) {
		// if(event.getAction() != MotionEvent.ACTION_DOWN)
		// return super.onTouchEvent(event);
		Point point = new Point();
		point.x = event.getX();
		point.y = event.getY();
		if (col_mode >= 0) {
			point.col = col_mode;
		} else {
			gen = new Random();
			point.col = gen.nextInt( 8 );
		}
		points.add(point);
		invalidate();
		Log.d(TAG, "point: " + point);
		return true;
	}
}

class Point {
	float x, y;
	int col;
	
	@Override
	public String toString() {
		return x + ", " + y + ", " + col;
	}
}