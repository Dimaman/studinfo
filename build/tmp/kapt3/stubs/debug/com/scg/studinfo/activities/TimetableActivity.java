package com.scg.studinfo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0015J\b\u0010\u0013\u001a\u00020\fH\u0014J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/scg/studinfo/activities/TimetableActivity;", "Lcom/scg/studinfo/activities/BaseActivity;", "()V", "CHANNEL_ID", "", "NOTIFY_ID", "", "mFirebase", "Lcom/scg/studinfo/utils/FireBaseHelper;", "timeNow", "", "buildNotification", "", "checkAuth", "checkVersion", "createNotificationChannel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "weekDay", "time", "app_debug"})
public final class TimetableActivity extends com.scg.studinfo.activities.BaseActivity {
    private com.scg.studinfo.utils.FireBaseHelper mFirebase;
    private final int NOTIFY_ID = 101;
    private final java.lang.String CHANNEL_ID = "channel";
    private final long timeNow = 0L;
    private java.util.HashMap _$_findViewCache;
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void buildNotification() {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    private final void checkAuth() {
    }
    
    private final void createNotificationChannel() {
    }
    
    private final java.lang.String weekDay(long time) {
        return null;
    }
    
    private final void checkVersion() {
    }
    
    public TimetableActivity() {
        super(0);
    }
}