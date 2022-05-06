package com.heinminlatt.shared.activity

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Base64
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.heinminlatt.shared.R
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showSnackBar(message : String){
        Snackbar.make(window.decorView, message, Snackbar.LENGTH_LONG).show()
    }

     fun slideToAnimation(){
        overridePendingTransition( R.anim.slide_in, R.anim.slide_out )
    }

    fun slideTopToBottomAnimation(){
        overridePendingTransition( R.anim.slide_from_top, R.anim.slide_in_top )
    }

    fun slideBottomToTopAnimation(){
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
    }

     fun slideBackAnimation(){
        overridePendingTransition( R.anim.slide_enter, R.anim.slide_exit )
    }

     fun addReadMore(text: String, textView: TextView) {
        val ss = SpannableString(text.substring(0, 150) + "... read more")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                addReadLess(text, textView)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ds.color = resources.getColor(R.color.color_view_more, theme)
                } else {
                    ds.color = resources.getColor(R.color.color_view_more)
                }
            }
        }
        ss.setSpan(clickableSpan, ss.length - 10, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
         textView.text = ss
         textView.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun addReadLess(text: String, textView: TextView) {
        val ss = SpannableString("$text read less")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                addReadMore(text, textView)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ds.color = resources.getColor(R.color.color_view_more, theme)
                } else {
                    ds.color = resources.getColor(R.color.color_view_more)
                }
            }
        }
        ss.setSpan(clickableSpan, ss.length - 10, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = ss
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}

fun hideKeyboard(activity: Activity) {
    val view = activity.findViewById<View>(android.R.id.content)
    try {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    } catch (e: Exception) {

    }

}

fun showKeyboard(activity: Activity, editText: EditText) {
    try {
        editText.requestFocus()
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    } catch (e: Exception) {

    }
}

//    fun getFirebaseInstanceID() {
//        FirebaseInstanceId.getInstance().instanceId
//            .addOnCompleteListener(OnCompleteListener { task ->
//                if (!task.isSuccessful) {
//                    Log.w("TOKEN", "getInstanceId failed", task.exception)
//                    return@OnCompleteListener
//                }
//
//                // Get new Instance ID token
//                val token = task.result?.token
//
//                // Log and toast
//                val msg = "token: $token"
//                Log.d("TOKEN", msg)
//                //Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
//            })
//    }

      fun printHashKey(pContext: Context) {
        try {
            val info = pContext.packageManager.getPackageInfo(
                pContext.packageName,
                PackageManager.GET_SIGNATURES
            )
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val hashKey = String(Base64.encode(md.digest(), 0))
                Log.d("Hash key", "printHashKey() Hash Key: $hashKey")
            }
        } catch (e: NoSuchAlgorithmException) {
            Log.d("", "printHashKey()", e)
        } catch (e: Exception) {
            Log.e("", "printHashKey()", e)
        }

    }
