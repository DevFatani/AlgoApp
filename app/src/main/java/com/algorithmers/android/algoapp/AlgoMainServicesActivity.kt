package com.algorithmers.android.algoapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.Spannable
import android.text.SpannableString
import android.view.Menu
import android.view.MenuItem
import com.algorithmers.android.algoapp.service_frag.CategoriesFragment
import com.algorithmers.android.algoapp.service_frag.NewsfeedFragment
import com.algorithmers.android.algoapp.util.MenuTypeface
import com.algorithmers.android.algoapp.util.TypefaceFont
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem

class AlgoMainServicesActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, AHBottomNavigation.OnTabSelectedListener, CategoriesFragment.CategorySelect {

    var changeContent: ChangeContent? = null
    private var mAhBottomNavigation: AHBottomNavigation? = null
    private val mNewsfeedFrg: NewsfeedFragment = NewsfeedFragment.instance
    private val mCategoriesFrg: CategoriesFragment = CategoriesFragment.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_algo_main_services)

        this.setupNavigationDrawer()
        this.setupBottomNavigation()
    }

    private fun setupNavigationDrawer() {
        val toolbar = this.findViewById(R.id.toolbar) as Toolbar
        this.setSupportActionBar(toolbar)
        val drawer = this.findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()
        val nv = this.findViewById(R.id.nav_view) as NavigationView
        nv.setNavigationItemSelectedListener(this)
    }

    private fun setupBottomNavigation() {
        this.mAhBottomNavigation = this.findViewById(R.id.bottom_navigation) as AHBottomNavigation
        this.mAhBottomNavigation!!.addItem(AHBottomNavigationItem(R.string.tab_bar1, R.drawable.ic_whatshot_black_24dp, R.color.b_dark_purple))
        this.mAhBottomNavigation!!.addItem(AHBottomNavigationItem(R.string.tab_bar2, R.drawable.ic_view_module_black_24dp, R.color.b_dark_purple))
        this.mAhBottomNavigation!!.isForceTint = true
        this.mAhBottomNavigation!!.isColored = true
        this.mAhBottomNavigation!!.setOnTabSelectedListener(this)
        this.mAhBottomNavigation!!.currentItem = 0
        this.mAhBottomNavigation!!.setTitleTypeface(TypefaceFont.set(this))
    }

    override fun onTabSelected(position: Int, wasSelected: Boolean): Boolean {
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()

        if (position == 0) {

            if (this.mNewsfeedFrg.isAdded) {
                fragmentTransaction.show(this.mNewsfeedFrg)
            } else {
                fragmentTransaction.replace(R.id.flActMainServices, this.mNewsfeedFrg)
            }

        } else if (position == 1) {
            if (this.mCategoriesFrg.isAdded) {
                fragmentTransaction.show(this.mCategoriesFrg)
            } else {
                fragmentTransaction.replace(R.id.flActMainServices, this.mCategoriesFrg)
            }
        }

        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
        return true
    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
//            super.onBackPressed()
            return
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.algo_main_services, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressWarnings("StatementWithEmptyBody")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (this.mAhBottomNavigation!!.currentItem == 1) {
            this.mAhBottomNavigation!!.currentItem = 0
        }

        if (id == R.id.nav_all_content) {
            this.changeContent!!.onChange(ALL)

        } else if (id == R.id.nav_txt) {

            this.changeContent!!.onChange(TXT)

        } else if (id == R.id.nav_video) {

            this.changeContent!!.onChange(VIDEO)

        } else if (id == R.id.nav_audio) {

            this.changeContent!!.onChange(AUDIO)

        } else if (id == R.id.nav_image) {

            this.changeContent!!.onChange(IMAGE)

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_logout) {
            this.startActivity(Intent(this, AlgoMainActivity::class.java))
            this.finishAffinity()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onSelected(id: Int) {
        this.changeContent!!.onChange(MIX, id)
        this.mAhBottomNavigation!!.currentItem = 0
    }
}
