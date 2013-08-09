package ch.expectusafterlun.androidtutorial;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String activities[] = { "Count", "TextPlay", "Email", "Camera", "Data",
			"FullScreen", "GFX" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_expandable_list_item_1, activities));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String activity = activities[position];
		try {
			Class<?> myClass = Class
					.forName("ch.expectusafterlun.androidtutorial." + activity);
			/* Different way to start an activity using a class variable */
			Intent myIntent = new Intent(Menu.this, myClass);
			startActivity(myIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// return super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.mi_about_us:
			Intent i = new Intent("ch.expectusafterlun.androidtutorial.ABOUT");
			startActivity(i);
			break;
		case R.id.mi_preferences:
			Intent p = new Intent("ch.expectusafterlun.androidtutorial.PREFS");
			startActivity(p);
			break;
		case R.id.mi_exit:
			finish();
			break;
		}
		return false;
	}
}