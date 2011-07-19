package pl.edu.uj.tcs.mib.colortone;

import android.graphics.Color;
import android.util.Log;

public class SimpleEstimator implements ValueEstimator{

	@Override
	public int getAverageColor(int[] data, int width, int height) {
		if ( data == null || data.length == 0 ) {
			Log.w(CTMain.TAG, "SimpleEstimator: no data provided");
			return Color.MAGENTA;
		}
		return data[ data.length / 2 ];
	}

}
