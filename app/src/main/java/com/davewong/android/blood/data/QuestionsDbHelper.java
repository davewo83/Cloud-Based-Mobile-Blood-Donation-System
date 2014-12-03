package com.davewong.android.blood.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.davewong.android.blood.data.QuestionsContract.DetailsEntry;
import com.davewong.android.blood.data.QuestionsContract.QuestionsEntry;



/**
 * Created by dcwou_000 on 28/10/2014.
 */
public class QuestionsDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "questions.db";

    public QuestionsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_DETAILS_TABLE = "CREATE TABLE " + DetailsEntry.TABLE_NAME + " (" +
                DetailsEntry._ID + " INTEGER PRIMARY KEY," +
                DetailsEntry.COLUMN_DON_KEY + " TEXT NOT NULL, " +
                DetailsEntry.COLUMN_DATETEXT + " TEXT NOT NULL, " +
                DetailsEntry.COLUMN_FN + " TEXT NOT NULL, " +
                DetailsEntry.COLUMN_SN + " TEXT NOT NULL); ";

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " + QuestionsEntry.TABLE_NAME + " (" +
                // Why AutoIncrement here, and not above?
                // Unique keys will be auto-generated in either case.  But for weather
                // forecasting, it's reasonable to assume the user will want information
                // for a certain date and all dates *following*, so the forecast data
                // should be sorted accordingly.
                QuestionsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +

                // the ID of the location entry associated with this weather data
                QuestionsEntry.COLUMN_DON_KEY + " TEXT NOT NULL, " +
                QuestionsEntry.COLUMN_DATETEXT + " TEXT NOT NULL, " +
                QuestionsEntry.COLUMN_Q1 + " INTEGER NOT NULL, " +
                QuestionsEntry.COLUMN_Q2 + " INTEGER NOT NULL, " +
                QuestionsEntry.COLUMN_Q3 + " INTEGER NOT NULL, " +
                QuestionsEntry.COLUMN_Q4 + " INTEGER NOT NULL, " +
                QuestionsEntry.COLUMN_Q5 + " INTEGER NOT NULL, " +


                // Set up the location column as a foreign key to location table.
                " FOREIGN KEY (" + QuestionsEntry.COLUMN_DON_KEY + ") REFERENCES " +
                DetailsEntry.TABLE_NAME + " (" + DetailsEntry._ID + "), " +

                // To assure the application have just one weather entry per day
                // per location, it's created a UNIQUE constraint with REPLACE strategy
                " UNIQUE (" + QuestionsEntry.COLUMN_DATETEXT + ", " +
                QuestionsEntry.COLUMN_DON_KEY + ") ON CONFLICT REPLACE);";

        sqLiteDatabase.execSQL(SQL_CREATE_DETAILS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_QUESTIONS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        // ALTER TABLE may be required instead
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DetailsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + QuestionsEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
