package pl.edu.uj.tcs.mib.colortone;

import java.util.List;
import pl.edu.uj.tcs.mib.colortone.R;
import android.hardware.Camera;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;

public class Preferences extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);

		ListPreference lp = (ListPreference) this
				.findPreference("white_balance");

		try {
			Camera mCamera = Camera.open();

			Camera.Parameters params = mCamera.getParameters();
			List<String> modes = params.getSupportedWhiteBalance();

			lp.setEntries(modes.toArray(new CharSequence[0]));
			lp.setEntryValues(modes.toArray(new CharSequence[0]));

			lp.setEnabled(true);
			mCamera.release();
		} catch (Exception e) {
			lp.setEnabled(false);
		}
	}
}
