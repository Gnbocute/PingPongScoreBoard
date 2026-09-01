package br.edu.ifsp.scl.sc3046664.pingpongscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.ifsp.scl.sc3046664.pingpongscoreboard.ui.theme.PingPongScoreBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PingPongScoreBoardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PingPongScoreBoardScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PingPongScoreBoardScreen(
    modifier: Modifier = Modifier,
    viewModel: PingPongViewModel = viewModel()
) {

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        val player1Score by viewModel.player1Score.collectAsStateWithLifecycle()
        val player2Score by viewModel.player2Score.collectAsStateWithLifecycle()
        val player1Name by viewModel.player1Name.collectAsStateWithLifecycle()
        val player2Name by viewModel.player2Name.collectAsStateWithLifecycle()

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            OutlinedTextField(
                value = player1Name,
                onValueChange = { viewModel.updatePlayer1Name(it) },
                singleLine = true
            )

            Text(
                text = player1Score.toString(),
                fontSize = 48.sp
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Button(
                    onClick = {
                        viewModel.incrementPlayer1()
                    }
                ) {
                    Text("+1")
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            contentAlignment = Alignment.Center
        ) {

            HorizontalDivider()

            Button(
                onClick = {
                    viewModel.reset()
                }
            ) {
                Text("Reiniciar")
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            OutlinedTextField(
                value = player2Name,
                onValueChange = { viewModel.updatePlayer2Name(it) },
                singleLine = true
            )

            Text(
                text = player2Score.toString(),
                fontSize = 48.sp
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Button(
                    onClick = {
                        viewModel.incrementPlayer2()
                    }
                ) {
                    Text("+1")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PingPongScoreBoardPreview() {
    PingPongScoreBoardTheme {
        PingPongScoreBoardScreen()
    }
}