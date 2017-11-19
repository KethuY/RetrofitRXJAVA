package com.tallrocket.trial.profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.tallrocket.trial.R
import com.tallrocket.trial.main.Employee
import com.tallrocket.trial.profile.OnItemClick
import com.tallrocket.trial.models.Comment
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

class ProfileActivity : AppCompatActivity(), OnItemClick,ProfileView {


    var mProfilePic: CircleImageView? = null
    var mName: TextView? = null
    var mDesignation: TextView? = null
    var mRecylerView: RecyclerView? = null
    var mProfileViewPresenter: ProfileViewPresenter? = null
    var mProfileView: ProfileView? = null
    private var mOnItemClickListener: OnItemClick?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setUp();
        setEmpData();
        initializeRecylerView();
    }

    private fun setEmpData() {
        val emp = intent?.getSerializableExtra("emp") as Employee
        mProfilePic = findViewById<CircleImageView>(R.id.profile_image)
        mName = findViewById<TextView>(R.id.name)
        mDesignation = findViewById<TextView>(R.id.des)
        Glide.with(this).load(emp.imageId).into(mProfilePic)
        mName?.text = emp.name;
        mDesignation?.text = emp.designation;

    }

    private fun initializeRecylerView() {
        mRecylerView = findViewById<RecyclerView>(R.id.recyler_view)
        mRecylerView?.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        try {
            mProfileViewPresenter?.getDataFromServer();
        } catch (e: Exception) {
            Log.e("TAG","Exception"+e.message);
        }
    }

    private fun setUp() {
        mOnItemClickListener = this
        mProfileView = this
        mProfileViewPresenter =ProfilePresenter(mProfileView)
    }

    override fun loadData(comments: MutableList<Comment>) {

        try {
            mRecylerView?.adapter=MyRecylerViewAdapter(this,comments,mOnItemClickListener)
        } catch (e: Exception) {
            Log.e("TAG","Exception"+e.message);
        }
    }


    override fun navigateToNextPage(pos: Int, employee: Comment?) {
        Toast.makeText(this,"Selected comment "+employee?.body,Toast.LENGTH_SHORT).show()
    }

}
