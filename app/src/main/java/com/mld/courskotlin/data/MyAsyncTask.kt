package com.mld.courskotlin.data

import android.os.AsyncTask

class MyAsyncTask : AsyncTask<Void, Void, Void>() {

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Void?): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
    }
}