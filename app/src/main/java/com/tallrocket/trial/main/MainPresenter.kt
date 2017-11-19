package com.tallrocket.trial.main

import com.tallrocket.trial.R

import java.util.ArrayList

/**
 * Created by user on 11/15/17.
 */

class MainPresenter( var mainView: MainView?) : MainViewPresenter {

    override fun getDataFromServer() {
        //  mainView.showProgressDialog();
        val employees = ArrayList<Employee>()
        val names = arrayOf("DivyaCharitha", "Rohini", "Chaitanya", "Durga Prasad", "Shivam Agarwal", "Manikanta", "Sampath", "Nagaraju", "Uday", "Prakash", "Maheswari", "Harika", "Sai Charitha")
        val designation = arrayOf("Digital Market Analyst", "Talent Acquisition Expert", "Senior Software Developer", "Application Developer", "Application Developer", "Master of Automation", "Application Developer", "Data Expert", "Big Data Engineer", "Infrastructure Lead", "Test Engineer", "Application Developer", "Data Analyst")
        val imgId = intArrayOf(R.drawable.profile_1, R.drawable.profile_2, R.drawable.profile_3, R.drawable.profile_4, R.drawable.profile_5, R.drawable.profile_6, R.drawable.profile_7, R.drawable.profile_8, R.drawable.profile_9, R.drawable.profile_10, R.drawable.profile_11, R.drawable.profile_12, R.drawable.profile_13)

        for (i in 0..12) {
            val employee = Employee()
            employee.name = names[i]
            employee.designation = designation[i]
            employee.imageId = imgId[i]
            employees.add(employee)
        }

        mainView?.loadData(employees)
        // mainView.dismissProgressDialog();


    }
}
