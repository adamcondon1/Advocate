package com.x18392911.final.advocate.recommendations.model

import com.google.gson.annotations.SerializedName
import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable

//serializing data retrieved for API
data class MovieTheater (
    @SerializedName("name")
    val name: String,
    @SerializedName("thumbnail")
    var thumbnail: String?,
    @SerializedName("address")
    val address: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
): Serializable {
    constructor(jsonObj: JSONObject) : this(jsonObj.getString("name"), null,
        jsonObj.getString("vicinity"), jsonObj.getJSONObject("geometry").getJSONObject("location").getDouble("lat"),
        jsonObj.getJSONObject("geometry").getJSONObject("location").getDouble("lng")){
        try {
            val array = jsonObj.getJSONArray("photos")
            if (array != null && array.length() > 0) {
                thumbnail = (array.get(0) as JSONObject).getString("photo_reference")
            }
        } catch (e: JSONException){}
    }
}