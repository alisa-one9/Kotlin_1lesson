package com.example.kotlin_1lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.kotlin_1lesson.adapters.Adapter
import com.example.kotlin_1lesson.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityRecyclerBinding
    private lateinit var adapter: Adapter
    private lateinit var list: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRecyclerBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        initList()

    }

    private fun initList() {
        adapter = Adapter()
        list = intent.getStringArrayListExtra(Keys.TEXT_KEY) as ArrayList<String>

        if (list.isNullOrEmpty()) {
            viewBinding.tvRecyclerScreen.visibility = View.VISIBLE
        } else {
            viewBinding.tvRecyclerScreen.visibility = View.GONE

            adapter.setList(list)
        }
       /* viewBinding.rvList.addItemDecoration(
            DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL
            )
        )*/
        viewBinding.rvList.adapter = adapter
    }
}