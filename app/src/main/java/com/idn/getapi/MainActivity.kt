package com.idn.getapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.getapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var _viewModel: MainViewModel? = null
    private val viewModel get() = _viewModel as MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getData()
        viewModel.gunungResponse.observe(this) {
            showData(it)
        }

    }

    private fun showData(data: List<GunungResponseItem>) {
        Log.d("MainActivity", "showData: $data")
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = GunungAdapter(data)
        }
    }

}