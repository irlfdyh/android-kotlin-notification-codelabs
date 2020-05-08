package com.example.android.eggtimernotifications

import android.app.NotificationManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        Log.d(TAG, "From: ${remoteMessage.from}")

        // Check if the message contains a data payload.
        remoteMessage.data.let {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")
        }

        // Check if the notification contains a notification payload.
        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
            sendNotification(it.body!!)
        }
    }

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the
     * InstanceID token is initially generated so this is where you would retrieve
     * the token.
     */
    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

        // To send messages to this application instance or manage this apps subscriptions
        // on the server side, send the Instance ID token to your app server.
        sendRegistrationToServer(token)
    }

    /**
     * Persist token to third-party servers.
     */
    private fun sendRegistrationToServer(token: String) {

    }

    /**
     * Create and show a simple notification containing the received FCM message.
     */
    private fun sendNotification(messageBody: String) {
        val notificationManager = ContextCompat.getSystemService(
            applicationContext, NotificationManager::class.java
        ) as NotificationManager
    }

    companion object {
        private const val TAG = "MyFirebaseMsgService"
    }

}