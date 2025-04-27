package eu.rudiment.captaingame

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import eu.rudiment.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
}

@Composable
fun CaptainGame(){
    val treasureFound = remember{mutableStateOf(0)}
//    val treasureFound by remember{ mutableStateOf(0) }-->indicates that there is no treasure to open, the coins are in your hands
    val direction = remember {mutableStateOf("North")}
    val stormOrTreasure = remember {mutableStateOf("")}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Treasures found: ${treasureFound.value}")
        Text(text = "Current direction: ${direction.value}")
        Text(text = "${stormOrTreasure.value}")

        Button(onClick = {
            direction.value = "East"
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
            }
        }) {
            Text("Sail East")
        }

        Button(onClick = {
            direction.value = "West"
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
            }
        }) {
            Text("Sail West")
        }


        Button(onClick = {
            direction.value = "North"
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
            }
        }) {
            Text("Sail North")
        }

        Button(onClick = {
            direction.value = "South"
            if (Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
            }
        }) {
            Text("Sail South")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOfCaptainGame(){
    CaptainGame()
}