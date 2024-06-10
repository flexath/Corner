package com.flexath.corner.features.main.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.flexath.corner.R

@Composable
fun PostDetail(
    modifier: Modifier = Modifier
) {
    var count by remember {
        mutableIntStateOf(-1)
    }

    val itemList = remember {
        mutableStateListOf<ComposableModelType>()
    }

    LazyColumn {
        items(count = itemList.size) {
            when (itemList[it].type) {
                ComposableType.TEXT -> {
                    Text(
                        text = "Text is added: Index $it",
                        fontSize = 20.sp
                    )
                }

                ComposableType.IMAGE -> {
                    AsyncImage(
                        model = R.drawable.dummy_profile,
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                }
            }
        }

        item {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Button(
                    onClick = {
                        count++
                        itemList.add(
                            ComposableModelType(
                                id = count,
                                type = ComposableType.TEXT
                            )
                        )
                    }
                ) {
                    Text(text = "Text")
                }

                Button(
                    onClick = {
                        count++
                        itemList.add(
                            ComposableModelType(
                                id = count,
                                type = ComposableType.IMAGE
                            )
                        )
                    }
                ) {
                    Text(text = "Image")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PostDetailPreview() {
    PostDetail(
        modifier = Modifier.fillMaxSize()
    )
}

enum class ComposableType {
    TEXT,
    IMAGE
}

data class ComposableModelType(
    val id: Int,
    val type: ComposableType
)

val composableList = mutableListOf<ComposableModelType>()