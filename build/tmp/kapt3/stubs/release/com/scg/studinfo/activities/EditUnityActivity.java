package com.scg.studinfo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\"\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0010H\u0014J\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010\u0013J\u001c\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010#0\"2\u0006\u0010$\u001a\u00020\u001eJ\u0014\u0010%\u001a\u00020\u00102\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/scg/studinfo/activities/EditUnityActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "CODE_IMG", "", "CODE_LOGO", "mCamera", "Lcom/scg/studinfo/utils/CameraHelper;", "mFirebase", "Lcom/scg/studinfo/utils/FireBaseHelper;", "mUri", "Landroid/net/Uri;", "mUriImg", "newPicture", "", "editUnity", "", "ifDeletedUsers", "", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setUnity", "Lcom/scg/studinfo/models/Unity;", "url", "url2", "updateInfo", "", "", "unity", "uploadUnityToUser", "onSuccess", "Lkotlin/Function0;", "app_release"})
public final class EditUnityActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.scg.studinfo.utils.FireBaseHelper mFirebase;
    private com.scg.studinfo.utils.CameraHelper mCamera;
    private android.net.Uri mUri;
    private android.net.Uri mUriImg;
    private boolean newPicture;
    private final int CODE_LOGO = 12;
    private final int CODE_IMG = 13;
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
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String url2) {
        return null;
    }
    
    public EditUnityActivity() {
        super();
    }
}