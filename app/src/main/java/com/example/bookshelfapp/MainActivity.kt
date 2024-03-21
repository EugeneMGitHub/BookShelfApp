package com.example.bookshelfapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookshelfapp.ui.theme.BookShelfAppTheme
import com.example.bookshelfapp.ui.theme.NewYorkFamily


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookShelfAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainApp(){

        val sheetState = rememberBottomSheetScaffoldState()

        BottomSheetScaffold(
            scaffoldState = sheetState,
            sheetPeekHeight = 50.dp,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 12.dp),
            topBar = {
                Row(
                    Modifier
                        .padding(start = 28.dp, end = 28.dp, top = 45.dp, bottom = 31.dp)
                        .fillMaxWidth()
//                        .height(IntrinsicSize.Min),
                    .height(45.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "20", fontWeight = FontWeight.Bold, fontFamily = NewYorkFamily, fontSize = 38.sp)
                    Column(Modifier.weight(1f)) {
                        Text(text = "Март", fontFamily = NewYorkFamily, fontSize = 14.sp, color = Color.Gray)
                        Text(text = "среда, 2024", fontFamily = NewYorkFamily, fontSize = 14.sp, color = Color.Gray)
                    }
                    IconButton(onClick = {}) {
                       Icon(imageVector = Icons.Filled.QrCode, contentDescription = "QRCode")
                    }
//                    Image(
//                        painter = painterResource(id = R.drawable.img_profile),
//                        contentDescription = "Profile Picture",
//                        modifier = Modifier
////                            .fillMaxHeight()
//                            .heightIn(12.dp, 50.dp)
//                            .clip(RoundedCornerShape(12.dp))
//                    )
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
//                            .fillMaxHeight()
                            .heightIn(12.dp, 50.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )

                }
            },
            sheetContent = {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Читали недавно",
                    fontFamily = NewYorkFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 28.dp),
                )

                LazyColumn(contentPadding = PaddingValues(vertical = 16.dp)){
                    items(myBookItems){book->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .clickable { }
                                .padding(horizontal = 28.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = book.book.image),
                                contentScale = ContentScale.FillHeight,
                                contentDescription = "Cover",
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .clip(RoundedCornerShape(8.dp))
                            )

                            Column(
                                Modifier.weight(1f)
                            ) {
                                Text(text = book.book.title, fontFamily = NewYorkFamily, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                Text(text = book.book.author, fontSize = 13.sp, color = Color.Gray)
                                Spacer(modifier = Modifier.weight(1f))
                                Text(text = "Читали в последний раз: ${book.returnDate}", color = MaterialTheme.colorScheme.primary, fontSize = 13.sp)
                            }
                            IconButton(onClick = {}) {
                                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu")
                            }

                        }
                    }
                }
            }

        ) { paddingValues->

        Column(Modifier.padding(paddingValues)
        ){

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp),
                verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "Новинки",
                    fontWeight = FontWeight.Bold,
                    fontFamily = NewYorkFamily,
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f))
                TextButton(
                    onClick = { },

                ) {
                    Text(text = "Посмотреть все")
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(imageVector = Icons.Filled.ChevronRight, contentDescription = "")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                contentPadding = PaddingValues(horizontal = 28.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                items(items){book ->

                    Column(
                        Modifier
                            .width(130.dp)
                            .clickable { }
                    ) {
                        Image(
                            painter = painterResource(id = book.image), contentDescription = "Book Cover",
                            modifier = Modifier

                                .fillMaxWidth()
//                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = book.title, fontFamily = NewYorkFamily, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Text(text = book.author, color = Color.Gray, fontSize = 13.sp)
                    }
                }

            }


        }

        }


    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookShelfAppTheme {
       MainApp()
    }
}