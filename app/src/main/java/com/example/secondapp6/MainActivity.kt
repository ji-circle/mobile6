package com.example.secondapp6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    //TODO 질문1) 이렇게 상태를 많이 써도 되나...? (=> OK)
    var refreshPressed by rememberSaveable { mutableStateOf(false) }
    var leftScore by rememberSaveable { mutableIntStateOf(0) }
    var rightScore by rememberSaveable { mutableIntStateOf(0) }
    var team1 by rememberSaveable { mutableIntStateOf(0) }
    var team2 by rememberSaveable { mutableIntStateOf(0) }
    var draw by rememberSaveable { mutableIntStateOf(0) }
    var gameOver by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White
                ),
                title = { Text("Soccer Game") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Some Description",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "Menu",
                            tint = Color.White
                        )
                    }

                }
            )
        },
        bottomBar = {
            BottomAppBar(actions = {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Check, contentDescription = "Check")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Edit, contentDescription = "Check")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Info, contentDescription = "Check")
                    }
                }
            }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { refreshPressed = !refreshPressed }) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refresh")
                //TODO 질문2) 상태를 여기저기서 써도 되나...? 그럼 그 때 마다 관련 부분들이 다 재구성되는거 맞나?
                // (여기에서 0으로 초기화하는것처럼 쓰인 부분은 다시 실행되지 않는 거 맞나)
                // (=> ㅇㅇ 여기서는 ScaffoldExample 자체가 다시 실행된다고 보면 될듯)
                if (refreshPressed) {
                    leftScore = 0
                    rightScore = 0
                    team1 = 0
                    team2 = 0
                    draw = 0
                    refreshPressed = false
                }
            }
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 30.dp)
                .padding(vertical = 120.dp)
            //TODO 질문3) 위에서 spaceEvenly 하고 vertical padding을 주는 거 말고 다른 방법 없나
        // (=> Arrangement.Center로 하고, 밑에서 각각에 대해 padding을 줘도 됨)
        ) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp)
                ) {
                    Text(
                        modifier = Modifier.padding((8.dp)),
                        textAlign = TextAlign.Center,
                        text = "Soccer Score",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                    Text(
                        modifier = Modifier.padding((8.dp)),
                        text = "$leftScore   :   $rightScore",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineLarge.copy(fontSize = 60.sp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(onClick = { leftScore += 1 }) {
                            Text("Goal")
                        }
                        Button(onClick = { rightScore += 1 }) {
                            Text("Goal")
                        }
                    }
                }
            }
            ElevatedButton(onClick = { gameOver = !gameOver }) {
                Text("Game Over")
                if (gameOver) {
                    if (leftScore > rightScore) {
                        team1 += 1
                    } else if (leftScore < rightScore) {
                        team2 += 1
                    } else {
                        draw += 1
                    }
                    leftScore = 0
                    rightScore = 0
                    gameOver = false
                }
            }
            Text(text = "Team1: $team1 draw: $draw Team2: $team2")
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
        ScaffoldExample()
    }
}