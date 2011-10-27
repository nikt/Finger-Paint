package nt.finger.paint;

import java.io.File;
import java.io.FilenameFilter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class FileChooser extends Activity {
	private static final String TAG = "FileChooser";
	private String[] mFileList;
	private File mPath = new File(Environment.getExternalStorageDirectory() + "//yourdir//");
	private String mChosenFile;
	private static final String JPG = ".jpg";
	private static final String JPEG = ".jpeg";
	private static final String PNG = ".png";
	private static final int DIALOG_LOAD_FILE = 1000;

	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        // Set full screen view
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        loadFileList();
	}
	
	private void loadFileList() {
		try {
			mPath.mkdirs();
		}
		catch(SecurityException e) {
			Log.e(TAG, "unable to write on the SD card " + e.toString());
		}
		
		if (mPath.exists()) {
			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File dir, String filename) {
					File sel = new File(dir, filename);
					return filename.contains(JPG) || filename.contains(JPEG) || filename.contains(PNG) || sel.isDirectory();
				}
			};
			mFileList = mPath.list(filter);
		} else {
			mFileList = new String[0];
		}
	}
	
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = null;
		AlertDialog.Builder builder = new Builder(this);
		
		switch (id) {
		case DIALOG_LOAD_FILE :
			builder.setTitle("Choose your background");
			if (mFileList == null) {
				Log.e(TAG, "Showing file chooser before loading the file list");
				dialog = builder.create();
				return dialog;
			}
			builder.setItems(mFileList, new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int which){
					mChosenFile = mFileList[which];
					// do other shit with file
				}
			});
			break;
		}
		dialog = builder.show();
		return dialog;
	}
}
