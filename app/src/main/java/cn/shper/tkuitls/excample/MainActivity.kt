package cn.shper.tkuitls.excample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.shper.tkuitls.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Author : Shper
 * Date : 2020/8/24
 */
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    device_info_btn.setOnClickListener {
      startActivity(Intent(this, DeviceInfoActivity::class.java))
    }
  }

}