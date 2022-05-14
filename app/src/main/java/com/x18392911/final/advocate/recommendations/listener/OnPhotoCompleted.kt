package com.x18392911.final.advocate.recommendations.listener

import android.graphics.Bitmap

//used for photo retrieval on map
interface OnPhotoCompleted {
    fun onPhotoCompleted(photo: Bitmap?)
}