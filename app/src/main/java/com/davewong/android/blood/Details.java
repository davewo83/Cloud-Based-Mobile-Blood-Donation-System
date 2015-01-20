package com.davewong.android.blood;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.davewong.android.blood.data.QuestionsContract;
import com.davewong.android.blood.data.QuestionsDbHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Details extends Activity {

    public static Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c = this.getApplicationContext();
        setContentView(R.layout.activity_details);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void OnNextClick (View view) {
        QuestionsDbHelper mDbHelper = new QuestionsDbHelper(getApplicationContext());
        // Gets the data repository in write mod
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(QuestionsContract.DetailsEntry.COLUMN_DON_KEY, "1");

        Calendar c = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c.getTime());

        values.put(QuestionsContract.DetailsEntry.COLUMN_DATETEXT, formattedDate);
        String fname = ((EditText)findViewById(R.id.editText)).getText().toString();
        values.put(QuestionsContract.DetailsEntry.COLUMN_FN, fname);
        values.put(QuestionsContract.DetailsEntry.COLUMN_SN, "Y");
        values.put(QuestionsContract.DetailsEntry.COLUMN_HN, "Y");
        values.put(QuestionsContract.DetailsEntry.COLUMN_PC, "Y");
        values.put(QuestionsContract.DetailsEntry.COLUMN_EM, "Y");
        values.put(QuestionsContract.DetailsEntry.COLUMN_PN, "Y");
        values.put(QuestionsContract.DetailsEntry.COLUMN_DB, "Y");
        values.put(QuestionsContract.DetailsEntry.COLUMN_SX, "Y");

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                QuestionsContract.DetailsEntry.TABLE_NAME,
                null,
                values);
        Intent nextScreen = new Intent(getApplicationContext(), Questions.class);
        startActivity(nextScreen);
    }

    private void tToast(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_details, container, false);
            return rootView;
        }
    }
}
