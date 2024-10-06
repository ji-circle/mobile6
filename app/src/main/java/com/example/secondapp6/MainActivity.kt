package com.example.secondapp6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.secondapp6.ui.theme.SecondApp6Theme

class MainActivity : ComponentActivity() {
    //아래에서 Scaffold 이하 내용 복사해서 옮겨넣으면서 api 어쩌구를 opt in for 했음... 그래서 아래 코드 없앰
//    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SecondApp6Theme {
                //scaffold = 틀...
                //  modifier 부분을 지웠음
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                Scaffold(
//                    topBar = {
//                        TopAppBar(
//                            colors = topAppBarColors(
//                                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                                titleContentColor = MaterialTheme.colorScheme.primary
//                            ),
//                            title = { Text("Top App Bar") }
//                        )
//                    },
//                    bottomBar = {
//                        BottomAppBar(
//                            containerColor = MaterialTheme.colorScheme.primaryContainer,
//                            contentColor = MaterialTheme.colorScheme.primary
//                        ) {
//                            Text(
//                                modifier = Modifier.fillMaxWidth(),
//                                textAlign = TextAlign.Center,
//                                text = "Bottom App Bar"
//                            )
//                        }
//                    },
//                    floatingActionButton = {
//                        FloatingActionButton(onClick = {}) {
//                            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
//                        }
//                    }
//                ) { innerPadding ->
//                    Column(
//                        verticalArrangement = Arrangement.spacedBy(16.dp),
//                        modifier = Modifier.padding(innerPadding)
//                    ) {
//                        Text(
//                            modifier = Modifier.padding((8.dp)),
//                            text =
//                                """
//                                    This is an example of a scaffold
//
//                                    You have pressed the floating action button x times
//                                """.trimIndent()
//                        )
//                    }
//                }
                //위 코드 옮긴 후 아래 코드 추가했음
                ScaffoldExample()
            }
        }
    }
}

//위의 scaffold가 상태를 가지는 함수를 가지고 있어야 위 텍스트의 x의 숫자를 바꿀 수 있음...
// 상태를 가지는 함수를 만들기
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample(){
    //상태를 나타내는 변수 (우린 정수로 나타낼거라 int로 함)
    var presses by rememberSaveable {mutableIntStateOf(0)}

    //위에 적었던 코드의 Scaffold 이하 전체를 복사해 옮겨넣음
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
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom App Bar"
                )
            }
        },
        floatingActionButton = {
            //클릭할때마다 1만큼 증가
            FloatingActionButton(onClick = {presses += 1}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(
                modifier = Modifier.padding((8.dp)),
                text =
                """
                                    This is an example of a scaffold
                                    
                                    You have pressed the floating action button $presses times
                                """.trimIndent()
            )
            //$presses를 텍스트 안에 넣어줌
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