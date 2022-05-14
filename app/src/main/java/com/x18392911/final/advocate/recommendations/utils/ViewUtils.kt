package com.x18392911.final.advocate.recommendations.utils

import android.content.Context
import android.widget.Toast

//toast to act as default print
fun showToast(context: Context, text: String) {
    Toast.makeText(
        context,
        text,
        Toast.LENGTH_LONG
    ).show()
}

