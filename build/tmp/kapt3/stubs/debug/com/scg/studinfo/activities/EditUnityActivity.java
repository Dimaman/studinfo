package com.scg.studinfo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\"\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\fH\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fJ\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e2\u0006\u0010 \u001a\u00020\u001bJ\u0014\u0010!\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/scg/studinfo/activities/EditUnityActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mCamera", "Lcom/scg/studinfo/utils/CameraHelper;", "mFirebase", "Lcom/scg/studinfo/utils/FireBaseHelper;", "mUri", "Landroid/net/Uri;", "newPicture", "", "editUnity", "", "ifDeletedUsers", "", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setUnity", "Lcom/scg/studinfo/models/Unity;", "url", "updateInfo", "", "", "unity", "uploadUnityToUser", "onSuccess", "Lkotlin/Function0;", "app_debug"})
public final class EditUnityActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.scg.studinfo.utils.FireBaseHelper mFirebase;
    private com.scg.studinfo.utils.CameraHelper mCamera;
    private android.net.Uri mUri;
    private boolean newPicture;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> updateInfo(@org.jetbrains.annotations.NotNull()
    com.scg.studinfo.models.Unity unity) {
        return null;
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    public final void editUnity() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> ifDeletedUsers() {
        return null;
    }
    
    public final void uploadUnityToUser(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scg.studinfo.models.Unity setUnity(@org.jetbrains.annotations.Nullable()
    java.lang.String url) {
        return null;
    }
    
    public EditUnityActivity() {
        super();
    }
}