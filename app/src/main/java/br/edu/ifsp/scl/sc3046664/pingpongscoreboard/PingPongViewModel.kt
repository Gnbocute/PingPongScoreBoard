package br.edu.ifsp.scl.sc3046664.pingpongscoreboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PingPongViewModel : ViewModel() {
    var player1Score by mutableIntStateOf(0)
        private set
    var player2Score by mutableIntStateOf(0)
        private set

    var player1Name by mutableStateOf("Player 1")

    var player2Name by mutableStateOf("Player 2")

    fun incrementPlayer1() { player1Score++ }
    fun incrementPlayer2() { player2Score++ }
    fun reset() { player1Score = 0; player2Score = 0 }
}