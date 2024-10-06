package com.example.secondapp6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.secondapp6.ui.theme.SecondApp6Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SecondApp6Theme {
                //scaffold = 틀...
                //  modifier 부분을 지웠음
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary
                            ),
                            title = { Text("Top App Bar") }
                        )
                    },
                    //바텀바 넣기
                    bottomBar = {
                        //BottomAppBar 선택할 때 action 어쩌구 없는거로
                        BottomAppBar(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.primary
                        ) {
                            //뭔가를 넣을 수 있음.
                            //텍스트 정렬하려면 textAlign을 괄호 뒤에 추가하기.
                            //  근데 그냥  textAlign = TextAlign.Center 이라고 하면, 텍스트의 범위가 텍스트에 딱 맞춰있는 상태라서
                            //    정렬이 안 됨... 텍스트가 차지하고 있는 범위를 bottom app bar의 전체로 해줘야 가운데 정렬이 됨...
                            //       = modifier 사용하라는 뜻
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                text = "Bottom App Bar")
                        }
                    }
                ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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
    SecondApp6Theme {
        Greeting("Android")
    }
}