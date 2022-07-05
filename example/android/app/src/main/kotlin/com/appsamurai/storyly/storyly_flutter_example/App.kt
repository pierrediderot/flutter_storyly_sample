package com.appsamurai.storyly.storyly_flutter_example

import android.app.Application
import android.content.Context
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

fun createFlutterEngine(context: Context): FlutterEngine =
    FlutterEngine(context).apply {
        flutterEngine = this
        navigationChannel.setInitialRoute("/")
        dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
        FlutterEngineCache.getInstance().put("cache_engine", this)
    }

lateinit var flutterEngine: FlutterEngine

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeEngine(applicationContext)
    }

    private fun initializeEngine(applicationContext: Context) {
        createFlutterEngine(applicationContext)
    }
}