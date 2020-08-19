package com.scg.studinfo.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/scg/studinfo/activities/ValueEventListenerAdapter;", "Lcom/google/firebase/database/ValueEventListener;", "handler", "Lkotlin/Function1;", "Lcom/google/firebase/database/DataSnapshot;", "", "(Lkotlin/jvm/functions/Function1;)V", "getHandler", "()Lkotlin/jvm/functions/Function1;", "onCancelled", "p0", "Lcom/google/firebase/database/DatabaseError;", "onDataChange", "data", "app_debug"})
public final class ValueEventListenerAdapter implements com.google.firebase.database.ValueEventListener {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.google.firebase.database.DataSnapshot, kotlin.Unit> handler = null;
    
    @java.lang.Override()
    public void onCancelled(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseError p0) {
    }
    
    @java.lang.Override()
    public void onDataChange(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DataSnapshot data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.google.firebase.database.DataSnapshot, kotlin.Unit> getHandler() {
        return null;
    }
    
    public ValueEventListenerAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.google.firebase.database.DataSnapshot, kotlin.Unit> handler) {
        super();
    }
}