package com.idn.getapi

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idn.getapi.databinding.RowItemGunungBinding

class GunungAdapter(private val listGunung: List<GunungResponseItem>) : RecyclerView.Adapter<GunungAdapter.MyViewHolder>() {

    class MyViewHolder (val binding: RowItemGunungBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemGunungBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listGunung [position]
        holder.binding.apply {
            tvNama.text = data.nama
            tvBentuk.text = data.bentuk
            tvLetusan.text = data.estimasiLetusanTerakhir
            tvTinggi.text = data.tinggiMeter
            tvGeolokasi.text = data.geolokasi
        }
    }

    override fun getItemCount(): Int = listGunung.size
}