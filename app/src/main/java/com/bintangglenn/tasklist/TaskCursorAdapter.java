package com.bintangglenn.tasklist;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.bintangglenn.tasklist.data.TaskContract.TaskEntry;

public class TaskCursorAdapter extends CursorAdapter {
    public TaskCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_subject, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewSubject = (TextView) view.findViewById(R.id.text_view_task);
        TextView textViewDay = (TextView) view.findViewById(R.id.text_view_day);

        int subjectColumnIndex = cursor.getColumnIndex(TaskEntry.COLUMN_ABSENT_TASK);
        int dayColumnIndex = cursor.getColumnIndex(TaskEntry.COLUMN_ABSENT_DAY);

        String subject = cursor.getString(subjectColumnIndex);
        int day = cursor.getInt(dayColumnIndex);
        String dayString;
        switch(day) {
            case TaskEntry.DAY_MONDAY:
                dayString = "Monday";
                break;
            case TaskEntry.DAY_TUESDAY:
                dayString = "Tuesday";
                break;
            case TaskEntry.DAY_WEDNESDAY:
                dayString = "Wednesday";
                break;
            case TaskEntry.DAY_THURSDAY:
                dayString = "Thursday";
                break;
            case TaskEntry.DAY_FRIDAY:
                dayString = "Friday";
                break;
            case TaskEntry.DAY_SATURDAY:
                dayString = "Saturday";
                break;
            default:
                dayString = "-";
        }

        textViewSubject.setText(subject);
        textViewDay.setText(dayString);
    }
}
