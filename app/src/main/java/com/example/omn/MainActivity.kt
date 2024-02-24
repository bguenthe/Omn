package com.example.omn

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.omn.ui.theme.OmnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainComp()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainComp() {
    Scaffold(
        content = { FilledButtonExample() }
    )
}

@Composable
fun FilledButtonExample() {
    val mContext = LocalContext.current
    val bodyscan = MediaPlayer.create(mContext, R.raw.bc)
    val meditation15m = MediaPlayer.create(mContext, R.raw.med15)
    Column {
        Row {
            Button(onClick = {
                bodyscan.start()
            }) {
                Text(text = "BodyScanStart")
            }
            Button(onClick = {
                bodyscan.pause()
            }) {
                Text(text = "BodyScanPause")
            }
            Button(onClick = {
                bodyscan.stop()
                bodyscan.prepare()
            }) {
                Text(text = "BodyScanStop")
            }
        }
        Row {
            Button(onClick = {
                meditation15m.start()
            })
            {
                Text(text = "Medi15minStart")
            }
            Button(onClick = {
                meditation15m.pause()
            }) {
                Text(text = "Medi15minPause")
            }
            Button(onClick = {
                meditation15m.stop()
                meditation15m.prepare()
            }) {
                Text(text = "Medi15minStop")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OmnTheme {
        FilledButtonExample()
    }
}