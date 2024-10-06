package com.example.secondapp6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.secondapp6.ui.theme.SecondApp6Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SecondApp6Theme {

                ScaffoldExample()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    var presses by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text("Top App Bar") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Some Description")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Edit, contentDescription = "Menu")
                    }

                }
            )
        },
        bottomBar = {
            BottomAppBar(actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Edit, contentDescription = "Check")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = "Check")
                }
            },
                floatingActionButton = {
                    FloatingActionButton(onClick = {presses += 1}) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses += 1 }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
//            verticalArrangement = Arrangement.spacedBy(16.dp),
            //  center로 바꾸기 전에, 컬럼의 영역을 전체로 바꿔준 다음에 해야 함!
            //body에서 컬럼의 내용을 세로중앙 정렬... 중앙정렬이 아님! y축 방향으로...
            verticalArrangement = Arrangement.Center,
            //이건 컬럼들 단위로 중앙정렬... 컬럼 안의 텍스트에 대해서는(버튼 안 텍스트 제외) 중앙정렬하지 않음
            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.padding(innerPadding)
            modifier = Modifier.fillMaxHeight().padding(innerPadding)
        ) {
            Text(
                modifier = Modifier.padding((8.dp)),
                text =
                """
                                    This is an example of a scaffold
                                    
                                    You have pressed the floating action button $presses times
                                """.trimIndent()
            )
            //버튼 추가
            //  배치, 배열은 위에서, 컬럼 다음의 괄호 안에서 처리
            //그냥 button으로 해도 됨... 색은 기본색
//            Button(onClick = {}) {
            //이러면 색이 바뀜... primary 색과 맞춰서 자동으로 들어감.
//            FilledTonalButton(onClick = {}) {
            //이러면 테두리 있는 버튼
//            OutlinedButton(onClick = {}) {
            //약간 입체적...?
//            ElevatedButton(onClick = {}) {
            //텍스트만 있는 버튼
            TextButton(onClick = {}) {
                Text("Filled")
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