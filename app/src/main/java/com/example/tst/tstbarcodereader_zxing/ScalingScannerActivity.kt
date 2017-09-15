package com.example.tst.tstbarcodereader_zxing

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.zxing.Result
import kotlinx.android.synthetic.main.activity_scaling_scanner.*
import me.dm7.barcodescanner.zxing.ZXingScannerView

@Suppress("PLUGIN_WARNING")
class ScalingScannerActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {


    private val FLASH_STATE = "FLASH_STATE"
    private val AUTOFOCUS_STATE = "AUTOFOCUS_STATE"

    private var mScannerView: ZXingScannerView? = null
    private var mFlash: Boolean = false
    private var mAutofocus: Boolean = false
    private var resultText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scaling_scanner)

        mScannerView = ZXingScannerView(this)

        content_frame.addView(mScannerView)

        switchFlash.setOnClickListener({
            mFlash = !mFlash
            mScannerView?.setFlash(mFlash)
        })

        switchAutoFocus.setOnClickListener ({
            mAutofocus = !mAutofocus
            mScannerView?.setAutoFocus(mAutofocus)
        })
    }

    override fun onResume() {
        super.onResume()
        mScannerView?.setResultHandler(this)
        mScannerView?.setAspectTolerance(0.2f)
        mScannerView?.setFlash(mFlash)
        mScannerView?.setAutoFocus(mAutofocus)
        mScannerView?.startCamera()

        switchAutoFocus.setChecked(mAutofocus)
        switchFlash.setChecked(mFlash)
    }

    override fun onPause() {
        super.onPause()
        mScannerView?.stopCamera()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putBoolean(FLASH_STATE, mFlash)
        outState?.putBoolean(AUTOFOCUS_STATE, mAutofocus)
    }

    override fun handleResult(result: Result?) {
        mScannerView?.resumeCameraPreview(this)

        if (result == null) {
            return
        }

        mScannerView?.stopCamera()

        resultText = result.text;
        val resultIntent: Intent = Intent().putExtra("BRCode", resultText)
        setResult(1, resultIntent)
        finish()
    }
}