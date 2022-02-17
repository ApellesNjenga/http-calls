package ke.co.tukenya.httpcalls

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://mtekcdnstoragev2.blob.core.windows.net/admin/mcfish/students.json"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                Log.w("Fetch", "response: ${response.substring(0, 500)}\"", )
            },
            Response.ErrorListener { Log.e("Error:", "\"That didn't work!\"" ) })

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}