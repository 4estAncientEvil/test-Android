package com.example.android.test_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.item_page.*
import android.app.Notification
import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class PagerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            val applicationContext = this.activity!!.applicationContext
            val position = it.getInt("position")
            tvNumberOfActivity.text = position.toString()
            bCreate.setOnClickListener {
                val builder = NotificationCompat.Builder(
                        applicationContext, Notification.CATEGORY_MESSAGE)
                        .setContentTitle("You create a notification")
                        .setContentText("Notification $position")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(applicationContext.resources,
                                R.mipmap.ic_launcher))

                with(NotificationManagerCompat.from(applicationContext)) {
                    // notificationId is a unique int for each notification that you must define
                    notify(position, builder.build())
                }
            }

        }
    }
}