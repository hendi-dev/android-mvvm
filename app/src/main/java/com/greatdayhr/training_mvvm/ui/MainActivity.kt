package com.greatdayhr.training_mvvm.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.greatdayhr.training_mvvm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProviders.of(this).get(MainViewModel::class.java)

        vm.isLoading.observe(this, Observer {
            if (it) {
                pb_loading.visibility = View.VISIBLE
            } else {
                pb_loading.visibility = View.GONE
            }
        })

        vm.message.observe(this, Observer {
            tv_message.text = it
        })

        vm.isButtonShow.observe(this, Observer {
            btn_get.visibility = it
        })

        btn_get.setOnClickListener {
            vm.getMessage()
        }
    }
}
