package com.umc.mediasearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.umc.mediasearchapp.databinding.ActivityMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val searchFragment = SearchFragment()
    private val fragmentList = listOf(searchFragment, FavoritesFragment())
    private val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, fragmentList)

    // rx는 activity 해제될 때 같이 해제
    private var observableTextQuery: Disposable? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        with(binding) {
            view = this@MainActivity
            viewPager.adapter = adapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = if (fragmentList[position] is SearchFragment) {
                    "검색 결과"
                } else {
                    "즐겨 찾기"
                }
            }.attach()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.option_menu, menu)

        observableTextQuery = Observable.create { emitter: ObservableEmitter<String>? ->
            (menu.findItem(R.id.search).actionView as SearchView).apply {
                setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String): Boolean {
                        emitter?.onNext(query)
                        return false
                    }

                    override fun onQueryTextChange(newText: String): Boolean {
                        binding.viewPager.setCurrentItem(0, true)
                        emitter?.onNext(newText)
                        return false
                    }

                })
            }
        }
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

            .subscribe { // 프래그먼트에 검색어 전달
                searchFragment.searchKeyword(it)
            }


        return false
    }

    override fun onDestroy() {
        super.onDestroy()
        observableTextQuery?.dispose()
        observableTextQuery = null
    }

}