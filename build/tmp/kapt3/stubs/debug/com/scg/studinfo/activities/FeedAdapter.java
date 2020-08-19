package com.scg.studinfo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%BU\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/scg/studinfo/activities/FeedAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/scg/studinfo/activities/FeedAdapter$ViewHolder;", "posts", "", "Lcom/scg/studinfo/models/FeedPost;", "allPosts", "activ", "Landroid/app/Activity;", "mUid", "", "users", "Lcom/scg/studinfo/models/User;", "unity", "Lcom/scg/studinfo/models/Unity;", "context", "Landroid/content/Context;", "(Ljava/util/List;Ljava/util/List;Landroid/app/Activity;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Landroid/content/Context;)V", "correctGradient", "", "view", "Landroid/view/View;", "position", "", "deleteNew", "uid", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "openPopmenu", "icon", "openView", "ViewHolder", "app_debug"})
public final class FeedAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.scg.studinfo.activities.FeedAdapter.ViewHolder> {
    private final java.util.List<com.scg.studinfo.models.FeedPost> posts = null;
    private final java.util.List<com.scg.studinfo.models.FeedPost> allPosts = null;
    private final android.app.Activity activ = null;
    private final java.lang.String mUid = null;
    private final java.util.List<com.scg.studinfo.models.User> users = null;
    private final java.util.List<com.scg.studinfo.models.Unity> unity = null;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.scg.studinfo.activities.FeedAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.scg.studinfo.activities.FeedAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    private final void openView(int position, android.view.View view) {
    }
    
    private final void openPopmenu(android.view.View icon, java.lang.String uid) {
    }
    
    private final void deleteNew(java.lang.String uid) {
    }
    
    private final void correctGradient(android.view.View view, int position) {
    }
    
    public FeedAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.scg.studinfo.models.FeedPost> posts, @org.jetbrains.annotations.NotNull()
    java.util.List<com.scg.studinfo.models.FeedPost> allPosts, @org.jetbrains.annotations.NotNull()
    android.app.Activity activ, @org.jetbrains.annotations.NotNull()
    java.lang.String mUid, @org.jetbrains.annotations.NotNull()
    java.util.List<com.scg.studinfo.models.User> users, @org.jetbrains.annotations.NotNull()
    java.util.List<com.scg.studinfo.models.Unity> unity, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/scg/studinfo/activities/FeedAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.view.View view = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getView() {
            return null;
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}