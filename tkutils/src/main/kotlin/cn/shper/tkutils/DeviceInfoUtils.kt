package cn.shper.tkutils

import android.util.Log
import java.io.*

/**
 * Author : Shper
 * Date : V0.1 2020/10/16
 */
object DeviceInfoUtils {

  private const val DEVICE_INFO_UNKNOWN = -1

  private val CPU_FILTER: FileFilter
    get() {
      return FileFilter { pathname ->
        val path = pathname.name
        //regex is slow, so checking char by char.
        if (path.startsWith("cpu")) {
          for (i in 3 until path.length) {
            if (path[i] < '0' || path[i] > '9') {
              return@FileFilter false
            }
          }
          return@FileFilter true
        }
        false
      }
    }

  fun getNumberOfCPUCores(): Int {
    return try {
      File("/sys/devices/system/cpu/").listFiles(CPU_FILTER)?.size ?: DEVICE_INFO_UNKNOWN
    } catch (e: Exception) {
      DEVICE_INFO_UNKNOWN
    }
  }

  fun getTotalMemory(): Long? {
    var initialMemory: Long = 0
    try {
      val localFileReader = FileReader("/proc/meminfo")
      val localBufferedReader = BufferedReader(localFileReader, 4096)
      val str2 = localBufferedReader.readLine() // 读取meminfo第一行，系统总内存大小
      val arrayOfString = str2.split("\\s+".toRegex()).toTypedArray()
      // 获得系统总内存，单位是KB
      initialMemory = Integer.valueOf(arrayOfString[1]).toLong()
      localBufferedReader.close()
    } catch (e: IOException) {
      e.printStackTrace()
    }

    return initialMemory
  }

}