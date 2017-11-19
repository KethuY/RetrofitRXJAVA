package com.tallrocket.trial.profile

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tallrocket.trial.R
import com.tallrocket.trial.main.Employee
import com.tallrocket.trial.profile.OnItemClick
import com.tallrocket.trial.models.Comment
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

/**
 * Created by user on 11/15/17.
 */

class MyRecylerViewAdapter(var context: Context?, var employees: MutableList<Comment>, var listener: OnItemClick?) : RecyclerView.Adapter<MyRecylerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.comments_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mDesignation.text = employees[position].email
        holder.mName.text = employees[position].name
        holder.mComments.text = employees[position].body

       /* Glide.with(context).load(employees[position].imageId).into(holder.mProfilePicture)
*/
        holder.mRelativeLayout.setOnClickListener {
            listener?.navigateToNextPage(position, employees[position]);
        }


    }

    override fun getItemCount(): Int {
        return employees.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mName: TextView
        var mDesignation: TextView
        var mComments: TextView
        var mRelativeLayout: RelativeLayout

        init {

            mName = itemView.findViewById(R.id.name)
            mDesignation = itemView.findViewById(R.id.designation)
            mComments = itemView.findViewById(R.id.body)
            mRelativeLayout = itemView.findViewById(R.id.relative)

        }
    }
}