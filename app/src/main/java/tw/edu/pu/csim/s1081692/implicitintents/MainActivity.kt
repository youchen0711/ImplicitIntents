package tw.edu.pu.csim.s1081692.implicitintents

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "侑辰FB", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            var it = Intent(Intent.ACTION_VIEW)
            it.data = Uri.parse("https://www.facebook.com")
            startActivity(it)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
         */


        when (item.itemId) {
            R.id.web -> {
                var it = Intent(Intent.ACTION_VIEW)
                it.data = Uri.parse("http://www1.pu.edu.tw/~s1081692")
                startActivity(it)
                return true
            }
            R.id.tel -> {
                var it = Intent(Intent.ACTION_VIEW)
                it.data = Uri.parse("tel:0974189618")
                startActivity(it)
                return true
            }
            R.id.email -> {
                var it = Intent(Intent.ACTION_SENDTO)
                it.data = Uri.parse("mailto:s1081692@gm.pu.edu.tw")
                startActivity(it)
                return true
            }
            R.id.search -> {
                var it = Intent(Intent.ACTION_WEB_SEARCH)
                it.putExtra(SearchManager.QUERY, "侑辰");
                startActivity(it)
                return true
            }
            R.id.map -> {
                var it = Intent(Intent.ACTION_VIEW)
                it.data = Uri.parse("geo:24.2267756,120.5771591")
                startActivity(it)
                return true
            }

            else -> return super.onOptionsItemSelected(item)

        }
    }
}
