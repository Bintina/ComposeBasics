package com.bintina.composebasics

//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.foundation.layout.RowScopeInstance.weight

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    ComposableQuadrant(
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxHeight()
                    )
                }
            }
        }
    }


    @Composable
    private fun ComposableQuadrant(modifier: Modifier = Modifier) {
        BoxWithColumnLayout() {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                BoxWithRowLayout() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(0.5f)
                    ) {
                        TextArticle()
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(0.5f)
                    ) {
                        ImageArticle()
                    }
                }

                BoxWithRowLayout {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(0.5f)
                    ) {
                        RowArticle()
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(0.5f)
                    ) {
                        ColumnArticle()
                    }

                }


            }
        }
    }


    @Composable
    fun BoxWithRowLayout(content: @Composable (RowScope.() -> Unit)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            content()
        }
    }

    @Composable
    fun BoxWithColumnLayout(content: @Composable (ColumnScope.() -> Unit)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            content()
        }
    }

    @Composable
    fun TextArticle() {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = colorResource(id = R.color.text_quadrant))
                .fillMaxHeight(0.5f)
                .padding(16.dp)

        ) {
            Text(text = "Text composable", fontWeight = FontWeight.Bold, modifier = Modifier.padding(0.dp,0.dp,0.dp,16.dp))
            Text(text = "Displays text and follows the recommended Material Design guidelines.", fontSize = 16.sp, textAlign = TextAlign.Justify)
        }
    }

    @Composable
    fun ImageArticle() {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = colorResource(id = R.color.image_quadrant))
                .fillMaxHeight(0.5f)
                .padding(16.dp)
        ) {
            Text(text = "Image composable", fontWeight = FontWeight.Bold, modifier = Modifier.padding(0.dp,0.dp,0.dp,16.dp))
            Text(text = "Creates a composable that lays out and draws a given Painter class object.", fontSize = 16.sp, textAlign = TextAlign.Justify)
        }
    }

    @Composable
    fun RowArticle() {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = colorResource(id = R.color.row_quadrant))
                .fillMaxHeight(1f)
                .padding(16.dp)
        ) {
            Text(text = "Row composable", fontWeight = FontWeight.Bold, modifier = Modifier.padding(0.dp,0.dp,0.dp,16.dp))
            Text(text = "A layout composable that places its children in a horizontal sequence.", fontSize = 16.sp, textAlign = TextAlign.Justify)
        }
    }

    @Composable
    fun ColumnArticle() {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = colorResource(id = R.color.column_quadrant))
                .fillMaxHeight(1f)
                .padding(16.dp)
        ) {
            Text(text = "Column composable", fontWeight = FontWeight.Bold, modifier = Modifier.padding(0.dp,0.dp,0.dp,16.dp))
            Text(text = "A layout composable that places its children in a vertical sequence.", fontSize = 16.sp, textAlign = TextAlign.Justify)
        }
    }

    @Preview
    @Composable
    fun QuadrantPreview() {
        ComposableQuadrant()
    }
}

