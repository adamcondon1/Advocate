package com.x18392911.final.advocate.recommendations.utils

import android.view.View

fun View.setVisible(isVisible: Boolean) {
  this.visibility = when {
    isVisible -> View.VISIBLE
    else -> View.GONE
  }
}