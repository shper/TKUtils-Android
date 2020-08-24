package cn.shper.tkutils

import android.content.Context
import android.util.DisplayMetrics

/**
 * Author : Shper
 * Date : 2020/8/24
 */

/**
 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
 *
 * @param dpValue 尺寸dip
 * @return 像素值
 */
fun Context.tk_dp2px(dpValue: Float): Float {
  val scale: Float = resources.displayMetrics.density
  return dpValue * scale
}

/**
 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
 *
 * @param pxValue 尺寸像素
 * @return DIP值
 */
fun Context.tk_px2dp(pxValue: Float): Float {
  val scale: Float = resources.displayMetrics.density
  return pxValue / scale
}

/**
 * 根据手机的分辨率从 px(像素) 的单位 转成为 sp
 *
 * @param pxValue 尺寸像素
 * @return SP值
 */
fun Context.tk_px2sp(pxValue: Float): Float {
  val fontScale: Float = resources.displayMetrics.scaledDensity
  return pxValue / fontScale
}

/**
 * 根据手机的分辨率从 sp 的单位 转成为 px
 *
 * @param spValue SP值
 * @return 像素值
 */
fun Context.tk_sp2px(spValue: Float): Float {
  val fontScale: Float = resources.displayMetrics.scaledDensity
  return spValue * fontScale
}

/**
 * DisplayMetrics
 *
 * @return
 */
fun Context.tk_getDisplayMetrics(): DisplayMetrics {
  return resources.displayMetrics
}

/**
 * 获取屏幕密度
 *
 * @return 屏幕密度
 */
fun Context.tk_getScreenDpi(): Int {
  return tk_getDisplayMetrics().densityDpi
}

/**
 * 获取真实屏幕密度
 *
 * @return 注意，Application和Activity的屏幕密度是不一样的
 */
fun Context.tk_getRealDpi(): Int {
  val metric: DisplayMetrics = resources.displayMetrics
  val xdpi = metric.xdpi
  val ydpi = metric.ydpi
  return ((xdpi + ydpi) / 2.0f + 0.5f).toInt()
}