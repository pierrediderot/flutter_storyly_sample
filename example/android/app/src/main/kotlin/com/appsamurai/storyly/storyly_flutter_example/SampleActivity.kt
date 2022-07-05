package com.appsamurai.storyly.storyly_flutter_example

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import io.flutter.embedding.android.FlutterFragment

private const val TAG_FLUTTER_FRAGMENT = "flutter_fragment"

class SampleActivity : FragmentActivity() {

    private var flutterFragment: FlutterFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        attachFlutterFragment()
    }

    private fun attachFlutterFragment() {
        flutterFragment = supportFragmentManager
            .findFragmentByTag(TAG_FLUTTER_FRAGMENT) as? FlutterFragment

        if (flutterFragment == null) {
            flutterFragment = createFlutterFragment()
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.flFlutterFragment,
                    flutterFragment!!,
                    TAG_FLUTTER_FRAGMENT
                )
                .commit()
        }
    }

    private fun createFlutterFragment(): FlutterFragment =
        FlutterFragment
            .withCachedEngine("cache_engine")
            .destroyEngineWithFragment(false)
            .build()

    override fun onPostResume() {
        super.onPostResume()
        flutterFragment?.onPostResume()
    }

    override fun onNewIntent(intent: Intent) {
        flutterFragment?.onNewIntent(intent)
        super.onNewIntent(intent)
    }

    override fun onBackPressed() {
        flutterFragment?.onBackPressed()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        flutterFragment?.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )
    }

    override fun onUserLeaveHint() {
        flutterFragment?.onUserLeaveHint()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        flutterFragment?.onTrimMemory(level)
    }
}