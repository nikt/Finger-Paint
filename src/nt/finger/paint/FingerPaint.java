package nt.finger.paint;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class FingerPaint extends Activity {
	DrawView drawView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set full screen view
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // lock screen orientation (stops screen clearing when rotating phone)
        setRequestedOrientation(getResources().getConfiguration().orientation);
        
        drawView = new DrawView(this);
        setContentView(drawView);
        drawView.setBackgroundColor(Color.BLACK);
        drawView.requestFocus();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.paint_menu, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// Handle item selection
    	switch (item.getItemId()) {
    	case R.id.clear_id : {
    		drawView.clearPoints();
    		return true;
    	}
    	case R.id.p_white_id : {
    		drawView.changeColour(0);
    		return true;
    	}
    	case R.id.p_blue_id : {
    		drawView.changeColour(1);
    		return true;
    	}
    	case R.id.p_lblue_id : {
    		drawView.changeColour(2);
    		return true;
    	}
    	case R.id.p_green_id : {
    		drawView.changeColour(3);
    		return true;
    	}
    	case R.id.p_pink_id : {
    		drawView.changeColour(4);
    		return true;
    	}
    	case R.id.p_red_id : {
    		drawView.changeColour(5);
    		return true;
    	}
    	case R.id.p_yellow_id : {
    		drawView.changeColour(6);
    		return true;
    	}
    	case R.id.p_black_id : {
    		drawView.changeColour(7);
    		return true;
    	}
    	case R.id.p_random_id : {
    		drawView.changeColour(-1);
    		return true;
    	}
    	case R.id.b_white_id : {
    		drawView.setBackgroundColor(Color.WHITE);
    		return true;
    	}
    	case R.id.b_blue_id : {
    		drawView.setBackgroundColor(Color.BLUE);
    		return true;
    	}
    	case R.id.b_lblue_id : {
    		drawView.setBackgroundColor(Color.CYAN);
    		return true;
    	}
    	case R.id.b_green_id : {
    		drawView.setBackgroundColor(Color.GREEN);
    		return true;
    	}
    	case R.id.b_pink_id : {
    		drawView.setBackgroundColor(Color.MAGENTA);
    		return true;
    	}
    	case R.id.b_red_id : {
    		drawView.setBackgroundColor(Color.RED);
    		return true;
    	}
    	case R.id.b_yellow_id : {
    		drawView.setBackgroundColor(Color.YELLOW);
    		return true;
    	}
    	case R.id.b_black_id : {
    		drawView.setBackgroundColor(Color.BLACK);
    		return true;
    	}
    	default : {
    		return true;
    	}
    	}
    }
}