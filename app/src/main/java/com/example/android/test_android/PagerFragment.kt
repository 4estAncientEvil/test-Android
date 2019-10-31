package com.example.android.test_android

import android.app.Notification
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.item_page.*


class PagerFragment : Fragment() {

    val n = mutableListOf<Int>()

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

                val id = (0..Int.MAX_VALUE).random()
                n.add(id)

                with(NotificationManagerCompat.from(applicationContext)) {
                    // notificationId is a unique int for each notification that you must define
                    notify(id, builder.build())
                }
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val applicationContext = this.activity!!.applicationContext
        with(NotificationManagerCompat.from(applicationContext)) {
            for (i in n) {
                cancel(i)
            }
        }
    }
}