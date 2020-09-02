package com.scg.studinfo.utils

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import com.google.firebase.database.ktx.getValue
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.scg.studinfo.activities.ValueEventListenerAdapter
import com.scg.studinfo.activities.showToast
import com.scg.studinfo.models.FeedPost
import com.scg.studinfo.models.Unity
import com.scg.studinfo.models.User

class FireBaseHelper (private val activity: Activity) {

    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val storage: StorageReference = FirebaseStorage.getInstance()
        .reference
    val database: DatabaseReference = FirebaseDatabase.getInstance()
        .reference

    fun guestAdded(key: String?, onSuccess: (key: String) -> Unit) {
        if(key != null) {
            database.child("guest/$key/online").setValue(System.currentTimeMillis())
                .addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess(key)
                } else {
                    activity.showToast(it.exception!!.message!!)
                }
            }
        } else {
            val pushedPost = database.child("guest").push()
            pushedPost.child("online").setValue(System.currentTimeMillis()).addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess(pushedPost.key!!)
                } else {
                    activity.showToast(it.exception!!.message!!)
                }
            }
        }
    }
    fun guestAddedGroup(key: String, group: String) {
        database.child("guest/$key/group").setValue(group)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    activity.showToast("Сохранено")
                } else {
                    activity.showToast(it.exception!!.message!!)
                }
            }
    }


    //Время подключения к сети
    fun openApp() {
        val s5r = ServerValue.TIMESTAMP
        database.child("online/users/${auth.currentUser!!.uid}/")
            .setValue(ServerValue.TIMESTAMP)
            .addOnCompleteListener {
                if (!it.isSuccessful) {
                    activity.showToast(it.exception!!.message!!)
                }
            }
    }

    //загрузка фото поста
    fun uploadPostPhoto(uid: String?, photo: Uri, onSuccess: (UploadTask.TaskSnapshot) -> Unit) {
        storage
            .child(uid ?: "users/${auth.currentUser!!.uid}/images/${photo.lastPathSegment}")
            .putFile(photo).addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess(it.result!!)
                } else {
                    activity.showToast(it.exception!!.message!!)
                }
            }
    }

    fun optionsBool(str: String, onSuccess: (bool: Boolean) -> Unit) {
        database.child("options/$str").addListenerForSingleValueEvent(ValueEventListenerAdapter {
            onSuccess(it.value as Boolean)
        })
    }

    //Загрузка списка объединений
    fun uploadUnity(onSuccess: (it: List<Unity>) -> Unit) {
        database.child("unity").addListenerForSingleValueEvent(
            ValueEventListenerAdapter {
                val unit = it.children.map { it.getValue(Unity::class.java)!!.copy(uid = it.key) }
                onSuccess(unit)
            }
        )
    }

    //Загрузка объединения
    fun uploadUnity(id: String, onSuccess: (it: Unity) -> Unit) {
        database.child("unity/$id").addListenerForSingleValueEvent(
            ValueEventListenerAdapter {
                val unit = it.getValue(Unity::class.java)!!.copy(uid = it.key)
                onSuccess(unit)
            }
        )
    }

    //Загрузка объединения
    fun addUnity(unity: Unity, onSuccess: () -> Unit) {
        database.child("unity").push().setValue(unity).addOnCompleteListener {
            if (it.isSuccessful) {
                onSuccess()
            } else {
                activity.showToast(it.exception!!.message!!)
            }
        }
    }

    //обновление информации об объединении
    fun updateUnity(uid: String, updates: Map<String, Any?>, onSuccess: () -> Unit) {
        database.child("unity/$uid").updateChildren(updates)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess()
                } else {
                    activity.showToast(it.exception!!.message!!)
                }
            }
    }

    fun checkRole(onSuccess: (str: String?) -> Unit) {
        database.child("private/users/${auth.currentUser!!.uid}/role").addListenerForSingleValueEvent(ValueEventListenerAdapter {
            onSuccess(it.value as String?)
        })
    }

    fun checkRole(uid: String, onSuccess: (str: String?) -> Unit) {
        database.child("private/users/$uid/role").addListenerForSingleValueEvent(ValueEventListenerAdapter {
            onSuccess(it.value as String?)
        })
    }

    //обновление информации о пользователе
    fun updateUser(updates: Map<String, Any?>, onSuccess: () -> Unit) {
        database.child("users").child(auth.currentUser!!.uid).updateChildren(updates)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess()
                } else {
                    activity.showToast(it.exception!!.message!!)
                }
            }
    }

    //обновление информации
    fun updateInfo(chld: String, updates: Map<String, Any?>, onSuccess: () -> Unit) {
        database.child(chld).updateChildren(updates)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess()
                } else {
                    activity.showToast(it.exception!!.message!!)
                }
            }
    }

    fun chUid(): String = auth.currentUser!!.uid

    //Проверка на уникальность email
    fun fetchSignInMethodsForEmail(email: String, onSuccess: () -> Unit) {
        auth.fetchSignInMethodsForEmail(email).addOnCompleteListener {
            if (it.isSuccessful) {
                onSuccess()
            } else {
                activity.showToast(it.exception!!.message!!)
            }
        }
    }

    //Проверка на смену email
    fun updateEmail(email: String, onSuccess: () -> Unit) {
        auth.currentUser!!.updateEmail(email).addOnCompleteListener {
            if (it.isSuccessful) {
                onSuccess()
            } else {
                activity.showToast(it.exception!!.message!!)
            }
        }
    }

    //Проверка на преаутентивикацию
    fun reauthenticate(credential: AuthCredential, onSuccess: () -> Unit) {
        auth.currentUser!!.reauthenticate(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                onSuccess()
            } else {
                activity.showToast(it.exception!!.message!!)
            }
        }
    }

    //получение URL
    fun getUrl(uid: String?, onSuccess: (Uri) -> Unit) {
        storage.child(
            uid ?: "users/${auth.currentUser!!.uid}/photo"
        ).downloadUrl.addOnCompleteListener {
            if (it.isSuccessful) {
                onSuccess(it.result!!)
            } else {
                activity.showToast(it.exception!!.message!!)
            }
        }
    }

    //загрузка фото
    fun uploadUserPhoto(photo: Uri, onSuccess: (UploadTask.TaskSnapshot) -> Unit) {
        storage.child("users/${auth.currentUser!!.uid}/photo").putFile(photo)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess(it.result!!)
                } else {
                    activity.showToast(it.exception!!.message!!)
                }
            }
    }

    //загрузка поста
    fun addPostToDatabase(feedPost: FeedPost, onSuccess: () -> Unit) {
        database.child("feed-posts")
            .push().setValue(feedPost).addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess()
                } else {
                    activity.showToast(it.exception!!.message!!)

                }
            }
    }

    val isLogged = auth.currentUser != null

    fun currentUserReference(): DatabaseReference =
        database.child("users").child(auth.currentUser!!.uid)

    //Загрузка информации о user
    fun getUser(it: DataSnapshot): User {
        return it.getValue(User::class.java)!!.copy(uid = it.key)
    }

    fun getUnity(it: DataSnapshot): Unity {
        return it.getValue(Unity::class.java)!!.copy(uid = it.key)
    }
}

