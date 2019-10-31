package com.example.android.test_android

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

class ViewPagerFragmentStateAdapter(
        fm: FragmentManager
) : FragmentPagerAdapter(
        fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    private val container = arrayListOf<Fragment>(PagerFragment())

    var itemCount = 1


    override fun getItem(position: Int): Fragment {
        val fragment = container[position]
        fragment.apply {
            arguments = bundleOf(
                "position" to position.plus(1)
            )
        }
        return fragment
    }

    override fun getCount(): Int = itemCount

    override fun getItemPosition(fr: Any): Int {
        val index = container.indexOf(fr)

        return if (index == -1)
            PagerAdapter.POSITION_NONE
        else
            index
    }


    fun inc(): Int {
        itemCount++
        val fragment = PagerFragment()
        container.add(fragment)
        this.notifyDataSetChanged()
        return itemCount
    }

    fun dec(): Int {
        itemCount--
        val fragment = container[itemCount]
        container.remove(fragment)
        fragment.fragmentManager
                ?.beginTransaction()
                ?.remove(fragment)
                ?.commit()

        this.notifyDataSetChanged()
        return itemCount
    }
}