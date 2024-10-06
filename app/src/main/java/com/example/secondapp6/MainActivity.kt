package com.example.secondapp6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.graphics.Color
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
        //이 부분을 카드로 바꿔볼것임...
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
            //만약 카드 가로 크기를 줄이고 싶다면 아래 코드로 해도 되더라... 나
//            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(horizontal = 30.dp)
        ) {
            //카드 부분... 위에 이미 패딩이 되어있어서...?
            //  만약 카드의 영역이 치우져있다면 위의 modifier에서 수정... (height, weight 모두 범위 지정 잘 되었는지 확인)
//            Card {
            //그냥 card로 해도 되긴 함...
//            ElevatedCard(
//                //elecatedcard인 경우 더 띄우려면... (그림자생김)
//                elevation = CardDefaults.cardElevation(
//                    defaultElevation = 6.dp
//                )
//            ){

            //테두리가 있는 카드가 됨... + elevation 주기도 가능.
            OutlinedCard(
//                elevation = CardDefaults.cardElevation(
//                    defaultElevation = 6.dp
//                )
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                //아웃라인 = border 수정
                border = BorderStroke(1.dp, Color.Black)
            ){
                //이 안의 것들 (여기선 텍스트 덩어리와 버튼)에 대해 가운데 정렬 하고 싶다면 컬럼을 만들어 하위 내용을 감싸기
                //  그리고 배치, 배열 관련 코드들 작성해주기
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    //카드 내부의 컬럼에 대해 여백을 줘서 카드 크기를 키우기...? modifier로.
                    modifier = Modifier.padding(vertical = 32.dp)
                ) {
                    Text(
                        modifier = Modifier.padding((8.dp)),
                        //텍스트에 대해 가운데정렬하려면 여기서
                        textAlign = TextAlign.Center,
                        text =
                        """
                                    This is an example of a scaffold
                                    
                                    You have pressed the floating action button $presses times
                                """.trimIndent()
                    )

                    Button(onClick = {}) {
                        Text("Filled")
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
    SecondApp6Theme {
        Greeting("Android")
    }
}