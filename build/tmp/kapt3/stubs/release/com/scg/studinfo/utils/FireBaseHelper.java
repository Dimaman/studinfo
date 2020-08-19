package com.scg.studinfo.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J\u001c\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\nJ\u001c\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!J$\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u001b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00120$J\u000e\u0010&\u001a\u00020\'2\u0006\u0010 \u001a\u00020!J\u0006\u0010(\u001a\u00020\u0012J\u001c\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J\u001c\u0010,\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J2\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u001b2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J2\u00101\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u001b2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J*\u00102\u001a\u00020\u00122\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J\u001c\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J0\u00105\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u001b2\u0006\u00106\u001a\u00020%2\u0016\u0010\u0015\u001a\u0012\u0012\b\u0012\u000607R\u000208\u0012\u0004\u0012\u00020\u00120$J/\u00109\u001a\u00020\u00122\'\u0010\u0015\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00190:\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00120$J1\u00109\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u001b2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00120$J&\u0010>\u001a\u00020\u00122\u0006\u00106\u001a\u00020%2\u0016\u0010\u0015\u001a\u0012\u0012\b\u0012\u000607R\u000208\u0012\u0004\u0012\u00020\u00120$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006?"}, d2 = {"Lcom/scg/studinfo/utils/FireBaseHelper;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "database", "Lcom/google/firebase/database/DatabaseReference;", "getDatabase", "()Lcom/google/firebase/database/DatabaseReference;", "storage", "Lcom/google/firebase/storage/StorageReference;", "getStorage", "()Lcom/google/firebase/storage/StorageReference;", "addPostToDatabase", "", "feedPost", "Lcom/scg/studinfo/models/FeedPost;", "onSuccess", "Lkotlin/Function0;", "addUnity", "unity", "Lcom/scg/studinfo/models/Unity;", "chUid", "", "currentUserReference", "fetchSignInMethodsForEmail", "email", "getUnity", "it", "Lcom/google/firebase/database/DataSnapshot;", "getUrl", "uid", "Lkotlin/Function1;", "Landroid/net/Uri;", "getUser", "Lcom/scg/studinfo/models/User;", "openApp", "reauthenticate", "credential", "Lcom/google/firebase/auth/AuthCredential;", "updateEmail", "updateInfo", "chld", "updates", "", "updateUnity", "updateUser", "updateUserPhoto", "photoUrl", "uploadPostPhoto", "photo", "Lcom/google/firebase/storage/UploadTask$TaskSnapshot;", "Lcom/google/firebase/storage/UploadTask;", "uploadUnity", "", "Lkotlin/ParameterName;", "name", "id", "uploadUserPhoto", "app_release"})
public final class FireBaseHelper {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.storage.StorageReference storage = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.DatabaseReference database = null;
    private final android.app.Activity activity = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getAuth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.StorageReference getStorage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference getDatabase() {
        return null;
    }
    
    public final void openApp() {
    }
    
    public final void updateUserPhoto(@org.jetbrains.annotations.NotNull()
    java.lang.String photoUrl, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void uploadPostPhoto(@org.jetbrains.annotations.Nullable()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    android.net.Uri photo, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.google.firebase.storage.UploadTask.TaskSnapshot, kotlin.Unit> onSuccess) {
    }
    
    public final void uploadUnity(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.scg.studinfo.models.Unity>, kotlin.Unit> onSuccess) {
    }
    
    public final void uploadUnity(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.scg.studinfo.models.Unity, kotlin.Unit> onSuccess) {
    }
    
    public final void addUnity(@org.jetbrains.annotations.NotNull()
    com.scg.studinfo.models.Unity unity, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void updateUnity(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> updates, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void updateUser(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> updates, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void updateInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String chld, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> updates, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String chUid() {
        return null;
    }
    
    public final void fetchSignInMethodsForEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void updateEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void reauthenticate(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.AuthCredential credential, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void getUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.net.Uri, kotlin.Unit> onSuccess) {
    }
    
    public final void uploadUserPhoto(@org.jetbrains.annotations.NotNull()
    android.net.Uri photo, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.google.firebase.storage.UploadTask.TaskSnapshot, kotlin.Unit> onSuccess) {
    }
    
    public final void addPostToDatabase(@org.jetbrains.annotations.NotNull()
    com.scg.studinfo.models.FeedPost feedPost, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference currentUserReference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scg.studinfo.models.User getUser(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DataSnapshot it) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scg.studinfo.models.Unity getUnity(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DataSnapshot it) {
        return null;
    }
    
    public FireBaseHelper(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
}