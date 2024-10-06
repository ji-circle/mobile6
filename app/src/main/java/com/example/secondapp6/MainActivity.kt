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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
            //action이 들어가 있는 bottom app bar
            //  이것도 row scope가 들어가있음
            BottomAppBar(actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check")
                    //위 코드 한 줄을 이 안에 더 넣으면 겹쳐져 버림... 같은 위치에.
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Edit, contentDescription = "Check")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = "Check")
                }
            },
                //bottomappbar의 actions의 괄호 범위 안에 floatingactionbutton 넣을 수 있음..
                // bottom app bar 안의 구성요소로 fab가 들어간 것임!
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