package com.bintina.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.FloatRange
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScopeInstance.alignBy
import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScopeInstance.alignBy
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            modifier = Modifier
                .size(80.dp, 40.dp)
                .alignBy{it.measuredWidth/2}
                .alignBy{it.measuredHeight/2}
                .padding(16.dp)
        ) {
//Top Left
            QuadrantContainer(
                modifier = Modifier.weight(weight =
                )
            )
            {
                TextArticle()
            }
            QuadrantContainer(
                modifier = Modifier.fillMaxSize()
            )
            {
                ImageArticle()
            }
            QuadrantContainer(
                modifier = Modifier.fillMaxSize()
            )
            {
                RowArticle()
            }
            QuadrantContainer(
                modifier = Modifier.fillMaxSize()
            )
            {
                ColumnArticle()
            }
        }
        /*
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth(fraction = 0.5F)
                ) {
                    Row(verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxHeight(fraction = 0.5F)) {
                            TextArticle()
                    }
                    Row(verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.fillMaxHeight(fraction = 0.5F)) {
                            ImageArticle()
                    }
                }
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth(fraction = 0.5F)
                ) {
                    Row(verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxHeight(fraction = 0.5F)) {
                            RowArticle()
                    }
                    Row(verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.fillMaxHeight(fraction = 0.5F)) {
                            ColumnArticle()
                    }
                }
        */


    }

    @Composable
    fun QuadrantContainer(
        modifier: Modifier = Modifier,
        content: @Composable BoxScope.() -> Unit
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center,
            content = content
        )

    }

    @Composable
    fun TextArticle() {
        Column(modifier = Modifier.background(color = colorResource(id = R.color.text_quadrant))) {
            Text(text = "Text composable")
            Text(text = "Displays text and follows the recommended Material Design guidelines.")
        }
    }

    @Composable
    fun ImageArticle() {
        Column(modifier = Modifier.background(color = colorResource(id = R.color.image_quadrant))) {
            Text(text = "Image composable")
            Text(text = "Creates a composable that lays out and draws a given Painter class object.")
        }
    }

    @Composable
    fun RowArticle() {
        Column(modifier = Modifier.background(color = colorResource(id = R.color.row_quadrant))) {
            Text(text = "Row composable")
            Text(text = "A layout composable that places its children in a horizontal sequence.")
        }
    }

    @Composable
    fun ColumnArticle() {
        Column(modifier = Modifier.background(color = colorResource(id = R.color.column_quadrant))) {
            Text(text = "Column composable")
            Text(text = "A layout composable that places its children in a vertical sequence.")
        }
    }

    @Preview
    @Composable
    fun QuadrantPreview() {
        ComposableQuadrant()
    }
}

