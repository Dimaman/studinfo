package com.scg.studinfo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0012\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0019H\u0014J\u0017\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0016\u00a2\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010\'\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/scg/studinfo/activities/AddActivActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/scg/studinfo/views/CalendarDialog$ListenerCalendar;", "()V", "dominColor", "", "getDominatorColor", "Lcom/scg/studinfo/utils/GetDominatorColor;", "kolvoUnity", "mCamera", "Lcom/scg/studinfo/utils/CameraHelper;", "mFirebase", "Lcom/scg/studinfo/utils/FireBaseHelper;", "mUri", "Landroid/net/Uri;", "setUinty", "", "checkTexts", "", "feedPost", "Lcom/scg/studinfo/models/FeedPost;", "uid", "url", "img", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onTimeConfim", "selDate", "", "(Ljava/lang/Long;)V", "selectUnity", "share", "app_release"})
public final class AddActivActivity extends androidx.appcompat.app.AppCompatActivity implements com.scg.studinfo.views.CalendarDialog.ListenerCalendar {
    private com.scg.studinfo.utils.FireBaseHelper mFirebase;
    private com.scg.studinfo.utils.CameraHelper mCamera;
    private android.net.Uri mUri;
    private com.scg.studinfo.utils.GetDominatorColor getDominatorColor;
    private int dominColor;
    private java.lang.String setUinty;
    private int kolvoUnity;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void selectUnity() {
    }
    
    private final void share() {
    }
    
    private final boolean checkTexts() {
        return false;
    }
    
    private final com.scg.studinfo.models.FeedPost feedPost(java.lang.String uid, java.lang.String url, java.lang.String img) {
        return null;
    }
    
    @java.lang.Override()
    public void onTimeConfim(@org.jetbrains.annotations.Nullable()
    java.lang.Long selDate) {
    }
    
    public AddActivActivity() {
        super();
    }
}