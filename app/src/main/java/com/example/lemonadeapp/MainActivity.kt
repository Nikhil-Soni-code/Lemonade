package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme {
                Lemonade()

            }
        }
    }
}

@Composable
fun Lemon(){
    var result by remember {
        mutableStateOf(1)
    }
    var squeezeCount by remember {
        mutableStateOf(1)
    }
    val imageResource = when(result){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    val textResource = when(result){
        1 -> {
            squeezeCount = (2..4).random()
            stringResource(id = R.string.Lemon_tree)
        }
        2 -> stringResource(id = R.string.Lemon)
        3 -> stringResource(id = R.string.Glass_of_lemonade)
        4 -> stringResource(id = R.string.Empty_glass)
        else -> stringResource(id = R.string.Lemon_tree)

    }
    Column (modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
            Button(onClick = {
                when(result){
                    1 -> result++
                    2 -> if(squeezeCount>=0) squeezeCount-- else result++
                    3 -> result++
                    4 -> result=1
                    else -> result =1
                }

            }) {
                Box(modifier = Modifier.height(200.dp)
//                    .border(
//                    width = 2.dp ,
//                    shape = RoundedCornerShape(4.dp) ,
//                    color = Color(red = 105 , green = 205 , blue = 216))
                ){
                    Image(painter = painterResource(id = imageResource),
                        contentDescription = "tree",
                    )
                }

            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                textResource,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }


@Preview(showBackground = true)
@Composable
fun Lemonade(){
    Lemon()
}