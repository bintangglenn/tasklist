package com.bintangglenn.tasklist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.bintangglenn.tasklist.data.TaskContract.TaskEntry;
import com.bintangglenn.tasklist.data.TaskDBHelper;

public class MainActivity extends AppCompatActivity {
    TaskDBHelper taskDBHelper;
    ListView listViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listViewMain = (ListView) findViewById(R.id.list_view_main);
        taskDBHelper = new TaskDBHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayData();
    }

    private void displayData() {
        SQLiteDatabase db = taskDBHelper.getReadableDatabase();
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor cursor = db.query(TaskEntry.TABLE_NAME, columns, selection, selectionArgs, groupBy, having, orderBy);
        TaskCursorAdapter taskCursorAdapter = new TaskCursorAdapter(this, cursor);
        listViewMain.setAdapter(taskCursorAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        } else if(id == R.id.action_clear){
            clearEntries();
        }

        return super.onOptionsItemSelected(item);
    }

    private void clearEntries() {
        SQLiteDatabase db = taskDBHelper.getWritableDatabase();
        db.delete(TaskEntry.TABLE_NAME, null, null);
        displayData();
    }

    @Override
    protected void onDestroy() {
        taskDBHelper.close();
        super.onDestroy();
    }
}
