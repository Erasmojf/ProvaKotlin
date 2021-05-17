package br.com.erasmogame.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.erasmogame.kotlinapp.model.RecyclerList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  lateinit var  recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }

    private  fun initRecyclerView(){
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerview.adapter = recyclerViewAdapter
    }

    private  fun  initViewModel(){
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, object : Observer<RecyclerList>{

            override fun onChanged(t: RecyclerList?) {
                if (t != null){
                    recyclerViewAdapter.setUpdatedData(t.items)
                    recyclerViewAdapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity, "Erro ao carregar dados ",Toast.LENGTH_SHORT).show()
                }
            }
        })
        viewModel.makeApicall()
    }
}