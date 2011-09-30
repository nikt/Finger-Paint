package nt.finger.paint;

import android.app.Activity;
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
        
        drawView = new DrawView(this);
        setContentView(drawView);
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
    	case R.id.change_colour_id : {
    		return true;
    	}
    	case R.id.white_id : {
    		drawView.changeColour(0);
    		return true;
    	}
    	case R.id.blue_id : {
    		drawView.changeColour(1);
    		return true;
    	}
    	case R.id.cyan_id : {
    		drawView.changeColour(2);
    		return true;
    	}
    	case R.id.green_id : {
    		drawView.changeColour(3);
    		return true;
    	}
    	case R.id.magenta_id : {
    		drawView.changeColour(4);
    		return true;
    	}
    	case R.id.red_id : {
    		drawView.changeColour(5);
    		return true;
    	}
    	case R.id.yellow_id : {
    		drawView.changeColour(6);
    		return true;
    	}
    	case R.id.random_id : {
    		drawView.changeColour(-1);
    		return true;
    	}
    	default : return true;
    	}
    }
}