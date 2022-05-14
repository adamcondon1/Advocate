package com.x18392911.final.advocate.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import com.x18392911.final.advocate.recommendations.listener.OnTaskCompleted
import com.x18392911.final.advocate.recommendations.model.MovieTheater

class MapsActivity : AppCompatActivity(), OnTaskCompleted, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var supportMapFragment: SupportMapFragment
    private val REQUEST_LOCATION_PERMISSION = 1
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private var movieTheaters: ArrayList<MovieTheater> = ArrayList()
    private var currentLat:Double = 0.0
    private var currentLong:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.x18392911.final.advocate.recommendations.R
                .R.layout.activity_maps)

        //Manage device location
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        supportMapFragment = supportFragmentManager.findFragmentById(import com.x18392911.final.advocate.recommendations.R
                com.x18392911.final.advocate.recommendations.R.id.map) as SupportMapFragment

        getLocationAccess()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(import com.x18392911.final.advocate.recommendations
                R.menu.map_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            import com.x18392911.final.advocate.recommendations.R.id.map_menu -> {
                val intent = Intent(this, ListActivity::class.java)
                intent.putExtra("lat", currentLat)
                intent.putExtra("lng", currentLong)
                intent.putExtra("list", movieTheaters)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getLocationAccess() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation()
        }
        else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }

    private fun getCurrentLocation() {
        //Initialize task location
        val task: Task<Location> = fusedLocationClient.lastLocation
        task.addOnSuccessListener { location ->
            currentLat = location.latitude
            currentLong = location.longitude

            supportMapFragment.getMapAsync { googleMap ->
                mMap = googleMap
                if (ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                }
                mMap.isMyLocationEnabled = true
                mMap.setOnMarkerClickListener(this)

                val latLng = LatLng(location.latitude, location.longitude)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12f))

                movieTheaters()
            }
        }
    }

    private fun getMovieTheaters() {
        //Query string
        val url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + currentLat + "," + currentLong +
                "&rankby=distance" + "&type=movie_theater&key=" + getString(import com.x18392911.final.advocate.recommendations.R
                .string.google_maps_key)

        //Places task method to download json
        PlacesTask(this).execute(url)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                getLocationAccess()
            }
            else {
                Toast.makeText(this, "User has not granted location access permission", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    override fun onTaskCompleted(result: ArrayList<MovieTheater>) {
        mMap.clear()
        movieTheaters = result

        for (movieTheater in result) {
            val options = MarkerOptions()
            options.position(LatLng(movieTheater.latitude, movieTheater.longitude))
            options.title(movieTheater.name)
            mMap.addMarker(options)
        }
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        for (movieTheater in movieTheaters) {
            if (movieTheater
                    .name == p0?.title) {
                MovieTheaterDialogFragment.newInstance(movieTheater)
                    .show(supportFragmentManager, null)
                break
            }
        }
        return true
    }
}
