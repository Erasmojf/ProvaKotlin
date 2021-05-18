package br.com.erasmogame.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.erasmogame.kotlinapp.infra.DaggerModule
import br.com.erasmogame.kotlinapp.model.IssueModel
import br.com.erasmogame.kotlinapp.services.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter : RecyclerViewAdapter
//    private  lateinit var  recyclerViewAdapter: RecyclerViewAdapter
//    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerViewAdapter = RecyclerViewAdapter()

        val recycler = findViewById<RecyclerView>(R.id.recyclerview)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/repos/JetBrains/kotlin/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val result = retrofit.create(GithubService::class.java).getDataFromAPI()

        result?.enqueue(object : Callback<List<IssueModel>> {
            override fun onResponse(
                call: Call<List<IssueModel>>,
                response: Response<List<IssueModel>>
            ) {
                println(response.body())
                response.body()?.let { recyclerViewAdapter.setListIssueModel(it)
                    recycler.adapter = recyclerViewAdapter
                }
            }

            override fun onFailure(call: Call<List<IssueModel>>, t: Throwable) {
                println(t.message)
            }
        })
//        initRecyclerView()
//        initViewModel()
    }

//    private  fun initRecyclerView(){
//        recyclerview.layoutManager = LinearLayoutManager(this)
//        recyclerViewAdapter = RecyclerViewAdapter()
//        recyclerview.adapter = recyclerViewAdapter
//    }

//    private  fun  initViewModel(){
//        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
//        viewModel.getLiveDataObserver().observe(this, object : Observer<RecyclerList>{
//
//            override fun onChanged(t: RecyclerList?) {
//                if (t != null){
//                    recyclerViewAdapter.setUpdatedData(t.items)
//                    recyclerViewAdapter.notifyDataSetChanged()
//                }else{
//                    Toast.makeText(this@MainActivity, "Erro ao carregar dados ",Toast.LENGTH_SHORT).show()
//                }
//            }
//        })
//        viewModel.makeApicall()
//    }
}