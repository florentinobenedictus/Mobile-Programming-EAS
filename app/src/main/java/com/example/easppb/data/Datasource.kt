package com.example.easppb.data

import com.example.easppb.R
import com.example.easppb.model.Item

class Datasource {
    fun loadItems(): List<Item> {
        return listOf(
            Item("Keranjang Rajut", "Kerajinan Tangan", 500000, R.drawable.product_1),
            Item("Kemeja Batik Pria", "Pakaian", 216000, R.drawable.product_2),
            Item("Panci Aluminium", "Perabotan", 61000, R.drawable.product_3),
            Item("Gayung Hati Plastik", "Perabotan", 8000, R.drawable.product_4),
            Item("Gayung Bundar", "Perabotan", 6000, R.drawable.product_5),
            Item("Sirop Marjan", "Makanan & Minuman", 21000, R.drawable.product_6),
        )
    }
}