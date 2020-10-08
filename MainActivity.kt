package com.example.swipetabsandfragments

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

import android.os.Bundle
import android.widget.TableLayout

import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    internal var mytab: TabLayout
    internal var myPage: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mytab = findViewById(R.id.mytab)
        myPage = findViewById(R.id.mypager)

        myPage.adapter = myOwnPagerAdapter(supportFragmentManager)
        mytab.setupWithViewPager(myPage)

        mytab.addOnTabSelectedListener(object : TabLayout.BaseOnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                myPage.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    internal inner class myOwnPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        var data = arrayOf("java", "android", "ios")

        override fun getItem(position: Int): Fragment? {
            if (position == 0) {
                return java()
            }

            if (position == 1) {
                return android()
            }

            return if (position == 2) {
                ios()
            } else null


        }

        override fun getCount(): Int {
            return data.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return data[position]
        }
    }
}
