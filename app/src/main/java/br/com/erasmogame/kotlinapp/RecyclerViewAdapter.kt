package br.com.erasmogame.kotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.erasmogame.kotlinapp.model.RecyclerData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.recycler_view_list_row.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private  var listData: List<RecyclerData>? = null

    fun setUpdatedData(listData: List<RecyclerData>){
         this.listData = listData
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageView = view.imageView
        val textViewName = view.textviewName
        val textViewDescription = view.textviewDescription
        val textviewState = view.textviewState
        fun bind(data: RecyclerData){
            textViewName.setText(data.title)
            textviewState.setText(data.state)

            Glide.with(imageView)
                .load(data.labels.toString())
                .apply(RequestOptions.centerCropTransform())
                .into(imageView)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val  view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_list_row,parent, false)
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
       if(listData == null){
           return  0
       }else{
           return  listData?.size!!
       }
    }
}