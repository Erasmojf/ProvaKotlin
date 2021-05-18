package br.com.erasmogame.kotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import br.com.erasmogame.kotlinapp.model.IssueModel
import kotlinx.android.synthetic.main.recycler_view_list_row.view.*
import java.sql.Array
import java.util.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var list: List<IssueModel> = Arrays.asList()

    fun setListIssueModel(list: List<IssueModel>) {
        this.list = list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.setValues(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder : RecyclerView.ViewHolder {

        val titleTextView: TextView
        val stateTextView: TextView

       constructor(itemView: View) : super(itemView) {
           titleTextView = itemView.findViewById(R.id.textview_title)
           stateTextView = itemView.findViewById(R.id.textview_state)
       }

        fun setValues(issueModel: IssueModel) {
           titleTextView.setText(issueModel.title)
            stateTextView.setText(issueModel.state)
        }
    }
}
