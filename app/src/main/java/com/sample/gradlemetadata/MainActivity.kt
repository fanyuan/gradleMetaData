package com.sample.gradlemetadata

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sample.gradlemetadata.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val APP_DATE: String = "APP_DATE"
    private val APP_DATA_LONG: String = "APP_DATA_LONG"
    private val ACTIVITY_NAME: String = "ACTIVITY_NAME"
    private val APP_DATA: String = "APP_DATA"
    lateinit var binding:ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }

    fun getMeta(view: View) {
        val appInfo = applicationContext.packageManager.getApplicationInfo(packageName,
            PackageManager.GET_META_DATA)
        val appData = appInfo.metaData.getString(APP_DATA)

        Log.d("test","time = " + System.currentTimeMillis())

        val appDataLong = appInfo.metaData.getString(APP_DATE)
        //val longStr = appDataLong?.replace(APP_DATA_LONG,"")
        //val longValue = longStr?.toLong();

        val actInfo = packageManager.getActivityInfo(componentName,PackageManager.GET_META_DATA)
        val actData = actInfo.metaData.getString(ACTIVITY_NAME)

        val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")

        //Log.d("test","date = " + sdf.format(Date(longValue!!)))

        binding.tvDisplay.append("${APP_DATA} = $appData")
        binding.tvDisplay.append("\n\n")
        binding.tvDisplay.append("$APP_DATA_LONG = $appDataLong")
//        binding.tvDisplay.append("\n\n")
//        binding.tvDisplay.append(sdf.format(Date(longValue!!)))
        binding.tvDisplay.append("\n\n")
        binding.tvDisplay.append("$actData = $actData")
    }

}