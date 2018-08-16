package com.visally.infrustructure.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.visally.R
import java.io.IOException
import java.nio.charset.Charset
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/*************************************
 *This File Is created By
 * mahdi_TD
 * on
 * 7/14/2018.
 *************************************/

class CommonUtils {

    private val TAG = "CommonUtils"

    val timeStamp: String
        get() = SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT, Locale.US).format(Date())


    fun showDialog(context: Context): Dialog {
        val dialog = Dialog(context)
        //        progressDialog.show();
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_custom)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        return dialog
    }


    fun isEmailValid(email: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        pattern = Pattern.compile(emailPattern)
        matcher = pattern.matcher(email)
        return matcher.matches()
    }

    @Throws(IOException::class)
    fun loadJSONFromAsset(context: Context, jsonFileName: String): String {

        val manager = context.assets
        val inputStreamReader = manager.open(jsonFileName)

        val size = inputStreamReader.available()
        val buffer = ByteArray(size)
        inputStreamReader.read(buffer)
        inputStreamReader.close()

        return String(buffer, Charset.forName("UTF-8"))
    }
}// This utility class is not publicly instantiable