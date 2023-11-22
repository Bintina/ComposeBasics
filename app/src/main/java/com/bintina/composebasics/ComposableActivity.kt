package com.bintina.composebasics

//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.bintina.composebasics.ui.theme.ComposeBasicsTheme

class ComposableActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                //Surface container
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposableQuadrant()
                }
            }
        }
    }


    @Composable
    private fun ComposableQuadrant(modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                Modifier
            ) {

            }
        }
    }


    @Composable
    fun TextArticle() {
        Column(modifier = Modifier.background(color = colorResource(id = R.color.text_quadrant))) {
            Text(text = "Text composable", fontWeight = FontWeight.Bold)
            Text(text = "Displays text and follows the recommended Material Design guidelines.")
        }
    }

    @Composable
    fun ImageArticle() {
        Column(modifier = Modifier.background(color = colorResource(id = R.color.image_quadrant))) {
            Text(text = "Image composable", fontWeight = FontWeight.Bold)
            Text(text = "Creates a composable that lays out and draws a given Painter class object.")
        }
    }

    @Composable
    fun RowArticle() {
        Column(modifier = Modifier.background(color = colorResource(id = R.color.row_quadrant))) {
            Text(text = "Row composable", fontWeight = FontWeight.Bold)
            Text(text = "A layout composable that places its children in a horizontal sequence.")
        }
    }

    @Composable
    fun ColumnArticle() {
        Column(modifier = Modifier.background(color = colorResource(id = R.color.column_quadrant))) {
            Text(text = "Column composable", fontWeight = FontWeight.Bold)
            Text(text = "A layout composable that places its children in a vertical sequence.")
        }
    }

    @Composable
    fun BoxWithRowLayout(content: @Composable RowScope.() -> Unit) {
        Row {
            content()
        }
    }

    @Composable
    fun BoxWithColumnLayout(content: @Composable ColumnScope.() -> Unit) {
        Column {
            content()
        }
    }

    @Preview
    @Composable
    fun QuadrantPreview() {
        BoxWithColumnLayout() {
            Column(Modifier.weight(0.5f, true)) {

                BoxWithRowLayout() {
                    Row(Modifier.weight(0.5f)) {
                        TextArticle()
                    }
                    Row(Modifier.weight(0.5f)) {
                        ImageArticle()
                    }
                }
            }
            Column(Modifier.weight(0.5f, true)) {
                BoxWithRowLayout {
                    Row(Modifier.weight(0.5f)) {
                        ColumnArticle()
                    }
                    Row(Modifier.weight(0.5f)) {
                        RowArticle()
                    }
                }
            }
        }
    }
}

