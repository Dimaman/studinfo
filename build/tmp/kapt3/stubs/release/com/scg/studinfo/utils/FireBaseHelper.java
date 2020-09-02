package com.scg.studinfo.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J\u001c\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J\u0006\u0010\u001d\u001a\u00020\u001eJ+\u0010\u001f\u001a\u00020\u00152#\u0010\u0018\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001e\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00150 J3\u0010\u001f\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u001e2#\u0010\u0018\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001e\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00150 J\u0006\u0010%\u001a\u00020\nJ\u001c\u0010&\u001a\u00020\u00152\u0006\u0010\'\u001a\u00020\u001e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*J$\u0010+\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u001e2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00150 J\u000e\u0010-\u001a\u00020.2\u0006\u0010)\u001a\u00020*J3\u0010/\u001a\u00020\u00152\b\u00100\u001a\u0004\u0018\u00010\u001e2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00150 J\u0016\u00101\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001eJ\u0006\u00103\u001a\u00020\u0015J1\u00104\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u001e2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00150 J\u001c\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u0002082\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J\u001c\u00109\u001a\u00020\u00152\u0006\u0010\'\u001a\u00020\u001e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J2\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u001e2\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00010=2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J2\u0010>\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u001e2\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00010=2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J*\u0010?\u001a\u00020\u00152\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00010=2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J0\u0010@\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u001e2\u0006\u0010A\u001a\u00020,2\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060BR\u00020C\u0012\u0004\u0012\u00020\u00150 J/\u0010D\u001a\u00020\u00152\'\u0010\u0018\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001c0E\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00150 J1\u0010D\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u001e2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00150 J&\u0010G\u001a\u00020\u00152\u0006\u0010A\u001a\u00020,2\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060BR\u00020C\u0012\u0004\u0012\u00020\u00150 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006H"}, d2 = {"Lcom/scg/studinfo/utils/FireBaseHelper;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "database", "Lcom/google/firebase/database/DatabaseReference;", "getDatabase", "()Lcom/google/firebase/database/DatabaseReference;", "isLogged", "", "()Z", "storage", "Lcom/google/firebase/storage/StorageReference;", "getStorage", "()Lcom/google/firebase/storage/StorageReference;", "addPostToDatabase", "", "feedPost", "Lcom/scg/studinfo/models/FeedPost;", "onSuccess", "Lkotlin/Function0;", "addUnity", "unity", "Lcom/scg/studinfo/models/Unity;", "chUid", "", "checkRole", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "str", "uid", "currentUserReference", "fetchSignInMethodsForEmail", "email", "getUnity", "it", "Lcom/google/firebase/database/DataSnapshot;", "getUrl", "Landroid/net/Uri;", "getUser", "Lcom/scg/studinfo/models/User;", "guestAdded", "key", "guestAddedGroup", "group", "openApp", "optionsBool", "bool", "reauthenticate", "credential", "Lcom/google/firebase/auth/AuthCredential;", "updateEmail", "updateInfo", "chld", "updates", "", "updateUnity", "updateUser", "uploadPostPhoto", "photo", "Lcom/google/firebase/storage/UploadTask$TaskSnapshot;", "Lcom/google/firebase/storage/UploadTask;", "uploadUnity", "", "id", "uploadUserPhoto", "app_release"})
public final class FireBaseHelper {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.storage.StorageReference storage = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.DatabaseReference database = null;
    private final boolean isLogged = false;
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
    
    public final void guestAdded(@org.jetbrains.annotations.Nullable()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess) {
    }
    
    public final void guestAddedGroup(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String group) {
    }
    
    public final void openApp() {
    }
    
    public final void uploadPostPhoto(@org.jetbrains.annotations.Nullable()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    android.net.Uri photo, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.google.firebase.storage.UploadTask.TaskSnapshot, kotlin.Unit> onSuccess) {
    }
    
    public final void optionsBool(@org.jetbrains.annotations.NotNull()
    java.lang.String str, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onSuccess) {
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
    
    public final void checkRole(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess) {
    }
    
    public final void checkRole(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess) {
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
    
    public final boolean isLogged() {
        return false;
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