package com.tallrocket.trial.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView

import com.bumptech.glide.Glide
import com.tallrocket.trial.R

import java.util.ArrayList

import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by user on 11/15/17.
 */

class MyRecylerViewAdapter(var context: Context?, var employees: ArrayList<Employee>, var listener: OnItemClick?) : RecyclerView.Adapter<MyRecylerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.single_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mDesignation.text = employees[position].designation
        holder.mName.text = employees[position].name
        holder.mName.text = employees[position].name

        Glide.with(context).load(employees[position].imageId).into(holder.mProfilePicture)

        holder.mRelativeLayout.setOnClickListener {
            listener?.navigateToNextPage(position, employees[position]);
        }


    }

    override fun getItemCount(): Int {
        return employees.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mProfilePicture: CircleImageView
        var mName: TextView
        var mDesignation: TextView
        var mRelativeLayout: RelativeLayout

        init {

            mProfilePicture = itemView.findViewById(R.id.profile_image)
            mName = itemView.findViewById(R.id.name)
            mDesignation = itemView.findViewById(R.id.designation)
            mRelativeLayout = itemView.findViewById(R.id.relative)

        }
    }
}
