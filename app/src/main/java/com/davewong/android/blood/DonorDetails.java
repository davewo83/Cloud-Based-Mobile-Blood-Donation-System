package com.davewong.android.blood;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.davewong.android.blood.data.QuestionsContract;
import com.davewong.android.blood.data.QuestionsDbHelper;

public class DonorDetails extends Activity {

    public static Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c = this.getApplicationContext();
        setContentView(R.layout.activity_donor_details);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    public void GetDonDets (View view) {
        QuestionsDbHelper mDbHelper = new QuestionsDbHelper(getApplicationContext());
        // Gets the data repository in write mod
        SQLiteDatabase db = mDbHelper.getReadableDatabase();


        // Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                QuestionsContract.DetailsEntry._ID,
                QuestionsContract.DetailsEntry.COLUMN_DON_KEY,
                QuestionsContract.DetailsEntry.COLUMN_DATETEXT,
                QuestionsContract.DetailsEntry.COLUMN_FN,
                QuestionsContract.DetailsEntry.COLUMN_SN,
                QuestionsContract.DetailsEntry.COLUMN_HN,
                QuestionsContract.DetailsEntry.COLUMN_PC,
                QuestionsContract.DetailsEntry.COLUMN_EM,
                QuestionsContract.DetailsEntry.COLUMN_PN,
                QuestionsContract.DetailsEntry.COLUMN_DB,
                QuestionsContract.DetailsEntry.COLUMN_SX
        };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                QuestionsContract.DetailsEntry.COLUMN_DON_KEY + " DESC";

        Cursor c = db.query(
                QuestionsContract.DetailsEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        c.moveToFirst();
        long itemId = c.getLong(
                c.getColumnIndexOrThrow(QuestionsContract.DetailsEntry._ID)
        );
        tToast(Long.toString(itemId));
        tToast(c.getString(2));




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
        getMenuInflater().inflate(R.menu.menu_donor_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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
            View rootView = inflater.inflate(R.layout.fragment_donor_details, container, false);
            return rootView;
        }
    }
}
