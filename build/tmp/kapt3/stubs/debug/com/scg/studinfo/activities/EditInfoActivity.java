package com.scg.studinfo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/scg/studinfo/activities/EditInfoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/scg/studinfo/views/PasswordDialog$Listener;", "()V", "APP_PREFERENCES", "", "mFirebaseHelper", "Lcom/scg/studinfo/utils/FireBaseHelper;", "mPendingEmail", "Lcom/scg/studinfo/models/User;", "mUser", "pref", "Landroid/content/SharedPreferences;", "prefPers", "getSavedInter", "", "goOut", "interSel", "btn", "Landroid/widget/ImageButton;", "ind", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPassConfim", "pass", "updateUser", "user", "validate", "app_debug"})
public final class EditInfoActivity extends androidx.appcompat.app.AppCompatActivity implements com.scg.studinfo.views.PasswordDialog.Listener {
    private com.scg.studinfo.models.User mUser;
    private com.scg.studinfo.models.User mPendingEmail;
    private com.scg.studinfo.utils.FireBaseHelper mFirebaseHelper;
    private android.content.SharedPreferences pref;
    private android.content.SharedPreferences prefPers;
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