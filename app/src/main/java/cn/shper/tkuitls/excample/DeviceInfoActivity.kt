package cn.shper.tkuitls.excample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.shper.tkuitls.R
import cn.shper.tkutils.DeviceInfoUtils
import kotlinx.android.synthetic.main.activity_device_info.*

/**
 * Author : Shper
 * Date : V0.1 2020/10/16
 */
class DeviceInfoActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_device_info)

    cpu_cores_btn.setOnClickListener {
      val cpuCores = DeviceInfoUtils.getNumberOfCPUCores()
      log_txt.text = "CPUCores: $cpuCores"
    }

    total_memory_btn.setOnClickListener {
      val totalMemory = DeviceInfoUtils.getTotalMemory()
      log_txt.text = "TotalMemory: $totalMemory"
    }
  }

}