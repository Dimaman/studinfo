package com.scg.studinfo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/scg/studinfo/activities/RegisterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/scg/studinfo/activities/EmailFragment$Listener;", "Lcom/scg/studinfo/activities/PassFragment$Listener;", "()V", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mDB", "Lcom/google/firebase/database/DatabaseReference;", "mEmail", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNext", "email", "onReg", "pass", "pass2", "app_release"})
public final class RegisterActivity extends androidx.appcompat.app.AppCompatActivity implements com.scg.studinfo.activities.EmailFragment.Listener, com.scg.studinfo.activities.PassFragment.Listener {
    private java.lang.String mEmail;
    private com.google.firebase.auth.FirebaseAuth mAuth;
    private com.google.firebase.database.DatabaseReference mDB;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onNext(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    @java.lang.Override()
    public void onReg(@org.jetbrains.annotations.NotNull()
    java.lang.String pass, @org.jetbrains.annotations.NotNull()
    java.lang.String pass2) {
    }
    
    public RegisterActivity() {
        super();
    }
}