package com.example.mrbennerham.calendar;

import android.os.AsyncTask;
import android.view.View;

import com.google.api.client.googleapis.extensions.android.gms.auth.GooglePlayServicesAvailabilityIOException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.firebase.messaging.RemoteMessage;

import java.io.IOException;

/**
 * Created by MR.BENNERHAM on 10/30/2016.
 */
public abstract class  CalendarAsyncTask_Notifications extends AsyncTask<Void, Void, Boolean> {

    final Main_Notifications calendarSample;
    final com.google.api.services.calendar.Calendar client;


    public CalendarAsyncTask_Notifications(Main_Notifications calendarSample) {
        this.calendarSample = calendarSample;
        client = calendarSample.client;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        calendarSample.numAsyncTasks++;
    }
    @Override
    protected final Boolean doInBackground(Void... ignored) {
        try {
            doInBackground();
            return true;
        }
        catch (IOException e) {
            Utils.logAndShow(calendarSample, MainActivity.TAG, e);
        }
        return false;
    }
    abstract protected void doInBackground() throws IOException;
}

