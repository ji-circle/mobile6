package com.example.secondapp6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                //Top bar = 컴포저블이 들어감...
                Scaffold(
                    //topBar 프로퍼티는 아무것도 안 받는 거에서 리턴값이 없는 함수를 받는다// () -> Unit
                    // topBar = TopAppBar 이런식으로 넣으면 TopAppBar 자체를 넣는 게 아니라 결과값을 넣는거라서 에러가 나 버림...
                    //  --> 람다함수를 써야 함
                    //아래처럼 하면 Topappbar를 구현부로 하는 함수를 넣는 게 됨. oncreate 해주기!
//                    topBar = {TopAppBar(title = {//})}
                    // title에 넣는 것도 함수이기 떄문에 그냥 string 넣으면 안 됨
                    //   -> 텍스트를 나타내는 텍스트 컴포저블 함수를 구현부로 하는 함수를 넣어야 함
                    // 그러면 상단 Top App Bar 자리에 해당 택스트가 들어가 있다...
                    topBar = {
                        TopAppBar(
                            //color 넣는 것. 컨테이너와 글자색 둘 다 바뀌었다.
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary
                            ),
                            title = { Text("Top App Bar") }
                        )
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