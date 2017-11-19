package com.tallrocket.trial.profile

import android.util.Log
import android.util.LogPrinter
import com.tallrocket.trial.models.Comment
import com.tallrocket.trial.restapis.APIServices
import com.tallrocket.trial.restapis.ServiceFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.internal.util.NotificationLite.subscription


/**
 * Created by user on 11/16/17.
 */

class ProfilePresenter(var profileView: ProfileView?) : ProfileViewPresenter {

    override fun getDataFromServer() {


        ServiceFactory.createRetrofitService(APIServices::class.java).getComments()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ aQiitaItemList ->

                    for (qiitaItem in aQiitaItemList) {
                        Log.e("TAG", qiitaItem.email)
                    }

                    profileView?.loadData(aQiitaItemList)
                }, { t: Throwable? ->
                    Log.e("TAG", "" + t?.message)

                })

       // subscription.dispose();

    }


}

