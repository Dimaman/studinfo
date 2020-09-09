package com.scg.studinfo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\'\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020302\"\u000203\u00a2\u0006\u0002\u00104\u001a\u0006\u00105\u001a\u000206\u001a\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u000208\u001a\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020:0(2\u0006\u0010;\u001a\u00020<\u001a\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010(\u001a\u001e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020!\u001a\u000e\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\u0001\u001a\u0016\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\u00012\u0006\u0010G\u001a\u00020\u0001\u001a\u000e\u0010H\u001a\u00020\u00012\u0006\u00107\u001a\u000208\u001a\u0014\u0010I\u001a\u00020.*\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001\u001a\u001a\u0010L\u001a\u00020.*\u00020J2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020:\u001a\u001c\u0010O\u001a\u00020.*\u00020A2\u0006\u0010P\u001a\u00020\u00012\b\b\u0002\u0010Q\u001a\u00020!\u001a\f\u0010R\u001a\u0004\u0018\u00010\u0001*\u00020S\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\"\u001c\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0004\b\u000e\u0010\u000f\"\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0014\u001a\u00020\u0001X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0003\"\u0014\u0010\u0016\u001a\u00020\u0001X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0003\"\u0014\u0010\u0018\u001a\u00020\u0001X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0003\"\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\"\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\"\u000e\u0010&\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\" \u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u0006T"}, d2 = {"APP_PREFERENCES", "", "getAPP_PREFERENCES", "()Ljava/lang/String;", "PERSON_INFO", "getPERSON_INFO", "imageNews", "Landroid/graphics/Bitmap;", "getImageNews", "()Landroid/graphics/Bitmap;", "setImageNews", "(Landroid/graphics/Bitmap;)V", "itemNews", "getItemNews", "setItemNews", "(Ljava/lang/String;)V", "listFac", "Ljava/util/ArrayList;", "getListFac", "()Ljava/util/ArrayList;", "personFac", "getPersonFac", "personGroup", "getPersonGroup", "personKey", "getPersonKey", "selUnity", "Lcom/scg/studinfo/models/Unity;", "getSelUnity", "()Lcom/scg/studinfo/models/Unity;", "setSelUnity", "(Lcom/scg/studinfo/models/Unity;)V", "selUnityActiv", "", "getSelUnityActiv", "()I", "setSelUnityActiv", "(I)V", "stringVersion", "usersAtUnity", "", "getUsersAtUnity", "()Ljava/util/List;", "setUsersAtUnity", "(Ljava/util/List;)V", "coordinateBtnAndInputs", "", "btn", "Landroid/widget/Button;", "inputs", "", "Landroid/widget/EditText;", "(Landroid/widget/Button;[Landroid/widget/EditText;)V", "getDatetime", "Landroid/icu/util/Calendar;", "time", "", "getSaveSetting", "", "activity", "Landroid/app/Activity;", "getStrSaveSetting", "showPopup", "Landroid/widget/PopupMenu;", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "menu", "validateBtn", "text1", "text2", "weekDayRus", "loadCircleImage", "Landroid/widget/ImageView;", "photoUrl", "loadImage", "image", "centr", "showToast", "text", "duration", "toStringOrNull", "Landroid/text/Editable;", "app_release"})
public final class UtilsKt {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String stringVersion = "1.1.8";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PERSON_INFO = "PERSON_INFO";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String APP_PREFERENCES = "mysettings";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String personGroup = "person_group";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String personFac = "person_fac";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String personKey = "person_key";
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String itemNews;
    @org.jetbrains.annotations.Nullable()
    private static android.graphics.Bitmap imageNews;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.ArrayList<java.lang.String> listFac = null;
    private static int selUnityActiv;
    @org.jetbrains.annotations.Nullable()
    private static com.scg.studinfo.models.Unity selUnity;
    @org.jetbrains.annotations.NotNull()
    private static java.util.List<java.lang.String> usersAtUnity;
    
    public static final void showToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$showToast, @org.jetbrains.annotations.NotNull()
    java.lang.String text, int duration) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getPERSON_INFO() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getAPP_PREFERENCES() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getPersonGroup() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getPersonFac() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getPersonKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<java.lang.String> getStrSaveSetting() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<java.lang.Boolean> getSaveSetting(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getItemNews() {
        return null;
    }
    
    public static final void setItemNews(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.Bitmap getImageNews() {
        return null;
    }
    
    public static final void setImageNews(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.ArrayList<java.lang.String> getListFac() {
        return null;
    }
    
    public static final int getSelUnityActiv() {
        return 0;
    }
    
    public static final void setSelUnityActiv(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final com.scg.studinfo.models.Unity getSelUnity() {
        return null;
    }
    
    public static final void setSelUnity(@org.jetbrains.annotations.Nullable()
    com.scg.studinfo.models.Unity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<java.lang.String> getUsersAtUnity() {
        return null;
    }
    
    public static final void setUsersAtUnity(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.icu.util.Calendar getDatetime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.icu.util.Calendar getDatetime(long time) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String weekDayRus(long time) {
        return null;
    }
    
    public static final boolean validateBtn(@org.jetbrains.annotations.NotNull()
    java.lang.String text1, @org.jetbrains.annotations.NotNull()
    java.lang.String text2) {
        return false;
    }
    
    public static final boolean validateBtn(@org.jetbrains.annotations.NotNull()
    java.lang.String text1) {
        return false;
    }
    
    public static final void coordinateBtnAndInputs(@org.jetbrains.annotations.NotNull()
    android.widget.Button btn, @org.jetbrains.annotations.NotNull()
    android.widget.EditText... inputs) {
    }
    
    public static final void loadCircleImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$loadCircleImage, @org.jetbrains.annotations.Nullable()
    java.lang.String photoUrl) {
    }
    
    public static final void loadImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$loadImage, @org.jetbrains.annotations.NotNull()
    java.lang.String image, boolean centr) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String toStringOrNull(@org.jetbrains.annotations.NotNull()
    android.text.Editable $this$toStringOrNull) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.widget.PopupMenu showPopup(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.view.View view, int menu) {
        return null;
    }
}