package com.scg.studinfo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/scg/studinfo/activities/EditInfoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/scg/studinfo/views/PasswordDialog$Listener;", "()V", "APP_PREFERENCES", "", "cameraHelper", "Lcom/scg/studinfo/utils/CameraHelper;", "mFirebaseHelper", "Lcom/scg/studinfo/utils/FireBaseHelper;", "mPendingEmail", "Lcom/scg/studinfo/models/User;", "mUser", "pref", "Landroid/content/SharedPreferences;", "getSavedInter", "", "goOut", "interSel", "btn", "Landroid/widget/ImageButton;", "ind", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPassConfim", "pass", "updateUser", "user", "validate", "app_release"})
public final class EditInfoActivity extends androidx.appcompat.app.AppCompatActivity implements com.scg.studinfo.views.PasswordDialog.Listener {
    private com.scg.studinfo.models.User mUser;
    private com.scg.studinfo.models.User mPendingEmail;
    private com.scg.studinfo.utils.FireBaseHelper mFirebaseHelper;
    private com.scg.studinfo.utils.CameraHelper cameraHelper;
    private android.content.SharedPreferences pref;
    private final java.lang.String APP_PREFERENCES = "mysettings";
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void interSel(android.widget.ImageButton btn, int ind) {
    }
    
    public final void getSavedInter() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void goOut() {
    }
    
    private final void updateUser(com.scg.studinfo.models.User user) {
    }
    
    private final java.lang.String validate(com.scg.studinfo.models.User user) {
        return null;
    }
    
    @java.lang.Override()
    public void onPassConfim(@org.jetbrains.annotations.NotNull()
    java.lang.String pass) {
    }
    
    public EditInfoActivity() {
        super();
    }
}